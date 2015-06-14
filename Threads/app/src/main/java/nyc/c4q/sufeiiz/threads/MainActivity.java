package nyc.c4q.sufeiiz.threads;

import android.os.CountDownTimer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
    EditText editText;
    Button submit;
    TextView answer;
    int num, guess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeViews();
        num = RandomNum.generateNum();

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guess = Integer.valueOf(editText.getText().toString());
                if (guess == num)
                    answer.setText("Congratulations! You guessed my number.");
                else if (guess > 10 || guess < 1)
                    answer.setText("Please guess a number between 1 and 10.");
                else
                    answer.setText("Sorry, that is not the correct number. Try again.");
            }
        });

        new CountDownTimer(5000, 1000) {

            public void onTick(long millisUntilFinished) {
                answer.setText("seconds remaining: " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                answer.setText("done!");
                submit.setVisibility(View.INVISIBLE);
            }
        }.start();
    }

    public void initializeViews() {
        editText = (EditText) findViewById(R.id.editText);
        submit = (Button) findViewById(R.id.submit);
        answer = (TextView) findViewById(R.id.submit);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
