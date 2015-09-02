package sufeiiz.c4q.nyc.preferences;

import android.os.Bundle;
import android.preference.PreferenceActivity;

/**
 * Created by sufeizhao on 7/11/15.
 */
public class SettingsActivity extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
    }

}
