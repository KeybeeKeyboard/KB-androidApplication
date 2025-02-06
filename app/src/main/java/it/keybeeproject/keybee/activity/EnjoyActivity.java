package it.keybeeproject.keybee.activity;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;

import it.keybeeproject.keybee.R;

public class EnjoyActivity extends AppCompatActivity {

	private static final String TAG = EnjoyActivity.class.getSimpleName();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_enjoy);
	}

	public void onClickOk(View view) {
		startActivity(new Intent(EnjoyActivity.this, SettingsActivity.class));
		finish();
	}

	@Override
	protected void onDestroy() {
		overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
		super.onDestroy();
	}

	@Override
	protected void onPause() {
		overridePendingTransition(0, android.R.anim.fade_out);
		super.onPause();
	}
}
