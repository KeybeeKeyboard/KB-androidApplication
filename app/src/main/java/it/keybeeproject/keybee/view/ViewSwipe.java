package it.keybeeproject.keybee.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by c161 on 13/08/16.
 */
public class ViewSwipe extends View {

	private static final String TAG = ViewSwipe.class.getSimpleName();

	public ViewSwipe(Context context) {
		super(context);
	}

	public ViewSwipe(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public ViewSwipe(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		return false;
	}
}
