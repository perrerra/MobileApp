package utils.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import model.Address;
import model.EventCat;

/**
 * Created by Pierre on 13/04/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "events.db";




    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldversion, int newversion){
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    private final static String SQL_CREATE_ENTRIES =
            Address.AddressEntry.SQL_CREATE_ENTRIES
            + EventCat.EventCatEntry.SQL_CREATE_ENTRIES;

    private final static String SQL_DELETE_ENTRIES =
            Address.AddressEntry.SQL_DELETE_ENTRIES
                    + EventCat.EventCatEntry.SQL_DELETE_ENTRIES;
}
