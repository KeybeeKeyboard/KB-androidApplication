package it.keybeeproject.keybee.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by c161 on 16/08/16.
 */
public class TextViewPopUp extends TextView {

	private static final String TAG = TextViewPopUp.class.getSimpleName();

	private int left, right, top;

	public TextViewPopUp(Context context) {
		super(context);
	}

	public TextViewPopUp(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public TextViewPopUp(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}

	@Override
	protected void onDraw(Canvas canvas) {

		int[] location = new int[2];
		getLocationOnScreen(location);
		left = location[0];
		right = left + getWidth();
		top = location[1] + getHeight();

		super.onDraw(canvas);
	}

	public boolean isInsideTextView(float x, float y) {
		return x > left && x < right && y > top;
	}
}
