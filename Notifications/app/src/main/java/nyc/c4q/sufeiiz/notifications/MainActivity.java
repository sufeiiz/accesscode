package nyc.c4q.sufeiiz.notifications;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;


public class MainActivity extends ActionBarActivity {

    TextView text;
    Button start;
    final int NOTIFICATION_ID = 1234;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = (TextView) findViewById(R.id.text);
        start = (Button) findViewById(R.id.start);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startDelay();
            }
        });
    }

    public void startDelay() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                showNotification();
            }
        }, 5000);
    }

    private void showNotification() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");
        updateNotification("The time is...", dateFormat.format(new Date()));
    }

    private void updateNotification(String text, String contentText) {
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setContentTitle(text);
        builder.setContentText(contentText);
        builder.setSmallIcon(R.drawable.ic_stat_action_accessibility);

        Intent intent = SecondActivity.createIntent(this);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pendingIntent);
        builder.setAutoCancel(true);

        // add large iamge
        NotificationCompat.BigPictureStyle style = new NotificationCompat.BigPictureStyle();
        Bitmap image;
        style.bigPicture(image);
        builder.setStyle(style);

        // Gmail style
        NotificationCompat.InboxStyle style2 = new NotificationCompat.InboxStyle();
        style2.addLine("LIne1");
        style2.addLine("Line2");
        style2.setSummaryText("Summary");

        // lock screen hide content LOLLOPOP+
        builder.setVisibility(Notification.VISIBILITY_PRIVATE);

        Notification notification = builder.build();
        manager.notify(NOTIFICATION_ID, notification);
    }
}
