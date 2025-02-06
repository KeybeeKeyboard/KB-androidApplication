package it.keybeeproject.keybee.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import androidx.appcompat.widget.AppCompatButton;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import it.keybeeproject.keybee.R;
import it.keybeeproject.keybee.service.KeyboardService;
import it.keybeeproject.keybee.utility.DrawableHelper;
import it.keybeeproject.keybee.utility.PrefData;
import it.keybeeproject.keybee.utility.TypeFace;

/**
 * Created by c161 on 21/07/16.
 */
public class ButtonHexagon extends AppCompatButton {

    private static final String TAG = ButtonHexagon.class.getSimpleName();

    private Context context;

    private TextView textKeyPreview;
    private PopupWindow popupWindowPreview, popupWindowPopup;

    private Path path;
    private Paint paintShape, paintShapeStroke, paintSelection;
    private Runnable runnableRepeatClick, runnableLongClick, runnableDismissPreview, runnablePopup, runnableHover;
    private OnHexagonTouchListener listenerHexagonTouch;
    private KeyboardService serviceKeyboard;
    private TextViewPopUp arrTextPopUp[];
    private GradientDrawable bgPopup;

    private int[] vertexX, vertexY, location;
    private int modeHexagon /*  1:full, 2:upper_half, 3:lower_half  */, previewWidth, popupItemWidth, previewHeight, previewMarginLeft,
            wd2, wd4, hd2, lastId, iconResId, mainCharPosition = 0, colorIconFullHexagon, colorIconBottomLine;
    private float previewTextSize, popupTextSize;
    private final long DELAY_LONG_CLICK = 500, DELAY_PREVIEW_DISMISS = 90, DELAY_POPUP_DISPLAY = 275,
            DELAY_HOVER_RESPONSE = 90;
    public static final long INTERVAL_REPEAT_INITIAL = 100, DELAY_REPEAT_INITIAL = 500, REPEAT_INTERVAL_MIN = 20,
            REPEAT_INTERVAL_STEP = 2;
    private long currentRepeatInterval = INTERVAL_REPEAT_INITIAL, firstTapMilli;
    private char keyCode;
    private char[] arrKeyPopup;
    private boolean isRepetitiveEnabled, isDoubleClickEnabled, isLongClickEnabled, isPreviewEnabled, isLongClicked,
            isPopUpClicked, isAllCaps, isActionUpdateCaps, isActionDown, isActionUp, isRedrawView = true, canHoverDelay,
            isSpecialKey;

    public interface OnHexagonTouchListener {
        void onActionDown(ButtonHexagon buttonHexagon);

        void onActionUp(ButtonHexagon buttonHexagon, boolean isInSide);

        void onActionMove(ButtonHexagon buttonHexagon, MotionEvent event);

        void onClick(ButtonHexagon buttonHexagon);

        boolean onLongClick(ButtonHexagon buttonHexagon);

        void onDoubleTap(ButtonHexagon buttonHexagon);

        void onPopUpLetterSelection(char keyCode);
    }

    public ButtonHexagon(Context context) {
        super(context);
        this.context = context;
        modeHexagon = 1;
        initView(context);
    }

    public ButtonHexagon(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        initAttributes(context, attrs);
        initView(context);
    }

    public ButtonHexagon(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        initAttributes(context, attrs);
        initView(context);
    }

