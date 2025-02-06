package it.keybeeproject.keybee.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.CheckedTextView;

import it.keybeeproject.keybee.R;
import it.keybeeproject.keybee.utility.TypeFace;

public class CheckedTextViewCustom extends CheckedTextView {

	private static final String TAG = CheckedTextViewCustom.class.getSimpleName();

	public CheckedTextViewCustom(Context context) {
		super(context);
	}

	public CheckedTextViewCustom(Context context, AttributeSet attrs) {
		super(context, attrs);
		setCustomFont(context, attrs);
	}

	public CheckedTextViewCustom(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		setCustomFont(context, attrs);
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
}