package nyc.c4q;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by sufeizhao on 8/30/15.
 */
public class PaceCalculatorFragment extends Fragment {

    private EditText distance, time_min, time_sec, pace_min, pace_sec;
    private double input_distance, input_time_min, input_time_sec, input_pace_min, input_pace_sec;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pace_calculator, container, false);

        distance = (EditText) view.findViewById(R.id.input_distance);
        time_min = (EditText) view.findViewById(R.id.input_time_min);
        time_sec = (EditText) view.findViewById(R.id.input_time_sec);
        pace_min = (EditText) view.findViewById(R.id.input_pace_min);
        pace_sec = (EditText) view.findViewById(R.id.input_pace_sec);
        Button calculate = (Button) view.findViewById(R.id.button_calculate);

        calculate.setOnClickListener(calculateListener);

        return view;
    }

    View.OnClickListener calculateListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            boolean isDistanceFilled = !distance.getText().toString().equals("");
            boolean isTimeFilled = !time_min.getText().toString().equals("") && !time_sec.getText().toString().equals("");
            boolean isPaceFilled = !pace_min.getText().toString().equals("") && !pace_sec.getText().toString().equals("");
            Log.d("BOOLEANS__", "Distance = " + isDistanceFilled + ", time = " + isTimeFilled + ", pace = " + isPaceFilled);

            if (isDistanceFilled & isTimeFilled & !isPaceFilled) {
                try {
                    input_distance = Double.valueOf(distance.getText().toString());
                    input_time_min = Double.valueOf(time_min.getText().toString());
                    input_time_sec = Double.valueOf(time_sec.getText().toString());

                    double mins = (input_time_sec / 60) + input_time_min;
                    String pace = mins / input_distance + "";

                    if (pace.contains(".")) {
                        int index = pace.indexOf(".");
                        pace_min.setText(pace.substring(0, index));

                        String sec = "0" + pace.substring(index);
                        pace_sec.setText(Float.valueOf(sec) * 60 + "");
                    } else {
                        pace_min.setText(pace);
                        pace_sec.setText("00");
                    }
                } catch (Exception e) {
                    Log.d("FIND PACE___", "error in finding pace");
                }
            } else if (isDistanceFilled & !isTimeFilled & isPaceFilled) {
                try {
                    input_distance = Double.valueOf(distance.getText().toString());
                    input_pace_min = Double.valueOf(pace_min.getText().toString());
                    input_pace_sec = Double.valueOf(pace_sec.getText().toString());

                    double pace = (input_pace_sec / 60) + input_pace_min;
                    String mins = input_distance * pace + "";

                    if (mins.contains(".")) {
                        int index = mins.indexOf(".");
                        time_min.setText(mins.substring(0, index));

                        String sec = "0" + mins.substring(index);
                        time_sec.setText(Float.valueOf(sec) * 60 + "");
                    } else {
                        time_min.setText(mins);
                        time_sec.setText("00");
                    }
                } catch (Exception e) {
                    Log.d("FIND PACE___", "error in finding pace");
                }
            } else if (!isDistanceFilled & isTimeFilled & isPaceFilled) {
                try {
                    input_time_min = Double.valueOf(time_min.getText().toString());
                    input_time_sec = Double.valueOf(time_sec.getText().toString());
                    input_pace_min = Double.valueOf(pace_min.getText().toString());
                    input_pace_sec = Double.valueOf(pace_sec.getText().toString());

                    double pace = (input_pace_sec / 60) + input_pace_min;
                    double mins = (input_time_sec / 60) + input_time_min;
                    String miles = mins / pace + "";
                    distance.setText(miles);
                } catch (Exception e) {
                    Log.d("FIND PACE___", "error in finding pace");
                }
            }
        }
    };
}
