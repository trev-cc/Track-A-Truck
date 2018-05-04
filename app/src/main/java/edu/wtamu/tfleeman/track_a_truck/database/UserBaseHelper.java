package edu.wtamu.tfleeman.track_a_truck.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import edu.wtamu.tfleeman.track_a_truck.database.UserDbSchema.UserTable;

public class UserBaseHelper  extends SQLiteOpenHelper{

    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "userBase.db";

    public UserBaseHelper(Context context){
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("create table " + UserTable.NAME + "(" +
            "_id integer primary key autoincrement, " +
            UserTable.Cols.UUID + ", " +
            UserTable.Cols.NAME + ", " +
            UserTable.Cols.POSITION + ", " +
            UserTable.Cols.EMAIL +
            ")"
        );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

    }

}
