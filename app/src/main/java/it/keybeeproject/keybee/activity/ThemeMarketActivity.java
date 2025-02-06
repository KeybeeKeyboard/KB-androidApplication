package it.keybeeproject.keybee.activity;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.text.Spannable;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import it.keybeeproject.keybee.R;
import it.keybeeproject.keybee.adapter.ThemeAdapter;
import it.keybeeproject.keybee.model.Theme;
import it.keybeeproject.keybee.utility.PrefData;
import it.keybeeproject.keybee.utility.TypefaceSpan;

public class ThemeMarketActivity extends AppCompatActivity {

    private ListView listTheme;
    private ArrayList<Theme> arrListTheme;
    private ThemeAdapter adpTheme;
    private AlertDialog dialogTheme;
    public static final int MODE_FIRST_LAUNCH = 1;
    public static final int MODE_SETTINGS = 2;
    public static final String MODE = "mode";
    private int currentMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theme_market);

        setUpControls();
        initGlobal();

    }

    private void setUpControls() {
        listTheme = (ListView) findViewById(R.id.list_theme);
    }

    private void initGlobal() {

        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        SpannableString spannableString = new SpannableString(actionBar.getTitle());
        spannableString.setSpan(new TypefaceSpan(this, getString(R.string.font_dosis_regular)), 0, spannableString.length(),
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        actionBar.setTitle(spannableString);

        currentMode = getIntent().getIntExtra(MODE, MODE_FIRST_LAUNCH);

        arrListTheme = Theme.getThemes();
        adpTheme = new ThemeAdapter(this, arrListTheme);
        listTheme.setAdapter(adpTheme);

        listTheme.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                showThemeInfo(position);
            }
        });
    }

    private void showThemeInfo(final int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.DialogTheme);

        View layout = LayoutInflater.from(this).inflate(R.layout.layout_dialog_theme, null);

        dialogTheme = builder.setView(layout).create();

        ((TextView) layout.findViewById(R.id.text_title)).setText(arrListTheme.get(position).getName());

        ((TextView) layout.findViewById(R.id.text_price)).setText(getString(R.string.free));

        ImageView imgThumbnail = (ImageView) layout.findViewById(R.id.img_themeThumbnail);

        Button buttonCancel = (Button) layout.findViewById(R.id.button_cancel);

        Button buttonUse = (Button) layout.findViewById(R.id.button_use);

        buttonUse.setText( R.string.use );

        imgThumbnail.setImageResource(arrListTheme.get(position).getThumbnailRes());

        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogTheme.dismiss();
            }
        });

        buttonUse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                applyTheme(position);
            }
        });

        dialogTheme.show();
    }

    private void applyTheme(int position) {
        PrefData.setIntPrefs(ThemeMarketActivity.this, PrefData.KEY_SELECTED_THEME_POSITION, position);
        arrListTheme.get(position).setPurchased(true);
        adpTheme.setSelectedThemePosition(position);
        adpTheme.notifyDataSetChanged();
        if (dialogTheme != null && dialogTheme.isShowing()) {
            dialogTheme.dismiss();
        }
        if (currentMode == MODE_FIRST_LAUNCH) {
            setResult(RESULT_OK);
            finish();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.theme_market_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_info:
                showThemeInfoDialog();
                break;
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void showThemeInfoDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.DialogTheme);
        SpannableString spannableString = new SpannableString(getString(R.string.theme_info));
        spannableString.setSpan(new TypefaceSpan(this, getString(R.string.font_dosis_regular)), 0, spannableString.length(),
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        builder.setMessage(spannableString)
                .setPositiveButton(R.string.cancel, null)
                .create().show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onPause() {
        overridePendingTransition(0, android.R.anim.fade_out);
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
