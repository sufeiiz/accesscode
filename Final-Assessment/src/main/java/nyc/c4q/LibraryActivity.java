package nyc.c4q;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class LibraryActivity extends Activity {
    public EditText inputParameter;
    private TextView display;
    private List<Books> queryBooks;
    private List<Members> queryMembers;
    private BooksSQLiteHelper bhelper;
    private MembersSQLiteHelper mhelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        inputParameter = (EditText) findViewById(R.id.input_parameter);
        display = (TextView) findViewById(R.id.text_display);
        bhelper = BooksSQLiteHelper.getInstance(LibraryActivity.this);
        mhelper = MembersSQLiteHelper.getInstance(LibraryActivity.this);

        // Load Books to Database
        new AsyncTask<Void, Void, List<Books>>(){
            @Override
            protected List<Books> doInBackground(Void[] params){
                List<Books> booklist = new ArrayList<>();

                try {
                    JSONArray books = new JSONArray(loadJson("books"));

                    for (int i = 0; i < books.length(); i++) {
                        JSONObject book = books.getJSONObject(i);
                        int id = book.getInt("id");
                        String title = book.getString("title");
                        String author = book.getString("author");
                        String isbn = book.getString("isbn");
                        String isbn13 = book.getString("isbn13");
                        String publisher = book.getString("publisher");
                        int publish_year = book.getInt("publishyear");

                        if (book.has("checkedoutby")) {
                            boolean checkedout = book.getBoolean("checkedout");
                            int checkedoutby = book.getInt("checkedoutby");
                            int checkedoutdateyear = book.getInt("checkoutdateyear");
                            int checkedoutdatemonth = book.getInt("checkoutdatemonth");
                            int checkedoutdateday = book.getInt("checkoutdateday");
                            int duedateyear = book.getInt("duedateyear");
                            int duedatemonth = book.getInt("duedatemonth");
                            int duedateday = book.getInt("duedateday");

                            booklist.add(new Books(id, title, author, isbn, isbn13, publisher, publish_year,
                                    checkedout, checkedoutby, checkedoutdateyear, checkedoutdatemonth, checkedoutdateday,
                                    duedateyear, duedatemonth, duedateday));
                        } else
                            booklist.add(new Books(id, title, author, isbn, isbn13, publisher, publish_year, false));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                bhelper.insertData(booklist);
                return booklist;
            }
        }.execute();

        // Load Members to Database
        new AsyncTask<Void, Void, List<Members>>(){
            @Override
            protected List<Members> doInBackground(Void[] params){
                List<Members> memberlist = new ArrayList<>();

                try {
                    JSONArray members = new JSONArray(loadJson("member"));

                    for (int i = 0; i < members.length(); i++) {
                        JSONObject member = members.getJSONObject(i);
                        int id = member.getInt("id");
                        String name = member.getString("name");
                        int dob_month = member.getInt("dob_month");
                        int dob_day = member.getInt("dob_day");
                        int dob_year = member.getInt("dob_year");
                        String city = member.getString("city");
                        String state = member.getString("state");

                        memberlist.add(new Members(id, name, dob_month, dob_day, dob_year, city, state));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                mhelper.insertData(memberlist);
                return memberlist;
            }
        }.execute();
    }

    public void checkOut(int memberId, int bookId) {
        //      This method is called when the member with the given ID checks
        //      out the book with the given ID. Update the system accordingly.
        //      The due date for the book is two weeks from today.
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        cal.set(Calendar.DAY_OF_YEAR, cal.get(Calendar.DAY_OF_YEAR) + 14);
        queryBooks = bhelper.loadData("id = ?", new String[]{String.valueOf(bookId)});

        if (queryBooks != null) {
            Books book = queryBooks.get(0);

            bhelper.insertRow(new Books(book.getId(), book.getTitle(), book.getAuthor(), book.getIsbn(), book.getIsbn13(),
                    book.getPublisher(), book.getPublishyear(), true, memberId, year, month, day,
                    cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH)));
        }
    }

    public boolean checkIn(int memberId, int bookId) {
        //      This method is called when the member with the given ID returns
        //      the book with the given ID. Update the system accordingly. If
        //      the member is returning the book on time, return true. If it's
        //      late, return false.
        Calendar today = Calendar.getInstance();
        Calendar duedate = Calendar.getInstance();
        boolean isLate = false;

        queryBooks = bhelper.loadData("id = ?", new String[]{String.valueOf(bookId)});

        if (queryBooks.size() != 0) {
            Books book = queryBooks.get(0);
            duedate.set(book.getDuedateyear(), book.getDuedatemonth(), book.getDuedateday());

            if (today.getTimeInMillis() > duedate.getTimeInMillis())
                isLate = true;

            bhelper.insertRow(new Books(book.getId(), book.getTitle(), book.getAuthor(), book.getIsbn(), book.getIsbn13(),
                    book.getPublisher(), book.getPublishyear(), false, 0, 0, 0, 0, 0, 0, 0));
        }

        return isLate;
    }

    public void button_getMember_onClick(View view) {
        String name = inputParameter.getText().toString();

        // Display member information for the member with the given name.
        queryMembers = mhelper.loadData("name = ?", new String[]{name});

        if (queryMembers.size() != 0) {
            Members member = queryMembers.get(0);

            display.setText("id: " + member.getId() + "\n" +
                    "name: " + member.getName() + "\n" +
                    "dob: " + member.getDob_month() + "/" + member.getDob_day() + "/" + member.getDob_year() + "\n" +
                    "location: " + member.getCity() + ", " + member.getState()
            );
        }
    }

    public void button_getBook_onClick(View view) {
        String isbn = inputParameter.getText().toString();

        // Display book information for the book with the given ISBN.
        queryBooks = bhelper.loadData("isbn = ?", new String[]{isbn});

        if (queryBooks.size() != 0) {
            Books book = queryBooks.get(0);

            display.setText("id: " + book.getId() + "\n" +
                            "title: " + book.getTitle() + "\n" +
                            "author: " + book.getAuthor() + "\n" +
                            "isbn: " + book.getIsbn() + "\n" +
                            "ibsn13: " + book.getIsbn13() + "\n" +
                            "publisher: " + book.getPublisher() + "\n" +
                            "publication year: " + book.getPublishyear()
            );
        }
    }

    public void button_getCheckedOut_onClick(View view) {
        String name = inputParameter.getText().toString();

        //      Display a list of books that the member with the given name
        //      currently has checked out, ordered by due date, with the
        //      earliest due first.
        queryMembers = mhelper.loadData("name = ?", new String[]{name});

        if (queryMembers.size() != 0) {
            Members member = queryMembers.get(0);
            queryBooks = bhelper.loadData("checkedoutby = ?", new String[]{String.valueOf(member.getId())});

            if (queryBooks.size() != 0) {
                List<String> checkedout_books = new ArrayList<>();
                for (Books book : queryBooks) {
                    checkedout_books.add("-----" + "\n" +
                            "title: " + book.getTitle() + "\n" +
                            "author: " + book.getAuthor() + "\n" +
                            "checkout date: " + book.getCheckedoutdatemonth() + "/" + book.getCheckedoutdateday() + "/" + book.getCheckedoutdateyear() + "\n" +
                            "due date: " + book.getDuedatemonth() + "/" + book.getDuedateday() + "/" + book.getDuedateyear() + "\n"
                    );
                }

                String list = "";

                for (String s : checkedout_books) {
                    list += s;
                }

                display.setText("name: " + member.getId() + "\n" + list);
            }
        }
    }

    public String loadJson(String file) {
        String json = null;

        if (file.equals("books")) {
            try {
                InputStream is = this.getAssets().open("books.json");
                int size = is.available();
                byte[] buffer = new byte[size];
                is.read(buffer);
                is.close();
                json = new String(buffer, "UTF-8");
            } catch (IOException ex) {
                ex.printStackTrace();
                return null;
            }
        } else {
            try {
                InputStream is = this.getAssets().open("members.json");
                int size = is.available();
                byte[] buffer = new byte[size];
                is.read(buffer);
                is.close();
                json = new String(buffer, "UTF-8");
            } catch (IOException ex) {
                ex.printStackTrace();
                return null;
            }
        }

        return json;
    }
}
