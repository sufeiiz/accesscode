package nyc.c4q.sufeiiz.notifications;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by sufeizhao on 6/14/15.
 */
public class SecondActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    public static Intent createIntent(Context c) {
        return new Intent(c, SecondActivity.class);
    }
}
