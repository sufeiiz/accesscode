package sufeiiz.c4q.nyc.fragments;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends ActionBarActivity {

    FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // dynamic fragment
        fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        FragmentExample fragment = new FragmentExample();
        ft.add(R.id.fragment_container, fragment);

//        ft.remove(fragment);
//        ft.replace(R.id.fragment_container, fragment);
//        ft.addToBackStack(null); //keeps old fragment around after replacing for reuse

        ft.commit(); // nothing is visible until commit is called

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        fm.popBackStack(); // restores previous
        fm.findFragmentById(R.id.fragment_container);

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
