package it.keybeeproject.keybee.utility;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by c161 on 29/07/16.
 */
public class PrefData {

    public static final String PREFERENCE = "Keybee";
    public static final String EXPIRY_TIME = "EXPIRY_TIME";
    public static final String KEY_KB_SIZE_F = "keyboardSizePercent";
    public static final String KEY_IS_KB_SIZE_FULL_B = "keyboardSizeFull";
    public static final String KEY_IS_TOP_GAP_FILL = "TopGapFill";
    public static final String KEY_ALIGN_I = "keyboardAlignment";
    public static final String KEY_IS_LATERAL_GAP_FILL_B = "isLateralGapFill";
    public static final String KEY_SELECTED_THEME_POSITION = "selectedThemePosition";
    public static final String KEY_CURRENCY_I = "defaultCurrency";
    public static final String KEY_IS_SOUND_ENABLED_B = "isAudioEnabled";
    public static final String KEY_IS_VIBRA_ENABLED_B = "isVibraEnabled";
    public static final String KEY_IS_FL_LANGUAGE_SET_B = "isFLLangageSet";  // FL : First launch
    public static final String KEY_IS_FL_ENABLED_B = "isFLEnabled";
    public static final String KEY_IS_FL_THEME_SET_B = "isFLThemeSet";
    public static final String KEY_IS_FL_TUTORIAL_SHOWN_B = "isFLTutorialShown";
	public static final String KEY_KEYBOARD_LAYOUT_I = "keyboardLayout";
	public static final String KEY_KEYBOARD_LAYOUT_CUSTOMLAYOUT = "keyboardLayout_custom";
	public static final String KEY_KEYBOARD_LAYOUT_CUSTOMPOPUP = "keyboardLayout_custom_popup";
	public static final String KEY_KEYBOARD_LANGUAGE_I = "keyboardLanguage";
    public static final String KEY_IS_DOT_SPACE_ENABLED_B = "isDotSpaceEnabled";
    public static final String KEY_IS_PREVIEW_ENABLED_B = "isPreviewEnabled";
    public static final String KEY_IS_TWIPE_ENABLED_B = "isTwipeEnabled";
    public static final String KEY_IS_CURSOR_ENABLED_B = "isCursorEnabled";
    public static final String KEY_IS_DOT_ENABLED_B = "isDotEnabled";
    public static final String KEY_IS_DOWNLOAD_EVENT_SENT_B = "isDownloadEventSent";
    public static final String KEY_USAGE_EVENT_DATE_S = "usageEventDate";
    public static final String KEY_IS_TEXT_SUGGESTION_ENABLED_B = "isTextSuggestionEnabled";
    public static final String KEY_IS_TEXT_AUTOCAPITALIZATION_ENABLED_B = "isTextAutocapitalizationEnabled";
    public static final String KEY_TYPE = "KeyboardLayout";
    public static final String AO_EN = "AO_EN";
    public static final String AO_IT = "AO_IT";
    public static final String AO_SP = "AO_SP";
    public static final String AO_DE = "AO_DE";
    public static final String A1_EN = "A1_EN";
    public static final String A1_IT = "A1_IT";
    public static final String A1_SP = "A1_SP";
    public static final String A1_DE = "A1_DE";
    public static final String A2_EN = "A2_EN";
    public static final String A2_IT = "A2_IT";
    public static final String A2_SP = "A2_SP";
    public static final String A2_DE = "A2_DE";
    public static final String A3_EN = "A3_EN";
    public static final String A3_IT = "A3_IT";
    public static final String A3_SP = "A3_SP";
    public static final String A3_DE = "A3_DE";
    public static final String B0_EN = "B0_EN";
    public static final String B0_IT = "B0_IT";
    public static final String B0_SP = "B0_SP";
    public static final String B0_DE = "B0_DE";
    public static final String B1_EN = "B1_EN";
    public static final String B1_IT = "B1_IT";
    public static final String B1_SP = "B1_SP";
    public static final String B1_DE = "B1_DE";
    public static final String B2_EN = "B2_EN";
    public static final String B2_IT = "B2_IT";
    public static final String B2_SP = "B2_SP";
    public static final String B2_DE ="B2_DE";
    public static final String B3_EN = "B3_EN";
    public static final String B3_IT = "B3_IT";
    public static final String B3_SP = "B3_SP";
    public static final String B3_DE = "B3_DE";
    public static final String C0_EN = "C0_EN";
    public static final String C0_IT = "C0_IT";
    public static final String C0_SP = "C0_SP";
    public static final String C0_DE = "C0_DE";
    public static final String C1_EN = "C1_EN";
    public static final String C1_IT = "C1_IT";
    public static final String C1_SP = "C1_SP";
    public static final String C1_DE = "C1_DE";
    public static final String C2_EN = "C2_EN";
    public static final String C2_IT = "C2_IT";
    public static final String C2_SP = "C2_SP";
    public static final String C2_DE = "C2_DE";
    public static final String C3_EN = "C3_EN";
    public static final String C3_IT = "C3_IT";
    public static final String C3_SP = "C3_SP";
    public static final String C3_DE = "C3_DE";
    public static final String D0_EN = "D0_EN";
    public static final String D0_IT = "D0_IT";
    public static final String D0_SP = "D0_SP";
    public static final String D0_DE = "D0_DE";
    public static final String D1_EN = "D1_EN";
    public static final String D1_IT = "D1_IT";
    public static final String D1_SP = "D1_SP";
    public static final String D1_DE = "D1_DE";
    public static final String D3_EN = "D3_EN";
    public static final String D3_IT = "D3_IT";
    public static final String D3_SP = "D3_SP";
    public static final String D3_DE = "D3_DE";
    public static final String E0_EN = "E0_EN";
    public static final String E0_IT = "E0_IT";
    public static final String E0_SP = "E0_SP";
    public static final String E0_DE = "E0_DE";
    public static final String E1_EN = "E1_EN";
    public static final String E1_IT = "E1_IT";
    public static final String E1_SP = "E1_SP";
    public static final String E1_DE = "E1_DE";
    public static final String E2_EN = "E2_EN";
    public static final String E2_IT = "E2_IT";
    public static final String E2_SP = "E2_SP";
    public static final String E2_DE = "E2_DE";
    public static final String E3_EN = "E3_EN";
    public static final String E3_IT = "E3_IT";
    public static final String E3_SP = "E3_SP";
    public static final String E3_DE = "E3_DE";
    public static final String F0_EN = "F0_EN";
    public static final String F0_IT = "F0_IT";
    public static final String F0_SP = "F0_SP";
    public static final String F0_DE = "F0_DE";
    public static final String F1_EN = "F1_EN";
    public static final String F1_IT = "F1_IT";
    public static final String F1_SP = "F1_SP";
    public static final String F1_DE = "F1_DE";
    public static final String F2_EN = "F2_EN";
    public static final String F2_IT = "F2_IT";
    public static final String F2_SP = "F2_SP";
    public static final String F2_DE = "F2_DE";
    public static final String F3_EN = "F3_EN";
    public static final String F3_IT = "F3_IT";
    public static final String F3_SP = "F3_SP";
    public static final String F3_DE = "F3_DE";
    public static final String G1_EN = "G1_EN";
    public static final String G1_IT = "G1_IT";
    public static final String G1_SP = "G1_SP";
    public static final String G1_DE = "G1_DE";
    public static final String G2_EN = "G2_EN";
    public static final String G2_IT = "G2_IT";
    public static final String G2_SP = "G2_SP";
    public static final String G2_DE = "G2_DE";
    public static final String G0_EN = "G0_EN";
    public static final String G0_IT = "G0_IT";
    public static final String G0_SP = "G0_SP";
    public static final String G0_DE = "G0_DE";

