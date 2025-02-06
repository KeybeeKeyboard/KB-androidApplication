package it.keybeeproject.keybee.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.Button;

import it.keybeeproject.keybee.R;
import it.keybeeproject.keybee.utility.TypeFace;

public class ButtonCustom extends Button {

	private static final String TAG = ButtonCustom.class.getSimpleName();

	public ButtonCustom(Context context) {
		super(context);
	}

	public ButtonCustom(Context context, AttributeSet attrs) {
		super(context, attrs);
		setCustomFont(context, attrs);
	}

	public ButtonCustom(Context context, AttributeSet attrs, int defStyle) {
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