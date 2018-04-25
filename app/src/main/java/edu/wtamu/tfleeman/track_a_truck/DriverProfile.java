package edu.wtamu.tfleeman.track_a_truck;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.sql.Driver;
import java.util.ArrayList;
import java.util.List;

import edu.wtamu.tfleeman.track_a_truck.database.DataBaseHelper;

public class DriverProfile {
    private static DriverProfile sDriverProfile;

    private List<Driver> mDrivers;
    private Context mContext;
    private SQLiteDatabase mDatabase;

    public static DriverProfile get(Context context) {
        if (sDriverProfile == null) {
            sDriverProfile = new DriverProfile(context);
        }

        return sDriverProfile;
    }


    private DriverProfile(Context context) {
        mContext = context.getApplicationContext();
        mDatabase = new DataBaseHelper(mContext)
                .getWritableDatabase();
        mDrivers = new ArrayList<>();
    }
}
