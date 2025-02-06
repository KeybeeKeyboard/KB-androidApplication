package it.keybeeproject.keybee.service;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Color;
import android.inputmethodservice.InputMethodService;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Vibrator;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatDelegate;
import android.text.InputType;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.ExtractedTextRequest;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.view.textservice.SentenceSuggestionsInfo;
import android.view.textservice.SpellCheckerSession;
import android.view.textservice.SuggestionsInfo;
import android.view.textservice.TextInfo;
import android.view.textservice.TextServicesManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import it.keybeeproject.keybee.R;
import it.keybeeproject.keybee.activity.SettingsActivity;
import it.keybeeproject.keybee.adapter.EmojiAdapter;
import it.keybeeproject.keybee.adapter.EmojiPagerAdapter;
import it.keybeeproject.keybee.model.EmojiFlag;
import it.keybeeproject.keybee.model.Theme;
import it.keybeeproject.keybee.utility.DrawableHelper;
import it.keybeeproject.keybee.utility.PrefData;
import it.keybeeproject.keybee.utility.Utility;
import it.keybeeproject.keybee.view.ButtonHexagon;
import it.keybeeproject.keybee.view.TextViewCustom;

import static android.view.inputmethod.InputConnection.CURSOR_UPDATE_MONITOR;
import static androidx.annotation.Dimension.SP;

/**
 * Created by c161 on 22/07/16.
 */
