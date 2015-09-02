package nyc.c4q;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Comparator;


public class ListActivity extends Activity {

    private static final String PREF = "PREFERENCES";
    private static final String COLOR = "show_color";
    private static final String SORT = "first_last";
    public ListView list;
    private boolean first_last = false, show_color = false;
    private String name;
    private ArrayAdapter adapter;
    private Button name_sort, color;
    private SharedPreferences preferences;

    public static final Person[] PEOPLE = {
        new Person("Hannah",    "Abbott",          House.Hufflepuff),
        new Person("Katie",     "Bell",            House.Gryffindor),
        new Person("Susan",     "Bones",           House.Hufflepuff),
        new Person("Terry",     "Boot",            House.Ravenclaw),
        new Person("Lavender",  "Brown",           House.Gryffindor),
        new Person("Cho",       "Chang",           House.Ravenclaw),
        new Person("Michael",   "Corner",          House.Ravenclaw),
        new Person("Colin",     "Creevey",         House.Gryffindor),
        new Person("Marietta",  "Edgecombe",       House.Ravenclaw),
        new Person("Justin",    "Finch-Fletchley", House.Hufflepuff),
        new Person("Seamus",    "Finnigan",        House.Gryffindor),
        new Person("Anthony",   "Goldstein",       House.Ravenclaw),
        new Person("Hermione",  "Granger",         House.Gryffindor),
        new Person("Angelina",  "Johnson",         House.Gryffindor),
        new Person("Lee",       "Jordan",          House.Gryffindor),
        new Person("Neville",   "Longbottom",      House.Gryffindor),
        new Person("Luna",      "Lovegood",        House.Ravenclaw),
        new Person("Ernie",     "Macmillan",       House.Hufflepuff),
        new Person("Parvati",   "Patil",           House.Gryffindor),
        new Person("Padma",     "Patil",           House.Ravenclaw),
        new Person("Harry",     "Potter",          House.Gryffindor),
        new Person("Zacharias", "Smith",           House.Hufflepuff),
        new Person("Alicia",    "Spinnet",         House.Gryffindor),
        new Person("Dean",      "Thomas",          House.Gryffindor),
        new Person("Fred",      "Weasley",         House.Gryffindor),
        new Person("George",    "Weasley",         House.Gryffindor),
        new Person("Ginny",     "Weasley",         House.Gryffindor),
        new Person("Ron",       "Weasley",         House.Gryffindor)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        preferences = getSharedPreferences(PREF, Context.MODE_PRIVATE);
        show_color = preferences.getBoolean(COLOR, false);
        first_last = preferences.getBoolean(SORT, false);

        list = (ListView) findViewById(R.id.list);
        Arrays.sort(PEOPLE, new PersonComparator());
        adapter = new ArrayAdapter(this, R.layout.listitem_member, R.id.text_house, PEOPLE) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                TextView house_name = (TextView) view.findViewById(R.id.text_house);
                TextView person_name = (TextView) view.findViewById(R.id.text_name);

                if (first_last)
                    name = PEOPLE[position].getFirstName() + " " + PEOPLE[position].getLastName();
                else
                    name = PEOPLE[position].getLastName() + ", " + PEOPLE[position].getFirstName();
                person_name.setText(name);
                house_name.setText(PEOPLE[position].getHouse());

                if (show_color) {
                    switch (PEOPLE[position].getHouse()) {
                        case "Gryffindor":
                            view.setBackgroundColor(getResources().getColor(R.color.gryffindor_red));
                            break;
                        case "Hufflepuff":
                            view.setBackgroundColor(getResources().getColor(R.color.hufflepuff_yellow));
                            break;
                        case "Slytherin":
                            view.setBackgroundColor(getResources().getColor(R.color.slytherin_green));
                            break;
                        case "Ravenclaw":
                            view.setBackgroundColor(getResources().getColor(R.color.ravenclaw_blue));
                            break;
                    }
                }

                return view;
            }
        };
        list.setAdapter(adapter);

        name_sort = (Button) findViewById(R.id.button_name);
        name_sort.setOnClickListener(sortNameListener);

        color = (Button) findViewById(R.id.button_color);
        color.setOnClickListener(colorListener);
    }

    View.OnClickListener sortNameListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            first_last = !first_last;

            if (!first_last)
                name_sort.setText("Last, First");
            else
                name_sort.setText("First Last");

            Arrays.sort(PEOPLE, new PersonComparator());
            adapter.notifyDataSetChanged();
            preferences.edit().putBoolean(SORT, first_last).apply();
        }
    };

    View.OnClickListener colorListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            show_color = !show_color;

            if (!show_color)
                color.setText("Show Color");
            else
                color.setText("Hide Color");

            adapter.notifyDataSetChanged();
            preferences.edit().putBoolean(COLOR, show_color).apply();
        }
    };

    public class PersonComparator implements Comparator<Person> {
        @Override
        public int compare(Person one, Person two) {
            int result;

            if (first_last) {
                result = one.getFirstName().compareTo(two.getFirstName());
            } else {
                result = one.getLastName().compareTo(two.getLastName());
            }

            return result;
        }
    }
}
