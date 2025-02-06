package it.keybeeproject.keybee.activity;

import android.os.Bundle;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.text.Spannable;
import android.text.SpannableString;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import it.keybeeproject.keybee.Global.Constant;
import it.keybeeproject.keybee.R;
import it.keybeeproject.keybee.utility.TypefaceSpan;
import it.keybeeproject.keybee.utility.Utility;

public class ProjectInfoActivity extends AppCompatActivity {

	private TextView textLinkKeybee;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_project_info);

		setUpControls();
		initGlobal();
	}

	private void setUpControls() {
		ActionBar actionBar = getSupportActionBar();
		actionBar.setHomeButtonEnabled(true);
		actionBar.setDisplayHomeAsUpEnabled(true);
		SpannableString spannableString = new SpannableString(actionBar.getTitle());
		spannableString.setSpan(new TypefaceSpan(this, getString(R.string.font_dosis_regular)), 0, spannableString.length(),
				Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		actionBar.setTitle(spannableString);

		textLinkKeybee = (TextView) findViewById(R.id.text_linkKeybee);
	}

	private void initGlobal() {
		textLinkKeybee.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Utility.openLinkInBrowser(ProjectInfoActivity.this, Constant.URL_KEYBEE);
			}
		});
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			case android.R.id.home:
				finish();
				break;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	protected void onPause() {
		overridePendingTransition(0, android.R.anim.fade_out);
		super.onPause();
	}
}
