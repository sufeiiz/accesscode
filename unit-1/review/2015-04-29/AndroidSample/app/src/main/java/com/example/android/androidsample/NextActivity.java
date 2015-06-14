package com.example.android.androidsample;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;


public class NextActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // not sure why this didn't work in class, but it works now...hmm
        TextView view = new TextView(this);
        view.setText("The next activity");
        setContentView(view);
    }
}
