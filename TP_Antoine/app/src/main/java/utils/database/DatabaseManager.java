package utils.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import model.Address;
import model.base.EntityBase;

/**
 * Created by Pierre on 13/04/2017.
 */

public class DatabaseManager {

    private SQLiteDatabase db;
    private DatabaseHelper dbHelper;

    public DatabaseManager(Context context) {
        dbHelper = new DatabaseHelper(context);
    }

    public long insertAdressData(Address address){
        db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Address.AddressEntry.COLUMN_NAME_COUNTRY, address.getCountry());
        values.put(Address.AddressEntry.COLUMN_NAME_CITY, address.getCity());
        values.put(Address.AddressEntry.COLUMN_NAME_ADRESS, address.getAddress());
        values.put(Address.AddressEntry.COLUMN_NAME_LAT, address.getLat());
        values.put(Address.AddressEntry.COLUMN_NAME_LNG, address.getLng());

        return db.insert(Address.AddressEntry.TABLE_NAME, null, values);
    }



    public Address selectAdressById(long id){

        String[] projection = {
                Address.AddressEntry.COLUMN_NAME_COUNTRY,
                Address.AddressEntry.COLUMN_NAME_CITY,
                Address.AddressEntry.COLUMN_NAME_ADRESS,
                Address.AddressEntry.COLUMN_NAME_LAT,
                Address.AddressEntry.COLUMN_NAME_LNG
        };

        // Filter results WHERE clause
        String selection = EntityBase.EntityBaseEntry.COLUMN_NAME_ID + " = ?";
        String[] selectionArgs = {
                String.valueOf(id)
        };

        Cursor cursor = db.query(
                Address.AddressEntry.TABLE_NAME,
                projection,
                selection,
                selectionArgs,
                null,
                null,
                null
        );

        cursor.moveToNext();
        Address address = new Address(
                cursor.getString(cursor.getColumnIndexOrThrow(Address.AddressEntry.COLUMN_NAME_COUNTRY)),
                cursor.getString(cursor.getColumnIndexOrThrow(Address.AddressEntry.COLUMN_NAME_CITY)),
                cursor.getString(cursor.getColumnIndexOrThrow(Address.AddressEntry.COLUMN_NAME_ADRESS)),
                cursor.getDouble(cursor.getColumnIndexOrThrow(Address.AddressEntry.COLUMN_NAME_LAT)),
                cursor.getDouble(cursor.getColumnIndexOrThrow(Address.AddressEntry.COLUMN_NAME_LNG))
        );

        return address;
    }
    public List<Address> selectAllAdress(){

        String[] projection = {
                Address.AddressEntry.COLUMN_NAME_COUNTRY,
                Address.AddressEntry.COLUMN_NAME_CITY,
                Address.AddressEntry.COLUMN_NAME_ADRESS,
                Address.AddressEntry.COLUMN_NAME_LAT,
                Address.AddressEntry.COLUMN_NAME_LNG
        };

        Cursor cursor = db.query(
                Address.AddressEntry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null
        );
        List<Address> addresses = new ArrayList<>();
        while(cursor.moveToNext()){
            Address address = new Address(
                    cursor.getString(cursor.getColumnIndexOrThrow(Address.AddressEntry.COLUMN_NAME_COUNTRY)),
                    cursor.getString(cursor.getColumnIndexOrThrow(Address.AddressEntry.COLUMN_NAME_CITY)),
                    cursor.getString(cursor.getColumnIndexOrThrow(Address.AddressEntry.COLUMN_NAME_ADRESS)),
                    cursor.getDouble(cursor.getColumnIndexOrThrow(Address.AddressEntry.COLUMN_NAME_LAT)),
                    cursor.getDouble(cursor.getColumnIndexOrThrow(Address.AddressEntry.COLUMN_NAME_LNG))
            );
            addresses.add(address);
        }


        return addresses;
    }

    public void deleteAdress(long id){
        db = dbHelper.getWritableDatabase();
        // Filter results WHERE clause
        String selection = EntityBase.EntityBaseEntry.COLUMN_NAME_ID + " = ?";
        String[] selectionArgs = {
                String.valueOf(id)
        };
        db.delete(Address.AddressEntry.TABLE_NAME, selection, selectionArgs);
    }

    public void updateAddress(Address address){
        ContentValues values = new ContentValues();
        values.put(Address.AddressEntry.COLUMN_NAME_COUNTRY, address.getCountry());
        values.put(Address.AddressEntry.COLUMN_NAME_CITY, address.getCity());
        values.put(Address.AddressEntry.COLUMN_NAME_ADRESS, address.getAddress());
        values.put(Address.AddressEntry.COLUMN_NAME_LAT, address.getLat());
        values.put(Address.AddressEntry.COLUMN_NAME_LNG, address.getLng());

        // Filter results WHERE clause
        String selection = EntityBase.EntityBaseEntry.COLUMN_NAME_ID + " = ?";
        String[] selectionArgs = {
                String.valueOf(address.getId())
        };

        int count = db.update(
                Address.AddressEntry.TABLE_NAME,
                values,
                selection,
                selectionArgs
        );

    }

}
