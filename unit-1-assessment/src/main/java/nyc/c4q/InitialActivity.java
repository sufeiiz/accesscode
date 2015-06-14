package nyc.c4q;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class InitialActivity extends Activity {

  public int counter = 0;
  public SharedPreferences preferences = null;
  public final static String TAG = "C4QTAG";
  public TextView tvCounter;

  public void loadState(){
    Log.d(TAG, "loadState()");
    counter = preferences.getInt("counter", 0);
    tvCounter.setText(preferences.getString("tv", tvCounter.getText().toString()));
    Log.d(TAG, "loadState(): counter=="+counter);
  }

  public void saveState(){
    Log.d(TAG, "saveState()");
    Log.d(TAG, "saveState(): counter=="+counter);
    SharedPreferences.Editor editor = preferences.edit();
    editor.putInt("counter", counter);
    editor.putString("tv", tvCounter.getText().toString());
    editor.commit();
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_initial);
    preferences = getPreferences(Context.MODE_PRIVATE);

      tvCounter = (TextView) findViewById(R.id.tvCounter);
      if (savedInstanceState != null) {
          tvCounter.setText(counter);
      }

      final Button buttonPlus = (Button) findViewById(R.id.buttonPlus);
      final Button buttonMinus = (Button) findViewById(R.id.buttonMinus);
      final Button buttonTileActivity = (Button) findViewById(R.id.buttonTileActivity);
      final Button buttonEmpty = (Button) findViewById(R.id.buttonEmpty);

      buttonPlus.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              counter = Integer.parseInt(tvCounter.getText().toString()) + 1;
              tvCounter.setText(String.valueOf(counter));
              saveState();
          }
      });
      buttonMinus.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              counter = Integer.parseInt(tvCounter.getText().toString()) - 1;
              tvCounter.setText(String.valueOf(counter));
              saveState();
          }
      });
      buttonTileActivity.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Intent intent = new Intent(getApplicationContext(), TileActivity.class);
              startActivity(intent);
              saveState();
          }
      });

      loadState();
  }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("tvCounter", tvCounter.getText().toString());
        outState.putInt("count", counter);
    }
}