public class KeyboardService extends InputMethodService implements
        SharedPreferences.OnSharedPreferenceChangeListener, EmojiAdapter.EmojiClickListener,
        SpellCheckerSession.SpellCheckerSessionListener {


    private static final String TAG = KeyboardService.class.getSimpleName();

    private RelativeLayout viewKeyboard, relativeKeyboardContainer, relativeEmoji;
    private LinearLayout linearEmojiCategory, linearCandidate;
    private ButtonHexagon button1, button2, button3, button4, button5, button6, button7, button8, button9, button10,
            button11, button12, button13, button14, button15, button16, button17, button18, button19, button20,
            button21, button22, button23, button24, button25, button26, button27, button28, button29, button30,
            button31, button32, button33, button34, button35, button36, button37, button38, button39;
    private View viewSwipe, viewDivider1, viewDivider2;
    private ViewPager pagerEmoji;
    private ImageView imgCatPeople, imgCatNature, imgCatThing, imgCatPlace, imgCatSymbol, imgDeleteEmoji, imgFlagEmoji;
    private TextView textAbc;
    private TextViewCustom textCandidate1, textCandidate2, textCandidate3;

    private ButtonHexagon[] arrButtons;
    private TextViewCustom[] arrTextCandidate;
    private ImageView[] arrImgEmojiCat;
    private Integer[] arrImgEmojiCatVectors;
    private char[][][] arrKeyCode;
    private ButtonHexagon.OnHexagonTouchListener onHexagonTouchListener;
    private Vibrator vibrator;
    private EmojiPagerAdapter adpEmojiPager;
    private Runnable runnableRepeatClick;
    private StringBuilder composing = new StringBuilder();
    private SpellCheckerSession spellCheckerSession;
    private TextServicesManager textServicesManager;
    private Theme currentTheme;

    private final char KEYCODE_SYM = (char) -111,
            KEYCODE_NUM = (char) -112,
            KEYCODE_ABC = (char) -113,
            KEYCODE_SPACE = (char) -114,
            KEYCODE_SHIFT = (char) -115,
            KEYCODE_SETTINGS = (char) -116,
            KEYCODE_EMOTICON = (char) -117,
            KEYCODE_ALIGNMENT = (char) -118;
    private long currentRepeatInterval = ButtonHexagon.INTERVAL_REPEAT_INITIAL;
    private final int buttonGap = 2; // Must be an even number
    //	private final int buttonGap = 0; // Must be an even number
    private final int cursorThresholdH = 20;
    private final int cursorThresholdV = 80;
    private int keyboardTopPadding, keyboardHeight, keyboardWidth, currentLanguageLayout, currentLanguage, currentLayout,
            currentAlignment, lastMoveId = -1, lastDownId, bgEmoji, hMove, candidateHeight = 0;
    private boolean isTopGap,isFullWidth, isShiftOn, isCapsLockOn, isSoundEnabled, isVibraEnabled, isDotSpaceEnabled,
            isPreviewOn, isMoved, isSizeChanged, isTwipeEnabled, isFirstButtonReset, isCursorEnabled, isCursorModeOn,
            isTextSuggestionEnabled, isCandidateClicked, isAutocapitalizationEnable;
    private boolean isActionDownCalled = false; // If user clicks outside of keyboard then text should not appear.For that ACTION_DOWN will be called but flag will not be true so that ACTION_UP will be called but due to condition code will not be execute.
    private final char space = 32;
    private float lastX, lastY, keyboardSize;

    @Override
    public View onCreateInputView() {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.
                WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        viewKeyboard = (RelativeLayout) getLayoutInflater().inflate(R.layout.layout_keyboard,
                linearLayout, false);

        setUpControls(viewKeyboard);
        initGlobal();

        return viewKeyboard;
    }

    private void setUpControls(RelativeLayout viewKeyboard) {
        button1 = (ButtonHexagon) viewKeyboard.findViewById(R.id.button1);
        button2 = (ButtonHexagon) viewKeyboard.findViewById(R.id.button2);
        button3 = (ButtonHexagon) viewKeyboard.findViewById(R.id.button3);
        button4 = (ButtonHexagon) viewKeyboard.findViewById(R.id.button4);
        button5 = (ButtonHexagon) viewKeyboard.findViewById(R.id.button5);
        button6 = (ButtonHexagon) viewKeyboard.findViewById(R.id.button6);
        button7 = (ButtonHexagon) viewKeyboard.findViewById(R.id.button7);
        button8 = (ButtonHexagon) viewKeyboard.findViewById(R.id.button8);
        button9 = (ButtonHexagon) viewKeyboard.findViewById(R.id.button9);
        button10 = (ButtonHexagon) viewKeyboard.findViewById(R.id.button10);
        button11 = (ButtonHexagon) viewKeyboard.findViewById(R.id.button11);
        button12 = (ButtonHexagon) viewKeyboard.findViewById(R.id.button12);
        button13 = (ButtonHexagon) viewKeyboard.findViewById(R.id.button13);
        button14 = (ButtonHexagon) viewKeyboard.findViewById(R.id.button14);
        button15 = (ButtonHexagon) viewKeyboard.findViewById(R.id.button15);
        button16 = (ButtonHexagon) viewKeyboard.findViewById(R.id.button16);
        button17 = (ButtonHexagon) viewKeyboard.findViewById(R.id.button17);
        button18 = (ButtonHexagon) viewKeyboard.findViewById(R.id.button18);
        button19 = (ButtonHexagon) viewKeyboard.findViewById(R.id.button19);
        button20 = (ButtonHexagon) viewKeyboard.findViewById(R.id.button20);
        button21 = (ButtonHexagon) viewKeyboard.findViewById(R.id.button21);
        button22 = (ButtonHexagon) viewKeyboard.findViewById(R.id.button22);
        button23 = (ButtonHexagon) viewKeyboard.findViewById(R.id.button23);
        button24 = (ButtonHexagon) viewKeyboard.findViewById(R.id.button24);
        button25 = (ButtonHexagon) viewKeyboard.findViewById(R.id.button25);  //.
        button26 = (ButtonHexagon) viewKeyboard.findViewById(R.id.button26);
        button27 = (ButtonHexagon) viewKeyboard.findViewById(R.id.button27);
        button28 = (ButtonHexagon) viewKeyboard.findViewById(R.id.button28);
        button29 = (ButtonHexagon) viewKeyboard.findViewById(R.id.button29);
        button30 = (ButtonHexagon) viewKeyboard.findViewById(R.id.button30);
        button31 = (ButtonHexagon) viewKeyboard.findViewById(R.id.button31);
        button32 = (ButtonHexagon) viewKeyboard.findViewById(R.id.button32);
        button33 = (ButtonHexagon) viewKeyboard.findViewById(R.id.button33);
        button34 = (ButtonHexagon) viewKeyboard.findViewById(R.id.button34);
        button35 = (ButtonHexagon) viewKeyboard.findViewById(R.id.button35);
        button36 = (ButtonHexagon) viewKeyboard.findViewById(R.id.button36);
        button37 = (ButtonHexagon) viewKeyboard.findViewById(R.id.button37);
        button38 = (ButtonHexagon) viewKeyboard.findViewById(R.id.button38);
        button39 = (ButtonHexagon) viewKeyboard.findViewById(R.id.button39);

        textAbc = (TextView) viewKeyboard.findViewById(R.id.text_abc);

        textCandidate1 = (TextViewCustom) viewKeyboard.findViewById(R.id.text_candidate1);
        textCandidate2 = (TextViewCustom) viewKeyboard.findViewById(R.id.text_candidate2);
        textCandidate3 = (TextViewCustom) viewKeyboard.findViewById(R.id.text_candidate3);

        imgCatPeople = (ImageView) viewKeyboard.findViewById(R.id.img_cat_people);
        imgCatNature = (ImageView) viewKeyboard.findViewById(R.id.img_cat_nature);
        imgCatThing = (ImageView) viewKeyboard.findViewById(R.id.img_cat_thing);
        imgCatPlace = (ImageView) viewKeyboard.findViewById(R.id.img_cat_place);
        imgCatSymbol = (ImageView) viewKeyboard.findViewById(R.id.img_cat_symbol);
        imgDeleteEmoji = (ImageView) viewKeyboard.findViewById(R.id.img_delete);
        imgFlagEmoji = (ImageView) viewKeyboard.findViewById(R.id.img_cat_flag);

        relativeKeyboardContainer = (RelativeLayout) viewKeyboard.findViewById(R.id.relative_keyboardContainer);

        relativeEmoji = (RelativeLayout) viewKeyboard.findViewById(R.id.relative_emoji);
        linearEmojiCategory = (LinearLayout) viewKeyboard.findViewById(R.id.linear_emojiCategories);

        linearCandidate = (LinearLayout) viewKeyboard.findViewById(R.id.linear_candidateView);

        viewSwipe = viewKeyboard.findViewById(R.id.view_swipe);
        viewDivider1 = viewKeyboard.findViewById(R.id.view_candidateDivider1);
        viewDivider2 = viewKeyboard.findViewById(R.id.view_candidateDivider2);

        pagerEmoji = (ViewPager) viewKeyboard.findViewById(R.id.pager_emoji);
    }

    private void initGlobal() {
        PrefData.setPreferenceChangeListener(this, this);

        initCurrentTheme();
        isSoundEnabled = PrefData.getBooleanPrefs(this, PrefData.KEY_IS_SOUND_ENABLED_B);
        isVibraEnabled = PrefData.getBooleanPrefs(this, PrefData.KEY_IS_VIBRA_ENABLED_B);
        isDotSpaceEnabled = PrefData.getBooleanPrefs(this, PrefData.KEY_IS_DOT_SPACE_ENABLED_B, true);
        isPreviewOn = PrefData.getBooleanPrefs(this, PrefData.KEY_IS_PREVIEW_ENABLED_B, true);
        isTwipeEnabled = PrefData.getBooleanPrefs(this, PrefData.KEY_IS_TWIPE_ENABLED_B, true);
        isCursorEnabled = PrefData.getBooleanPrefs(this, PrefData.KEY_IS_CURSOR_ENABLED_B, true);
        isTextSuggestionEnabled = PrefData.getBooleanPrefs(this, PrefData.KEY_IS_TEXT_SUGGESTION_ENABLED_B);

        if (isTextSuggestionEnabled) {
            linearCandidate.setVisibility(View.VISIBLE);
        }

        arrButtons = new ButtonHexagon[]{button1, button2, button3, button4, button5, button6, button7, button8, button9, button10,
                button11, button12, button13, button14, button15, button16, button17, button18, button19, button20,
                button21, button22, button23, button24, button25, button26, button27, button28, button29, button30,
                button31, button32, button33, button34, button35, button36, button37, button38, button39};
        arrTextCandidate = new TextViewCustom[]{textCandidate1, textCandidate2, textCandidate3};
        arrImgEmojiCat = new ImageView[]{imgCatPeople, imgCatNature, imgCatThing, imgCatPlace,
                imgCatSymbol, imgFlagEmoji};
        arrImgEmojiCatVectors = new Integer[]{R.drawable.ic_emoji_smilies, R.drawable.ic_emoji_people,R.drawable.ic_emoji_nature,
                R.drawable.ic_emoji_place, R.drawable.ic_emoji_hobbies, R.drawable.ic_emoji_flag};

        textServicesManager = (TextServicesManager) getSystemService(Context.TEXT_SERVICES_MANAGER_SERVICE);
        spellCheckerSession = textServicesManager.newSpellCheckerSession(null, null, this, true);

        viewSwipe.setVisibility(isTwipeEnabled ? View.VISIBLE : View.GONE);

        onHexagonTouchListener = new ButtonHexagon.OnHexagonTouchListener() {

            @Override
            public void onActionDown(ButtonHexagon buttonHexagon) {
                callTapEffect();
            }

            @Override
            public void onActionUp(ButtonHexagon buttonHexagon, boolean isInSide) {
                isCursorModeOn = false;
            }

            @Override
            public void onActionMove(ButtonHexagon buttonHexagon, MotionEvent event) {
                if (buttonHexagon.getKeyCode() == KEYCODE_SPACE && isCursorEnabled && isCursorModeOn) {
                    if (lastX == 0) {
                        lastX = event.getX();
                        hMove = 0;
                    }
                    if (lastY == 0) {
                        lastY = event.getY();
                    }
                    float diffY = event.getY() - lastY;
                    float diffX = event.getX() - lastX;
                    if (diffX > cursorThresholdH) {
                        lastX = event.getX();
                        keyDownUp(KeyEvent.KEYCODE_DPAD_RIGHT);
                        hMove--;
                    } else if (diffX < -cursorThresholdH) {
                        lastX = event.getX();
                        keyDownUp(KeyEvent.KEYCODE_DPAD_LEFT);
                        hMove++;
                    }
                    if (diffY > cursorThresholdV || diffY < -cursorThresholdV) {
                        lastY = event.getY();
                        getCurrentInputConnection().commitText("", hMove > 0 ? hMove + 1 : hMove);
                        hMove = 0;
                    }
                }
            }

            @Override
            public void onClick(ButtonHexagon buttonHexagon) {
                if (buttonHexagon.getKeyCode() != KeyEvent.KEYCODE_UNKNOWN) {
                    handleOnClick(buttonHexagon);
                }
            }

            @Override
            public boolean onLongClick(ButtonHexagon buttonHexagon) {
                if (buttonHexagon.getKeyCode() != KeyEvent.KEYCODE_UNKNOWN) {
                    callTapEffect();
                    handleOnLongClick(buttonHexagon);
                }
                return true;
            }

            @Override
            public void onDoubleTap(ButtonHexagon buttonHexagon) {
                if (buttonHexagon.getKeyCode() != KeyEvent.KEYCODE_UNKNOWN) {
                    handleOnDoubleTap(buttonHexagon);
                }
            }

            @Override
            public void onPopUpLetterSelection(char keyCode) {
                onClickLetter(keyCode);
            }
        };

        setButtonValues();
        setUpKeyboard();
        setKeyboardAlignment();
        setKeyboardTheme();
        setVibra();

        // For swipe gesture
        viewSwipe.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_MOVE) {
                    if (arrButtons[lastDownId].isShowingPopUp()) {
                        arrButtons[lastDownId].onTouchPopUp(motionEvent);
                    } else if (isCursorModeOn) {
                        arrButtons[lastDownId].onTouchEvent(motionEvent);
                    } else {
                        for (int i = 0; i < arrButtons.length; i++) {
                            if (arrButtons[i].isHoveredHexagon(motionEvent)) {
                                if (i == lastMoveId) {
                                    break;
                                }
                                if (i != lastDownId) {
                                    if (!isFirstButtonReset) {
                                        arrButtons[lastDownId].performClick();
                                        arrButtons[lastDownId].onTouchEvent(motionEvent);
                                        isFirstButtonReset = true;
                                        isMoved = true;
                                    }
                                    onHoverButton(i);
                                } else if (isFirstButtonReset) { // When twiping between two buttons repetitively.
                                    onHoverButton(i);
                                }
                                lastMoveId = i;
                                break;
                            }
                        }
                    }
                } else {
                    switch (motionEvent.getAction()) {
                        case MotionEvent.ACTION_DOWN:
                            for (int i = 0; i < arrButtons.length; i++) {
                                if (arrButtons[i].isHoveredHexagon(motionEvent)) {
                                    isActionDownCalled = true;
                                    arrButtons[i].onTouch(motionEvent);
                                    lastDownId = i;
                                    break;
                                }
                            }
                            break;
                        case MotionEvent.ACTION_UP:
                            isCandidateClicked = false;
                            /*if (isTextSuggestionEnabled) {
                                for (int i = 0; i < arrTextCandidate.length; i++) {
                                    if (arrTextCandidate[i].isHoveredTextView(motionEvent)) {
                                        arrTextCandidate[i].performClick();
                                        isCandidateClicked = true;
                                        break;
                                    }
                                }
                            }*/
                            if (isActionDownCalled) {
                                isActionDownCalled = false;
                                if (arrButtons[lastDownId].isShowingPopUp()) {
                                    arrButtons[lastDownId].onTouchPopUp(motionEvent);
                                } else if (!isMoved){ //&& !isCandidateClicked) {
                                    arrButtons[lastDownId].onTouch(motionEvent);
                                } else if (lastMoveId >= 0) {
                                    arrButtons[lastMoveId].invalidateOnActionUp();
                                }
                                isMoved = false;
                                lastMoveId = -1;
                                isFirstButtonReset = false;
                            }
                            if (arrButtons[lastDownId].isShowingPopUp()) {
                                arrButtons[lastDownId].onTouchPopUp(motionEvent);
                            }
                            break;
                    }
                }
                return true;
            }

            private void onHoverButton(int buttonPosition) {
                arrButtons[buttonPosition].invalidateOnActionDown();
                arrButtons[buttonPosition].performClick();
                arrButtons[lastMoveId != -1 ? lastMoveId : lastDownId].invalidateOnActionUp();
            }
        });

        adpEmojiPager = new EmojiPagerAdapter(this, this);
        setEmojiPagerAdapter();

        pagerEmoji.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                setEmojiCategorySelection(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        textAbc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callTapEffect();
                setEmojiViewVisible(false);
            }
        });

        textCandidate1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                commitSelected(textCandidate1.getText());
            }
        });

        textCandidate2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                commitSelected(textCandidate2.getText());
            }
        });

        textCandidate3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                commitSelected(textCandidate3.getText());
            }
        });

        imgCatPeople.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callTapEffect();
                pagerEmoji.setCurrentItem(0);
            }
        });

        imgCatNature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callTapEffect();
                pagerEmoji.setCurrentItem(1);
            }
        });

        imgCatThing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callTapEffect();
                pagerEmoji.setCurrentItem(2);
            }
        });

        imgCatPlace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callTapEffect();
                pagerEmoji.setCurrentItem(3);
            }
        });

        imgCatSymbol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callTapEffect();
                pagerEmoji.setCurrentItem(4);
            }
        });

        imgFlagEmoji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callTapEffect();
                pagerEmoji.setCurrentItem(5);
            }
        });

        imgDeleteEmoji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callTapEffect();
                updateOnBackSpace();
            }
        });

        runnableRepeatClick = new Runnable() {
            @Override
            public void run() {
                imgDeleteEmoji.performClick();
                if (currentRepeatInterval > ButtonHexagon.REPEAT_INTERVAL_MIN) {
                    currentRepeatInterval = currentRepeatInterval - ButtonHexagon.REPEAT_INTERVAL_STEP;
                }
                imgDeleteEmoji.postDelayed(runnableRepeatClick, currentRepeatInterval);
            }
        };

        imgDeleteEmoji.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    imgDeleteEmoji.removeCallbacks(runnableRepeatClick);
                    imgDeleteEmoji.performClick();
                    currentRepeatInterval = ButtonHexagon.INTERVAL_REPEAT_INITIAL;
                    imgDeleteEmoji.postDelayed(runnableRepeatClick, ButtonHexagon.DELAY_REPEAT_INITIAL);
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    imgDeleteEmoji.removeCallbacks(runnableRepeatClick);
                }
                return true;
            }
        });
    }

    private void initCurrentTheme() {
        ArrayList<Theme> arrListTheme = Theme.getThemes();
        currentTheme = arrListTheme.get(PrefData.getIntPrefs(this, PrefData.KEY_SELECTED_THEME_POSITION));
    }

    private void setEmojiViewVisible(boolean visible) {
        if (visible) {
            pagerEmoji.setCurrentItem(0, false);
            relativeEmoji.setVisibility(View.VISIBLE);
            relativeKeyboardContainer.setVisibility(View.GONE);
        } else {
            relativeEmoji.setVisibility(View.GONE);
            relativeKeyboardContainer.setVisibility(View.VISIBLE);
        }
    }

    private void callTapEffect() {
        if (isSoundEnabled) {
            playSound();
        }
        if (isVibraEnabled) {
            vibrate();
        }
    }

    private void setEmojiCategorySelection(int position) {
        for (int i = 0; i < arrImgEmojiCat.length; i++) {
            arrImgEmojiCat[i].setBackgroundColor(i == position ? bgEmoji : Color.TRANSPARENT);
        }
    }

    private void handleOnClick(ButtonHexagon buttonHexagon) {
        try {
            switch (buttonHexagon.getKeyCode()) {
                case KEYCODE_SHIFT:
                    isShiftOn = !isShiftOn;
                    isCapsLockOn = false;
                    updateOnShift();
                    break;
                case KEYCODE_SYM:
                    updateOnSym();
                    break;
                case KEYCODE_NUM:
                    if (isShiftOn && !isCapsLockOn) {
                        isShiftOn = false;
                        updateOnShift();
                    }
                    updateOnNum();
                    break;
                case KEYCODE_ABC:
                    updateOnAbc();
                    break;
                case KeyEvent.KEYCODE_DEL:
                    updateOnBackSpace();

                    /**
                     * Check for dot + space
                     */
                    String currentText = getCurrentInputConnection().getTextBeforeCursor(2, 0).toString();
                    if (currentText != null && currentText.length() > 1) {
                        if (isDotSpaceEnabled && currentText.equals(". ") && !isShiftOn) {
                            isShiftOn = true;
                            updateOnShift();
                        } else if (isShiftOn && !isCapsLockOn) {
                            isShiftOn = false;
                            updateOnShift();
                        }
                    } else if ((currentText == null || currentText.length() == 0) && !isShiftOn &&
                            !isAutocapitalizationEnable) {
                        isShiftOn = true;
                        updateOnShift();
                    }
                    break;
                case KeyEvent.KEYCODE_ENTER:
                    commitOnSeparator();
                    keyDownUp(KeyEvent.KEYCODE_ENTER);
                    break;
                case KEYCODE_SPACE:
                    commitOnSeparator();
                    printText(space);
                    break;
                case KEYCODE_EMOTICON:
                    setEmojiViewVisible(true);
                    break;
                case KEYCODE_SETTINGS:
                case KEYCODE_ALIGNMENT:
                    break;
                default:
                    onClickLetter(buttonHexagon.getKeyCode());
            }
            PrefData.setIntPrefs(getApplicationContext(), PrefData.KEY_TYPE, currentLayout);
        } catch (Exception e) {
            Log.e(TAG, "handleOnClick Exception : ", e);
        }
    }

    private void commitOnSeparator() {
        if (isTextSuggestionEnabled) {
            commitComposing(getCurrentInputConnection());
        }
    }

    private void onClickLetter(char keyCode) {

/*
        InputConnection inputConnection = getCurrentInputConnection();
        CharSequence currentText = inputConnection.getExtractedText(new ExtractedTextRequest(), 0).text;
        int beforCursorTextcount = inputConnection.getTextBeforeCursor(currentText.length(), 0).length();
        String beforCursorText = inputConnection.getTextBeforeCursor(currentText.length(), 0).toString();
        String afterCursorText = inputConnection.getTextAfterCursor(currentText.length(), 0).toString();
        int afterCursorTextcount = inputConnection.getTextAfterCursor(currentText.length(), 0).length();
        System.out.println(afterCursorTextcount+"======befor====after==="+beforCursorTextcount);
*/


        if (keyCode == '.') {
            commitOnSeparator();
        }

/*
        if(beforCursorTextcount>0 && afterCursorTextcount>0){
            commitOnSeparator();
        }
*/

        printText(keyCode);
        if (isShiftOn && !isCapsLockOn) {
            isShiftOn = false;
            updateOnShift();
        }
    }

    private void handleOnLongClick(ButtonHexagon buttonHexagon) {
        try {
            switch (buttonHexagon.getKeyCode()) {
                case KEYCODE_SHIFT:
                    toggleCapsLock();
                    break;
                case KEYCODE_SETTINGS:
                    Intent intentSettings = new Intent(this, SettingsActivity.class);
                    intentSettings.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intentSettings);
                    break;
                case KEYCODE_ALIGNMENT:
                    if (!isFullWidth) {
                        if (currentAlignment == PrefData.VAL_ALIGN_LEFT) {
                            currentAlignment = PrefData.VAL_ALIGN_RIGHT;
                        } else {
                            currentAlignment++;
                        }
                    }
                    PrefData.setIntPrefs(this, PrefData.KEY_ALIGN_I, currentAlignment);
                    setKeyboardAlignment();
                    break;
                case KEYCODE_SPACE:
                    if (isCursorEnabled) {
                        isCursorModeOn = true;
                        lastX = 0;
                        lastY = 0;
                    } else {
                        ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE)).
                                showInputMethodPicker();
                    }
                    break;
            }
        } catch (Exception e) {
            Log.e(TAG, "handleOnLongClick Exception : ", e);
        }
    }

    private void handleOnDoubleTap(ButtonHexagon buttonHexagon) {
        try {
            switch (buttonHexagon.getKeyCode()) {
                case KEYCODE_SHIFT:
                    toggleCapsLock();
                    break;
            }
        } catch (Exception e) {
            Log.e(TAG, "handleOnDoubleTap Exception : ", e);
        }
    }

    private void toggleCapsLock() {
        isCapsLockOn = !isCapsLockOn;
        isShiftOn = isCapsLockOn;
        updateOnShift();
    }

    private void updateOnBackSpace() {
        //boolean isDeleted = false;
        /*To check
        if ((getCurrentInputConnection().getTextBeforeCursor(1, 0) + "").equals(EmojiSymbol.BOX)) { //EmojiSymbol.BOX is not used
            isDeleted = getCurrentInputConnection().deleteSurroundingText(2, 0);
        }
        else if (Build.VERSION.SDK_INT == Build.VERSION_CODES.M) {
            String preChar = getCurrentInputConnection().getTextBeforeCursor(2, 0) + "";
            /*for (int i = 0; i < EmojiFlag.FLAG_CHAR.length; i++) {
                if (preChar.equals(EmojiFlag.FLAG_CHAR[i])) {
                    break;
                }
            }
            //isDeleted = getCurrentInputConnection().deleteSurroundingText(4, 0); //to check
            isDeleted = getCurrentInputConnection().deleteSurroundingText(1, 0);

        }*/
       // if (!isDeleted) {
            if (composing.length() > 0) {
                composing.deleteCharAt(composing.length() - 1);
            }
           /* if (composing.length() > 0) {
                findSuggestions();
            } else {
                clearSuggestions();
            }
            */
            keyDownUp(KeyEvent.KEYCODE_DEL);
        //}
    }

    private void keyDownUp(int keyEventCode) {
        getCurrentInputConnection().sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, keyEventCode));
        getCurrentInputConnection().sendKeyEvent(new KeyEvent(KeyEvent.ACTION_UP, keyEventCode));
    }

    private void updateOnSym() {
        currentLayout = PrefData.VAL_LAYOUT_SYMBOL;
        updateLayoutText();
    }

    private void updateOnAbc() {
        currentLayout = currentLanguageLayout;
        updateLayoutText();
    }

    private void updateOnNum() {
        currentLayout = PrefData.VAL_LAYOUT_NUMBER;
        updateLayoutText();
    }

    private void updateOnShift() {
        for (int buttonPosition = 0; buttonPosition < arrButtons.length; buttonPosition++) {
            if (arrButtons[buttonPosition].getShape() == 1) {
                arrButtons[buttonPosition].setAllCaps(isShiftOn);
            }
        }
        setShiftIcon();
        button30.setAllCaps(false);
    }

    private void setShiftIcon() {
        if (currentLayout == currentLanguageLayout) {
            if (isCapsLockOn) {
                button30.setIcon(R.drawable.ic_caps_lock);
            } else if (isShiftOn) {
                button30.setIcon(R.drawable.ic_shift_active);
            } else {
                button30.setIcon(R.drawable.ic_shift);
            }
        }
    }

    private void setUpKeyboard() {
        currentLayout = currentLanguageLayout = PrefData.getIntPrefs(this, PrefData.KEY_KEYBOARD_LAYOUT_I,
                PrefData.VAL_LAYOUT_ENGLISH);
        currentLanguage = PrefData.getIntPrefs(this, PrefData.KEY_KEYBOARD_LANGUAGE_I, PrefData.VAL_LANGUAGE_ENGLISH);
        int screenWidth = getResources().getConfiguration().screenWidthDp;
        int screenHeight = getResources().getConfiguration().screenHeightDp;

        DisplayMetrics dm = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) this.getSystemService(WINDOW_SERVICE);
        windowManager.getDefaultDisplay().getMetrics(dm);
        int widthInDP = Math.round(dm.widthPixels / dm.density);
        int heightInDP = Math.round(dm.heightPixels / dm.density);

        /**
         * Change keyboard size in percentage from here.
         */
