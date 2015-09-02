package nyc.c4q;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sufeizhao on 8/30/15.
 */
public class BooksSQLiteHelper extends SQLiteOpenHelper {

    private static final String DB_books = "books";
    private static final int VERSION = 3;

    public BooksSQLiteHelper(Context context) {
        super(context, DB_books, null, VERSION);
    }

    private static BooksSQLiteHelper INSTANCE;

    public static synchronized BooksSQLiteHelper getInstance(Context context) {
        if (INSTANCE == null)
            INSTANCE = new BooksSQLiteHelper(context.getApplicationContext());

        return INSTANCE;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    public static abstract class DataEntry implements BaseColumns {
        public static final String TABLE_NAME = "Books";
        public static final String COLUMN_ID = "id";
        public static final String COLUMN_TITLE = "title";
        public static final String COLUMN_AUTHOR = "author";
        public static final String COLUMN_ISBN = "isbn";
        public static final String COLUMN_ISBN13 = "isbn13";
        public static final String COLUMN_PUBLISHER = "publisher";
        public static final String COLUMN_PUBLISH_YEAR = "publish_year";
        public static final String COLUMN_CHECKEDOUT = "checkedout";
        public static final String COLUMN_CHECKEDOUTBY = "checkedoutby";
        public static final String COLUMN_CHECKOUT_DATEYEAR = "checkoutdateyear";
        public static final String COLUMN_CHECKOUT_DATEMONTH = "checkoutdatemonth";
        public static final String COLUMN_CHECKOUT_DATEDAY = "checkoutdateday";
        public static final String COLUMN_DUEDATE_YEAR = "duedateyear";
        public static final String COLUMN_DUEDATE_MONTH = "duedatemonth";
        public static final String COLUMN_DUEDATE_DAY = "duedateday";
    }

    private static final String SQL_CREATE_ENTRIES = "CREATE TABLE " +
            DataEntry.TABLE_NAME + " (" +
            DataEntry.COLUMN_ID + " INTEGER," +
            DataEntry.COLUMN_TITLE + " TEXT," +
            DataEntry.COLUMN_AUTHOR + " TEXT," +
            DataEntry.COLUMN_ISBN + " TEXT," +
            DataEntry.COLUMN_ISBN13 + " TEXT," +
            DataEntry.COLUMN_PUBLISHER + " TEXT," +
            DataEntry.COLUMN_PUBLISH_YEAR + " INTEGER," +
            DataEntry.COLUMN_CHECKEDOUT + " BOOLEAN," +
            DataEntry.COLUMN_CHECKEDOUTBY + " INTEGER," +
            DataEntry.COLUMN_CHECKOUT_DATEYEAR + " INTEGER," +
            DataEntry.COLUMN_CHECKOUT_DATEMONTH + " INTEGER," +
            DataEntry.COLUMN_CHECKOUT_DATEDAY + " INTEGER," +
            DataEntry.COLUMN_DUEDATE_YEAR + " INTEGER," +
            DataEntry.COLUMN_DUEDATE_MONTH + " INTEGER," +
            DataEntry.COLUMN_DUEDATE_DAY + " INTEGER" + ")";

    private static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + DataEntry.TABLE_NAME;

    public void insertData(List<Books> books) {
        SQLiteDatabase db = getWritableDatabase();
        db.delete(DataEntry.TABLE_NAME, null, null);

        for (Books book : books) {
            insertRow(book);
        }
    }

    public void insertRow(Books book) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(DataEntry.COLUMN_ID, book.getId());
        values.put(DataEntry.COLUMN_TITLE, book.getTitle());
        values.put(DataEntry.COLUMN_AUTHOR, book.getAuthor());
        values.put(DataEntry.COLUMN_ISBN, book.getIsbn());
        values.put(DataEntry.COLUMN_ISBN13, book.getIsbn13());
        values.put(DataEntry.COLUMN_PUBLISHER, book.getPublisher());
        values.put(DataEntry.COLUMN_PUBLISH_YEAR, book.getPublishyear());
        values.put(DataEntry.COLUMN_CHECKEDOUT, book.isCheckedout());
        values.put(DataEntry.COLUMN_CHECKEDOUTBY, book.getCheckedoutby());
        values.put(DataEntry.COLUMN_CHECKOUT_DATEYEAR, book.getCheckedoutdateyear());
        values.put(DataEntry.COLUMN_CHECKOUT_DATEMONTH, book.getCheckedoutdatemonth());
        values.put(DataEntry.COLUMN_CHECKOUT_DATEDAY, book.getCheckedoutdateday());
        values.put(DataEntry.COLUMN_DUEDATE_YEAR, book.getDuedateyear());
        values.put(DataEntry.COLUMN_DUEDATE_MONTH, book.getDuedatemonth());
        values.put(DataEntry.COLUMN_DUEDATE_DAY, book.getDuedateday());

        db.insertOrThrow(DataEntry.TABLE_NAME, null, values);
    }

