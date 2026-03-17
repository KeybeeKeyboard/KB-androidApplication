package it.keybeeproject.keybee.model;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import it.keybeeproject.keybee.utility.PrefData;

public enum ButtonAction {
    // Actions
    Disabled("Disabled", false),
    Settings("Settings", false),
    Emoji("Emoji", false),
    Enter("Enter", false),
    Layout("Layout", false),
    // Letter characters
    A("a", true),
    B("b", true),
    C("c", true),
    D("d", true),
    E("e", true),
    F("f", true),
    G("g", true),
    H("h", true),
    I("i", true),
    J("j", true),
    K("k", true),
    L("l", true),
    M("m", true),
    N("n", true),
    O("o", true),
    P("p", true),
    Q("q", true),
    R("r", true),
    S("s", true),
    T("t", true),
    U("u", true),
    V("v", true),
    W("w", true),
    X("x", true),
    Y("y", true),
    Z("z", true),
    // Symbol characters
    Digit0("0", true),
    Digit1("1", true),
    Digit2("2", true),
    Digit3("3", true),
    Digit4("4", true),
    Digit5("5", true),
    Digit6("6", true),
    Digit7("7", true),
    Digit8("8", true),
    Digit9("9", true),
    // Accent characters
    A1("æ", true),
    A2("à", true),
    A3("ã", true),
    A4("å", true),
    A5("á", true),
    A6("â", true),
    A7("ä", true),
    A8("ª", true),
    A9("ā", true),
    A10("ă", true),
    A11("ą", true),
    C1("ć", true),
    C2("č", true),
    C3("ç", true),
    C4("ċ", true),
    C5("ĉ", true),
    D1("ð", true),
    D2("đ", true),
    D3("ď", true),
    E1("ē", true),
    E2("è", true),
    E3("ê", true),
    E4("ë", true),
    E5("é", true),
    E6("ę", true),
    E7("ė", true),
    E8("ě", true),
    G1("ġ", true),
    G2("ğ", true),
    G3("ĝ", true),
    G4("ģ", true),
    H1("ħ", true),
    H2("ĥ", true),
    I1("ï", true),
    I2("ì", true),
    I3("ī", true),
    I4("î", true),
    I5("í", true),
    I6("į", true),
    I7("ĩ", true),
    J1("ĵ", true),
    K1("ĸ", true),
    K2("ķ", true),
    L1("ļ", true),
    L2("ĺ", true),
    L3("ľ", true),
    L4("ŀ", true),
    L5("ł", true),
    N1("ń", true),
    N2("ñ", true),
    N3("ņ", true),
    N4("ŋ", true),
    N5("ň", true),
    N6("ŉ", true),
    O1("õ", true),
    O2("ò", true),
    O3("ó", true),
    O4("ø", true),
    O5("ō", true),
    O6("ö", true),
    O7("ô", true),
    O8("œ", true),
    O9("º", true),
    O10("ő", true),
    R1("ŕ", true),
    R2("ř", true),
    R3("ŗ", true),
    S1("ŝ", true),
    S2("ß", true),
    S3("š", true),
    S4("ş", true),
    S5("ś", true),
    S6("ș", true),
    T1("ŧ", true),
    T2("ť", true),
    T3("ț", true),
    T4("ţ", true),
    U1("ü", true),
    U2("ù", true),
    U3("ú", true),
    U4("ů", true),
    U5("û", true),
    U6("ū", true),
    U7("ŭ", true),
    U8("ũ", true),
    U9("ų", true),
    U10("ű", true),
    U11("µ", true),
    W1("ŵ", true),
    Y1("ý", true),
    Y2("ŷ", true),
    Y3("ÿ", true),
    Z1("ź", true),
    Z2("ż", true),
    Z3("ž", true),
    Symbol1("'", true),
    Symbol2("\"", true),
    Symbol3("`", true),
    Symbol4("_", true),
    Symbol5("(", true),
    Symbol6(")", true),
    Symbol7("*", true),
    Symbol8("+", true),
    Symbol9("/", true),
    Symbol10("\\", true),
    Symbol11("<", true),
    Symbol12(">", true),
    Symbol13("[", true),
    Symbol14("]", true),
    Symbol15("^", true),
    Symbol16("{", true),
    Symbol17("|", true),
    Symbol18("}", true),
    Symbol19("~", true),
    Symbol20("-", true),
    Symbol21("@", true),
    Symbol22("%", true),
    Symbol23("&", true),
    Symbol24("#", true),
    Symbol25("=", true),
    Symbol26(";", true),
    Symbol27(":", true),
    Symbol28(".", true),
    Symbol29(",", true),
    Symbol30("!", true),
    Symbol31("?", true),
    Symbol32("$", true),
    Symbol33("£", true),
    Symbol34("¥", true),
    Symbol35("¢", true),
    Symbol36("₱", true),
    Symbol37("€", true),
    Symbol38("¡", true),
    Symbol39("±", true),
    Symbol40("–", true),
    Symbol41("—", true),
    Symbol42("×", true),
    Symbol43("≤", true),
    Symbol44("¿", true),
    Symbol45("÷", true),
    Symbol46("„", true),
    Symbol47("«", true),
    Symbol48("“", true),
    Symbol49("»", true),
    Symbol50("≥", true),
    Symbol51("‰", true),
    Symbol52("¼", true),
    Symbol53("¾", true),
    Symbol54("∞", true),
    Symbol55("≠", true),
    Symbol56("≈", true),
    Symbol57("™", true),
    Symbol58("©", true),
    Symbol59("℅", true),
    Symbol60("Π", true),
    Symbol61("¦", true),
    Symbol62("§", true),
    Symbol63("®", true),
    Symbol64("°", true),
    Symbol65("¶", true),
    Symbol66("½", true),
    Symbol67("π", true),
    Symbol68("•", true),
    Symbol69("…", true);

    public final String buttonLabel;
    public final boolean isCharacter;

    ButtonAction(String buttonLabel, boolean isCharacter) {
        this.buttonLabel = buttonLabel;
        this.isCharacter = isCharacter;
    }

    public static final String[] LABELS;
    public static final List<String> NAMES;

    static {
        ButtonAction[] values = values();
        LABELS = new String[values.length];
        NAMES = new ArrayList<>();
        for (int i = 0; i < values.length; i++) {
            LABELS[i] = values[i].buttonLabel;
            NAMES.add(values[i].name());
        }
    }

    /**
     * Helper function to get the setting value for some index
     */
    public static ButtonAction helperGetCustomizableButtonConfiguration(Context context, int idx) {
        List<String> settings = PrefData.getArrayListPref(context, PrefData.CUSTOM_BUTTONS);
        if (settings == null) {
            return ButtonAction.Disabled;
        }
        String buttonActionString = settings.get(idx);
        if (buttonActionString == null) {
            return ButtonAction.Disabled;
        }
        try {
            return ButtonAction.valueOf(buttonActionString);
        } catch (IllegalArgumentException e) {
            return ButtonAction.Disabled;
        }
    }
}