//		isFullWidth = PrefData.getBooleanPrefs(this, PrefData.KEY_IS_KB_SIZE_FULL_B, !getResources().getBoolean(R.bool.isTablet));
        isFullWidth = PrefData.getBooleanPrefs(this, PrefData.KEY_IS_KB_SIZE_FULL_B, false);
        isTopGap = PrefData.getBooleanPrefs(this, PrefData.KEY_IS_TOP_GAP_FILL, false);

        keyboardSize = PrefData.getFloatPrefs(this, PrefData.KEY_KB_SIZE_F, PrefData.VAL_KB_SIZE_PHONE_MEDIUM);
        keyboardWidth = (int) (Utility.dpToPx(screenWidth < screenHeight ? getResources().getConfiguration().screenWidthDp :
                getResources().getConfiguration().screenHeightDp) * (isFullWidth ? PrefData.VAL_KB_SIZE_FULL : keyboardSize)); //keyboardSize

		/*int cornerGap;
        if (buttonGap % 4 == 0) {
			cornerGap = (buttonGap / 4) * 5;
		} else {
//			cornerGap = (buttonGap / 2) * 3;
			cornerGap = buttonGap;
		}*/
        int cornerGap = buttonGap;
//		int buttonWidth = ((keyboardWidth - (6 * cornerGap)) / 11) * 2;
        int buttonWidth = (keyboardWidth / 11) * 2;
        int buttonHeight = (int) (buttonWidth * 0.86);
        candidateHeight = (int) (buttonHeight * .6);
        if (buttonHeight % 2 != 0) {
            buttonHeight--;
        }
        int buttonHeightHalf = buttonHeight / 2;
        int buttonHeightQuarter = buttonHeight / 4;
        int buttonHalfSideLength = buttonWidth / 4;
//		int buttonLeftMargin = buttonHalfSideLength * 3 + (buttonWidth % 4 == 0 ? cornerGap : cornerGap * 2);
        int buttonLeftMargin = buttonHalfSideLength * 3 + (buttonWidth % 4 == 0 ? 0 : cornerGap);
//		keyboardHeight = buttonHeight * 5 + buttonGap * 7 + getResources().getDimensionPixelOffset(R.dimen.dp10);
//		keyboardHeight = buttonHeight * 5 + getResources().getDimensionPixelOffset(R.dimen.dp20);
//		keyboardTopPadding = getResources().getDimensionPixelOffset(R.dimen.dp5);
        keyboardTopPadding = (int) (buttonHeight * .1);
        keyboardHeight = (int)(buttonHeight * 5);



        for (int i = 0; i < arrButtons.length; i++) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) arrButtons[i].
                    getLayoutParams();

            layoutParams.width = buttonWidth;
            layoutParams.height = (i == 0 || i == 2 || i == 4 || i == 6 || i == 35 || i == 36 ||
                    i == 37 || i == 38) ?
                    buttonHeightHalf : buttonHeight;

            int marginLeft = buttonLeftMargin;
//			int marginTop = buttonGap;
            switch (i) {
                case 0:
                case 7:
                case 14:
                case 21:
                case 28:
                case 35:
                    marginLeft = 0;
                    break;
                /*case 1:
                case 3:
				case 5:
					marginTop += marginTop / 2;
					break;*/
            }
