package it.keybeeproject.keybee.model;

import android.graphics.Color;
import android.util.Log;

import java.util.ArrayList;

import it.keybeeproject.keybee.R;

public class Theme {

    private static final String TAG = Theme.class.getSimpleName();

    private String themeId;
    private String name;
    private String price;
    private boolean isSelected;
    private boolean isPurchased;
    private int cellBackgroundColor;
    private int cellFontColor;
    private int defaultKeyExternalColor;
    private int defaultKeyCenterColor;
    private int defaultKeyFontColor;
    private int defaultKeyPressedColor;
    private int specialKeyExternalColor;
    private int specialKeyCenterColor;
    private int specialKeyFontColor;
    private int specialKeyPressedColor;
    private int iconColor;
    private int keyStrokeColor;
    private int backgroundColor;
    private int popupColor;
    private int popupFontColor;
    private int popupSelectedColor;
    private int popupSelectedFontColor;
    private int popupStroke;
    private int candidateBgColor;
    private int candidateFontColor;
    private int emojiBgColor;
    private int emojiCategoryBgColor;
    private int emojiCategoryIconColor;
    private int thumbnailRes;

    public Theme(String themeId, String name, boolean isSelected, boolean isPurchased,int cellBackgroundColor,int cellFontColor,
                 int defaultKeyExternalColor, int defaultKeyCenterColor, int defaultKeyFontColor, int defaultKeyPressedColor,
                 int specialKeyExternalColor, int specialKeyCenterColor, int specialKeyFontColor, int specialKeyPressedColor,
                 int iconColor, int keyStrokeColor, int backgroundColor,
                 int popupColor, int popupFontColor, int popupSelectedColor, int popupSelectedFontColor, int popupStroke,
                 int candidateBgColor, int candidateFontColor,
                 int emojiBgColor, int emojiCategoryBgColor, int emojiCategoryIconColor, int thumbnailRes) {

        this.themeId = themeId;
        this.name = name;
        this.isSelected = isSelected;
        this.isPurchased = isPurchased;
        this.cellBackgroundColor = cellBackgroundColor;
        this.cellFontColor = cellFontColor;
        this.defaultKeyExternalColor = defaultKeyExternalColor;
        this.defaultKeyCenterColor = defaultKeyCenterColor;
        this.defaultKeyFontColor = defaultKeyFontColor;
        this.defaultKeyPressedColor = defaultKeyPressedColor;
        this.specialKeyExternalColor = specialKeyExternalColor;
        this.specialKeyCenterColor = specialKeyCenterColor;
        this.specialKeyFontColor = specialKeyFontColor;
        this.specialKeyPressedColor = specialKeyPressedColor;
        this.iconColor = iconColor;
        this.keyStrokeColor = keyStrokeColor;
        this.backgroundColor = backgroundColor;
        this.popupColor = popupColor;
        this.popupFontColor = popupFontColor;
        this.popupSelectedColor = popupSelectedColor;
        this.popupSelectedFontColor = popupSelectedFontColor;
        this.popupStroke = popupStroke;
        this.candidateBgColor = candidateBgColor;
        this.candidateFontColor = candidateFontColor;
        this.emojiBgColor = emojiBgColor;
        this.emojiCategoryBgColor = emojiCategoryBgColor;
        this.emojiCategoryIconColor = emojiCategoryIconColor;
        this.thumbnailRes = thumbnailRes;
    }

    public int getCellFontColor() {
        return cellFontColor;
    }

    public int getCellBackgroundColor() {
        return cellBackgroundColor;
    }

    public String getThemeId() {
        return themeId;
    }

