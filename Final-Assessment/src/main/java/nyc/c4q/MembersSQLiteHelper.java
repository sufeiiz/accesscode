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
public class MembersSQLiteHelper extends SQLiteOpenHelper {

    private static final String DB_members = "members";
    private static final int VERSION = 1;

    public MembersSQLiteHelper(Context context) {
        super(context, DB_members, null, VERSION);
    }

    private static MembersSQLiteHelper INSTANCE;

    public static synchronized MembersSQLiteHelper getInstance(Context context) {
        if (INSTANCE == null)
            INSTANCE = new MembersSQLiteHelper(context.getApplicationContext());

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
        public static final String TABLE_NAME = "Members";
        public static final String COLUMN_ID = "id";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_DOB_MONTH = "dob_month";
        public static final String COLUMN_DOB_DAY = "dob_day";
        public static final String COLUMN_DOB_YEAR = "dob_year";
        public static final String COLUMN_CITY = "city";
        public static final String COLUMN_STATE = "state";
    }

    private static final String SQL_CREATE_ENTRIES = "CREATE TABLE " +
            DataEntry.TABLE_NAME + " (" +
            DataEntry.COLUMN_ID + " INTEGER," +
            DataEntry.COLUMN_NAME + " TEXT," +
            DataEntry.COLUMN_DOB_MONTH + " INTEGER," +
            DataEntry.COLUMN_DOB_DAY + " INTEGER," +
            DataEntry.COLUMN_DOB_YEAR + " INTEGER," +
            DataEntry.COLUMN_CITY + " TEXT," +
            DataEntry.COLUMN_STATE + " TEXT" + ")";

    private static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + DataEntry.TABLE_NAME;

    public void insertData(List<Members> members) {
        SQLiteDatabase db = getWritableDatabase();
        db.delete(DataEntry.TABLE_NAME, null, null);

        for (Members member : members) {
            insertRow(member);
        }
    }

    public void insertRow(Members member) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(DataEntry.COLUMN_ID, member.getId());
        values.put(DataEntry.COLUMN_NAME, member.getName());
        values.put(DataEntry.COLUMN_DOB_MONTH, member.getDob_month());
        values.put(DataEntry.COLUMN_DOB_DAY, member.getDob_day());
        values.put(DataEntry.COLUMN_DOB_YEAR, member.getDob_year());
        values.put(DataEntry.COLUMN_CITY, member.getCity());
        values.put(DataEntry.COLUMN_STATE, member.getState());

        db.insertOrThrow(DataEntry.TABLE_NAME, null, values);
    }

    public List<Members> loadData(String find, String[] what) {
        SQLiteDatabase db = getWritableDatabase();
        String[] projection = {
                DataEntry.COLUMN_ID,
                DataEntry.COLUMN_NAME,
                DataEntry.COLUMN_DOB_MONTH,
                DataEntry.COLUMN_DOB_DAY,
                DataEntry.COLUMN_DOB_YEAR,
                DataEntry.COLUMN_CITY,
                DataEntry.COLUMN_STATE
        };

        List<Members> members = new ArrayList<>();

        Cursor cursor = db.query(
                DataEntry.TABLE_NAME, projection, find, what, null, null, DataEntry.COLUMN_CITY);

        while (cursor.moveToNext()) {
            members.add(new Members(cursor.getInt(cursor.getColumnIndex(DataEntry.COLUMN_ID)),
                    cursor.getString(cursor.getColumnIndex(DataEntry.COLUMN_NAME)),
                    cursor.getInt(cursor.getColumnIndex(DataEntry.COLUMN_DOB_MONTH)),
                    cursor.getInt(cursor.getColumnIndex(DataEntry.COLUMN_DOB_DAY)),
                    cursor.getInt(cursor.getColumnIndex(DataEntry.COLUMN_DOB_YEAR)),
                    cursor.getString(cursor.getColumnIndex(DataEntry.COLUMN_CITY)),
                    cursor.getString(cursor.getColumnIndex(DataEntry.COLUMN_STATE))));
        }

        cursor.close();
        return members;
    }
}
