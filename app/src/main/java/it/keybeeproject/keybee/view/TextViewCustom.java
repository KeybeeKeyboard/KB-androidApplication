package it.keybeeproject.keybee.view;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

import it.keybeeproject.keybee.R;
import it.keybeeproject.keybee.utility.TypeFace;

public class TextViewCustom extends androidx.appcompat.widget.AppCompatTextView {

	private static final String TAG = TextViewCustom.class.getSimpleName();

	private int right, bottom;
	private int[] location = new int[2];
	private boolean isPortrait;

	public TextViewCustom(Context context) {
		super(context);
	}

	public TextViewCustom(Context context, AttributeSet attrs) {
		super(context, attrs);
		setCustomFont(context, attrs);
	}

	public TextViewCustom(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		setCustomFont(context, attrs);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		right = getWidth();
		bottom = getHeight();
		isPortrait = getResources().getConfiguration().screenWidthDp < getResources().getConfiguration().screenHeightDp;
	}

	private void setCustomFont(Context context, AttributeSet attrs) {
		try {
			TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomFont);
			String customFont = typedArray.getString(R.styleable.CustomFont_custom_font);
			if (customFont != null && customFont.length() > 0) {
				setTypeface(TypeFace.getTypeface(context, customFont));
			}
			typedArray.recycle();
		} catch (Exception e) {
			Log.e(TAG, "setCustomFont Exception : " + e.toString());
		}
	}

	@Override
	protected void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		isPortrait = newConfig.screenWidthDp < newConfig.screenHeightDp;
	}

	public boolean isHoveredTextView(MotionEvent event) {
		getLocationInWindow(location);
		float X = event.getX() - location[0], Y = event.getY() - location[1];
		if (isPortrait) {
			return X > 0 && X < right && Y > 0 && Y < bottom;
		} else {
			return X > 0 && X < right && event.getY() > 0 && event.getY() < bottom;
		}
	}
}