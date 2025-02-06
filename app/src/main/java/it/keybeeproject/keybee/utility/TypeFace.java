package it.keybeeproject.keybee.utility;

import android.content.Context;
import android.util.Log;

import java.util.Hashtable;

import it.keybeeproject.keybee.R;

/**
 * Created by c161 on 28/07/16.
 */
public class TypeFace {

	private static final String TAG = TypeFace.class.getSimpleName();

	private static Hashtable<String, android.graphics.Typeface> hashTypeface = new Hashtable<>();

	public static android.graphics.Typeface getTypeface(Context context, String fontAssetPath) {
	    try {
		    android.graphics.Typeface typeface = hashTypeface.get(fontAssetPath);

		    if (typeface == null) {
			    typeface = android.graphics.Typeface.createFromAsset(context.getAssets(), fontAssetPath);
			    hashTypeface.put(fontAssetPath, typeface);
		    }

		    return typeface;
	    } catch (Exception e) {
		    Log.e(TAG, "getTypeface Exception : " + e.toString());
		    return null;
	    }
	}

	public static android.graphics.Typeface dosisLight(Context context) {
		return getTypeface(context, context.getString(R.string.font_dosis_light));
	}

	public static android.graphics.Typeface dosisRegular(Context context) {
	    return getTypeface(context, context.getString(R.string.font_dosis_regular));
	}

	public static android.graphics.Typeface dosisMedium(Context context) {
	    return getTypeface(context, context.getString(R.string.font_dosis_medium));
	}

	public static android.graphics.Typeface dosisSemiBold(Context context) {
	    return getTypeface(context, context.getString(R.string.font_dosis_semi_bold));
	}

	public static android.graphics.Typeface dosisBold(Context context) {
	    return getTypeface(context, context.getString(R.string.font_dosis_bold));
	}

	public static android.graphics.Typeface robotoLight(Context context) {
	    return getTypeface(context, context.getString(R.string.font_roboto_light));
	}

	public static android.graphics.Typeface robotoRegular(Context context) {
		return getTypeface(context, context.getString(R.string.font_roboto_regular));
	}
}
