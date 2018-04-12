package mobile.intranet.infocamere.it.pocappic.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import mobile.intranet.infocamere.it.pocappic.model.PrefUI;

/**
 * Created by LucaVise on 11/04/18.
 */

public class PrefUIRepo {

    private DBHelper dbHelper;

    public PrefUIRepo(Context context) {
        dbHelper = new DBHelper(context);
    }

    public int insert(PrefUI prefUI) {

        //Open connection to write data
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(prefUI.KEY_ID, prefUI.get_id());
        values.put(prefUI.KEY_orderUI, prefUI.getOrderUI());

        // Inserting Row
        long prefUI_id = db.insert(PrefUI.TABLE, null, values);
        db.close(); // Closing database connection

        return (int) prefUI_id;
    }

    public Cursor getPrefUIList() {
        //Open connection to read only
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery =  "SELECT * " +
                " FROM " + PrefUI.TABLE;

        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list

        PrefUI prefUI = new PrefUI();

        if (cursor.moveToFirst()) {
            do {
                prefUI.prefUI_id = cursor.getInt(cursor.getColumnIndex(PrefUI.KEY_ID));
                prefUI.orderUI = cursor.getString(cursor.getColumnIndex(PrefUI.KEY_orderUI));
                Log.i("PrefUI.KEY_ID", String.valueOf(prefUI.prefUI_id));
                Log.i("PrefUI.KEY_orderUI", prefUI.orderUI);
            } while (cursor.moveToNext());
        }

        if (cursor == null) {
            return null;
        }
        else if (!cursor.moveToFirst()) {
            cursor.close();
            return null;
        }

        return cursor;
    }

    public PrefUI getPrefUIById(int id) {
        Log.i("PREFUIREPO", "getPrefUIById");
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery =  "SELECT * " +
                "FROM " + PrefUI.TABLE
                + " WHERE " +
                PrefUI.KEY_ID + "=?";// It's a good practice to use parameter ?, instead of concatenate string

        PrefUI prefUI = new PrefUI();

        Cursor cursor = db.rawQuery(selectQuery, new String[] { String.valueOf(id) } );

        if (cursor.moveToFirst()) {
            do {
                Log.i("PrefUI.KEY_ID", PrefUI.KEY_ID);
                Log.i("PrefUI.KEY_orderUI", PrefUI.KEY_orderUI);
                prefUI.prefUI_id = cursor.getInt(cursor.getColumnIndex(PrefUI.KEY_ID));
                prefUI.orderUI = cursor.getString(cursor.getColumnIndex(PrefUI.KEY_orderUI));
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return prefUI;
    }

}