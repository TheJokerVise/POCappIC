package mobile.intranet.infocamere.it.pocappic.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import mobile.intranet.infocamere.it.pocappic.model.PrefUI;
import mobile.intranet.infocamere.it.pocappic.model.ServiceIC;
import mobile.intranet.infocamere.it.pocappic.model.UserIC;

/**
 * Created by LucaVise on 08/03/18.
 */

public class DBHelper  extends SQLiteOpenHelper {
    //version number to upgrade database version
    //each time if you Add, Edit table, you need to change the
    //version number.
    private static final int DATABASE_VERSION = 22;

    // Database Name
    private static final String DATABASE_NAME = "ic_app";

    public DBHelper(Context context ) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //All necessary tables you like to create will create here

        String CREATE_TABLE_USERIC = "CREATE TABLE " + UserIC.TABLE  + "("
                + UserIC.KEY_ROWID  + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                + UserIC.KEY_ID  + " INTEGER ,"
                + UserIC.KEY_YYI + " TEXT, "
                + UserIC.KEY_surname + " TEXT, "
                + UserIC.KEY_name + " TEXT, "
                + UserIC.KEY_matricola + " TEXT, "
                + UserIC.KEY_sede + " TEXT, "
                + UserIC.KEY_phone_fix + " TEXT, "
                + UserIC.KEY_phone_mobile + " TEXT, "
                + UserIC.KEY_cdr + " TEXT, "
                + UserIC.KEY_office + " TEXT, "
                + UserIC.KEY_email + " TEXT )";

        String CREATE_TABLE_PREFUI = "CREATE TABLE " + PrefUI.TABLE  + "("
                + PrefUI.KEY_ROWID  + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                + PrefUI.KEY_ID  + " INTEGER ,"
                + PrefUI.KEY_orderUI + " TEXT )";

        String CREATE_TABLE_SERVICEIC = "CREATE TABLE " + ServiceIC.TABLE  + "("
                + ServiceIC.KEY_ROWID  + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                + ServiceIC.KEY_ID  + " TEXT ,"
                + ServiceIC.KEY_serviceName + " TEXT )"
                + ServiceIC.KEY_serviceVisible + " TEXT )";

        db.execSQL(CREATE_TABLE_USERIC);

        db.execSQL(CREATE_TABLE_PREFUI);

        db.execSQL(CREATE_TABLE_SERVICEIC);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed, all data will be gone!!!
        db.execSQL("DROP TABLE IF EXISTS " + UserIC.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + PrefUI.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + ServiceIC.TABLE);

        // Create tables again
        onCreate(db);

    }

}