//			layoutParams.setMargins(marginLeft, marginTop, 0, 0);
            layoutParams.setMargins(marginLeft, 0, 0, 0);

            arrButtons[i].setLayoutParams(layoutParams);
            arrButtons[i].setOnHexagonTouchListener(onHexagonTouchListener);

            if (arrKeyCode[i][currentLayout].length > 0) {
                switch (arrKeyCode[i][currentLayout][currentLanguage]) {
                    case KEYCODE_SHIFT:
                    case KEYCODE_SYM:
                    case KEYCODE_NUM:
                    case KEYCODE_ABC:
                        arrButtons[i].setTextSize(TypedValue.COMPLEX_UNIT_PX, buttonHeight * .35f);
                        break;
                    case KEYCODE_SETTINGS:
                        arrButtons[i].setPadding(0, buttonHeightHalf / 7, 1, 0);
                    case KEYCODE_EMOTICON:
                    case KeyEvent.KEYCODE_ENTER:
                    case KEYCODE_ALIGNMENT:
                        arrButtons[i].setTextSize(TypedValue.COMPLEX_UNIT_PX, buttonHeightHalf * .35f);
                        break;
                    default:
                        arrButtons[i].setTextSize(TypedValue.COMPLEX_UNIT_PX, buttonHeight * .6f);
                }
                setButtonText(i);
            }
        }
    }

    private void updateLayoutText() {
        for (int buttonPosition = 0; buttonPosition < arrButtons.length; buttonPosition++) {
            setButtonText(buttonPosition);
        }
    }

    private void setButtonText(int buttonPosition) {

        arrButtons[buttonPosition].setKeyCode(arrKeyCode[buttonPosition][currentLayout][currentLanguage]);

        switch (arrKeyCode[buttonPosition][currentLayout][currentLanguage]) {
            case KEYCODE_SPACE:
                break;
            case KEYCODE_SYM:
                arrButtons[buttonPosition].setText(R.string.sym);
                arrButtons[buttonPosition].setIcon(0);
                break;
            case KEYCODE_NUM:
                arrButtons[buttonPosition].setText(R.string._123);
                arrButtons[buttonPosition].setIcon(0);
                break;
            case KEYCODE_ABC:
                arrButtons[buttonPosition].setText(R.string.abc);
                break;
            case KEYCODE_SETTINGS:
                arrButtons[buttonPosition].setText(getResources().getStringArray(R.array.
                        layout_language_code)[currentLanguageLayout]);
                break;
            case KEYCODE_SHIFT:
                setShiftIcon();
            case KeyEvent.KEYCODE_DEL:
            case KeyEvent.KEYCODE_ENTER:
            case KEYCODE_EMOTICON:
            case KEYCODE_ALIGNMENT:
                arrButtons[buttonPosition].setText("");
                break;
            default:

                switch (arrKeyCode[buttonPosition][currentLayout][currentLanguage]) {
                    case 'e':   // ę é ė ě
                        //ē è(main) ê ë
                        ArrayList<String> e =PrefData.getArrayListPref(this,PrefData.e);
                        if(e!=null && e.size()!=0){
                            arrButtons[buttonPosition].setPopupChars(new char[]{e.get(0).charAt(0),e.get(1).charAt(0),e.get(2).charAt(0),e.get(3).charAt(0),e.get(4).charAt(0),e.get(5).charAt(0),e.get(6).charAt(0),e.get(7).charAt(0)});
                        }else{
                            arrButtons[buttonPosition].setPopupChars(new char[]{'ē', 'è', 'ê', 'ë', 'é', 'ę', 'ė', 'ě'});
                        }
                        arrButtons[buttonPosition].setMainCharPosition(1);
                        break;
                    case 'u':   // ų ű µ
                        //û ū ŭ ũ
                        //ü ù(main) ú ů
                        ArrayList<String> u =PrefData.getArrayListPref(this,PrefData.u);
                        if(u!=null && u.size()!=0){
                            arrButtons[buttonPosition].setPopupChars(new char[]{u.get(0).charAt(0),u.get(1).charAt(0),u.get(2).charAt(0),u.get(3).charAt(0),u.get(4).charAt(0),u.get(5).charAt(0),u.get(6).charAt(0),u.get(7).charAt(0),u.get(8).charAt(0),u.get(9).charAt(0),u.get(10).charAt(0)});
                        }else{
                            arrButtons[buttonPosition].setPopupChars(new char[]{'ü', 'ù', 'ú', 'ů', 'û', 'ū', 'ŭ', 'ũ', 'ų', 'ű', 'µ'});
                        }
                        arrButtons[buttonPosition].setMainCharPosition(1);
                        break;
                    case 'i':   // į í ĩ
                        //ï ì(main) î ī
                        ArrayList<String> i =PrefData.getArrayListPref(this,PrefData.i);
                        if(i!=null && i.size()!=0){
                            arrButtons[buttonPosition].setPopupChars(new char[]{i.get(0).charAt(0),i.get(1).charAt(0),i.get(2).charAt(0),i.get(3).charAt(0),i.get(4).charAt(0),i.get(5).charAt(0),i.get(6).charAt(0)});
                        }else{
                            arrButtons[buttonPosition].setPopupChars(new char[]{'ï', 'ì', 'ī', 'î', 'í', 'į', 'ĩ'});
                        }
                        arrButtons[buttonPosition].setMainCharPosition(1);
                        break;
                    case 'o':   // º ő
                        //ō ö ô œ
                        //õ ò(main) ó ø

                        ArrayList<String> o =PrefData.getArrayListPref(this,PrefData.o);
                        if(o!=null && o.size()!=0){
                            arrButtons[buttonPosition].setPopupChars(new char[]{o.get(0).charAt(0),o.get(1).charAt(0),o.get(2).charAt(0),o.get(3).charAt(0),o.get(4).charAt(0),o.get(5).charAt(0),o.get(6).charAt(0),o.get(7).charAt(0),o.get(8).charAt(0),o.get(9).charAt(0)});
                        }else{
                            arrButtons[buttonPosition].setPopupChars(new char[]{'õ', 'ò', 'ó', 'ø', 'ō', 'ö', 'ô', 'œ', 'º', 'ő'});
                        }
                        arrButtons[buttonPosition].setMainCharPosition(2);
                        break;
                    case 'a':   // ā ă ą
                        //â á ä ª
                        //æ à(main) ã å

                        ArrayList<String> a =PrefData.getArrayListPref(this,PrefData.a);

                            if(a!=null && a.size()!=0){
                                arrButtons[buttonPosition].setPopupChars(new char[]{a.get(0).charAt(0),a.get(1).charAt(0),a.get(2).charAt(0),a.get(3).charAt(0),a.get(4).charAt(0),a.get(5).charAt(0),a.get(6).charAt(0),a.get(7).charAt(0),a.get(8).charAt(0),a.get(9).charAt(0)});
                            }else{
                                arrButtons[buttonPosition].setPopupChars(new char[]{'æ', 'à', 'ã', 'å', 'á', 'â', 'ä', 'ā', 'ă', 'ą'});
                            }
                        arrButtons[buttonPosition].setMainCharPosition(1);
                        break;
                    case 's':   // ş ś ș
                        //ŝ ß(main) š
                        ArrayList<String> s =PrefData.getArrayListPref(this,PrefData.s);
                        if(s!=null && s.size()!=0){
                            arrButtons[buttonPosition].setPopupChars(new char[]{s.get(0).charAt(0),s.get(1).charAt(0),s.get(2).charAt(0),s.get(3).charAt(0),s.get(4).charAt(0),s.get(5).charAt(0)});
                        }else{
                            arrButtons[buttonPosition].setPopupChars(new char[]{'ŝ', 'ß', 'š', 'ş', 'ś', 'ș'});
                        }
                        arrButtons[buttonPosition].setMainCharPosition(1);
                        break;
                    case 'c':   // ċ ĉ
                        //ć č(main) ç
                        ArrayList<String> c =PrefData.getArrayListPref(this,PrefData.c);
                        if(c!=null && c.size()!=0){
                            arrButtons[buttonPosition].setPopupChars(new char[]{c.get(0).charAt(0),c.get(1).charAt(0),c.get(2).charAt(0),c.get(3).charAt(0),c.get(4).charAt(0)});
                        }else{
                            arrButtons[buttonPosition].setPopupChars(new char[]{'ć', 'č', 'ç', 'ċ', 'ĉ'});
                        }

                        arrButtons[buttonPosition].setMainCharPosition(1);
                        break;
                    case 'n':   // ŋ ň ŉ
                        //ń ñ(main) ņ
                        ArrayList<String> n =PrefData.getArrayListPref(this,PrefData.n);
                        if(n!=null && n.size()!=0){
                            arrButtons[buttonPosition].setPopupChars(new char[]{n.get(0).charAt(0),n.get(1).charAt(0),n.get(2).charAt(0),n.get(3).charAt(0),n.get(4).charAt(0),n.get(5).charAt(0)});
                        }else{
                            arrButtons[buttonPosition].setPopupChars(new char[]{'ń', 'ñ', 'ņ', 'ŋ', 'ň', 'ŉ'});
                        }
                        arrButtons[buttonPosition].setMainCharPosition(2);
                        break;
                    case 'r':   // ŕ ř(main) ŗ
                        ArrayList<String> r =PrefData.getArrayListPref(this,PrefData.r);
                        if(r!=null && r.size()!=0){
                            arrButtons[buttonPosition].setPopupChars(new char[]{r.get(0).charAt(0),r.get(1).charAt(0),r.get(2).charAt(0)});
                        }else{
                            arrButtons[buttonPosition].setPopupChars(new char[]{'ŕ', 'ř', 'ŗ'});
                        }
                        arrButtons[buttonPosition].setMainCharPosition(1);
                        break;
                    case 't':   // ŧ ť(main) ț ţ
                        ArrayList<String> t =PrefData.getArrayListPref(this,PrefData.t);
                        if(t!=null && t.size()!=0){
                            arrButtons[buttonPosition].setPopupChars(new char[]{t.get(0).charAt(0),t.get(1).charAt(0),t.get(2).charAt(0),t.get(3).charAt(0)});
                        }else{
                            arrButtons[buttonPosition].setPopupChars(new char[]{'ŧ', 'ť', 'ț', 'ţ'});
                        }
                        arrButtons[buttonPosition].setMainCharPosition(1);
                        break;
                    case 'w':   // ŵ
                        arrButtons[buttonPosition].setPopupChars(new char[]{'ŵ'});
                        arrButtons[buttonPosition].setMainCharPosition(0);
                        break;
                    case 'y':   // ý ŷ(main) ÿ
                        ArrayList<String> y =PrefData.getArrayListPref(this,PrefData.y);
                        if(y!=null && y.size()!=0){
                            arrButtons[buttonPosition].setPopupChars(new char[]{y.get(0).charAt(0),y.get(1).charAt(0),y.get(2).charAt(0)});
                        }else{
                            arrButtons[buttonPosition].setPopupChars(new char[]{'ý', 'ŷ', 'ÿ'});
                        }
                        arrButtons[buttonPosition].setMainCharPosition(2);
                        break;
                    case 'z':   // ź ż ž (main)
                        ArrayList<String> z =PrefData.getArrayListPref(this,PrefData.z);
                        if(z!=null && z.size()!=0){
                            arrButtons[buttonPosition].setPopupChars(new char[]{z.get(0).charAt(0),z.get(1).charAt(0), z.get(2).charAt(0)});
                        }else{
                            arrButtons[buttonPosition].setPopupChars(new char[]{'ź', 'ż', 'ž'});
                        }
                        arrButtons[buttonPosition].setMainCharPosition(2);
                        break;
                    case 'd':   // ð đ(main) ď
                        ArrayList<String> d =PrefData.getArrayListPref(this,PrefData.d);
                        if(d!=null && d.size()!=0){
                            arrButtons[buttonPosition].setPopupChars(new char[]{d.get(0).charAt(0),d.get(1).charAt(0),d.get(2).charAt(0)});
                        }else{
                            arrButtons[buttonPosition].setPopupChars(new char[]{'ð', 'đ', 'ď'});
                        }
                        arrButtons[buttonPosition].setMainCharPosition(1);
                        break;
                    case 'g':   // ġ ğ ĝ(main) ģ
                        ArrayList<String> g =PrefData.getArrayListPref(this,PrefData.g);
                        if(g!=null && g.size()!=0){
                            arrButtons[buttonPosition].setPopupChars(new char[]{g.get(0).charAt(0),g.get(1).charAt(0),g.get(2).charAt(0),g.get(3).charAt(0)});
                        }else{
                            arrButtons[buttonPosition].setPopupChars(new char[]{'ġ', 'ğ', 'ĝ', 'ģ'});
                        }
                        arrButtons[buttonPosition].setMainCharPosition(2);
                        break;
                    case 'h':   // ħ(main) ĥ
                        ArrayList<String> h =PrefData.getArrayListPref(this,PrefData.h);
                        if(h!=null && h.size()!=0){
                            arrButtons[buttonPosition].setPopupChars(new char[]{h.get(0).charAt(0),h.get(1).charAt(0)});
                        }else{
                            arrButtons[buttonPosition].setPopupChars(new char[]{'ħ', 'ĥ'});
                        }
                        arrButtons[buttonPosition].setMainCharPosition(0);
                        break;
                    case 'j':   // ĵ
                        arrButtons[buttonPosition].setPopupChars(new char[]{'ĵ'});
                        arrButtons[buttonPosition].setMainCharPosition(0);
                        break;
                    case 'k':   // ķ(main) ĸ
                        ArrayList<String> k =PrefData.getArrayListPref(this,PrefData.k);
                        if(k!=null && k.size()!=0){
                            arrButtons[buttonPosition].setPopupChars(new char[]{k.get(0).charAt(0),k.get(1).charAt(0)});
                        }else{
                            arrButtons[buttonPosition].setPopupChars(new char[]{'ĸ', 'ķ'});
                        }
                        arrButtons[buttonPosition].setMainCharPosition(0);
                        break;
                    case 'l':   // ļ ĺ(main) ľ ŀ ł
                        ArrayList<String> l =PrefData.getArrayListPref(this,PrefData.l);
                        if(l!=null && l.size()!=0){
                            arrButtons[buttonPosition].setPopupChars(new char[]{l.get(0).charAt(0),l.get(1).charAt(0),l.get(2).charAt(0),l.get(3).charAt(0),l.get(4).charAt(0)});
                        }else{
                            arrButtons[buttonPosition].setPopupChars(new char[]{'ļ', 'ĺ', 'ľ', 'ŀ', 'ł'});
                        }
                        arrButtons[buttonPosition].setMainCharPosition(1);
                        break;
                    case '€':   // $(main) £ ¥ ¢ ₱ €
                    case '$':
                    case '£':
                        arrButtons[buttonPosition].setPopupChars(new char[]{'$', '£', '¥', '¢', '₱', '€'});
                        arrButtons[buttonPosition].setMainCharPosition(0);
                        break;
                    case '!':   // ¡
                        arrButtons[buttonPosition].setPopupChars(new char[]{'¡'});
                        arrButtons[buttonPosition].setMainCharPosition(0);
                        break;
                    case '+':   // ±
                        arrButtons[buttonPosition].setPopupChars(new char[]{'±'});
                        arrButtons[buttonPosition].setMainCharPosition(0);
                        break;
                    case '-':   // ±
                        arrButtons[buttonPosition].setPopupChars(new char[]{'–','—'});
                        arrButtons[buttonPosition].setMainCharPosition(0);
                        break;
                    case '*':   // ×
                        arrButtons[buttonPosition].setPopupChars(new char[]{'×'});
                        arrButtons[buttonPosition].setMainCharPosition(0);
                        break;
                    case '<':   // ≤
                        arrButtons[buttonPosition].setPopupChars(new char[]{'≤'});
                        arrButtons[buttonPosition].setMainCharPosition(0);
                        break;
                    case '?':   // ¿
                        arrButtons[buttonPosition].setPopupChars(new char[]{'¿'});
                        arrButtons[buttonPosition].setMainCharPosition(0);
                        break;
                    case '/':   // ÷
                        arrButtons[buttonPosition].setPopupChars(new char[]{'÷'});
                        arrButtons[buttonPosition].setMainCharPosition(0);
                        break;
                    case '"':   // „ “(main) « »
                        arrButtons[buttonPosition].setPopupChars(new char[]{'„', '«', '“', '»'});
                        arrButtons[buttonPosition].setMainCharPosition(2);
                        break;
                    case '>':   // ≥
                        arrButtons[buttonPosition].setPopupChars(new char[]{'≥'});
                        arrButtons[buttonPosition].setMainCharPosition(0);
                        break;
                    case '\'':   // & % = ;  //- @ , #(main)& % = ;
                        // - @ , #
                    case '.':
                        arrButtons[buttonPosition].setPopupChars(new char[]{'-', '@', '%', ',', '&', '#', '=', ';', ':', '.', '!', '?'});
                        arrButtons[buttonPosition].setMainCharPosition(5);
                        break;
                    case '%':   // ‰
                        arrButtons[buttonPosition].setPopupChars(new char[]{'‰'});
                        arrButtons[buttonPosition].setMainCharPosition(0);
                        break;
                    case '½':   // ¼ ¾
                        arrButtons[buttonPosition].setPopupChars(new char[]{'¼', '¾'});
                        arrButtons[buttonPosition].setMainCharPosition(0);
                        break;
                    case '=':   // ≠(main) ∞ ≈
                        arrButtons[buttonPosition].setPopupChars(new char[]{'∞', '≠', '≈'});
                        arrButtons[buttonPosition].setMainCharPosition(1);
                        break;
                    case '®':   // ©(main) ™ ℅
                        arrButtons[buttonPosition].setPopupChars(new char[]{'™', '©', '℅'});
                        arrButtons[buttonPosition].setMainCharPosition(1);
                        break;
                    case 'π':   // Π
                        arrButtons[buttonPosition].setPopupChars(new char[]{'Π'});
                        arrButtons[buttonPosition].setMainCharPosition(0);
                        break;
                    case '|':   // ¦
                        arrButtons[buttonPosition].setPopupChars(new char[]{'¦'});
                        arrButtons[buttonPosition].setMainCharPosition(0);
                        break;
                    default:
                        arrButtons[buttonPosition].setPopupChars(null);
                }
                arrButtons[buttonPosition].setText("" + arrKeyCode[buttonPosition][currentLayout][currentLanguage]);
        }
    }

    private void setKeyboardAlignment() {
        currentAlignment = isFullWidth ? PrefData.VAL_ALIGN_CENTER
                : PrefData.getIntPrefs(this, PrefData.KEY_ALIGN_I, PrefData.VAL_ALIGN_CENTER);
        switch (currentAlignment) {
            case PrefData.VAL_ALIGN_RIGHT:
                viewKeyboard.setGravity(Gravity.RIGHT);
                relativeKeyboardContainer.setGravity(Gravity.RIGHT|Gravity.BOTTOM);
                relativeEmoji.setGravity(Gravity.RIGHT);
                button39.setIcon(R.drawable.ic_align_right);
                break;
            case PrefData.VAL_ALIGN_CENTER:
                viewKeyboard.setGravity(Gravity.CENTER_HORIZONTAL);
                relativeKeyboardContainer.setGravity(Gravity.CENTER_HORIZONTAL|Gravity.BOTTOM);
                relativeEmoji.setGravity(Gravity.CENTER_HORIZONTAL);
                button39.setIcon(isFullWidth ? R.drawable.ic_align_full : R.drawable.ic_align_center);
                break;
            case PrefData.VAL_ALIGN_LEFT:
                viewKeyboard.setGravity(Gravity.LEFT);
                relativeKeyboardContainer.setGravity(Gravity.LEFT|Gravity.BOTTOM);
                relativeEmoji.setGravity(Gravity.LEFT);
                button39.setIcon(R.drawable.ic_align_left);
                break;
            default:
                break;
        }
    }

    private void setKeyboardHeight() {
        try {
            ViewGroup.LayoutParams layoutParamsKeyboard = viewKeyboard.getLayoutParams();
            //todo by bcp on 24-06-2020
            RelativeLayout.LayoutParams layoutParamsContainer =  (RelativeLayout.LayoutParams) relativeKeyboardContainer.getLayoutParams();
            RelativeLayout.LayoutParams layoutParamsSwipe = (RelativeLayout.LayoutParams) viewSwipe.getLayoutParams();
            RelativeLayout.LayoutParams layoutParamsEmoji = (RelativeLayout.LayoutParams) relativeEmoji.getLayoutParams();
            LinearLayout.LayoutParams layoutParamsDivider1 = (LinearLayout.LayoutParams) viewDivider1.getLayoutParams();
            LinearLayout.LayoutParams layoutParamsDivider2 = (LinearLayout.LayoutParams) viewDivider2.getLayoutParams();
            RelativeLayout.LayoutParams layoutParamsCandidate = (RelativeLayout.LayoutParams) linearCandidate.getLayoutParams();
            layoutParamsEmoji.width = layoutParamsSwipe.width = layoutParamsContainer.width =
                    PrefData.getBooleanPrefs(this, PrefData.KEY_IS_LATERAL_GAP_FILL_B, true) ? ViewGroup.LayoutParams.MATCH_PARENT : keyboardWidth;

            //todo by bcp on 24-06-2020
            linearEmojiCategory.getLayoutParams().width = keyboardWidth;
            pagerEmoji.getLayoutParams().width = keyboardWidth;
            layoutParamsCandidate.width = keyboardWidth;
            int dividerMargin = candidateHeight / 4;
            layoutParamsCandidate.height = candidateHeight;
//			int candiateTextSize = (int) (candidateHeight * .45);
            int candiateTextSize = keyboardSize > PrefData.VAL_KB_SIZE_TAB_LARGE ? 18 : 11;
            textCandidate1.setTextSize(SP, candiateTextSize);
            textCandidate2.setTextSize(SP, candiateTextSize);
            textCandidate3.setTextSize(SP, candiateTextSize);
            int candidateMargin = getResources().getDimensionPixelOffset(R.dimen.dp1);
            layoutParamsCandidate.setMargins(0, candidateMargin, 0, candidateMargin);
            layoutParamsDivider1.setMargins(0, dividerMargin, 0, dividerMargin);
            layoutParamsDivider2.setMargins(0, dividerMargin, 0, dividerMargin);
            viewDivider1.setLayoutParams(layoutParamsDivider1);
            viewDivider2.setLayoutParams(layoutParamsDivider2);
            linearCandidate.setLayoutParams(layoutParamsCandidate);
            //todo by bcp on 08-12-2020
            if (Build.VERSION.SDK_INT == Build.VERSION_CODES.P){

                if(isTopGap){
                    if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
                        if (isTextSuggestionEnabled) {
                            layoutParamsKeyboard.height = (int) (keyboardHeight + candidateHeight + keyboardTopPadding * 3);
                        } else {
                            layoutParamsKeyboard.height = (int) (keyboardHeight + candidateHeight + keyboardTopPadding * 5);
                        }
                    }else{
                        if (isTextSuggestionEnabled) {
                            layoutParamsKeyboard.height = (int) (keyboardHeight + candidateHeight + keyboardTopPadding );
                        } else {
                            layoutParamsKeyboard.height = (int) (keyboardHeight + keyboardTopPadding * 5);
                        }
                    }

                }else{
                    if (isTextSuggestionEnabled) {
                        layoutParamsKeyboard.height = (int) (keyboardHeight + candidateHeight + keyboardTopPadding );
                    } else {
                        layoutParamsKeyboard.height = (int) (keyboardHeight + keyboardTopPadding * 1.8);
                    }
                }

            }else{
                if (isTextSuggestionEnabled) {
                    layoutParamsKeyboard.height = (int) (keyboardHeight + candidateHeight + keyboardTopPadding );
                } else {
                    layoutParamsKeyboard.height = (int) (keyboardHeight + keyboardTopPadding * 1.8);
                }
            }

            viewKeyboard.setLayoutParams(layoutParamsKeyboard);
            relativeKeyboardContainer.setPadding(0, isTextSuggestionEnabled ? 0 : keyboardTopPadding, 0, 5);
            relativeKeyboardContainer.setLayoutParams(layoutParamsContainer);
        } catch (Exception e) {
            Log.e(TAG, "setKeyboardHeight Exception : ", e);
        }
    }

    private void setVibra() {
        if (isVibraEnabled && vibrator == null) {
            vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        }
    }

    @Override
    public void onStartInputView(EditorInfo editorInfo, boolean restarting) {
        setKeyboardHeight();
        super.onStartInputView(editorInfo, restarting);

        isAutocapitalizationEnable = PrefData.getBooleanPrefs(this, PrefData.KEY_IS_TEXT_AUTOCAPITALIZATION_ENABLED_B, false);

        setEmojiViewVisible(false);

        composing.setLength(0);

        isCapsLockOn = false;

        boolean isSearch = false;
        if (button38 != null) {
            switch (editorInfo.imeOptions & (EditorInfo.IME_MASK_ACTION | EditorInfo.IME_FLAG_NO_ENTER_ACTION)) {
                case EditorInfo.IME_ACTION_SEARCH:
                    button38.setIcon(R.drawable.ic_search);
                    isSearch = true;
                    break;
                default:
                    button38.setIcon(R.drawable.ic_enter);
            }
        }

        ExtractedTextRequest request = new ExtractedTextRequest();
        request.hintMaxChars = 1;
        if (isSizeChanged) {
            for (int buttonPosition = 0; buttonPosition < arrButtons.length; buttonPosition++) {
                arrButtons[buttonPosition].redrawView();
            }
            isSizeChanged = false;
        }
        if (getCurrentInputConnection() != null) {
            ExtractedText extractedText = getCurrentInputConnection().getExtractedText(request, 0);
            isShiftOn = !isSearch && extractedText != null && extractedText.text.toString().length() == 0;
            if (isAutocapitalizationEnable) {
                isCapsLockOn = false;// if edit text excepts text with number then show keyboard with small text.
                isShiftOn = false;
            }
            updateOnShift();
            updateOnAbc();// todo by bcp on 19-06-2020
        }
        /*boolean isAutocapitalizationEnable = PrefData.getBooleanPrefs(this, PrefData.KEY_IS_TEXT_AUTOCAPITALIZATION_ENABLED_B, false);
        if (isAutocapitalizationEnable) {
            isCapsLockOn = false;// if edit text excepts only text with number then show keyboard with small text.
            isShiftOn = false;
            updateOnShift();
        }*/

        setButtonValues();
        //for (int i = 0; i < arrButtons.length; i++) {
        setButtonText(34);
       // }

        if (editorInfo != null) {
            int i = editorInfo.inputType;
            if ((i == (InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD)) ||
                    (i == (InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_VARIATION_PASSWORD))) {
                isCapsLockOn = false;// if edit text excepts only text with number then show keyboard with small text.
                isShiftOn = false;
                updateOnShift();
                if ((i == (InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_VARIATION_PASSWORD))) {
                    isShiftOn = true;
                    updateOnNum();// if edit text excepts only number password then show keyboard with number pad.
                }
            }
        }
    }

    @Override
    public void onFinishInputView(boolean finishingInput) {
        updateOnAbc();
        super.onFinishInputView(finishingInput);
        composing.setLength(0);
        setSuggestions(null);
    }

    private void setKeyboardLayout() {
        currentLayout = currentLanguageLayout = PrefData.getIntPrefs(this, PrefData.KEY_KEYBOARD_LAYOUT_I,
                PrefData.VAL_LAYOUT_ENGLISH);
        updateLayoutText();
    }

    private void setKeyboardTheme() {
        initCurrentTheme();
        relativeKeyboardContainer.setBackgroundColor(currentTheme.getBackgroundColor());
        relativeEmoji.setBackgroundColor(currentTheme.getBackgroundColor());
        button34.setIcon(R.drawable.ic_delete);
        linearCandidate.setBackgroundColor(currentTheme.getCandidateBgColor());
        int candidateFontColor = currentTheme.getCandidateFontColor();
        textCandidate1.setTextColor(candidateFontColor);
        textCandidate2.setTextColor(candidateFontColor);
        textCandidate3.setTextColor(candidateFontColor);
        viewDivider1.setBackgroundColor(candidateFontColor);
        viewDivider2.setBackgroundColor(candidateFontColor);
        bgEmoji = currentTheme.getEmojiBgColor();
        pagerEmoji.setBackgroundColor(bgEmoji);
        linearEmojiCategory.setBackgroundColor(currentTheme.getEmojiCategoryBgColor());
        int emojiCatIconColor = currentTheme.getEmojiCategoryIconColor();
        textAbc.setTextColor(emojiCatIconColor);
        imgDeleteEmoji.setImageDrawable(DrawableHelper
                .withContext(this)
                .withColor(emojiCatIconColor)
                .withDrawable(R.drawable.ic_delete)
                .tint()
                .get());
        for (int i = 0; i < arrImgEmojiCat.length; i++) {
            arrImgEmojiCat[i].setImageDrawable(DrawableHelper
                    .withContext(this)
                    .withColor(emojiCatIconColor)
                    .withDrawable(arrImgEmojiCatVectors[i])
                    .tint()
                    .get());
        }
        setEmojiCategorySelection(pagerEmoji.getCurrentItem());
    }

    private void playSound() {
        try {
            MediaPlayer mediaPlayer = MediaPlayer.create(KeyboardService.this, R.raw.click);
            mediaPlayer.start();
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                public void onCompletion(MediaPlayer mediaPlayer) {
                    mediaPlayer.release();
                }

                ;
            });
        } catch (Exception e) {
            Log.e(TAG, "playSound Exception : ", e);
        }
    }

    private void vibrate() {
        vibrator.vibrate(15);
    }

    private void printText(char code) {
        InputConnection inputConnection = getCurrentInputConnection();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            boolean b=inputConnection.requestCursorUpdates(CURSOR_UPDATE_MONITOR);
        }

        if (Character.isLetter(code) && isShiftOn) {
            code = Character.toUpperCase(code);
        }

        if (code == space || code == '.' || !isTextSuggestionEnabled) {
            inputConnection.commitText("" + code, 1);
        } else {
                composing.append(code);
                inputConnection.setComposingText(composing, 1);
                findSuggestions();

        }

        /**
         * Check for dot + space
         */
        if (isDotSpaceEnabled && code == space && inputConnection.getTextBeforeCursor(2, 0).charAt(0) == '.' && !isShiftOn) {
            isShiftOn = true;
            updateOnShift();
            if (currentLayout == PrefData.VAL_LAYOUT_NUMBER || currentLayout == PrefData.VAL_LAYOUT_SYMBOL) {
                updateOnAbc();
            }
        }
    }

    private void findSuggestions() {
        if (spellCheckerSession != null) {
            if (isSentenceSpellCheckSupported()) {
                // getSentenceSuggestions works on JB or later.
                spellCheckerSession.getSentenceSuggestions(new TextInfo[]{new TextInfo(composing.toString())}, 3);
            } else {
                // getSuggestions() is a deprecated API.
                // It is recommended for an application running on Jelly Bean or later
                // to call getSentenceSuggestions() only.
                spellCheckerSession.getSuggestions(new TextInfo(composing.toString()), 3);
            }
        } else {
            Log.e(TAG, "Couldn't obtain the spell checker service.");
        }
    }

    private boolean isSentenceSpellCheckSupported() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN;
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String preference) {
        switch (preference) {
            case PrefData.KEY_IS_TOP_GAP_FILL:
                setUpKeyboard();
                suggestionlayout();
                setKeyboardHeight();
            case PrefData.KEY_IS_KB_SIZE_FULL_B:
            case PrefData.KEY_KB_SIZE_F:
                setUpKeyboard();
                setKeyboardHeight();
                setEmojiPagerAdapter();
                isSizeChanged = true;
            case PrefData.KEY_ALIGN_I:
                setKeyboardAlignment();
                break;
            case PrefData.KEY_IS_LATERAL_GAP_FILL_B:
                setKeyboardHeight();
                setEmojiPagerAdapter();
                break;
            case PrefData.KEY_KEYBOARD_LAYOUT_I:
                setKeyboardLayout();
                break;
            case PrefData.KEY_KEYBOARD_LAYOUT_CUSTOMLAYOUT:
                setButtonValues();
                setKeyboardLayout();
                break;
            case PrefData.KEY_KEYBOARD_LAYOUT_CUSTOMPOPUP:
                setKeyboardLayout();
                break;
            case PrefData.KEY_SELECTED_THEME_POSITION:
                setKeyboardTheme();
                setEmojiPagerAdapter();
                break;
            case PrefData.KEY_CURRENCY_I:
                arrKeyCode[28][PrefData.VAL_LAYOUT_NUMBER][PrefData.VAL_LAYOUT_ENGLISH] = getDefaultCurrency();
                updateLayoutText();
                break;
            case PrefData.KEY_IS_SOUND_ENABLED_B:
                isSoundEnabled = PrefData.getBooleanPrefs(this, PrefData.KEY_IS_SOUND_ENABLED_B);
                break;
            case PrefData.KEY_IS_VIBRA_ENABLED_B:
                isVibraEnabled = PrefData.getBooleanPrefs(this, PrefData.KEY_IS_VIBRA_ENABLED_B);
                setVibra();
                break;
            case PrefData.KEY_IS_DOT_SPACE_ENABLED_B:
                isDotSpaceEnabled = PrefData.getBooleanPrefs(this, PrefData.KEY_IS_DOT_SPACE_ENABLED_B);
                break;
            case PrefData.KEY_IS_PREVIEW_ENABLED_B:
                isPreviewOn = PrefData.getBooleanPrefs(this, PrefData.KEY_IS_PREVIEW_ENABLED_B);
                break;
            case PrefData.KEY_IS_TWIPE_ENABLED_B:
                isTwipeEnabled = PrefData.getBooleanPrefs(this, PrefData.KEY_IS_TWIPE_ENABLED_B);
                viewSwipe.setVisibility(isTwipeEnabled ? View.VISIBLE : View.GONE);
                break;
            case PrefData.KEY_IS_CURSOR_ENABLED_B:
                isCursorEnabled = PrefData.getBooleanPrefs(this, PrefData.KEY_IS_CURSOR_ENABLED_B);
                break;
            case PrefData.KEY_IS_TEXT_SUGGESTION_ENABLED_B:
                isTextSuggestionEnabled = PrefData.getBooleanPrefs(this, PrefData.KEY_IS_TEXT_SUGGESTION_ENABLED_B);
                suggestionlayout();
                break;
        }
    }

    //todo by bcp on 09/12/2020
    private void suggestionlayout(){
        if (Build.VERSION.SDK_INT == Build.VERSION_CODES.P) {
            if(isTopGap) {
                if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
                    linearCandidate.setVisibility(isTextSuggestionEnabled ? View.VISIBLE : View.INVISIBLE);
                }else{
                    linearCandidate.setVisibility(isTextSuggestionEnabled ? View.VISIBLE : View.GONE);
                }
            }else{
                linearCandidate.setVisibility(isTextSuggestionEnabled ? View.VISIBLE : View.GONE);
            }

        }else{
            linearCandidate.setVisibility(isTextSuggestionEnabled ? View.VISIBLE : View.GONE);

        }

    }

    private void setEmojiPagerAdapter() {
        pagerEmoji.setAdapter(adpEmojiPager);
        setEmojiCategorySelection(pagerEmoji.getCurrentItem());
        if (keyboardSize < PrefData.VAL_KB_SIZE_PHONE_SMALL) {
            textAbc.setTextSize(SP, 12);
        } else {
            textAbc.setTextSize(SP, 16);
        }
    }

    private void setButtonValues() {
        char KEYCODE_DOT_APOSTROPHE = '.';
        char KEYCODE_DOT_APOSTROPHE1 = '\'';
        boolean isDotOrApostrophe = PrefData.getBooleanPrefs(this, PrefData.KEY_IS_DOT_ENABLED_B);
        if (isDotOrApostrophe) {
            KEYCODE_DOT_APOSTROPHE = '\'';
            KEYCODE_DOT_APOSTROPHE1 = '.';
        }
        try {
            /**
             *  arrKeyCode [ button ] [ layout ] [ language ];
             */
            arrKeyCode = new char[][][]{
                    {{KeyEvent.KEYCODE_UNKNOWN},                     // 1, 1
                            {KeyEvent.KEYCODE_UNKNOWN},
                            {KeyEvent.KEYCODE_UNKNOWN},
                            {KeyEvent.KEYCODE_UNKNOWN},
                            {KeyEvent.KEYCODE_UNKNOWN},
                            {KeyEvent.KEYCODE_UNKNOWN}},
                    {{PrefData.getStringPrefs(this,PrefData.B0_EN,"q").charAt(0)}, {PrefData.getStringPrefs(this,PrefData.B0_IT,"q").charAt(0)}, {PrefData.getStringPrefs(this,PrefData.B0_SP,"q").charAt(0)}, {PrefData.getStringPrefs(this,PrefData.B0_DE,"z").charAt(0)}, {'2'}, {'½'}},      // 2, b0
                    {{KeyEvent.KEYCODE_UNKNOWN},                     // 3, 3
                            {KeyEvent.KEYCODE_UNKNOWN},
                            {KeyEvent.KEYCODE_UNKNOWN},
                            {KeyEvent.KEYCODE_UNKNOWN},
                            {KeyEvent.KEYCODE_UNKNOWN},
                            {KeyEvent.KEYCODE_UNKNOWN}},
                    {{PrefData.getStringPrefs(this,PrefData.D0_EN,"w").charAt(0)}, {PrefData.getStringPrefs(this,PrefData.D0_IT,"h").charAt(0)}, {PrefData.getStringPrefs(this,PrefData.D0_SP,"h").charAt(0)}, {PrefData.getStringPrefs(this,PrefData.D0_DE,"h").charAt(0)}, {'+'}, {'±'}},      // 4, d0
                    {{KeyEvent.KEYCODE_UNKNOWN},                     // 5, 5
                            {KeyEvent.KEYCODE_UNKNOWN},
                            {KeyEvent.KEYCODE_UNKNOWN},
                            {KeyEvent.KEYCODE_UNKNOWN},
                            {KeyEvent.KEYCODE_UNKNOWN},
                            {KeyEvent.KEYCODE_UNKNOWN}},
                    {{PrefData.getStringPrefs(this,PrefData.F0_EN,"c").charAt(0)}, {PrefData.getStringPrefs(this,PrefData.F0_IT,"w").charAt(0)}, {PrefData.getStringPrefs(this,PrefData.F0_SP,"w").charAt(0)}, {PrefData.getStringPrefs(this,PrefData.F0_DE,"k").charAt(0)}, {'/'}, {'¡'}},      // 6, f0
                    {{KeyEvent.KEYCODE_UNKNOWN},                     // 7, 7
                            {KeyEvent.KEYCODE_UNKNOWN},
                            {KeyEvent.KEYCODE_UNKNOWN},
                            {KeyEvent.KEYCODE_UNKNOWN},
                            {KeyEvent.KEYCODE_UNKNOWN},
                            {KeyEvent.KEYCODE_UNKNOWN}},
                    {{PrefData.getStringPrefs(this,PrefData.AO_EN,"j").charAt(0)}, {PrefData.getStringPrefs(this,PrefData.AO_IT,"k").charAt(0)}, {PrefData.getStringPrefs(this,PrefData.AO_SP,"g").charAt(0)}, {PrefData.getStringPrefs(this,PrefData.AO_DE,"q").charAt(0)}, {'1'}, {'ª'}},      // 8, a0 j
                    {{PrefData.getStringPrefs(this,PrefData.B1_EN,"f").charAt(0)}, {PrefData.getStringPrefs(this,PrefData.B1_IT,"d").charAt(0)}, {PrefData.getStringPrefs(this,PrefData.B1_SP,"r").charAt(0)}, {PrefData.getStringPrefs(this,PrefData.B1_DE,"g").charAt(0)}, {'5'}, {'•'}},      // 9, b1
                    {{PrefData.getStringPrefs(this,PrefData.C0_EN,"u").charAt(0)}, {PrefData.getStringPrefs(this,PrefData.C0_IT,"u").charAt(0)}, {PrefData.getStringPrefs(this,PrefData.C0_SP,"u").charAt(0)}, {PrefData.getStringPrefs(this,PrefData.C0_DE,"u").charAt(0)}, {'3'}, {'®'}},      // 10, c0
                    {{PrefData.getStringPrefs(this,PrefData.D1_EN,"h").charAt(0)}, {PrefData.getStringPrefs(this,PrefData.D1_IT,"i").charAt(0)}, {PrefData.getStringPrefs(this,PrefData.D1_SP,"i").charAt(0)}, {PrefData.getStringPrefs(this,PrefData.D1_DE,"i").charAt(0)}, {'*'}, {'~'}},      // 11, d1
                    {{PrefData.getStringPrefs(this,PrefData.E0_EN,"i").charAt(0)}, {PrefData.getStringPrefs(this,PrefData.E0_IT,"c").charAt(0)}, {PrefData.getStringPrefs(this,PrefData.E0_SP,"c").charAt(0)}, {PrefData.getStringPrefs(this,PrefData.E0_DE,"c").charAt(0)}, {'<'}, {'«'}},      // 12, e0
                    {{PrefData.getStringPrefs(this,PrefData.F1_EN,"n").charAt(0)}, {PrefData.getStringPrefs(this,PrefData.F1_IT,"f").charAt(0)}, {PrefData.getStringPrefs(this,PrefData.F1_SP,"v").charAt(0)}, {PrefData.getStringPrefs(this,PrefData.F1_DE,"l").charAt(0)}, {'-'}, {'¿'}},      // 13, f1
                    {{PrefData.getStringPrefs(this,PrefData.G0_EN,"k").charAt(0)}, {PrefData.getStringPrefs(this,PrefData.G0_IT,"j").charAt(0)}, {PrefData.getStringPrefs(this,PrefData.G0_SP,"k").charAt(0)}, {PrefData.getStringPrefs(this,PrefData.G0_DE,"j").charAt(0)}, {'>'}, {'»'}},      // 14, g0
                    {{PrefData.getStringPrefs(this,PrefData.A1_EN,"z").charAt(0)}, {PrefData.getStringPrefs(this,PrefData.A1_IT,"v").charAt(0)}, {PrefData.getStringPrefs(this,PrefData.A1_SP,"b").charAt(0)}, {PrefData.getStringPrefs(this,PrefData.A1_DE,"y").charAt(0)}, {'4'}, {'{'}},      // 15, a1
                    {{PrefData.getStringPrefs(this,PrefData.B2_EN,"r").charAt(0)}, {PrefData.getStringPrefs(this,PrefData.B2_IT,"r").charAt(0)}, {PrefData.getStringPrefs(this,PrefData.B2_SP,"l").charAt(0)}, {PrefData.getStringPrefs(this,PrefData.B2_DE,"r").charAt(0)}, {'8'}, {'°'}},      // 16, b2
                    {{PrefData.getStringPrefs(this,PrefData.C1_EN,"o").charAt(0)}, {PrefData.getStringPrefs(this,PrefData.C1_IT,"e").charAt(0)}, {PrefData.getStringPrefs(this,PrefData.C1_SP,"o").charAt(0)}, {PrefData.getStringPrefs(this,PrefData.C1_DE,"n").charAt(0)}, {'6'}, {'}'}},      // 17, c1
                    {{KEYCODE_SPACE},                                // 18, d2
                            {KEYCODE_SPACE},
                            {KEYCODE_SPACE},
                            {KEYCODE_SPACE},
                            {KEYCODE_SPACE},
                            {KEYCODE_SPACE}},
                    {{PrefData.getStringPrefs(this,PrefData.E1_EN,"t").charAt(0)}, {PrefData.getStringPrefs(this,PrefData.E1_IT,"l").charAt(0)}, {PrefData.getStringPrefs(this,PrefData.E1_SP,"y").charAt(0)}, {PrefData.getStringPrefs(this,PrefData.E1_DE,"s").charAt(0)}, {'('}, {'['}},      // 19, e1
                    {{PrefData.getStringPrefs(this,PrefData.F2_EN,"y").charAt(0)}, {PrefData.getStringPrefs(this,PrefData.F2_IT,"g").charAt(0)}, {PrefData.getStringPrefs(this,PrefData.F2_SP,"d").charAt(0)}, {PrefData.getStringPrefs(this,PrefData.F2_DE,"t").charAt(0)}, {':'}, {'\\'}},     // 20, f2
                    {{PrefData.getStringPrefs(this,PrefData.G1_EN,"g").charAt(0)}, {PrefData.getStringPrefs(this,PrefData.G1_IT,"y").charAt(0)}, {PrefData.getStringPrefs(this,PrefData.G1_SP,"j").charAt(0)}, {PrefData.getStringPrefs(this,PrefData.G1_DE,"f").charAt(0)}, {')'}, {']'}},      // 21, g1
                    {{PrefData.getStringPrefs(this,PrefData.A2_EN,"b").charAt(0)}, {PrefData.getStringPrefs(this,PrefData.A2_IT,"b").charAt(0)}, {PrefData.getStringPrefs(this,PrefData.A2_SP,"f").charAt(0)}, {PrefData.getStringPrefs(this,PrefData.A2_DE,"p").charAt(0)}, {'7'}, {'§'}},      // 22, a2
                    {{PrefData.getStringPrefs(this,PrefData.B3_EN,"p").charAt(0)}, {PrefData.getStringPrefs(this,PrefData.B3_IT,"p").charAt(0)}, {PrefData.getStringPrefs(this,PrefData.B3_SP,"p").charAt(0)}, {PrefData.getStringPrefs(this,PrefData.B3_DE,"b").charAt(0)}, {'0'}, {'='}},      // 23, b3
                    {{PrefData.getStringPrefs(this,PrefData.C2_EN,"e").charAt(0)}, {PrefData.getStringPrefs(this,PrefData.C2_IT,"a").charAt(0)}, {PrefData.getStringPrefs(this,PrefData.C2_SP,"a").charAt(0)}, {PrefData.getStringPrefs(this,PrefData.C2_DE,"e").charAt(0)}, {'9'}, {'π'}},      // 24, c2
                    {{PrefData.getStringPrefs(this,PrefData.D3_EN,"a").charAt(0)}, {PrefData.getStringPrefs(this,PrefData.D3_IT,"t").charAt(0)}, {PrefData.getStringPrefs(this,PrefData.D3_SP,"s").charAt(0)}, {PrefData.getStringPrefs(this,PrefData.D3_DE,"d").charAt(0)}, {KEYCODE_DOT_APOSTROPHE}, {';'}},      // 25, d3
                    {{PrefData.getStringPrefs(this,PrefData.E2_EN,"s").charAt(0)}, {PrefData.getStringPrefs(this,PrefData.E2_IT,"o").charAt(0)}, {PrefData.getStringPrefs(this,PrefData.E2_SP,"e").charAt(0)}, {PrefData.getStringPrefs(this,PrefData.E2_DE,"a").charAt(0)}, {'@'}, {'¶'}},      // 26, e2
                    {{PrefData.getStringPrefs(this,PrefData.F3_EN,"m").charAt(0)}, {PrefData.getStringPrefs(this,PrefData.F3_IT,"m").charAt(0)}, {PrefData.getStringPrefs(this,PrefData.F3_SP,"n").charAt(0)}, {PrefData.getStringPrefs(this,PrefData.F3_DE,"o").charAt(0)}, {'"'}, {'^'}},      // 27, f3
                    {{PrefData.getStringPrefs(this,PrefData.G2_EN,"v").charAt(0)}, {PrefData.getStringPrefs(this,PrefData.G2_IT,"z").charAt(0)}, {PrefData.getStringPrefs(this,PrefData.G2_SP,"z").charAt(0)}, {PrefData.getStringPrefs(this,PrefData.G2_DE,"v").charAt(0)}, {'_'}, {'|'}},      // 28, g2
                    {{PrefData.getStringPrefs(this,PrefData.A3_EN,"x").charAt(0)}, {PrefData.getStringPrefs(this,PrefData.A3_IT,"x").charAt(0)}, {PrefData.getStringPrefs(this,PrefData.A3_SP,"x").charAt(0)}, {PrefData.getStringPrefs(this,PrefData.A3_DE,"x").charAt(0)},                     // 29, a3
                            {getDefaultCurrency()}, {'%'}},
                    {{KEYCODE_SHIFT},                                // 30, b4
                            {KEYCODE_SHIFT},
                            {KEYCODE_SHIFT},
                            {KEYCODE_SHIFT},
                            {KEYCODE_SYM},
                            {KEYCODE_NUM}},
                    {{PrefData.getStringPrefs(this,PrefData.C3_EN,"l").charAt(0)}, {PrefData.getStringPrefs(this,PrefData.C3_IT,"s").charAt(0)}, {PrefData.getStringPrefs(this,PrefData.C3_SP,"m").charAt(0)}, {PrefData.getStringPrefs(this,PrefData.C3_DE,"m").charAt(0)}, {'!'}, {'#'}},      // 31, c3
                    {{KEYCODE_NUM},                                  // 32, d4
                            {KEYCODE_NUM},
                            {KEYCODE_NUM},
                            {KEYCODE_NUM},
                            {KEYCODE_ABC},
                            {KEYCODE_ABC}},
                    {{PrefData.getStringPrefs(this,PrefData.E3_EN,"d").charAt(0)}, {PrefData.getStringPrefs(this,PrefData.E3_IT,"n").charAt(0)}, {PrefData.getStringPrefs(this,PrefData.E3_SP,"t").charAt(0)}, {PrefData.getStringPrefs(this,PrefData.E3_DE,"w").charAt(0)}, {'?'}, {'&'}},      // 33, e3
                    {{KeyEvent.KEYCODE_DEL},                         // 34, f4
                            {KeyEvent.KEYCODE_DEL},
                            {KeyEvent.KEYCODE_DEL},
                            {KeyEvent.KEYCODE_DEL},
                            {KeyEvent.KEYCODE_DEL},
                            {KeyEvent.KEYCODE_DEL}},
                    {{KEYCODE_DOT_APOSTROPHE1}, {KEYCODE_DOT_APOSTROPHE1}, {KEYCODE_DOT_APOSTROPHE1}, {KEYCODE_DOT_APOSTROPHE1}, {','}, {'…'}},// 35, g3
                    {{KEYCODE_SETTINGS},                             // 36, 36
                            {KEYCODE_SETTINGS},
                            {KEYCODE_SETTINGS},
                            {KEYCODE_SETTINGS},
                            {KEYCODE_SETTINGS},
                            {KEYCODE_SETTINGS}},
                    {{KEYCODE_EMOTICON},                             // 37, 37
                            {KEYCODE_EMOTICON},
                            {KEYCODE_EMOTICON},
                            {KEYCODE_EMOTICON},
                            {KEYCODE_EMOTICON},
                            {KEYCODE_EMOTICON}},
                    {{KeyEvent.KEYCODE_ENTER},                       // 38, 38
                            {KeyEvent.KEYCODE_ENTER},
                            {KeyEvent.KEYCODE_ENTER},
                            {KeyEvent.KEYCODE_ENTER},
                            {KeyEvent.KEYCODE_ENTER},
                            {KeyEvent.KEYCODE_ENTER}},
                    {{KEYCODE_ALIGNMENT},                            // 39, 39
                            {KEYCODE_ALIGNMENT},
                            {KEYCODE_ALIGNMENT},
                            {KEYCODE_ALIGNMENT},
                            {KEYCODE_ALIGNMENT},
                            {KEYCODE_ALIGNMENT}},
            };
        } catch (Exception e) {
            Log.e(TAG, "setButtonValues Exception : ", e);
        }
    }

    private char getDefaultCurrency() {
        switch (PrefData.getIntPrefs(this, PrefData.KEY_CURRENCY_I, PrefData.VAL_CURRENCY_EUR)) {
            case PrefData.VAL_CURRENCY_EUR:
                return '€';
            case PrefData.VAL_CURRENCY_USD:
                return '$';
            case PrefData.VAL_CURRENCY_GBP:
                return '£';
            default:
                return 0;
        }
    }

    public Theme getCurrentTheme() {
        return currentTheme;
    }

    public boolean isPreviewOn() {
        return isPreviewOn;
    }

    public int getKeyboardRightX() {
        int[] location = new int[2];
        button35.getLocationInWindow(location);
        return location[0] + button35.getWidth();
    }

    public int getKeyboardLeftX() {
        int[] location = new int[2];
        button29.getLocationInWindow(location);
        return location[0];
    }

    @Override
    public void onClickEmoji(String emoji) {
        callTapEffect();
        getCurrentInputConnection().commitText(emoji, 1);
    }

    @Override
    public void onGetSuggestions(SuggestionsInfo[] results) {
        final ArrayList<String> arrListSuggestions = new ArrayList<>();
        for (int i = 0; i < results.length; i++) {
            SuggestionsInfo si = results[i];
            if (si != null) {
                for (int j = 0; j < si.getSuggestionsCount(); j++) {
                    arrListSuggestions.add(si.getSuggestionAt(j));
                }
            }
        }
        setSuggestions(arrListSuggestions);
    }

    @Override
    public void onUpdateSelection(int oldSelStart, int oldSelEnd, int newSelStart, int newSelEnd, int candidatesStart, int candidatesEnd) {
        super.onUpdateSelection(oldSelStart, oldSelEnd, newSelStart, newSelEnd, candidatesStart, candidatesEnd);

/*
        if (composing.length() > 0 && candidatesStart > 0 && (newSelStart < candidatesStart || newSelStart > candidatesEnd)) {
            composing.setLength(0);
            setSuggestions(null);
            InputConnection inputConnection = getCurrentInputConnection();
            if (inputConnection != null) {
                inputConnection.finishComposingText();
            }
        }
*/
         // todo changes by bcp 22-06-2020
        /*for cursor jump to last issue*/
        if (composing.length() > 0 && (newSelStart != candidatesEnd
                || newSelEnd != candidatesEnd)) {
            composing.setLength(0);
            setSuggestions(null);
            InputConnection inputConnection = getCurrentInputConnection();
            if (inputConnection != null) {
                inputConnection.finishComposingText();
            }
        }


    }

  /*  @Override
    public void onDisplayCompletions(CompletionInfo[] completions) {
        ArrayList<String> stringList = new ArrayList<String>();
        for (int i = 0; i < completions.length; i++) {
            CompletionInfo ci = completions[i];
            if (ci != null) stringList.add(ci.getText().toString());
        }
        setSuggestions(stringList);
    }*/

    @Override
    public void onGetSentenceSuggestions(SentenceSuggestionsInfo[] results) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN && results != null && results.length > 0) {
            final ArrayList<String> arrListSuggestions = new ArrayList<>();
            for (int i = 0; i < results.length; i++) {
                SentenceSuggestionsInfo ssi = results[i];
                if (ssi != null) {
                    for (int j = 0; j < ssi.getSuggestionsCount(); j++) {
                        SuggestionsInfo suggestionsInfo = ssi.getSuggestionsInfoAt(j);
                        if (suggestionsInfo != null) {
                            for (int k = 0; k < suggestionsInfo.getSuggestionsCount(); k++) {
                                arrListSuggestions.add(suggestionsInfo.getSuggestionAt(k));
                            }
                        }
                    }
                }
            }
            setSuggestions(arrListSuggestions);
        }
    }

    private void setSuggestions(ArrayList<String> arrListSuggestions) {
        try {
            if (arrListSuggestions != null && arrListSuggestions.size() > 0) {
                for (int i = 0; i < arrListSuggestions.size(); i++) {
                    switch (i) {
                        case 0:
                            textCandidate2.setText(arrListSuggestions.get(i));
                            break;
                        case 1:
                            textCandidate1.setText(arrListSuggestions.get(i));
                            break;
                        case 2:
                            textCandidate3.setText(arrListSuggestions.get(i));
                            break;
                    }
                }
            } else {
                clearSuggestions();
            }
        } catch (Exception e) {
            Log.e(TAG, "setSuggestions Exception : ", e);
        }
    }

    private void clearSuggestions() {
        for (int i = 0; i < arrTextCandidate.length; i++) {
            arrTextCandidate[i].setText("");
        }
    }

    private void commitComposing(InputConnection inputConnection) {
        //System.out.println("compassing===="+composing);
        if (composing.length() > 0) {
            inputConnection.commitText(composing, 1);
            composing.setLength(0);
            setSuggestions(null);
        }
    }

    private void commitSelected(CharSequence text) {
        composing.replace(0, composing.length(), text.toString());
        commitComposing(getCurrentInputConnection());
    }
}