package edu.wtamu.tfleeman.track_a_truck;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import edu.wtamu.tfleeman.track_a_truck.database.UserBaseHelper;

public class UserLab {
    private static UserLab sUserLab;

    private List<User> mUsers;
    //private Context mContext;
    //private SQLiteDatabase mDatabase;

    public static UserLab get(Context context){
        if (sUserLab == null){
            sUserLab = new UserLab(context);
        }
        return sUserLab;
    }

    private UserLab(Context context){
        //mContext = context.getApplicationContext();
        //mDatabase = new UserBaseHelper(mContext)
                //.getWritableDatabase();
        mUsers = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            User user = new User();
            user.setName("Driver #" + i);
            mUsers.add(user);
        }
        }

    public List<User> getUsers(){
        return mUsers;
    }

    public User getUser(UUID id){
        for (User user : mUsers) {
            if (user.getId().equals(id)){
                return user;
            }
        }

        return null;
    }

}
