package edu.wtamu.tfleeman.track_a_truck.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import edu.wtamu.tfleeman.track_a_truck.database.DriverSchema.DriverTable;

public class DataBaseHelper extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "trackBase.db";

    public DataBaseHelper (Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + DriverTable.NAME + "(" +
                "_id integer primary key autoincrement, " +
                DriverTable.Cols.UUID + ", " +
                DriverTable.Cols.Fname + ", " +
                DriverTable.Cols.Lname + ", " +
                DriverTable.Cols.Position + ", " +
                DriverTable.Cols.Phone + ", " +
                DriverTable.Cols.Email + ", " +
                DriverTable.Cols.Address +
                ")"
        );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        /* static final String UUID = "uuid";
        public static final String Fname = "fname";
        public static final String Lname = "lnamne";
        public static final String Position = "Position";
        public static final String Phone = "Phone";
        public static final String Email = "Email";
        public static final String Address = "Address";
        */
    }

}
