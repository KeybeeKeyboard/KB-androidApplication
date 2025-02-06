package it.keybeeproject.keybee;

import android.app.Application;
import androidx.appcompat.app.AppCompatDelegate;
import com.onesignal.OneSignal;
import com.onesignal.debug.LogLevel;
import com.onesignal.Continue;
import it.keybeeproject.keybee.utility.PrefData;

public class KeybeeApplication extends Application {

	private static final String TAG = KeybeeApplication.class.getSimpleName();
	private static final String ONESIGNAL_APP_ID = "b077fe03-3379-4872-a089-0fbc948d6b30";

	@Override
	public void onCreate() {
		super.onCreate();

		AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);

		// Verbose Logging set to help debug issues, remove before releasing your app.
		OneSignal.getDebug().setLogLevel(LogLevel.VERBOSE);

		// OneSignal Initialization
		OneSignal.initWithContext(this, ONESIGNAL_APP_ID);

		// requestPermission will show the native Android notification permission prompt.
		// NOTE: It's recommended to use a OneSignal In-App Message to prompt instead.
		OneSignal.getNotifications().requestPermission(false, Continue.none());


		if (!PrefData.getBooleanPrefs(this, PrefData.KEY_IS_DOWNLOAD_EVENT_SENT_B)) {
			PrefData.setBooleanPrefs(this, PrefData.KEY_IS_DOWNLOAD_EVENT_SENT_B, true);
    	}
	}

}
