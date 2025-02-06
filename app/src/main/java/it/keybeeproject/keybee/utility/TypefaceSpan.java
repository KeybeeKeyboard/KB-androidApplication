package it.keybeeproject.keybee.utility;

import android.content.Context;
import android.graphics.Paint;
import android.text.Spannable;
import android.text.TextPaint;
import android.graphics.Typeface;
import android.text.style.MetricAffectingSpan;
import android.util.LruCache;

/**
 * Style a {@link Spannable} with a custom {@link Typeface}.
 * 
 * @author Tristan Waddington
 */
public class TypefaceSpan extends MetricAffectingSpan {

	private static final String TAG = TypefaceSpan.class.getSimpleName();

    /** An <code>LruCache</code> for previously loaded typefaces. */
    private static LruCache<String, Typeface> sTypefaceCache = new LruCache<>(12);

    private Typeface mTypeface;

    /**
     * Load the {@link Typeface} and apply to a {@link Spannable}.
     */
    public TypefaceSpan(Context context, String typefacePath) {
        mTypeface = sTypefaceCache.get(typefacePath);

        if (mTypeface == null) {
            mTypeface = Typeface.createFromAsset(context.getApplicationContext().getAssets(), typefacePath);

            // Cache the loaded Typeface
            sTypefaceCache.put(typefacePath, mTypeface);
        }
    }

    @Override
    public void updateMeasureState(TextPaint p) {
        p.setTypeface(mTypeface);

        // Note: This flag is required for proper typeface rendering
        p.setFlags(p.getFlags() | Paint.SUBPIXEL_TEXT_FLAG);
    }

    @Override
    public void updateDrawState(TextPaint tp) {
        tp.setTypeface(mTypeface);

        // Note: This flag is required for proper typeface rendering
        tp.setFlags(tp.getFlags() | Paint.SUBPIXEL_TEXT_FLAG);
    }
}