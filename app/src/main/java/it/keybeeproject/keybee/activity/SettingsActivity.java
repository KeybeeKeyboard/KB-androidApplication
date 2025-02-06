package it.keybeeproject.keybee.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import android.text.Spannable;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.onesignal.OneSignal;

import it.keybeeproject.keybee.Global.Constant;
import it.keybeeproject.keybee.R;
import it.keybeeproject.keybee.model.Theme;
import it.keybeeproject.keybee.utility.PrefData;
import it.keybeeproject.keybee.utility.TypefaceSpan;
import it.keybeeproject.keybee.utility.Utility;


public class SettingsActivity extends AppCompatActivity {

    private TextView textSize, textSizeIntro, textAlignment, textAlignmentIntro, textLateralGap, textThemeIntro,
            textLayoutIntro, textSelectedCurrency, text_theme_subsription/*, textAutoCorrection, textAutoCompletion, textLanguageDictionary*/;
    private LinearLayout linearEnable, linearTutorial, linearProjectInfo, linearSize, linearAlignment, linearTheme,
            linearLayout, linearKeybee, linearGithub, linearKeybeecontest, linearFacebook, linearTwitter, linearLinkedIn, linearDonate, linearCurrency;
    private RelativeLayout relative_topgap,relativeFullWidth, relativeLateralGap, relativeSound, relativeVibra, relativeDotSpace, linear_free_theme,
            relativePreview, relativeTwipe, relativeCursor, relativeDotApostophe, relativeTextCorrection, relativeTextAutoCapitalization, relative_notification;
    private ImageView img_apply_theme;
    private String[] arrSizeTitle, arrAlignmentTitle, arrLayoutTitle, arrCurrencyTitle, arrLanguageCode;
    private float[] arrSizeValue;
    private int currentKeyboardLayout;
    private CheckBox check_topgap,checkFullWidth, checkLateralGapFill, checkSound, checkVibra, checkDotSpace, checkPreview, checkTwipe,
            checkCursor, checkDotApostophe, checkTextSuggestion, checkTextAutoCapitalization, check_notification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        setUpControls();
        initGlobal();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
    }


    private void setUpControls() {
        textSize = findViewById(R.id.text_size);
        textSizeIntro = findViewById(R.id.text_sizeIntro);
        textAlignment = findViewById(R.id.text_alignment);
        textAlignmentIntro = findViewById(R.id.text_alignmentIntro);
        textLayoutIntro = findViewById(R.id.text_layoutIntro);
        textThemeIntro = findViewById(R.id.text_themeIntro);
        textSelectedCurrency = findViewById(R.id.text_selectedCurrency);
        textLateralGap = findViewById(R.id.text_lateralGap);
        text_theme_subsription = findViewById(R.id.text_theme_subsription);

        linearEnable = findViewById(R.id.linear_enable);
        linearTutorial = findViewById(R.id.linear_tutorial);
        linearProjectInfo = findViewById(R.id.linear_projectInfo);
        linearTheme = findViewById(R.id.linear_theme);
        linearLayout = findViewById(R.id.linear_layout);
        linearSize = findViewById(R.id.linear_size);
        linearAlignment = findViewById(R.id.linear_alignment);
        linearKeybee = findViewById(R.id.linear_linkKeybee);
        linearGithub = findViewById(R.id.linear_linkGithub);
        linearKeybeecontest = findViewById(R.id.linear_linkKeybeecontest);
        linearFacebook = findViewById(R.id.linear_linkFacebook);
        linearTwitter = findViewById(R.id.linear_linkTwitter);
        linearLinkedIn = findViewById(R.id.linear_linkLinkedIn);
        linearDonate = findViewById(R.id.linear_donate);
        linearCurrency = findViewById(R.id.linear_currency);
//      linear_theme = findViewById(R.id.linear_theme);
        linear_free_theme = findViewById(R.id.linear_free_theme);

        relativeFullWidth = findViewById(R.id.relative_fullWidth);
        relative_topgap = findViewById(R.id.relative_topgap);
        relativeLateralGap = findViewById(R.id.relative_lateralGap);
        relativeSound = findViewById(R.id.relative_sound);
        relativeVibra = findViewById(R.id.relative_vibra);
        relativeDotSpace = findViewById(R.id.relative_dotSpace);
        relativePreview = findViewById(R.id.relative_preview);
        relativeTwipe = findViewById(R.id.relative_twipe);
        relativeCursor = findViewById(R.id.relative_cursor);
        relativeDotApostophe = findViewById(R.id.relative_dot_apostophe);
        relativeTextCorrection = findViewById(R.id.relative_textCorrection);
        relativeTextAutoCapitalization = findViewById(R.id.relative_textAutoCapitalization);
        relative_notification = findViewById(R.id.relative_notification);

        check_notification = findViewById(R.id.check_notification);
        checkFullWidth = findViewById(R.id.check_fullWidth);
        check_topgap = findViewById(R.id.check_topgap);
        checkLateralGapFill = findViewById(R.id.check_lateralGap);
        checkSound = findViewById(R.id.check_sound);
        checkVibra = findViewById(R.id.check_vibra);
        checkDotSpace = findViewById(R.id.check_dotSpace);
        checkPreview = findViewById(R.id.check_preview);
        checkTwipe = findViewById(R.id.check_twipe);
        checkCursor = findViewById(R.id.check_cursor);
        checkDotApostophe = findViewById(R.id.check_dot_apostophe);
        checkTextSuggestion = findViewById(R.id.check_textCorrection);
        checkTextAutoCapitalization = findViewById(R.id.check_textAutoCapitalization);

        img_apply_theme = findViewById(R.id.img_apply_theme);

        if(Build.VERSION.SDK_INT==Build.VERSION_CODES.P){
            relative_topgap.setVisibility(View.VISIBLE);
        }else{
            relative_topgap.setVisibility(View.GONE);
        }
    }

    private void initGlobal() {

        ActionBar actionBar = getSupportActionBar();
        SpannableString spannableString = new SpannableString(actionBar.getTitle());
        spannableString.setSpan(new TypefaceSpan(this, getString(R.string.font_dosis_regular)), 0, spannableString.length(),
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        actionBar.setTitle(spannableString);


        arrLanguageCode = getResources().getStringArray(R.array.language_code);

        relativeFullWidth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkFullWidth.setChecked(!checkFullWidth.isChecked());
                PrefData.setBooleanPrefs(SettingsActivity.this, PrefData.KEY_IS_KB_SIZE_FULL_B, checkFullWidth.isChecked());
                enableOtherSizeSettings(!checkFullWidth.isChecked());
            }
        });

        relative_topgap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                check_topgap.setChecked(!check_topgap.isChecked());
                PrefData.setBooleanPrefs(SettingsActivity.this, PrefData.KEY_IS_TOP_GAP_FILL, check_topgap.isChecked());
                //enableOtherSizeSettings(!check_topgap.isChecked());
            }
        });


        linearEnable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentEnable = new Intent(SettingsActivity.this, EnableActivity.class);
                intentEnable.putExtra(EnableActivity.MODE, EnableActivity.MODE_SETTINGS);
                startActivity(intentEnable);
            }
        });

        linearTutorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentTutorial = new Intent(SettingsActivity.this, TutorialActivity.class);
                intentTutorial.putExtra(TutorialActivity.MODE, TutorialActivity.MODE_SETTINGS);
                startActivity(intentTutorial);
            }
        });

        linearProjectInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SettingsActivity.this, ProjectInfoActivity.class));
            }
        });

        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showLayoutDialog();
            }
        });


        linearCurrency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showCurrencyDialog();
            }
        });

        linearSize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showSizeDialog();
            }
        });

        linearAlignment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAlignmentDialog();
            }
        });

        relativeLateralGap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkLateralGapFill.setChecked(!checkLateralGapFill.isChecked());
                PrefData.setBooleanPrefs(SettingsActivity.this, PrefData.KEY_IS_LATERAL_GAP_FILL_B,
                        checkLateralGapFill.isChecked());
            }
        });

        relativeSound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkSound.setChecked(!checkSound.isChecked());
                PrefData.setBooleanPrefs(SettingsActivity.this, PrefData.KEY_IS_SOUND_ENABLED_B, checkSound.isChecked());
            }
        });

        relativeVibra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkVibra.setChecked(!checkVibra.isChecked());
                PrefData.setBooleanPrefs(SettingsActivity.this, PrefData.KEY_IS_VIBRA_ENABLED_B, checkVibra.isChecked());
            }
        });

        relativeDotSpace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkDotSpace.setChecked(!checkDotSpace.isChecked());
                PrefData.setBooleanPrefs(SettingsActivity.this, PrefData.KEY_IS_DOT_SPACE_ENABLED_B, checkDotSpace.isChecked());
            }
        });

        relativePreview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkPreview.setChecked(!checkPreview.isChecked());
                PrefData.setBooleanPrefs(SettingsActivity.this, PrefData.KEY_IS_PREVIEW_ENABLED_B, checkPreview.isChecked());
            }
        });

        relativeTextAutoCapitalization.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkTextAutoCapitalization.setChecked(!checkTextAutoCapitalization.isChecked());
                PrefData.setBooleanPrefs(SettingsActivity.this, PrefData.KEY_IS_TEXT_AUTOCAPITALIZATION_ENABLED_B, checkTextAutoCapitalization.isChecked());
            }
        });

        relativeTwipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkTwipe.setChecked(!checkTwipe.isChecked());
                PrefData.setBooleanPrefs(SettingsActivity.this, PrefData.KEY_IS_TWIPE_ENABLED_B, checkTwipe.isChecked());
            }
        });

        relativeCursor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkCursor.setChecked(!checkCursor.isChecked());
                PrefData.setBooleanPrefs(SettingsActivity.this, PrefData.KEY_IS_CURSOR_ENABLED_B, checkCursor.isChecked());
            }
        });

        relativeDotApostophe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkDotApostophe.setChecked(!checkDotApostophe.isChecked());
                PrefData.setBooleanPrefs(SettingsActivity.this, PrefData.KEY_IS_DOT_ENABLED_B, checkDotApostophe.isChecked());
            }
        });

        relative_notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(OneSignal.getNotifications().getPermission()){
                    showNotificationDialog();
                    try {
                        OneSignal.getUser().getPushSubscription().optIn();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }
        });

        linearKeybee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utility.openLinkInBrowser(SettingsActivity.this, Constant.URL_KEYBEE);
            }
        });

        linearGithub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utility.openLinkInBrowser(SettingsActivity.this, Constant.URL_GITHUB);
            }
        });

        linearKeybeecontest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utility.openLinkInBrowser(SettingsActivity.this, Constant.URL_KEYBEE_SPEED_CONTEST);
            }
        });

        linearFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utility.openLinkInBrowser(SettingsActivity.this, Constant.URL_FACEBOOK);
            }
        });

        linearTwitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utility.openLinkInBrowser(SettingsActivity.this, Constant.URL_TWITTER);
            }
        });

        linearLinkedIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utility.openLinkInBrowser(SettingsActivity.this, Constant.URL_LINKEDIN);
            }
        });

        linearDonate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utility.openLinkInBrowser(SettingsActivity.this, Constant.URL_DONATE);
            }
        });

        linearTheme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentThemeMarket = new Intent(SettingsActivity.this, ThemeMarketActivity.class);
                intentThemeMarket.putExtra(ThemeMarketActivity.MODE, ThemeMarketActivity.MODE_SETTINGS);
                startActivity(intentThemeMarket);
            }
        });

    }


    @Override
    protected void onResume() {
        super.onResume();
        initMainSettings();
        initSizeSettings();
        initFeedbackSettings();
        initTextSettings();
    }

    private void showLayoutDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.DialogTheme);

        LayoutInflater inflater = LayoutInflater.from(this);
        TextView textTitle = (TextView) inflater.inflate(R.layout.dialog_title, null);
        textTitle.setText(R.string.layout_dialog);

        builder.setCustomTitle(textTitle)
                .setSingleChoiceItems(
                        new ArrayAdapter<>(this, R.layout.item_list_simple, getResources().getStringArray(R.array.layout)),
                        currentKeyboardLayout,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int position) {
                                currentKeyboardLayout = position;
                                PrefData.setIntPrefs(SettingsActivity.this, PrefData.KEY_KEYBOARD_LAYOUT_I, currentKeyboardLayout);
                                Utility.changeLanguage(SettingsActivity.this, arrLanguageCode[currentKeyboardLayout]);
                                textLayoutIntro.setText(arrLayoutTitle[position]);
                                dialogInterface.dismiss();
                            }
                        }).setPositiveButton(R.string.cancel,null)
                .setNegativeButton(R.string.CUSTOMIZE, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                      Intent intent =new Intent(SettingsActivity.this, CustomLayoutActivity.class);
                      startActivity(intent);
                    }
                });


        final AlertDialog dialog = builder.create();
        dialog.show();


        Button btnPositive = dialog.getButton(AlertDialog.BUTTON_POSITIVE);
        Button btnNegative = dialog.getButton(AlertDialog.BUTTON_NEGATIVE);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) btnPositive.getLayoutParams();
        layoutParams.weight = 10;

        btnPositive.setLayoutParams(layoutParams);
        btnNegative.setLayoutParams(layoutParams);

    }

    private void initMainSettings() {
        arrLayoutTitle = getResources().getStringArray(R.array.layout);
        currentKeyboardLayout = PrefData.getIntPrefs(this, PrefData.KEY_KEYBOARD_LAYOUT_I,
                PrefData.VAL_LAYOUT_ENGLISH);
        textLayoutIntro.setText(arrLayoutTitle[currentKeyboardLayout]);
        arrCurrencyTitle = getResources().getStringArray(R.array.currency);
        textThemeIntro.setText(Theme.getThemes().get(PrefData.getIntPrefs(this, PrefData.KEY_SELECTED_THEME_POSITION)).getName());
        textSelectedCurrency.setText(arrCurrencyTitle[PrefData.getIntPrefs(this, PrefData.KEY_CURRENCY_I, PrefData.VAL_CURRENCY_EUR)]);
        checkTwipe.setChecked(PrefData.getBooleanPrefs(SettingsActivity.this, PrefData.KEY_IS_TWIPE_ENABLED_B, true));
        checkCursor.setChecked(PrefData.getBooleanPrefs(SettingsActivity.this, PrefData.KEY_IS_CURSOR_ENABLED_B, true));
        checkDotApostophe.setChecked(PrefData.getBooleanPrefs(SettingsActivity.this, PrefData.KEY_IS_DOT_ENABLED_B, false));
        img_apply_theme.setImageResource(PrefData.getBooleanPrefs(this, Constant.SKU) ? R.drawable.ic_check : R.drawable.ic_add);
        //int status = PrefData.getIntPrefs(this, PrefData.KEY_NOTIFICATION, OneSignal.getNotifications().getPermission() ? 1 : -1);
        check_notification.setChecked(OneSignal.getNotifications().getPermission());
        try {
            if (!OneSignal.getNotifications().getPermission())
                OneSignal.getUser().getPushSubscription().optOut();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initSizeSettings() {
        arrSizeTitle = getResources().getStringArray(R.array.keyboard_size);
        arrSizeValue = new float[]{PrefData.VAL_KB_SIZE_TAB_SMALL, PrefData.VAL_KB_SIZE_TAB_MEDIUM, PrefData.VAL_KB_SIZE_TAB_LARGE,
                PrefData.VAL_KB_SIZE_PHONE_SMALL, PrefData.VAL_KB_SIZE_PHONE_MEDIUM, PrefData.VAL_KB_SIZE_PHONE_LARGE};
        arrAlignmentTitle = getResources().getStringArray(R.array.alignments);

        check_topgap.setChecked(PrefData.getBooleanPrefs(this, PrefData.KEY_IS_TOP_GAP_FILL, false));
        checkFullWidth.setChecked(PrefData.getBooleanPrefs(this, PrefData.KEY_IS_KB_SIZE_FULL_B, false));
        checkLateralGapFill.setChecked(PrefData.getBooleanPrefs(this, PrefData.KEY_IS_LATERAL_GAP_FILL_B, true));
        enableOtherSizeSettings(!checkFullWidth.isChecked());
        textSizeIntro.setText(arrSizeTitle[getCurrentSizePosition()]);
        textAlignmentIntro.setText(arrAlignmentTitle[PrefData.getIntPrefs(this, PrefData.KEY_ALIGN_I, PrefData.VAL_ALIGN_CENTER)]);
    }

    private void initFeedbackSettings() {
        checkSound.setChecked(PrefData.getBooleanPrefs(SettingsActivity.this, PrefData.KEY_IS_SOUND_ENABLED_B));
        checkVibra.setChecked(PrefData.getBooleanPrefs(SettingsActivity.this, PrefData.KEY_IS_VIBRA_ENABLED_B));
    }

    private void initTextSettings() {
        checkDotSpace.setChecked(PrefData.getBooleanPrefs(SettingsActivity.this, PrefData.KEY_IS_DOT_SPACE_ENABLED_B, true));
        checkPreview.setChecked(PrefData.getBooleanPrefs(SettingsActivity.this, PrefData.KEY_IS_PREVIEW_ENABLED_B, true));
        checkTextSuggestion.setChecked(PrefData.getBooleanPrefs(SettingsActivity.this, PrefData.KEY_IS_TEXT_SUGGESTION_ENABLED_B));
        checkTextAutoCapitalization.setChecked(PrefData.getBooleanPrefs(SettingsActivity.this, PrefData.KEY_IS_TEXT_AUTOCAPITALIZATION_ENABLED_B));
    }

    private void showCurrencyDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.DialogTheme);

        LayoutInflater inflater = LayoutInflater.from(this);
        TextView textTitle = (TextView) inflater.inflate(R.layout.dialog_title, null);
        textTitle.setText(R.string.currency_selection);

        builder.setCustomTitle(textTitle)
                .setSingleChoiceItems(
                        new ArrayAdapter<>(this, R.layout.item_list_simple, arrCurrencyTitle),
                        PrefData.getIntPrefs(this, PrefData.KEY_CURRENCY_I, PrefData.VAL_CURRENCY_EUR),
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int position) {
                                PrefData.setIntPrefs(SettingsActivity.this, PrefData.KEY_CURRENCY_I, position);
                                textSelectedCurrency.setText(arrCurrencyTitle[position]);
                                dialogInterface.dismiss();
                            }
                        })
                .setNegativeButton(R.string.cancel, null);
        builder.create().show();
    }

    private void showNotificationDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.DialogTheme);
        SpannableString spannableString = new SpannableString(getString(R.string.notification_sync_message));
        spannableString.setSpan(new TypefaceSpan(this, getString(R.string.font_dosis_regular)), 0, spannableString.length(),
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        LayoutInflater inflater = LayoutInflater.from(this);
        TextView textTitle = (TextView) inflater.inflate(R.layout.dialog_title, null);
        textTitle.setText(R.string.currency_selection);
        builder.setNegativeButton(R.string.cancel, null)
                .setMessage(spannableString);
        builder.create().show();
    }

    private void showSizeDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.DialogTheme);

        LayoutInflater inflater = LayoutInflater.from(this);
        TextView textTitle = (TextView) inflater.inflate(R.layout.dialog_title, null);
        View view = inflater.inflate(R.layout.dialog_size, null);

        textTitle.setText(R.string.size);
        final TextView textSize = view.findViewById(R.id.text_size);
        final SeekBar seekSize = view.findViewById(R.id.seek_size);

        seekSize.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                textSize.setText(arrSizeTitle[progress]);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekSize.setProgress(getCurrentSizePosition());

        builder.setCustomTitle(textTitle)
                .setView(view)
                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        PrefData.setFloatPrefs(SettingsActivity.this, PrefData.KEY_KB_SIZE_F, arrSizeValue[seekSize.getProgress()]);
                        textSizeIntro.setText(arrSizeTitle[seekSize.getProgress()]);
                    }
                }).setNegativeButton(R.string.cancel, null)
                .setNeutralButton(R.string.default_, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        PrefData.setFloatPrefs(SettingsActivity.this, PrefData.KEY_KB_SIZE_F, arrSizeValue[4]);
                        textSizeIntro.setText(arrSizeTitle[4]);
                    }
                });
        builder.create().show();
    }

    private void showAlignmentDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.DialogTheme);

        LayoutInflater inflater = LayoutInflater.from(this);
        TextView textTitle = (TextView) inflater.inflate(R.layout.dialog_title, null);
        textTitle.setText(R.string.alignment);

        builder.setCustomTitle(textTitle)
                .setSingleChoiceItems(
                        new ArrayAdapter<>(this, R.layout.item_list_simple, getResources().getStringArray(R.array.alignments)),
                        PrefData.getIntPrefs(this, PrefData.KEY_ALIGN_I, PrefData.VAL_ALIGN_CENTER),
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int position) {
                                PrefData.setIntPrefs(SettingsActivity.this, PrefData.KEY_ALIGN_I, position);
                                textAlignmentIntro.setText(arrAlignmentTitle[position]);
                                dialogInterface.dismiss();
                            }
                        })
                .setNegativeButton(R.string.cancel, null);
        builder.create().show();
    }

    private int getCurrentSizePosition() {
        float currentSize = PrefData.getFloatPrefs(this, PrefData.KEY_KB_SIZE_F, PrefData.VAL_KB_SIZE_PHONE_MEDIUM);
        if (currentSize == PrefData.VAL_KB_SIZE_TAB_SMALL) {
            return 0;
        } else if (currentSize == PrefData.VAL_KB_SIZE_TAB_MEDIUM) {
            return 1;
        } else if (currentSize == PrefData.VAL_KB_SIZE_TAB_LARGE) {
            return 2;
        } else if (currentSize == PrefData.VAL_KB_SIZE_PHONE_SMALL) {
            return 3;
        } else if (currentSize == PrefData.VAL_KB_SIZE_PHONE_MEDIUM) {
            return 4;
        } else if (currentSize == PrefData.VAL_KB_SIZE_PHONE_LARGE) {
            return 5;
        }
        return 4;
    }

    private void enableOtherSizeSettings(boolean enable) {
        int textColor = enable ? getResources().getColor(R.color.black) : getResources().getColor(R.color.text_gray);
        linearSize.setEnabled(enable);
        textSize.setTextColor(textColor);
        linearAlignment.setEnabled(enable);
        textAlignment.setTextColor(textColor);
        relativeLateralGap.setEnabled(enable);
        textLateralGap.setTextColor(textColor);
    }

    @Override
    protected void onPause() {
        overridePendingTransition(0, android.R.anim.fade_out);
        super.onPause();
    }

}
