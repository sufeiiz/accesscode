package com.example.accesscode.myphone;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by amyquispe on 4/30/15.
 */
public class EmailActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);
        final EditText emailSubject = (EditText) findViewById(R.id.email_subject);
        final EditText emailBody = (EditText) findViewById(R.id.email_body);
        Button mailButton = (Button) findViewById(R.id.mail_button);
        mailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String myEmailAddress = "sufeizhao@gmail.com"; /* put your email address here */
                String subject = emailSubject.getText().toString();
                String body = emailBody.getText().toString();

                /*
                    Use an implicit intent to open up the user's email program and send
                    and email with this subject and body to you.

                    http://developer.android.com/guide/components/intents-common.html#Email
                 */
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setType("*/*");
                intent.setData(Uri.parse("mailto:" + myEmailAddress));
                intent.putExtra(Intent.EXTRA_SUBJECT, subject);
                intent.putExtra(Intent.EXTRA_TEXT, body);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });
    }
}
