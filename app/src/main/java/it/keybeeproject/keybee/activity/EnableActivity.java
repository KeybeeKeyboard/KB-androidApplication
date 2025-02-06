package it.keybeeproject.keybee.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import it.keybeeproject.keybee.R;
import it.keybeeproject.keybee.utility.PrefData;

public class EnableActivity extends AppCompatActivity {

	private static final String TAG = EnableActivity.class.getSimpleName();

	private Button buttonEnable, buttonChoose, buttonNext;
	private TextView textInstruct, textPageNo;

	private InputMethodManager inputMethodManager;

	public static final int MODE_FIRST_LAUNCH = 1;
	public static final int MODE_SETTINGS = 2;
	public static final String MODE = "mode";
	private String packageName;
	private int currentMode;
	private boolean isFirstCheck = true;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_enable);

		setUpControls();
		initGlobal();

	}

	private void setUpControls() {
		buttonEnable = (Button) findViewById(R.id.button_enable);
		buttonChoose = (Button) findViewById(R.id.button_choose);
		buttonNext = (Button) findViewById(R.id.button_next);
		textInstruct = (TextView) findViewById(R.id.text_instruct);
		textPageNo = (TextView) findViewById(R.id.text_pageNo);
	}

	private void initGlobal() {
		currentMode = getIntent().getIntExtra(MODE, MODE_FIRST_LAUNCH);

		if (currentMode == MODE_FIRST_LAUNCH) {
			textPageNo.setVisibility(View.VISIBLE);
			buttonNext.setText(R.string.next);
		}

		packageName = getPackageName();
		inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);

		buttonEnable.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				startActivity(new Intent(Settings.ACTION_INPUT_METHOD_SETTINGS));
			}
		});

		buttonChoose.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				inputMethodManager.showInputMethodPicker();
			}
		});

		buttonNext.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				onClickNext();
			}
		});
	}

	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
		super.onWindowFocusChanged(hasFocus);
		if (hasFocus) {
			if (isKeybeeEnabled(packageName, inputMethodManager)) {
				buttonEnable.setEnabled(false);
				if (Settings.Secure.getString(getContentResolver(), Settings.Secure.DEFAULT_INPUT_METHOD).contains(packageName)) {
					buttonChoose.setEnabled(false);
					if (isFirstCheck) {
						textInstruct.setText(R.string.msg_already_enabled);
						buttonNext.setVisibility(View.VISIBLE);
					} else {
						onClickNext();
					}
				} else {
					textInstruct.setText(R.string.msg_enable_keybee);
					buttonChoose.setEnabled(true);
				}
			} else {
				textInstruct.setText(R.string.msg_enable_keybee);
				buttonEnable.setEnabled(true);
				buttonChoose.setEnabled(false);
			}
			isFirstCheck = false;
		}
	}

	private void onClickNext() {
		if (currentMode == MODE_FIRST_LAUNCH) {
			PrefData.setBooleanPrefs(this, PrefData.KEY_IS_FL_ENABLED_B, true);
			startActivity(new Intent(EnableActivity.this, ThemeActivity.class));
		}
		finish();
	}

	private boolean isKeybeeEnabled(String packageName, InputMethodManager inputMethodManager) {
		List<InputMethodInfo> listEnabledInputMethods = inputMethodManager.getEnabledInputMethodList();
		for (int i = 0; i < listEnabledInputMethods.size(); i++) {
			InputMethodInfo inputMethodInfo = listEnabledInputMethods.get(i);
			if (inputMethodInfo.getId().contains(packageName)) {
				return true;
			}
		}
		return false;
	}

	@Override
	protected void onPause() {
		overridePendingTransition(0, android.R.anim.fade_out);
		super.onPause();
	}
}
