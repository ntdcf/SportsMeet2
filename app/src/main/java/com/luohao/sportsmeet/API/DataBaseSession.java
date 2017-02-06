package com.luohao.sportsmeet.API;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract;

/**
 * Created by luohao3 on 2017/2/6.
 */

public class DataBaseSession extends SQLiteOpenHelper {

    public static final String CREATE_SESSION_TB = "create table session(" +
            "session_id text primary key," +
            "user text);";
    public Context sContext;

    public DataBaseSession(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        sContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_SESSION_TB);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
