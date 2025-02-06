package it.keybeeproject.keybee.activity;

import android.content.Intent;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.IOException;

import it.keybeeproject.keybee.R;
import it.keybeeproject.keybee.utility.PrefData;

public class TutorialActivity extends AppCompatActivity implements MediaPlayer.OnPreparedListener,
		MediaPlayer.OnCompletionListener {

	private static final String TAG = TutorialActivity.class.getSimpleName();
	private TextView textPageNo;
	private TextureView textureTutorial;
	private ProgressBar progress;
	private MediaPlayer mediaPlayer;
	private SurfaceTexture surfaceTexture;
	public static final int MODE_FIRST_LAUNCH = 1;
	public static final int MODE_SETTINGS = 2;
	public static final String MODE = "mode";
	private int currentMode;
	private boolean isRepeated;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tutorial);

		setUpControls();
		initGlobal();

	}

	private void setUpControls() {
		textPageNo = (TextView) findViewById(R.id.text_pageNo);
		textureTutorial = (TextureView) findViewById(R.id.texture_tutorial);
		progress = (ProgressBar) findViewById(R.id.progress_tutorial);
	}

	private void initGlobal() {
		currentMode = getIntent().getIntExtra(MODE, MODE_FIRST_LAUNCH);
		if (currentMode == MODE_FIRST_LAUNCH) {
			textPageNo.setVisibility(View.VISIBLE);
		}

		textureTutorial.setSurfaceTextureListener(new TextureView.SurfaceTextureListener() {
			@Override
			public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i1) {
				TutorialActivity.this.surfaceTexture = surfaceTexture;
				playVideo();
			}

			@Override
			public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i1) {

			}

			@Override
			public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
				return false;
			}

			@Override
			public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {

			}
		});

		textureTutorial.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				mediaPlayer.release();
				playVideo();
			}
		});
	}

	private void playVideo() {
		try {
			progress.setVisibility(View.VISIBLE);
			Uri uriVideo = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video_tutorial);
			mediaPlayer = new MediaPlayer();
			mediaPlayer.setOnPreparedListener(TutorialActivity.this);
			mediaPlayer.setOnCompletionListener(TutorialActivity.this);
			mediaPlayer.setDataSource(TutorialActivity.this, uriVideo);
			mediaPlayer.setSurface(new Surface(surfaceTexture));
			mediaPlayer.prepareAsync();
		} catch (IOException e) {
			Log.e(TAG, "onSurfaceTextureAvailable Exception : ", e);
		}
	}

	@Override
	protected void onPause() {
		overridePendingTransition(0, android.R.anim.fade_out);
		try {
			if (mediaPlayer != null) {
				mediaPlayer.release();
				isRepeated = false;
			}
		} catch (Exception e) {
			Log.e(TAG, "onPause Exception : " + e.toString());
		}
		super.onPause();
	}

	public void onClickOk(View view) {
		if (currentMode == MODE_FIRST_LAUNCH) {
			PrefData.setBooleanPrefs(this, PrefData.KEY_IS_FL_TUTORIAL_SHOWN_B, true);
			startActivity(new Intent(TutorialActivity.this, EnjoyActivity.class));
		}
		finish();
	}

	@Override
	public void onPrepared(MediaPlayer mediaPlayer) {
		try {
			progress.setVisibility(View.GONE);
			int videoWidth = mediaPlayer.getVideoWidth(), videoHeight = mediaPlayer.getVideoHeight();
			float videoProportion = (float) videoWidth / (float) videoHeight;
			int screenWidth = getWindowManager().getDefaultDisplay().getWidth()
					- getResources().getDimensionPixelOffset(R.dimen.dp20);
			int screenHeight = getWindowManager().getDefaultDisplay().getHeight();
			float screenProportion = (float) screenWidth / (float) screenHeight;
			ViewGroup.LayoutParams layoutParams = textureTutorial.getLayoutParams();

			if (videoProportion > screenProportion) {
				layoutParams.width = screenWidth;
				layoutParams.height = (int) ((float) screenWidth / videoProportion);
			} else {
				layoutParams.width = screenHeight;
				layoutParams.height = (int) ((float) screenHeight / videoProportion);
			}
			textureTutorial.setLayoutParams(layoutParams);

			mediaPlayer.start();
		} catch (Exception e) {
			Log.e(TAG, "onPrepared Exception : " + e.toString());
		}
	}

	@Override
	public void onCompletion(MediaPlayer mediaPlayer) {
		try {
			if (!isRepeated) {
				isRepeated = true;
				mediaPlayer.start();
			} else {
				mediaPlayer.release();
			}
		} catch (Exception e) {
			Log.e(TAG, "onCompletion Exception : " + e.toString());
		}
	}

}
