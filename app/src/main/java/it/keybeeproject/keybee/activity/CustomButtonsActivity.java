package it.keybeeproject.keybee.activity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import it.keybeeproject.keybee.R;
import it.keybeeproject.keybee.adapter.PopUpAdapter;
import it.keybeeproject.keybee.model.ButtonAction;
import it.keybeeproject.keybee.model.CustomButtonSetting;
import it.keybeeproject.keybee.utility.PrefData;
import it.keybeeproject.keybee.utility.TypefaceSpan;

public class CustomButtonsActivity extends AppCompatActivity {//implements IabBroadcastReceiver.IabBroadcastListener {
    private static final String TAG = CustomButtonsActivity.class.getSimpleName();

    // The number of button settings. (4 buttons on top + 4 on bottom) * 2 for short+long press makes 16
    static final int NUM_CUSTOM_BUTTON_SETTINGS = 16;
    // List of default custom button settings. Short and long actions
    String[] defaultButtonActions = {
            ButtonAction.Disabled.name(), ButtonAction.Disabled.name(),
            ButtonAction.Disabled.name(), ButtonAction.Disabled.name(),
            ButtonAction.Disabled.name(), ButtonAction.Disabled.name(),
            ButtonAction.Disabled.name(), ButtonAction.Disabled.name(),
            ButtonAction.Disabled.name(), ButtonAction.Settings.name(),
            ButtonAction.Emoji.name(), ButtonAction.Disabled.name(),
            ButtonAction.Enter.name(), ButtonAction.Disabled.name(),
            ButtonAction.Layout.name(), ButtonAction.Disabled.name()};
    int currentKeyboardLayout;
    TextView reset, done, main_txt;

    int[] spinnerIds = {R.id.Spin_Top1Short, R.id.Spin_Top1Long, R.id.Spin_Top2Short, R.id.Spin_Top2Long, R.id.Spin_Top3Short, R.id.Spin_Top3Long, R.id.Spin_Top4Short, R.id.Spin_Top4Long, R.id.Spin_Bottom1Short, R.id.Spin_Bottom1Long, R.id.Spin_Bottom2Short, R.id.Spin_Bottom2Long, R.id.Spin_Bottom3Short, R.id.Spin_Bottom3Long, R.id.Spin_Bottom4Short, R.id.Spin_Bottom4Long};
    int[] textIds = {R.id.Text_Top1Short, R.id.Text_Top1Long, R.id.Text_Top2Short, R.id.Text_Top2Long, R.id.Text_Top3Short, R.id.Text_Top3Long, R.id.Text_Top4Short, R.id.Text_Top4Long, R.id.Text_Bottom1Short, R.id.Text_Bottom1Long, R.id.Text_Bottom2Short, R.id.Text_Bottom2Long, R.id.Text_Bottom3Short, R.id.Text_Bottom3Long, R.id.Text_Bottom4Short, R.id.Text_Bottom4Long};
    CustomButtonSetting[] customButtonSettingList = new CustomButtonSetting[NUM_CUSTOM_BUTTON_SETTINGS];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        setContentView(R.layout.activity_custom_buttons);
        initGloble();
        Onclick();
        setData();
    }


    private void setData() {
        List<String> currentSettings = PrefData.getArrayListPref(CustomButtonsActivity.this, PrefData.CUSTOM_BUTTONS);
        if (currentSettings == null || currentSettings.size() != customButtonSettingList.length) {
            currentSettings = Arrays.asList(defaultButtonActions);
        }
        for (int i = 0; i < NUM_CUSTOM_BUTTON_SETTINGS; i++) {
            String currentSetting = currentSettings.get(i);
            int position = ButtonAction.NAMES.indexOf(currentSetting);
            if (position == -1) {
                // We didn't find this in the list, so let's set it to the default
                position = ButtonAction.NAMES.indexOf(defaultButtonActions[i]);
            }
            if (position == -1) {
                Log.e(TAG, "Could not find default button action " + defaultButtonActions[i] + "for button " + i);
            }
            customButtonSettingList[i].spinner.setSelection(position);
        }
        saveSettings();
    }

    private void Onclick() {
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PrefData.remove(CustomButtonsActivity.this, PrefData.CUSTOM_BUTTONS);
                setData();
            }

        });
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishmethod();
            }
        });

    }

    private void saveSettings() {
        ArrayList<String> newSettings = new ArrayList<>();
        for (int i = 0; i < NUM_CUSTOM_BUTTON_SETTINGS; i++) {
            newSettings.add(ButtonAction.values()[customButtonSettingList[i].spinner.getSelectedItemPosition()].name());
        }
        PrefData.setArrayListPref(CustomButtonsActivity.this, PrefData.CUSTOM_BUTTONS, newSettings);
    }

    private void finishmethod() {
        saveSettings();
        finish();
    }

    private void initGloble() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        SpannableString spannableString = new SpannableString(actionBar.getTitle());
        spannableString.setSpan(new TypefaceSpan(this, getString(R.string.font_dosis_regular)), 0, spannableString.length(),
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        actionBar.setTitle(spannableString);
        main_txt = findViewById(R.id.main_txt);
        currentKeyboardLayout = PrefData.getIntPrefs(this, PrefData.KEY_KEYBOARD_LAYOUT_I,
                PrefData.VAL_LAYOUT_ENGLISH);

        reset = findViewById(R.id.reset);
        done = findViewById(R.id.done);

        for (int i = 0; i < customButtonSettingList.length; i++) {
            customButtonSettingList[i] = new CustomButtonSetting(
                    i,
                    i > 8,
                    i/2,
                    i%2==0,
                    this,
                    findViewById(spinnerIds[i]),
                    findViewById(textIds[i])
            );
            customButtonSettingList[i].spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    saveSettings();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });
        }

        setData();
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
                showLayoutInfoDialog();
                break;
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void showLayoutInfoDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.DialogTheme);
        SpannableString spannableString = new SpannableString(getString(R.string.layout_info));
        spannableString.setSpan(new TypefaceSpan(this, getString(R.string.font_dosis_regular)), 0, spannableString.length(),
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        builder.setMessage(spannableString)
                .setPositiveButton(R.string.cancel, null)
                .create().show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

}
