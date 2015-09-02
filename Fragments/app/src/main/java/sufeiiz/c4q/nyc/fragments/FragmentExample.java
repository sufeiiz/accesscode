package sufeiiz.c4q.nyc.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by sufeizhao on 7/18/15.
 */
public class FragmentExample extends Fragment {

    int count = 0;
    Button button;
    TextView tw;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.example_fragment, container, false);

        tw = (TextView) view.findViewById(R.id.tw);
        button = (Button) view.findViewById(R.id.countButton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                tw.setText(Integer.toString(count));
            }
        });

        return view;
    }


}