    public List<Books> loadData(String find, String[] what) {
        SQLiteDatabase db = getWritableDatabase();
        String[] projection = {
                DataEntry.COLUMN_ID,
                DataEntry.COLUMN_TITLE,
                DataEntry.COLUMN_AUTHOR,
                DataEntry.COLUMN_ISBN,
                DataEntry.COLUMN_ISBN13,
                DataEntry.COLUMN_PUBLISHER,
                DataEntry.COLUMN_PUBLISH_YEAR,
                DataEntry.COLUMN_CHECKEDOUT,
                DataEntry.COLUMN_CHECKEDOUTBY,
                DataEntry.COLUMN_CHECKOUT_DATEYEAR,
                DataEntry.COLUMN_CHECKOUT_DATEMONTH,
                DataEntry.COLUMN_CHECKOUT_DATEDAY,
                DataEntry.COLUMN_DUEDATE_YEAR,
                DataEntry.COLUMN_DUEDATE_MONTH,
                DataEntry.COLUMN_DUEDATE_DAY,
        };

        List<Books> books = new ArrayList<>();

        Cursor cursor = db.query(
                DataEntry.TABLE_NAME, projection, find, what, null, null, DataEntry.COLUMN_PUBLISHER);

        while (cursor.moveToNext()) {
            if (cursor.getInt(cursor.getColumnIndex(DataEntry.COLUMN_CHECKEDOUT)) > 0) {
                books.add(new Books(cursor.getInt(cursor.getColumnIndex(DataEntry.COLUMN_ID)),
                        cursor.getString(cursor.getColumnIndex(DataEntry.COLUMN_TITLE)),
                        cursor.getString(cursor.getColumnIndex(DataEntry.COLUMN_AUTHOR)),
                        cursor.getString(cursor.getColumnIndex(DataEntry.COLUMN_ISBN)),
                        cursor.getString(cursor.getColumnIndex(DataEntry.COLUMN_ISBN13)),
                        cursor.getString(cursor.getColumnIndex(DataEntry.COLUMN_PUBLISHER)),
                        cursor.getInt(cursor.getColumnIndex(DataEntry.COLUMN_PUBLISH_YEAR)),
                        cursor.getInt(cursor.getColumnIndex(DataEntry.COLUMN_CHECKEDOUT)) > 0,
                        cursor.getInt(cursor.getColumnIndex(DataEntry.COLUMN_CHECKEDOUTBY)),
                        cursor.getInt(cursor.getColumnIndex(DataEntry.COLUMN_CHECKOUT_DATEYEAR)),
                        cursor.getInt(cursor.getColumnIndex(DataEntry.COLUMN_CHECKOUT_DATEMONTH)),
                        cursor.getInt(cursor.getColumnIndex(DataEntry.COLUMN_CHECKOUT_DATEDAY)),
                        cursor.getInt(cursor.getColumnIndex(DataEntry.COLUMN_DUEDATE_YEAR)),
                        cursor.getInt(cursor.getColumnIndex(DataEntry.COLUMN_DUEDATE_MONTH)),
                        cursor.getInt(cursor.getColumnIndex(DataEntry.COLUMN_DUEDATE_DAY))));
            } else {
                books.add(new Books(cursor.getInt(cursor.getColumnIndex(DataEntry.COLUMN_ID)),
                        cursor.getString(cursor.getColumnIndex(DataEntry.COLUMN_TITLE)),
                        cursor.getString(cursor.getColumnIndex(DataEntry.COLUMN_AUTHOR)),
                        cursor.getString(cursor.getColumnIndex(DataEntry.COLUMN_ISBN)),
                        cursor.getString(cursor.getColumnIndex(DataEntry.COLUMN_ISBN13)),
                        cursor.getString(cursor.getColumnIndex(DataEntry.COLUMN_PUBLISHER)),
                        cursor.getInt(cursor.getColumnIndex(DataEntry.COLUMN_PUBLISH_YEAR)),
                        cursor.getInt(cursor.getColumnIndex(DataEntry.COLUMN_CHECKEDOUT)) > 0 ));
            }
        }

        cursor.close();
        return books;
    }
}
