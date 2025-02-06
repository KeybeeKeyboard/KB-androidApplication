package it.keybeeproject.keybee.activity;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;

import it.keybeeproject.keybee.R;
import it.keybeeproject.keybee.utility.PrefData;
import it.keybeeproject.keybee.utility.Utility;

public class LanguageActivity extends AppCompatActivity {

	private static final String TAG = LanguageActivity.class.getSimpleName();

	private String[] arrLanguageCode;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
		super.onCreate(savedInstanceState);
		arrLanguageCode = getResources().getStringArray(R.array.language_code);

		if (PrefData.getBooleanPrefs(this, PrefData.KEY_IS_FL_LANGUAGE_SET_B)) {
			Utility.changeLanguage(this, arrLanguageCode[PrefData.getIntPrefs(this, PrefData.KEY_KEYBOARD_LAYOUT_I)]);
			if (PrefData.getBooleanPrefs(this, PrefData.KEY_IS_FL_ENABLED_B)) {
				if (PrefData.getBooleanPrefs(this, PrefData.KEY_IS_FL_THEME_SET_B)) {
					if (PrefData.getBooleanPrefs(this, PrefData.KEY_IS_FL_TUTORIAL_SHOWN_B)) {
						startActivity(new Intent(this, SettingsActivity.class));
						finish();
					} else {
						Intent intentTutorial = new Intent(LanguageActivity.this, TutorialActivity.class);
						intentTutorial.putExtra(TutorialActivity.MODE, TutorialActivity.MODE_FIRST_LAUNCH);
						startActivity(intentTutorial);
						finish();
					}
				} else {
					startActivity(new Intent(this, ThemeActivity.class));
					finish();
				}
			} else {
				launchEnableActivity();
			}
		} else {
			setContentView(R.layout.activity_language);
		}
	}

	public void onClickLanguageLayout(View view) {
		switch (view.getId()) {
			case R.id.button_english:
				PrefData.setIntPrefs(this, PrefData.KEY_KEYBOARD_LAYOUT_I, PrefData.VAL_LAYOUT_ENGLISH);
				break;
			case R.id.button_spanish:
				PrefData.setIntPrefs(this, PrefData.KEY_KEYBOARD_LAYOUT_I, PrefData.VAL_LAYOUT_SPANISH);
				break;
			case R.id.button_italian:
				PrefData.setIntPrefs(this, PrefData.KEY_KEYBOARD_LAYOUT_I, PrefData.VAL_LAYOUT_ITALIAN);
				break;
			case R.id.button_german:
				PrefData.setIntPrefs(this, PrefData.KEY_KEYBOARD_LAYOUT_I, PrefData.VAL_LAYOUT_GERMAN);
				break;
		}
		PrefData.setBooleanPrefs(this, PrefData.KEY_IS_FL_LANGUAGE_SET_B, true);
		Utility.changeLanguage(this, arrLanguageCode[PrefData.getIntPrefs(this, PrefData.KEY_KEYBOARD_LAYOUT_I)]);
		launchEnableActivity();
	}

	private void launchEnableActivity() {
		Intent intentEnable = new Intent(LanguageActivity.this, EnableActivity.class);
		intentEnable.putExtra(EnableActivity.MODE, EnableActivity.MODE_FIRST_LAUNCH);
		startActivity(intentEnable);
		finish();
	}

	@Override
	protected void onPause() {
		overridePendingTransition(0, android.R.anim.fade_out);
		super.onPause();
	}


}
