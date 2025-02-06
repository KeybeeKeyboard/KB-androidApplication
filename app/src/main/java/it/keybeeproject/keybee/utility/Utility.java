package it.keybeeproject.keybee.utility;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import androidx.appcompat.app.AlertDialog;
import android.util.DisplayMetrics;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by c161 on 21/07/16.
 */
public class Utility {

	private static final String TAG = Utility.class.getSimpleName();

	public static int dpToPx(int dp) {
		return Math.round(dp * Resources.getSystem().getDisplayMetrics().density);
	}

	public static void changeLanguage(Context context, String language) {
		Resources resources = context.getResources();
		DisplayMetrics displayMetrics = resources.getDisplayMetrics();
		Configuration configuration = resources.getConfiguration();
		configuration.locale = new Locale(language.toLowerCase());
		resources.updateConfiguration(configuration, displayMetrics);
	}

	public static void openLinkInBrowser(Context context, String url) {
		context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
	}

	public static String getStringDate(Date date) {
		String dateString = null;
		try {
			dateString = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(date);
		} catch (Exception e) {
			Log.e(TAG, "getStringDate Exception:" + e.toString());
		}
		return dateString;
	}

	/**
	 * Common dialog to show for alerts.
	 *
	 * @param context
	 * @param title
	 * @param message
	 * @return
	 */
	public static AlertDialog alert(Context context, String title, String message) {
		AlertDialog.Builder builder = new AlertDialog.Builder(context);
		if (title != null) {
			builder.setTitle(title);
		}
		if (message != null) {
			builder.setMessage(message);
		}
		AlertDialog dialog = builder.setPositiveButton("OK", null).create();
		dialog.show();
		return dialog;
	}
}