    private void initAttributes(Context context, AttributeSet attrs) {
        if (attrs != null) {

            TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.ButtonHexagon, 0, 0);
            try {
                modeHexagon = typedArray.getInteger(R.styleable.ButtonHexagon_hexagonShape, 1);
                isRepetitiveEnabled = typedArray.getBoolean(R.styleable.ButtonHexagon_repetitiveEnabled, false);
                isDoubleClickEnabled = typedArray.getBoolean(R.styleable.ButtonHexagon_doubleTapEnabled, false);
                isPreviewEnabled = typedArray.getBoolean(R.styleable.ButtonHexagon_previewEnabled, true);
                isLongClickEnabled = typedArray.getBoolean(R.styleable.ButtonHexagon_longClickEnabled, false);
                isSpecialKey = typedArray.getBoolean(R.styleable.ButtonHexagon_isSpecialKey, false);
                iconResId = typedArray.getResourceId(R.styleable.ButtonHexagon_icon, 0);

                initRepetitiveRunnable();

                if (isPreviewEnabled) {
                    runnableDismissPreview = new Runnable() {
                        @Override
                        public void run() {
                            dismissPreview();
                        }
                    };
                    runnablePopup = new Runnable() {
                        @Override
                        public void run() {
                            showPopup();
                        }
                    };
                }

                if (isLongClickEnabled) {
                    runnableLongClick = new Runnable() {
                        @Override
                        public void run() {
                            isLongClicked = listenerHexagonTouch.onLongClick(ButtonHexagon.this);
                        }
                    };
                }

                runnableHover = new Runnable() {
                    @Override
                    public void run() {
                        isActionUp = true;
                        invalidate();
                    }
                };
            } finally {
                typedArray.recycle();
            }

            try {
                typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomFont);
                String customFont = typedArray.getString(R.styleable.CustomFont_custom_font);
                if (customFont != null && customFont.length() > 0) {
                    setTypeface(TypeFace.getTypeface(context, customFont));
                }
            } finally {
                typedArray.recycle();
            }
        }
    }

    private void initView(Context context) {
        serviceKeyboard = (KeyboardService) context;
        paintShape = new Paint(Paint.ANTI_ALIAS_FLAG);
        paintShape.setStyle(Paint.Style.FILL);
        paintShapeStroke = new Paint(Paint.ANTI_ALIAS_FLAG);
        paintShapeStroke.setStyle(Paint.Style.STROKE);
        canHoverDelay = Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP;

        if (isPreviewEnabled) {
            textKeyPreview = (TextView) LayoutInflater.from(context).inflate(R.layout.layout_key_preview, null);
            popupWindowPreview = new PopupWindow(textKeyPreview);
            popupWindowPreview.setClippingEnabled(false);
            popupWindowPreview.setTouchable(false);
            location = new int[2];
        }
    }

    public void redrawView() {
        isRedrawView = true;
    }

    @Override
    public void setAllCaps(boolean allCaps) {
        isActionUpdateCaps = true;
        super.setAllCaps(allCaps);
        isAllCaps = allCaps;
    }

    @Override
    protected void onDraw(Canvas canvas) {

        if (isActionDown) {

            canvas.drawPath(path, paintSelection);
            canvas.drawPath(path, paintShapeStroke);
            isActionDown = false;
            drawIconForFullHexagon(canvas);
            super.onDraw(canvas);

        } else if (isActionUp) {

            canvas.drawPath(path, paintShape);
            canvas.drawPath(path, paintShapeStroke);
            isActionUp = false;
            drawIconForFullHexagon(canvas);
            super.onDraw(canvas);

        } else if (!isRedrawView && isActionUpdateCaps) {

            /**
             * To update theme
             */
            if (path != null) {
                if (modeHexagon == 1) {
                    drawOnCanvas(canvas);
                } else if (modeHexagon == 2) {
                    drawIconForFullHexagon(canvas);
                }
            }
            isActionUpdateCaps = false;

            super.onDraw(canvas);

        } else {

            isRedrawView = false;

            int width = getWidth();
            int height = getHeight();
            int top = 0;
            int right = width;
            int bottom = height;
            int left = 0;
            wd2 = width / 2; // wd2(width divided by 2)
            wd4 = width / 4; // wd4(width divided by 4)
            hd2 = height / 2; // hd2(height divided by 2)

            switch (modeHexagon) {
                case 1: //  Full hexagon
                    vertexX = new int[6];
                    vertexY = new int[6];

                    vertexX[0] = left + wd4;
                    vertexX[1] = right - wd4;
                    vertexX[2] = right;
                    vertexX[3] = right - wd4;
                    vertexX[4] = left + wd4;
                    vertexX[5] = left;

                    vertexY[0] = top;
                    vertexY[1] = top;
                    vertexY[2] = bottom - hd2;
                    vertexY[3] = bottom;
                    vertexY[4] = bottom;
                    vertexY[5] = bottom - hd2;

                    path = new Path();
                    path.moveTo(vertexX[0], vertexY[0]);
                    for (int i = 1; i < vertexX.length; i++) {
                        path.lineTo(vertexX[i], vertexY[i]);
                    }
                    path.lineTo(vertexX[0], vertexY[0]);
                    path.close();

                    paintSelection = new Paint(Paint.ANTI_ALIAS_FLAG);
                    paintSelection.setStyle(Paint.Style.FILL);

                    drawOnCanvas(canvas);
                    break;

                case 2: //  Upper half hexagon
                    vertexX = new int[4];
                    vertexY = new int[4];

                    vertexX[0] = left + wd4;
                    vertexX[1] = right - wd4;
                    vertexX[2] = right;
                    vertexX[3] = left;

                    vertexY[0] = top;
                    vertexY[1] = top;
                    vertexY[2] = bottom;
                    vertexY[3] = bottom;

                    drawOnUpperHalfHexagonCanvas(canvas);

                    break;

                case 3: //  Lower half hexagon
                    vertexX = new int[4];
                    vertexY = new int[4];

                    vertexX[0] = left;
                    vertexX[1] = right;
                    vertexX[2] = right - wd4;
                    vertexX[3] = left + wd4;

                    vertexY[0] = top;
                    vertexY[1] = top;
                    vertexY[2] = bottom;
                    vertexY[3] = bottom;
                    break;
            }

            if (isPreviewEnabled) {
                previewMarginLeft = (int) (width * .20);
                previewWidth = (int) (width * .60);
                popupItemWidth = wd2;
                previewHeight = height;
                popupWindowPreview.setWidth(previewWidth);
                popupWindowPreview.setHeight(previewHeight);
                previewTextSize = previewWidth * .95f;
                popupTextSize = popupItemWidth * .95f;
                textKeyPreview.setTextSize(TypedValue.COMPLEX_UNIT_PX, previewTextSize);
                getLocationInWindow(location);
            }

            super.onDraw(canvas);
        }

    }

    private void drawOnUpperHalfHexagonCanvas(Canvas canvas) {
        try {
            if (iconResId != 0) {
                colorIconBottomLine = serviceKeyboard.getCurrentTheme().getIconColor();
                setTextColor(colorIconBottomLine);
                Drawable drawable = DrawableHelper
                        .withContext(getContext())
                        .withColor(colorIconBottomLine)
                        .withDrawable(iconResId)
                        .tint()
                        .get();
                int extraSpace = (int) (wd4 * .17), iconMarginHorizontal = (int) (hd2 * .3);
                drawable.setBounds(wd4 + extraSpace + iconMarginHorizontal, (int) (hd2 * 0.5),
                        getWidth() - wd4 - extraSpace - iconMarginHorizontal, getHeight() - (int) (hd2 * 0.1));
                drawable.draw(canvas);
            }
        } catch (Exception e) {
            Log.e(TAG, "drawOnUpperHalfHexagonCanvas Exception : " + e.toString());
        }
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        if (location != null) {
            getLocationInWindow(location);
        }
        super.onLayout(changed, left, top, right, bottom);
    }

    private void drawOnCanvas(Canvas canvas) {
        int centerColor = 0, edgeColor = 0, selectionColor, strokeColor;

        if (isSpecialKey) {
            setTextColor(serviceKeyboard.getCurrentTheme().getSpecialKeyFontColor());
            centerColor = serviceKeyboard.getCurrentTheme().getSpecialKeyCenterColor();
            edgeColor = serviceKeyboard.getCurrentTheme().getSpecialKeyExternalColor();
            selectionColor = serviceKeyboard.getCurrentTheme().getSpecialKeyPressedColor();
        } else {
            setTextColor(serviceKeyboard.getCurrentTheme().getDefaultKeyFontColor());
            centerColor = serviceKeyboard.getCurrentTheme().getDefaultKeyCenterColor();
            edgeColor = serviceKeyboard.getCurrentTheme().getDefaultKeyExternalColor();
            selectionColor = serviceKeyboard.getCurrentTheme().getDefaultKeyPressedColor();
        }

        if (textKeyPreview != null) {
            textKeyPreview.setTextColor(serviceKeyboard.getCurrentTheme().getPopupSelectedFontColor());
        }
        strokeColor = serviceKeyboard.getCurrentTheme().getKeyStrokeColor();
        bgPopup = (GradientDrawable) getResources().getDrawable(R.drawable.bg_popup_item_selected);
        bgPopup.setColor(serviceKeyboard.getCurrentTheme().getPopupSelectedColor());
        colorIconFullHexagon = serviceKeyboard.getCurrentTheme().getSpecialKeyFontColor();

        if (isPreviewEnabled) {
            popupWindowPreview.setBackgroundDrawable(bgPopup);
        }
        paintSelection.setColor(selectionColor);
        RadialGradient gradient = new RadialGradient(wd2, hd2, wd2, centerColor,
                edgeColor, android.graphics.Shader.TileMode.CLAMP);
        paintShape.setDither(false);
        paintShape.setShader(gradient);
        canvas.drawPath(path, paintShape);

        paintShapeStroke.setStrokeWidth(1);
        paintShapeStroke.setDither(false);
        paintShapeStroke.setColor(strokeColor);
        canvas.drawPath(path, paintShapeStroke);

        drawIconForFullHexagon(canvas);
    }

    private void drawIconForFullHexagon(Canvas canvas) {
        try {
            if (iconResId != 0) {
                Drawable drawable = DrawableHelper
                        .withContext(getContext())
                        .withColor(colorIconFullHexagon)
                        .withDrawable(iconResId)
                        .tint()
                        .get();
                int verticalSpace = (int) (hd2 * 0.45), horizontalSpace = (int) (wd4 * 0.1);
                drawable.setBounds(wd4 + horizontalSpace, verticalSpace, getWidth() - wd4 - horizontalSpace, getHeight() - verticalSpace);
                drawable.draw(canvas);
            }
        } catch (Exception e) {
            Log.e(TAG, "drawIconForFullHexagon : " + e.toString());
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        if (isShowingPopUp()) {
            return onTouchPopUp(event);
        }

        if (isInsideHexagon(event)) {
            return onTouch(event);
        }

        /**
         * For action drop outside of button.
         */
        if (event.getAction() == MotionEvent.ACTION_UP) {
            listenerHexagonTouch.onActionUp(this, false);
            removeCallbacks(runnableRepeatClick);
            removeCallbacks(runnableLongClick);
            removeCallbacks(runnablePopup);
            isLongClicked = false;
            postDismissPreview();
            invalidateOnActionUp();
        } else if (event.getAction() == MotionEvent.ACTION_MOVE) {  // For ACTION_MOVE during twipe
            listenerHexagonTouch.onActionMove(this, event);
            removeCallbacks(runnableRepeatClick);
            removeCallbacks(runnableLongClick);
            removeCallbacks(runnablePopup);
            dismissPreview();
            invalidateOnActionUp();
        }

        return false;
    }

    public void invalidateOnActionUp() {
        if (modeHexagon == 1) {
            if (canHoverDelay) {
                postDelayed(runnableHover, DELAY_HOVER_RESPONSE);
            } else {
                isActionUp = true;
                postInvalidate();
            }
        }
    }

    public boolean isShowingPopUp() {
        return popupWindowPopup != null && popupWindowPopup.isShowing();
    }

    public boolean onTouch(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            showPreview();
            postDelayed(runnablePopup, DELAY_POPUP_DISPLAY);
            invalidateOnActionDown();
            listenerHexagonTouch.onActionDown(this);
            if (isRepetitiveEnabled) {
                removeCallbacks(runnableRepeatClick);
                listenerHexagonTouch.onClick(this);
                currentRepeatInterval = INTERVAL_REPEAT_INITIAL;
                postDelayed(runnableRepeatClick, DELAY_REPEAT_INITIAL);
            } else if (isLongClickEnabled) {
                postDelayed(runnableLongClick, DELAY_LONG_CLICK);
            }
        } else if (event.getAction() == MotionEvent.ACTION_UP) {
            listenerHexagonTouch.onActionUp(this, true);
            removeCallbacks(runnableLongClick);
            removeCallbacks(runnablePopup);

            invalidateOnActionUp();

            /**
             * On double tap.
             */
            if (isDoubleClickEnabled && listenerHexagonTouch != null) {
                if (System.currentTimeMillis() - firstTapMilli <= 400) {
                    listenerHexagonTouch.onDoubleTap(this);
                    return true;
                }
                firstTapMilli = System.currentTimeMillis();
            }

            /**
             * Single click
             */
            if (!isRepetitiveEnabled && !isLongClicked && !isPopUpClicked) {
                listenerHexagonTouch.onClick(this);
            } else if (isRepetitiveEnabled) {
                removeCallbacks(runnableRepeatClick);
            }
            isLongClicked = false;
            isPopUpClicked = false;
            postDismissPreview();
        } else if (event.getAction() == MotionEvent.ACTION_MOVE) {
            listenerHexagonTouch.onActionMove(this, event);
        }
        return true;
    }

    public void postDismissPreview() {
        if (isPreviewEnabled) {
            postDelayed(runnableDismissPreview, DELAY_PREVIEW_DISMISS);
        }
    }

    public void invalidateOnActionDown() {
        if (modeHexagon == 1) {
            isActionDown = true;
            invalidate();
        }
    }

    @Override
    public boolean performClick() {
        listenerHexagonTouch.onActionDown(this);
        listenerHexagonTouch.onClick(this);
        return true;
    }

    private void showPreview() {
        if (isPreviewEnabled && serviceKeyboard.isPreviewOn()) {
            removeCallbacks(runnableDismissPreview);
            textKeyPreview.setAllCaps(isAllCaps);
            textKeyPreview.setText("" + keyCode);
            popupWindowPreview.showAtLocation(this, Gravity.NO_GRAVITY, location[0] + previewMarginLeft,
                    location[1] - getHeight() - 2 /* button gap as defined in KeyboardService */); //y: location[1] - getHeight() - hd2 - 2


        }
    }

    private void showPopup() {
        try {
            // 'a' special char not working
            // Dot position is OFF: No pop up on 123 keyboard on . and ' key
            // Dot position is ON : the pop up appers also in the 123 keyboard. That's not correct.
            if ((!getText().toString().equals(".") && !getText().toString().equals("'")) || (PrefData.getIntPrefs(context, PrefData.KEY_TYPE) != PrefData.VAL_LAYOUT_NUMBER)) {
                if (arrKeyPopup != null && arrKeyPopup.length > 0) {
                    dismissPreview();
                    LayoutInflater inflater = LayoutInflater.from(getContext());
                    LinearLayout linearPopUp = (LinearLayout) inflater.inflate(R.layout.layout_key_popup, null);

                    LinearLayout linearOne = new LinearLayout(getContext());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                            ViewGroup.LayoutParams.WRAP_CONTENT);
                    linearOne.setOrientation(LinearLayout.HORIZONTAL);
                    linearOne.setLayoutParams(layoutParams);
                    arrTextPopUp = new TextViewPopUp[arrKeyPopup.length];

                    int length1 = arrKeyPopup.length;
                    if(Build.VERSION.SDK_INT==Build.VERSION_CODES.P){

                        /*if (arrKeyPopup.length > 6) {

                            length1 = 6; //4

                            LinearLayout linearTwo = new LinearLayout(getContext());
                            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                                    ViewGroup.LayoutParams.WRAP_CONTENT);
                            linearTwo.setOrientation(LinearLayout.HORIZONTAL);
                            linearTwo.setLayoutParams(layoutParams2);

                            for (int i = 6; i < arrKeyPopup.length; i++) { //4
                                arrTextPopUp[i] = addLetter(arrKeyPopup[i]);
                                linearTwo.addView(arrTextPopUp[i]);
                            }
                            linearPopUp.addView(linearTwo);

                        }*/
                        for (int i = 0; i < arrKeyPopup.length; i++) {
                            arrTextPopUp[i] = addLetter(arrKeyPopup[i]);
                            linearOne.addView(arrTextPopUp[i]);
                        }
                    }else{
                        if (arrKeyPopup.length > 6) {
                        /*if (arrKeyPopup.length > 8) {
                            length1 = 6; //4
                            LinearLayout linearTwo = new LinearLayout(getContext());
                            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                                    ViewGroup.LayoutParams.WRAP_CONTENT);
                            linearTwo.setOrientation(LinearLayout.HORIZONTAL);
                            linearTwo.setLayoutParams(layoutParams2);

                            for (int i = 8; i < arrKeyPopup.length; i++) {
                                arrTextPopUp[i] = addLetter(arrKeyPopup[i]);
                                linearTwo.addView(arrTextPopUp[i]);
                            }
                            linearPopUp.addView(linearTwo);

                            LinearLayout linearThree = new LinearLayout(getContext());
                            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                                    ViewGroup.LayoutParams.WRAP_CONTENT);
                            linearThree.setOrientation(LinearLayout.HORIZONTAL);
                            linearThree.setLayoutParams(layoutParams4);

                            for (int i = 6; i < arrKeyPopup.length; i++) { //4 //8
                                arrTextPopUp[i] = addLetter(arrKeyPopup[i]);
                                linearThree.addView(arrTextPopUp[i]);
                            }
                            linearPopUp.addView(linearThree);
                        }else { }*/

                            length1 = 6; //4

                            LinearLayout linearTwo = new LinearLayout(getContext());
                            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                                    ViewGroup.LayoutParams.WRAP_CONTENT);
                            linearTwo.setOrientation(LinearLayout.HORIZONTAL);
                            linearTwo.setLayoutParams(layoutParams2);

                            for (int i = 6; i < arrKeyPopup.length; i++) { //4
                                arrTextPopUp[i] = addLetter(arrKeyPopup[i]);
                                linearTwo.addView(arrTextPopUp[i]);
                            }
                            linearPopUp.addView(linearTwo);

                        }
                        for (int i = 0; i < length1; i++) {
                            arrTextPopUp[i] = addLetter(arrKeyPopup[i]);
                            linearOne.addView(arrTextPopUp[i]);
                        }
                    }




                    linearPopUp.addView(linearOne);

                    lastId = -1;
                    popupWindowPopup = new PopupWindow(getContext());
                    int padding = getResources().getDimensionPixelOffset(R.dimen.dp2);
                    int spacing = getResources().getDimensionPixelOffset(R.dimen.dp2) * 2;
                    int popUpWidth,popUpHeight;
                    if(Build.VERSION.SDK_INT == Build.VERSION_CODES.P){
                         popUpWidth = popupItemWidth * (arrKeyPopup.length > 6 ? arrKeyPopup.length : arrKeyPopup.length) + spacing;
                         popUpHeight = previewHeight * (arrKeyPopup.length > 6 ? 1 : 1) + spacing;
                    }else{
                         popUpWidth = popupItemWidth * (arrKeyPopup.length > 6 ? 6 : arrKeyPopup.length) + spacing;
                         popUpHeight = previewHeight * (arrKeyPopup.length > 6 ? 2 : 1) + spacing;
                    }

                    popupWindowPopup.setWidth(popUpWidth);
                    popupWindowPopup.setHeight(popUpHeight); //arrKeyPopup.length > 8 ? 2 :
                    popupWindowPopup.setContentView(linearPopUp);
                    popupWindowPopup.setClippingEnabled(false);

                    GradientDrawable gradientDrawable = (GradientDrawable) getResources().getDrawable(R.drawable.bg_popup_dark);
                    gradientDrawable.setColor(serviceKeyboard.getCurrentTheme().getPopupColor());
                    gradientDrawable.setStroke(1, serviceKeyboard.getCurrentTheme().getPopupStroke());
                    popupWindowPopup.setBackgroundDrawable(gradientDrawable);

                    int popUpLeftShift;
                    if (arrKeyPopup.length == 1 || arrKeyPopup.length == 2) {
                        popUpLeftShift = wd4;
                    } else {
                        popUpLeftShift = (int) (popupItemWidth * 1.5);
                    }
                    int locationX = location[0] + wd2
                            - popUpLeftShift
                            - padding/* popup layout padding */;
                    int locationRightX = locationX + popUpWidth;

                    int keyboardRightX = serviceKeyboard.getKeyboardRightX();
                    int keyboardLeftX = serviceKeyboard.getKeyboardLeftX();

                    int locationDifference = 0;
                    if (locationRightX > keyboardRightX) {
                        locationDifference = locationRightX - keyboardRightX;
                        if (locationDifference <= spacing) {
                            locationDifference += wd4;
                        }
                    }
                    int x,y;
                    if(Build.VERSION.SDK_INT==Build.VERSION_CODES.P){
                        y=location[1] - getHeight() * (arrKeyPopup.length > 6 ? 1 : 1);
                    }else{
                       y= location[1] - getHeight() * (arrKeyPopup.length > 6 ? 2 : 1);
                    }

                    popupWindowPopup.showAtLocation(this, Gravity.NO_GRAVITY,
                            locationX < keyboardLeftX ? (keyboardLeftX + wd4 - padding)
                                    : locationRightX > keyboardRightX ?
                                    locationX - locationDifference - wd4 + padding : locationX,
                            y/* - hd2*/ //arrKeyPopup.length > 8 ? 2 :
//								- 2 /* button gap as defined in KeyboardService */
                                    - spacing /* popup layout padding, top and bottom */);

                    arrTextPopUp[mainCharPosition].setBackgroundDrawable(bgPopup);
                    arrTextPopUp[mainCharPosition].setTextColor(serviceKeyboard.getCurrentTheme().
                            getPopupSelectedFontColor());
                    lastId = mainCharPosition;
                }
            }
        } catch (Exception e) {
            Log.e(TAG, "showPopup Exception : " + e.toString());
        }
    }

    public boolean onTouchPopUp(MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_MOVE:

                for (int i = 0; i < arrTextPopUp.length; i++) {

                    if (arrTextPopUp[i].isInsideTextView(event.getRawX(), event.getRawY())) {
                        if (i == lastId) {
                            break;
                        }
                        arrTextPopUp[i].setBackgroundDrawable(bgPopup);
                        arrTextPopUp[i].setTextColor(serviceKeyboard.getCurrentTheme().getPopupSelectedFontColor());
                        if (lastId != -1) {
                            arrTextPopUp[lastId].setBackgroundResource(R.color.transparent);
                            arrTextPopUp[lastId].setTextColor(serviceKeyboard.getCurrentTheme().getPopupFontColor());
                        }
                        lastId = i;
                        break;
                    }
                }

                break;
            case MotionEvent.ACTION_UP:

                if (lastId != -1) {
                    listenerHexagonTouch.onPopUpLetterSelection(arrTextPopUp[lastId].getText().charAt(0));
                    isPopUpClicked = true;
                }

                dismissPopup();
                onTouch(event);
                break;
        }

        return true;
    }

    private TextViewPopUp addLetter(char keyCode) {
        TextViewPopUp textView = new TextViewPopUp(getContext());
        LinearLayout.LayoutParams layoutParamsText = new LinearLayout.LayoutParams(popupItemWidth, previewHeight);
        textView.setAllCaps(isAllCaps && keyCode != 'ß');
        textView.setTextColor(serviceKeyboard.getCurrentTheme().getPopupFontColor());
        textView.setTypeface(TypeFace.robotoLight(getContext()));
        textView.setGravity(Gravity.CENTER);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_PX, popupTextSize);
        textView.setLayoutParams(layoutParamsText);
        textView.setText("" + keyCode);
        return textView;
    }

    public void dismissPreview() {
        if (popupWindowPreview != null && popupWindowPreview.isShowing()) {
            popupWindowPreview.dismiss();
        }
    }

    private void dismissPopup() {
        if (popupWindowPopup != null && popupWindowPopup.isShowing()) {
            popupWindowPopup.dismiss();
        }
    }

    public boolean isInsideHexagon(MotionEvent event) {
        boolean isInside = false;
        for (int i = 0, j = vertexX.length - 1; i < vertexX.length; j = i++) {
            if (((vertexY[i] > event.getY()) != (vertexY[j] > event.getY()))
                    && (event.getX() < (vertexX[j] - vertexX[i]) * (event.getY() - vertexY[i])
                    / (vertexY[j] - vertexY[i]) + vertexX[i])) {
                isInside = !isInside;
            }
        }
        return isInside;
    }

    public boolean isHoveredHexagon(MotionEvent event) {
        boolean isInside = false;
        try {
            isInside = false;
            float X = event.getX() - getX(), Y = event.getY() - getY();
            for (int i = 0, j = vertexX.length - 1; i < vertexX.length; j = i++) {
                if (((vertexY[i] > Y) != (vertexY[j] > Y))
                        && (X < (vertexX[j] - vertexX[i]) * (Y - vertexY[i])
                        / (vertexY[j] - vertexY[i]) + vertexX[i])) {
                    isInside = !isInside;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isInside;
    }

    private void initRepetitiveRunnable() {
        if (isRepetitiveEnabled && runnableRepeatClick == null) {
            runnableRepeatClick = new Runnable() {
                @Override
                public void run() {
                    performClick();
                    if (currentRepeatInterval > REPEAT_INTERVAL_MIN) {
                        currentRepeatInterval = currentRepeatInterval - REPEAT_INTERVAL_STEP;
                    }
                    postDelayed(runnableRepeatClick, currentRepeatInterval);
                }
            };
        }
    }

    public void setPopupChars(char[] popupChars) {
        arrKeyPopup = popupChars;
    }

    public void setMainCharPosition(int mainCharPosition) {
        this.mainCharPosition = mainCharPosition;
    }

    public boolean isRepetitiveEnabled() {
        return isRepetitiveEnabled;
    }

    public void setRepetitiveEnabled(boolean repetitiveEnabled) {
        isRepetitiveEnabled = repetitiveEnabled;
        initRepetitiveRunnable();
    }

    public boolean isDoubleClickEnabled() {
        return isDoubleClickEnabled;
    }

    public void setDoubleClickEnabled(boolean doubleClickEnabled) {
        isDoubleClickEnabled = doubleClickEnabled;
    }

    public boolean isPreviewEnabled() {
        return isPreviewEnabled;
    }

    public void setPreviewEnabled(boolean previewEnabled) {
        isPreviewEnabled = previewEnabled;
    }

    public void setKeyCode(char keyCode) {
        this.keyCode = keyCode;
    }

    public char getKeyCode() {
        return keyCode;
    }

    public void setOnHexagonTouchListener(OnHexagonTouchListener hexagonTouchListener) {
        this.listenerHexagonTouch = hexagonTouchListener;
    }

    public int getShape() {
        return modeHexagon;
    }

    public void setIcon(int iconResId) {
        this.iconResId = iconResId;
        isRedrawView = true;
        invalidate();
    }
}