    public static final String a="a";
    public static final String c="c";
    public static final String d="d";
    public static final String e="e";
    public static final String g="g";
    public static final String h="h";
    public static final String i="i";
    public static final String k="k";
    public static final String l="l";
    public static final String n="n";
    public static final String o="o";
    public static final String r="r";
    public static final String s="s";
    public static final String t="t";
    public static final String u="u";
    public static final String y="y";
    public static final String z="z";

    public static final float VAL_KB_SIZE_FULL = 1.0f;
    public static final float VAL_KB_SIZE_TAB_SMALL = 0.4f;
    public static final float VAL_KB_SIZE_TAB_MEDIUM = 0.5f;
    public static final float VAL_KB_SIZE_TAB_LARGE = 0.6f;
    public static final float VAL_KB_SIZE_PHONE_SMALL = 0.8f;
    public static final float VAL_KB_SIZE_PHONE_MEDIUM = 0.9f;
    public static final float VAL_KB_SIZE_PHONE_LARGE = 0.95f;
    public static final int VAL_ALIGN_RIGHT = 0;
    public static final int VAL_ALIGN_CENTER = 1;
    public static final int VAL_ALIGN_LEFT = 2;
    public static final int VAL_CURRENCY_EUR = 0;
    public static final int VAL_CURRENCY_USD = 1;
    public static final int VAL_CURRENCY_GBP = 2;
    public static final int VAL_LAYOUT_ENGLISH = 0;
    public static final int VAL_LAYOUT_ITALIAN = 1;
    public static final int VAL_LAYOUT_SPANISH = 2;
    public static final int VAL_LAYOUT_GERMAN = 3;
    public static final int VAL_LAYOUT_NUMBER = 4;
    public static final int VAL_LAYOUT_SYMBOL = 5;
    public static final int VAL_LANGUAGE_ENGLISH = 0;
    public static final int VAL_LANGUAGE_ITALIAN = 1;
    public static final int VAL_LANGUAGE_SPANISH = 2;
    public static final int VAL_LANGUAGE_GERMAN = 3;
    public static final java.lang.String KEY_NOTIFICATION = "KEY_NOTIFICATION";