    public void setThemeId(String themeId) {
        this.themeId = themeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public boolean isPurchased() {
        return isPurchased;
    }

    public void setPurchased(boolean purchased) {
        isPurchased = purchased;
    }

    public int getDefaultKeyExternalColor() {
        return defaultKeyExternalColor;
    }

    public void setDefaultKeyExternalColor(int defaultKeyExternalColor) {
        this.defaultKeyExternalColor = defaultKeyExternalColor;
    }

    public int getDefaultKeyCenterColor() {
        return defaultKeyCenterColor;
    }

    public void setDefaultKeyCenterColor(int defaultKeyCenterColor) {
        this.defaultKeyCenterColor = defaultKeyCenterColor;
    }

    public int getDefaultKeyFontColor() {
        return defaultKeyFontColor;
    }

    public void setDefaultKeyFontColor(int defaultKeyFontColor) {
        this.defaultKeyFontColor = defaultKeyFontColor;
    }

    public int getDefaultKeyPressedColor() {
        return defaultKeyPressedColor;
    }

    public void setDefaultKeyPressedColor(int defaultKeyPressedColor) {
        this.defaultKeyPressedColor = defaultKeyPressedColor;
    }

    public int getSpecialKeyExternalColor() {
        return specialKeyExternalColor;
    }

    public void setSpecialKeyExternalColor(int specialKeyExternalColor) {
        this.specialKeyExternalColor = specialKeyExternalColor;
    }

    public int getSpecialKeyCenterColor() {
        return specialKeyCenterColor;
    }

    public void setSpecialKeyCenterColor(int specialKeyCenterColor) {
        this.specialKeyCenterColor = specialKeyCenterColor;
    }

    public int getSpecialKeyFontColor() {
        return specialKeyFontColor;
    }

    public void setSpecialKeyFontColor(int specialKeyFontColor) {
        this.specialKeyFontColor = specialKeyFontColor;
    }

    public int getSpecialKeyPressedColor() {
        return specialKeyPressedColor;
    }

    public void setSpecialKeyPressedColor(int specialKeyPressedColor) {
        this.specialKeyPressedColor = specialKeyPressedColor;
    }

    public int getIconColor() {
        return iconColor;
    }

    public void setIconColor(int iconColor) {
        this.iconColor = iconColor;
    }

    public int getKeyStrokeColor() {
        return keyStrokeColor;
    }

    public void setKeyStrokeColor(int keyStrokeColor) {
        this.keyStrokeColor = keyStrokeColor;
    }

    public int getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(int backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public int getPopupColor() {
        return popupColor;
    }

    public void setPopupColor(int popupColor) {
        this.popupColor = popupColor;
    }

    public int getPopupFontColor() {
        return popupFontColor;
    }

    public void setPopupFontColor(int popupFontColor) {
        this.popupFontColor = popupFontColor;
    }

    public int getPopupSelectedColor() {
        return popupSelectedColor;
    }

    public void setPopupSelectedColor(int popupSelectedColor) {
        this.popupSelectedColor = popupSelectedColor;
    }

    public int getPopupSelectedFontColor() {
        return popupSelectedFontColor;
    }

    public void setPopupSelectedFontColor(int popupSelectedFontColor) {
        this.popupSelectedFontColor = popupSelectedFontColor;
    }

    public int getPopupStroke() {
        return popupStroke;
    }

    public void setPopupStroke(int popupStroke) {
        this.popupStroke = popupStroke;
    }

    public int getCandidateBgColor() {
        return candidateBgColor;
    }

    public void setCandidateBgColor(int candidateBgColor) {
        this.candidateBgColor = candidateBgColor;
    }

    public int getCandidateFontColor() {
        return candidateFontColor;
    }

    public void setCandidateFontColor(int candidateFontColor) {
        this.candidateFontColor = candidateFontColor;
    }

    public int getEmojiBgColor() {
        return emojiBgColor;
    }

    public void setEmojiBgColor(int emojiBgColor) {
        this.emojiBgColor = emojiBgColor;
    }

    public int getEmojiCategoryBgColor() {
        return emojiCategoryBgColor;
    }

    public void setEmojiCategoryBgColor(int emojiCategoryBgColor) {
        this.emojiCategoryBgColor = emojiCategoryBgColor;
    }

    public int getEmojiCategoryIconColor() {
        return emojiCategoryIconColor;
    }

    public void setEmojiCategoryIconColor(int emojiCategoryIconColor) {
        this.emojiCategoryIconColor = emojiCategoryIconColor;
    }

    public int getThumbnailRes() {
        return thumbnailRes;
    }

    public void setThumbnailRes(int thumbnailRes) {
        this.thumbnailRes = thumbnailRes;
    }

    public static ArrayList<Theme> getThemes() {
        ArrayList<Theme> arrListTheme = new ArrayList<>();
        try {

            arrListTheme.add(new Theme("theme_001", "Dark", true, true,
                    Color.parseColor("#1a1a1a"),
                    Color.parseColor("#FFFFFF"),
                    Color.parseColor("#1a1a1a"),
                    Color.parseColor("#2B2B2B"),
                    Color.parseColor("#FFFFFF"),
                    Color.parseColor("#2B2B2B"),
                    Color.parseColor("#1a1a1a"),
                    Color.parseColor("#2B2B2B"),
                    Color.parseColor("#FFFFFF"),
                    Color.parseColor("#2B2B2B"),
                    Color.parseColor("#3898b5"),
                    Color.parseColor("#000000"),
                    Color.parseColor("#121212"),

                    Color.parseColor("#2B2B2B"),
                    Color.parseColor("#FFFFFF"),
                    Color.parseColor("#3898b5"),
                    Color.parseColor("#FFFFFF"),
                    Color.parseColor("#000000"),
                    Color.parseColor("#121212"),
                    Color.parseColor("#3898b5"),
                    Color.parseColor("#121212"),
                    Color.parseColor("#2b2b2b"),
                    Color.parseColor("#FFFFFF"),
                    R.drawable.img_theme_001));

            arrListTheme.add(new Theme("theme_002", "Light", false, true,
                    Color.parseColor("#E8E8E8"),
                    Color.parseColor("#2e2e2e"),
                    Color.parseColor("#E8E8E8"),
                    Color.parseColor("#FFFFFF"),
                    Color.parseColor("#2e2e2e"),
                    Color.parseColor("#F7F7F7"),
                    Color.parseColor("#E8E8E8"),
                    Color.parseColor("#FFFFFF"),
                    Color.parseColor("#2e2e2e"),
                    Color.parseColor("#F7F7F7"),
                    Color.parseColor("#14aaef"),
                    Color.parseColor("#999999"),
                    Color.parseColor("#F5f5f5"),

                    Color.parseColor("#F7F7F7"),
                    Color.parseColor("#2e2e2e"),
                    Color.parseColor("#14aaef"),
                    Color.parseColor("#2e2e2e"),
                    Color.parseColor("#999999"),
                    Color.parseColor("#F5f5f5"),
                    Color.parseColor("#14aaef"),
                    Color.parseColor("#F5F5F5"),
                    Color.parseColor("#FFFFFF"),
                    Color.parseColor("#2e2e2e"),
                    R.drawable.img_theme_002));

            arrListTheme.add(new Theme("theme_003", "Minimal Black", false, true,
                    Color.parseColor("#000000"),
                    Color.parseColor("#FFFFFF"),
                    Color.parseColor("#000000"),
                    Color.parseColor("#000000"),
                    Color.parseColor("#FFFFFF"),
                    Color.parseColor("#121212"),
                    Color.parseColor("#000000"),
                    Color.parseColor("#000000"),
                    Color.parseColor("#FFFFFF"),
                    Color.parseColor("#000000"),
                    Color.parseColor("#FFFFFF"),
                    Color.parseColor("#000000"),
                    Color.parseColor("#000000"),

                    Color.parseColor("#000000"),
                    Color.parseColor("#FFFFFF"),
                    Color.parseColor("#FFFFFF"),
                    Color.parseColor("#000000"),
                    Color.parseColor("#FFFFFF"),
                    Color.parseColor("#000000"),
                    Color.parseColor("#FFFFFF"),
                    Color.parseColor("#121212"),
                    Color.parseColor("#2b2b2b"),
                    Color.parseColor("#FFFFFF"),
                    R.drawable.img_theme_003));

            arrListTheme.add(new Theme("theme_004", "Vintage Teal", false, true,
                    Color.parseColor("#30666d"),
                    Color.parseColor("#f4e9d7"),
                    Color.parseColor("#30666d"),
                    Color.parseColor("#497578"),
                    Color.parseColor("#f4e9d7"),
                    Color.parseColor("#497578"),
                    Color.parseColor("#c05336"),
                    Color.parseColor("#dc7358"),
                    Color.parseColor("#f4e9d7"),
                    Color.parseColor("#dc7358"),
                    Color.parseColor("#1c5259"),
                    Color.parseColor("#edd2a5"),
                    Color.parseColor("#f4e8d8"),

                    Color.parseColor("#497578"),
                    Color.parseColor("#f4e9d7"),
                    Color.parseColor("#dc7358"),
                    Color.parseColor("#f4e9d7"),
                    Color.parseColor("#edd2a5"),
                    Color.parseColor("#f4e8d8"),
                    Color.parseColor("#1c5259"),
                    Color.parseColor("#F5F5F5"),
                    Color.parseColor("#FFFFFF"),
                    Color.parseColor("#2e2e2e"),
                    R.drawable.img_theme_004));

            arrListTheme.add(new Theme("theme_005", "RGB", false, true,
                    Color.parseColor("#FFFFFF"),
                    Color.parseColor("#2476ff"),
                    Color.parseColor("#FFFFFF"),
                    Color.parseColor("#FFFFFF"),
                    Color.parseColor("#2476ff"),
                    Color.parseColor("#F5F5F5"),
                    Color.parseColor("#FFFFFF"),
                    Color.parseColor("#FFFFFF"),
                    Color.parseColor("#ff2a00"),
                    Color.parseColor("#F5F5F5"),
                    Color.parseColor("#00ac2e"),
                    Color.parseColor("#FFFFFF"),
                    Color.parseColor("#FFFFFF"),

                    Color.parseColor("#FFFFFF"),
                    Color.parseColor("#2476ff"),
                    Color.parseColor("#FFFFFF"),
                    Color.parseColor("#ff2a00"),
                    Color.parseColor("#00ac2e"),
                    Color.parseColor("#FFFFFF"),
                    Color.parseColor("#00ac2e"),
                    Color.parseColor("#F5F5F5"),
                    Color.parseColor("#FFFFFF"),
                    Color.parseColor("#2e2e2e"),
                    R.drawable.img_theme_005));

            arrListTheme.add(new Theme("theme_006", "Midnight Gold", false, true,
                    Color.parseColor("#081936"),
                    Color.parseColor("#FFC445"),
                    Color.parseColor("#081936"),
                    Color.parseColor("#1D3357"),
                    Color.parseColor("#FFC445"),
                    Color.parseColor("#112445"),
                    Color.parseColor("#081936"),
                    Color.parseColor("#1D3357"),
                    Color.parseColor("#FFC445"),
                    Color.parseColor("#112445"),
                    Color.parseColor("#fbce57"),
                    Color.parseColor("#000C29"),
                    Color.parseColor("#000C29"),

                    Color.parseColor("#112445"),
                    Color.parseColor("#FFC445"),
                    Color.parseColor("#FFC445"),
                    Color.parseColor("#112445"),
                    Color.parseColor("#000C29"),
                    Color.parseColor("#000C29"),
                    Color.parseColor("#fbce57"),
                    Color.parseColor("#121212"),
                    Color.parseColor("#2b2b2b"),
                    Color.parseColor("#FFFFFF"),
                    R.drawable.img_theme_006));

            arrListTheme.add(new Theme("theme_007", "Sunny Yellow", false, true,
                    Color.parseColor("#FFC80B"),
                    Color.parseColor("#000000"),
                    Color.parseColor("#FFC80B"),
                    Color.parseColor("#FFC80B"),
                    Color.parseColor("#000000"),
                    Color.parseColor("#FFDA5C"),
                    Color.parseColor("#EC6626"),
                    Color.parseColor("#EC6626"),
                    Color.parseColor("#FFFFFF"),
                    Color.parseColor("#F58E5D"),
                    Color.parseColor("#FFFFFF"),
                    Color.parseColor("#000000"),
                    Color.parseColor("#005398"),

                    Color.parseColor("#FFDA5C"),
                    Color.parseColor("#000000"),
                    Color.parseColor("#EC6626"),
                    Color.parseColor("#FFFFFF"),
                    Color.parseColor("#000000"),
                    Color.parseColor("#005398"),
                    Color.parseColor("#FFFFFF"),
                    Color.parseColor("#121212"),
                    Color.parseColor("#2b2b2b"),
                    Color.parseColor("#FFFFFF"),
                    R.drawable.img_theme_007));

            arrListTheme.add(new Theme("theme_008", "British Racing Green", false, true,
                    Color.parseColor("#003D22"),
                    Color.parseColor("#ffcb3f"),
                    Color.parseColor("#003D22"),
                    Color.parseColor("#004d2b"),
                    Color.parseColor("#ffcb3f"),
                    Color.parseColor("#004d2b"),
                    Color.parseColor("#00361E"),
                    Color.parseColor("#004225"),
                    Color.parseColor("#ffcb3f"),
                    Color.parseColor("#004d2b"),
                    Color.parseColor("#7B9E81"),
                    Color.parseColor("#002B19"),
                    Color.parseColor("#002B19"),

                    Color.parseColor("#004d2b"),
                    Color.parseColor("#ffcb3f"),
                    Color.parseColor("#ffcb3f"),
                    Color.parseColor("#004d2b"),
                    Color.parseColor("#002B19"),
                    Color.parseColor("#002B19"),
                    Color.parseColor("#7B9E81"),
                    Color.parseColor("#121212"),
                    Color.parseColor("#2b2b2b"),
                    Color.parseColor("#FFFFFF"),
                    R.drawable.img_theme_008));

            arrListTheme.add(new Theme("theme_009", "Cappuccino Cream", false, true,
                    Color.parseColor("#F5F3EB"),
                    Color.parseColor("#783E1D"),
                    Color.parseColor("#F5F3EB"),
                    Color.parseColor("#F5F3EB"),
                    Color.parseColor("#783E1D"),
                    Color.parseColor("#F7EFE1"),
                    Color.parseColor("#D9A877"),
                    Color.parseColor("#F0CDA3"),
                    Color.parseColor("#FFFFFF"),
                    Color.parseColor("#F0CDA3"),
                    Color.parseColor("#FCFBE3"),
                    Color.parseColor("#8A665C"),
                    Color.parseColor("#4D2B22"),

                    Color.parseColor("#F7EFE1"),
                    Color.parseColor("#783E1D"),
                    Color.parseColor("#D9A877"),
                    Color.parseColor("#FCFBE3"),
                    Color.parseColor("#8A665C"),
                    Color.parseColor("#4D2B22"),
                    Color.parseColor("#FCFBE3"),
                    Color.parseColor("#F5F5F5"),
                    Color.parseColor("#FFFFFF"),
                    Color.parseColor("#2e2e2e"),
                    R.drawable.img_theme_009));

            arrListTheme.add(new Theme("theme_010", "Planet Blue", false, true,
                    Color.parseColor("#063A70"),
                    Color.parseColor("#DEC685"),
                    Color.parseColor("#063A70"),
                    Color.parseColor("#0A4D94"),
                    Color.parseColor("#DEC685"),
                    Color.parseColor("#0A4D94"),
                    Color.parseColor("#044A1B"),
                    Color.parseColor("#096125"),
                    Color.parseColor("#DEC685"),
                    Color.parseColor("#096125"),
                    Color.parseColor("#DEC685"),
                    Color.parseColor("#000D14"),
                    Color.parseColor("#050F1C"),

                    Color.parseColor("#044A1B"),
                    Color.parseColor("#DEC685"),
                    Color.parseColor("#DEC685"),
                    Color.parseColor("#044A1B"),
                    Color.parseColor("#000D14"),
                    Color.parseColor("#050F1C"),
                    Color.parseColor("#DEC685"),
                    Color.parseColor("#121212"),
                    Color.parseColor("#2b2b2b"),
                    Color.parseColor("#FFFFFF"),
                    R.drawable.img_theme_010));

            arrListTheme.add(new Theme("theme_011", "Pumpkin Orange", false, true,
                    Color.parseColor("#D66400"),
                    Color.parseColor("#FCECBD"),
                    Color.parseColor("#D66400"),
                    Color.parseColor("#E38330"),
                    Color.parseColor("#FCECBD"),
                    Color.parseColor("#E38330"),
                    Color.parseColor("#A22543"),
                    Color.parseColor("#DF2A33"),
                    Color.parseColor("#FCECBD"),
                    Color.parseColor("#BF133C"),
                    Color.parseColor("#FCECBD"),
                    Color.parseColor("#FFDDBF"),
                    Color.parseColor("#36402F"),

                    Color.parseColor("#E38330"),
                    Color.parseColor("#FCECBD"),
                    Color.parseColor("#A22543"),
                    Color.parseColor("#FCECBD"),
                    Color.parseColor("#FFDDBF"),
                    Color.parseColor("#36402F"),
                    Color.parseColor("#FCECBD"),
                    Color.parseColor("#121212"),
                    Color.parseColor("#2b2b2b"),
                    Color.parseColor("#FFFFFF"),
                    R.drawable.img_theme_011));

            arrListTheme.add(new Theme("theme_012", "Cactus Green", false, true,
                    Color.parseColor("#3e512a"),
                    Color.parseColor("#f5edda"),
                    Color.parseColor("#3e512a"),
                    Color.parseColor("#4B7042"),
                    Color.parseColor("#f5edda"),
                    Color.parseColor("#4B7042"),
                    Color.parseColor("#253614"),
                    Color.parseColor("#3E5229"),
                    Color.parseColor("#F2DED3"),
                    Color.parseColor("#374A23"),
                    Color.parseColor("#374a2d"),
                    Color.parseColor("#faccb2"),
                    Color.parseColor("#faccb2"),

                    Color.parseColor("#4B7042"),
                    Color.parseColor("#f5edda"),
                    Color.parseColor("#253614"),
                    Color.parseColor("#f5edda"),
                    Color.parseColor("#faccb2"),
                    Color.parseColor("#faccb2"),
                    Color.parseColor("#374a2d"),
                    Color.parseColor("#F5F5F5"),
                    Color.parseColor("#FFFFFF"),
                    Color.parseColor("#2e2e2e"),
                    R.drawable.img_theme_012));

            arrListTheme.add(new Theme("theme_013", "Mozzarella White", false, true,
                    Color.parseColor("#FFFFFF"),
                    Color.parseColor("#194500"),
                    Color.parseColor("#FFFFFF"),
                    Color.parseColor("#FFFFFF"),
                    Color.parseColor("#194500"),
                    Color.parseColor("#F7F6ED"),
                    Color.parseColor("#659E44"),
                    Color.parseColor("#659E44"),
                    Color.parseColor("#FFFFFF"),
                    Color.parseColor("#7AC44F"),
                    Color.parseColor("#F2EFDC"),
                    Color.parseColor("#194500"),
                    Color.parseColor("#DB3F1F"),

                    Color.parseColor("#F7F6ED"),
                    Color.parseColor("#194500"),
                    Color.parseColor("#659E44"),
                    Color.parseColor("#FFFFFF"),
                    Color.parseColor("#194500"),
                    Color.parseColor("#DB3F1F"),
                    Color.parseColor("#F2EFDC"),
                    Color.parseColor("#F5F5F5"),
                    Color.parseColor("#FFFFFF"),
                    Color.parseColor("#2e2e2e"),
                    R.drawable.img_theme_013));

            arrListTheme.add(new Theme("theme_014", "Electric Blue", false, true,
                    Color.parseColor("#041263"),
                    Color.parseColor("#FF00E8"),
                    Color.parseColor("#041263"),
                    Color.parseColor("#081C8C"),
                    Color.parseColor("#FF00E8"),
                    Color.parseColor("#132278"),
                    Color.parseColor("#030F52"),
                    Color.parseColor("#00137A"),
                    Color.parseColor("#00D69A"),
                    Color.parseColor("#132278"),
                    Color.parseColor("#45D7FF"),
                    Color.parseColor("#00072B"),
                    Color.parseColor("#00072B"),

                    Color.parseColor("#132278"),
                    Color.parseColor("#FF00E8"),
                    Color.parseColor("#00D69A"),
                    Color.parseColor("#132278"),
                    Color.parseColor("#00072B"),
                    Color.parseColor("#00072B"),
                    Color.parseColor("#45D7FF"),
                    Color.parseColor("#121212"),
                    Color.parseColor("#2b2b2b"),
                    Color.parseColor("#FFFFFF"),
                    R.drawable.img_theme_014));

            arrListTheme.add(new Theme("theme_015", "New York Yellow", false, true,
                    Color.parseColor("#ffb217"),
                    Color.parseColor("#000000"),
                    Color.parseColor("#ffb217"),
                    Color.parseColor("#ffbf17"),
                    Color.parseColor("#000000"),
                    Color.parseColor("#ffbf17"),
                    Color.parseColor("#000000"),
                    Color.parseColor("#000000"),
                    Color.parseColor("#ffb217"),
                    Color.parseColor("#1b1b1b"),
                    Color.parseColor("#FFFFFF"),
                    Color.parseColor("#000000"),
                    Color.parseColor("#4e4e4e"),

                    Color.parseColor("#ffbf17"),
                    Color.parseColor("#000000"),
                    Color.parseColor("#000000"),
                    Color.parseColor("#ffb217"),
                    Color.parseColor("#000000"),
                    Color.parseColor("#4e4e4e"),
                    Color.parseColor("#FFFFFF"),
                    Color.parseColor("#121212"),
                    Color.parseColor("#2b2b2b"),
                    Color.parseColor("#FFFFFF"),
                    R.drawable.img_theme_015));

            arrListTheme.add(new Theme("theme_016", "Summer Vibe", false, true,
                    Color.parseColor("#69c2b5"),
                    Color.parseColor("#FFFFFF"),
                    Color.parseColor("#69c2b5"),
                    Color.parseColor("#69c2b5"),
                    Color.parseColor("#FFFFFF"),
                    Color.parseColor("#6dccbe"),
                    Color.parseColor("#ffaf3c"),
                    Color.parseColor("#ffaf3c"),
                    Color.parseColor("#FFFFFF"),
                    Color.parseColor("#ffc852"),
                    Color.parseColor("#FFFFFF"),
                    Color.parseColor("#f1f1f1"),
                    Color.parseColor("#f28f8f"),

                    Color.parseColor("#6dccbe"),
                    Color.parseColor("#FFFFFF"),
                    Color.parseColor("#ffaf3c"),
                    Color.parseColor("#FFFFFF"),
                    Color.parseColor("#f1f1f1"),
                    Color.parseColor("#f28f8f"),
                    Color.parseColor("#FFFFFF"),
                    Color.parseColor("#F5F5F5"),
                    Color.parseColor("#FFFFFF"),
                    Color.parseColor("#2e2e2e"),
                    R.drawable.img_theme_016));

            arrListTheme.add(new Theme("theme_017", "Aldebaran Red", false, true,
                    Color.parseColor("#a11e21"),
                    Color.parseColor("#ffe672"),
                    Color.parseColor("#a11e21"),
                    Color.parseColor("#e74222"),
                    Color.parseColor("#ffe672"),
                    Color.parseColor("#bf3521"),
                    Color.parseColor("#a11e21"),
                    Color.parseColor("#e74222"),
                    Color.parseColor("#ffe672"),
                    Color.parseColor("#bf3521"),
                    Color.parseColor("#FFFFFF"),
                    Color.parseColor("#000000"),
                    Color.parseColor("#0e0d17"),

                    Color.parseColor("#bf3521"),
                    Color.parseColor("#ffe672"),
                    Color.parseColor("#FFFFFF"),
                    Color.parseColor("#e74222"),
                    Color.parseColor("#000000"),
                    Color.parseColor("#0e0d17"),
                    Color.parseColor("#FFFFFF"),
                    Color.parseColor("#121212"),
                    Color.parseColor("#2b2b2b"),
                    Color.parseColor("#FFFFFF"),
                    R.drawable.img_theme_017));

            arrListTheme.add(new Theme("theme_018", "Aluminium Silver", false, true,
                    Color.parseColor("#efefef"),
                    Color.parseColor("#2E2E2E"),
                    Color.parseColor("#BABABA"),
                    Color.parseColor("#efefef"),
                    Color.parseColor("#2E2E2E"),
                    Color.parseColor("#d4d4d4"),
                    Color.parseColor("#7b7b7b"),
                    Color.parseColor("#bfbfbf"),
                    Color.parseColor("#FFFFFF"),
                    Color.parseColor("#7b7b7b"),
                    Color.parseColor("#000000"),
                    Color.parseColor("#414141"),
                    Color.parseColor("#f5f5f5"),
                    Color.parseColor("#d4d4d4"),
                    Color.parseColor("#2E2E2E"),
                    Color.parseColor("#7b7b7b"),
                    Color.parseColor("#FFFFFF"),
                    Color.parseColor("#414141"),
                    Color.parseColor("#f5f5f5"),
                    Color.parseColor("#000000"),
                    Color.parseColor("#F5F5F5"),
                    Color.parseColor("#FFFFFF"),
                    Color.parseColor("#2e2e2e"),
                    R.drawable.img_theme_018));

            arrListTheme.add(new Theme("theme_019", "Chat Blue", false, true,
                    Color.parseColor("#02a1ff"),
                    Color.parseColor("#FFFFFF"),
                    Color.parseColor("#f7f7f7"),
                    Color.parseColor("#f7f7f7"),
                    Color.parseColor("#636363"),
                    Color.parseColor("#fbfbfb"),
                    Color.parseColor("#02a1ff"),
                    Color.parseColor("#02a1ff"),
                    Color.parseColor("#FFFFFF"),
                    Color.parseColor("#34b0f9"),
                    Color.parseColor("#0084ff"),
                    Color.parseColor("#c7c7c7"),
                    Color.parseColor("#FFFFFF"),
                    Color.parseColor("#fbfbfb"),
                    Color.parseColor("#636363"),
                    Color.parseColor("#02a1ff"),
                    Color.parseColor("#FFFFFF"),
                    Color.parseColor("#c7c7c7"),
                    Color.parseColor("#FFFFFF"),
                    Color.parseColor("#0084ff"),
                    Color.parseColor("#F5F5F5"),
                    Color.parseColor("#FFFFFF"),
                    Color.parseColor("#2e2e2e"),
                    R.drawable.img_theme_019));

            arrListTheme.add(new Theme("theme_020", "Chat Green", false, true,
                    Color.parseColor("#dcf8c6"),
                    Color.parseColor("#262626"),
                    Color.parseColor("#dcf8c6"),
                    Color.parseColor("#dcf8c6"),
                    Color.parseColor("#262626"),
                    Color.parseColor("#e7ffd5"),
                    Color.parseColor("#075e54"),
                    Color.parseColor("#075e54"),
                    Color.parseColor("#FFFFFF"),
                    Color.parseColor("#09756a"),
                    Color.parseColor("#34b7f1"),
                    Color.parseColor("#c4bdb7"),
                    Color.parseColor("#ece5dd"),
                    Color.parseColor("#e7ffd5"),
                    Color.parseColor("#262626"),
                    Color.parseColor("#075e54"),
                    Color.parseColor("#FFFFFF"),
                    Color.parseColor("#c4bdb7"),
                    Color.parseColor("#ece5dd"),
                    Color.parseColor("#34b7f1"),
                    Color.parseColor("#F5F5F5"),
                    Color.parseColor("#FFFFFF"),
                    Color.parseColor("#2e2e2e"),
                    R.drawable.img_theme_020));

            arrListTheme.add(new Theme("theme_021", "Chat Purple", false, true,
                    Color.parseColor("#715bab"),
                    Color.parseColor("#FFFFFF"),
                    Color.parseColor("#e2d4e7"),
                    Color.parseColor("#e2d4e7"),
                    Color.parseColor("#4e4e4e"),
                    Color.parseColor("#e7daec"),
                    Color.parseColor("#715bab"),
                    Color.parseColor("#715bab"),
                    Color.parseColor("#FFFFFF"),
                    Color.parseColor("#7f66bf"),
                    Color.parseColor("#59267c"),
                    Color.parseColor("#c098e0"),
                    Color.parseColor("#ededed"),
                    Color.parseColor("#e7daec"),
                    Color.parseColor("#4e4e4e"),
                    Color.parseColor("#715bab"),
                    Color.parseColor("#FFFFFF"),
                    Color.parseColor("#c098e0"),
                    Color.parseColor("#ededed"),
                    Color.parseColor("#59267c"),
                    Color.parseColor("#F5F5F5"),
                    Color.parseColor("#FFFFFF"),
                    Color.parseColor("#2e2e2e"),
                    R.drawable.img_theme_021));

        } catch (Exception e) {
            Log.e(TAG, "getThemes Exception : ", e);
        }
        return arrListTheme;
    }
}