package it.keybeeproject.keybee.activity;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;

import it.keybeeproject.keybee.R;
import it.keybeeproject.keybee.utility.PrefData;

public class ThemeActivity extends AppCompatActivity {

	private static final String TAG = ThemeActivity.class.getSimpleName();

	private static final int RC_THEME_MARKET = 2345;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_theme);
	}

	public void onClickTheme(View view) {
		switch (view.getId()) {
			case R.id.button_dark:
				PrefData.setIntPrefs(ThemeActivity.this, PrefData.KEY_SELECTED_THEME_POSITION, 0);
				launchTutorialActivity();
				break;
			case R.id.button_light:
				PrefData.setIntPrefs(ThemeActivity.this, PrefData.KEY_SELECTED_THEME_POSITION, 1);
				launchTutorialActivity();
				break;
			case R.id.button_more:
				Intent intentThemeMarket = new Intent(ThemeActivity.this, ThemeMarketActivity.class);
				intentThemeMarket.putExtra(ThemeMarketActivity.MODE, ThemeMarketActivity.MODE_FIRST_LAUNCH);
				startActivityForResult(intentThemeMarket, RC_THEME_MARKET);
				break;
		}
	}

	private void launchTutorialActivity() {
		PrefData.setBooleanPrefs(this, PrefData.KEY_IS_FL_THEME_SET_B, true);
		Intent intentTutorial = new Intent(ThemeActivity.this, TutorialActivity.class);
		intentTutorial.putExtra(TutorialActivity.MODE, TutorialActivity.MODE_FIRST_LAUNCH);
		startActivity(intentTutorial);
		finish();
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (requestCode == RC_THEME_MARKET && resultCode == RESULT_OK) {
			launchTutorialActivity();
		}
	}

	@Override
	protected void onPause() {
		overridePendingTransition(0, android.R.anim.fade_out);
		super.onPause();
	}
}