    public static void setPreferenceChangeListener(Context context, SharedPreferences.OnSharedPreferenceChangeListener listener) {
        context.getSharedPreferences(PREFERENCE, Context.MODE_PRIVATE).registerOnSharedPreferenceChangeListener(listener);
    }

    public static boolean setArrayListPref(Context context, String prefKey, ArrayList<String> list) {
        Gson gson = new Gson();
        String json = gson.toJson(list);
        return context.getSharedPreferences(PREFERENCE, Context.MODE_PRIVATE).edit().putString(prefKey, json).commit();
    }

    public static ArrayList<String> getArrayListPref(Context context, String prefKey) {
        Gson gson = new Gson();
        String json = context.getSharedPreferences(PREFERENCE, Context.MODE_PRIVATE).getString(prefKey, "");
        Type type = new TypeToken<ArrayList<String>>() {}.getType();
        return gson.fromJson(json, type);
        //return context.getSharedPreferences(PREFERENCE, Context.MODE_PRIVATE).getString(prefKey, defaultValue);
    }

    public static boolean setBooleanPrefs(Context context, String prefKey, boolean value) {
        return context.getSharedPreferences(PREFERENCE, Context.MODE_PRIVATE).edit().putBoolean(prefKey, value).commit();
    }

    public static boolean getBooleanPrefs(Context context, String prefKey) {
        return context.getSharedPreferences(PREFERENCE, Context.MODE_PRIVATE).getBoolean(prefKey, false);
    }

    public static boolean getBooleanPrefs(Context context, String prefKey, boolean defaultValue) {
        return context.getSharedPreferences(PREFERENCE, Context.MODE_PRIVATE).getBoolean(prefKey, defaultValue);
    }

    public static boolean setStringPrefs(Context context, String prefKey, String Value) {
	    return context.getSharedPreferences(PREFERENCE, Context.MODE_PRIVATE).edit().putString(prefKey, Value).commit();
    }

    public static String getStringPrefs(Context context, String prefKey) {
        return context.getSharedPreferences(PREFERENCE, Context.MODE_PRIVATE).getString(prefKey, null);
    }

    public static String getStringPrefs(Context context, String prefKey, String defaultValue) {
        return context.getSharedPreferences(PREFERENCE, Context.MODE_PRIVATE).getString(prefKey, defaultValue);
    }

    public static boolean setIntPrefs(Context context, String prefKey, int value) {
	    return context.getSharedPreferences(PREFERENCE, 0).edit().putInt(prefKey, value).commit();
    }

    public static int getIntPrefs(Context context, String prefKey) {
        return context.getSharedPreferences(PREFERENCE, Context.MODE_PRIVATE).getInt(prefKey, 0);
    }

    public static int getIntPrefs(Context context, String prefKey, int defaultValue) {
        return context.getSharedPreferences(PREFERENCE, Context.MODE_PRIVATE).getInt(prefKey, defaultValue);
    }

    public static boolean setLongPrefs(Context context, String prefKey, long value) {
	    return context.getSharedPreferences(PREFERENCE, Context.MODE_PRIVATE).edit().putLong(prefKey, value).commit();
    }

    public static long getLongPrefs(Context context, String prefKey) {
        return context.getSharedPreferences(PREFERENCE, Context.MODE_PRIVATE).getLong(prefKey, 0);
    }

    public static long getLongPrefs(Context context, String prefKey, long defaultValue) {
        return context.getSharedPreferences(PREFERENCE, Context.MODE_PRIVATE).getLong(prefKey, defaultValue);
    }

    public static boolean setFloatPrefs(Context context, String prefKey, float value) {
	    return context.getSharedPreferences(PREFERENCE, Context.MODE_PRIVATE).edit().putFloat(prefKey, value).commit();
    }

    public static float getFloatPrefs(Context context, String prefKey) {
        return context.getSharedPreferences(PREFERENCE, Context.MODE_PRIVATE).getFloat(prefKey, 0);
    }

    public static float getFloatPrefs(Context context, String prefKey, float defaultValue) {
        return context.getSharedPreferences(PREFERENCE, Context.MODE_PRIVATE).getFloat(prefKey, defaultValue);
    }

    /**
     * Clear all data in SharedPreference
     *
     * @param context
     */
    public static boolean clearWholePreference(Context context) {
	    return context.getSharedPreferences(PREFERENCE, Context.MODE_PRIVATE).edit().clear().commit();
    }

    /**
     * Clear single key value
     *
     * @param prefKey
     * @param context
     */
    public static boolean remove(Context context, String prefKey) {
	    return context.getSharedPreferences(PREFERENCE, Context.MODE_PRIVATE).edit().remove(prefKey).commit();
    }

}