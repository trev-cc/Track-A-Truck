package edu.wtamu.tfleeman.track_a_truck;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserLab {
    private static UserLab sUserLab;

    private List<User> mUsers;

    public static UserLab get(Context context){
        if (sUserLab == null){
            sUserLab = new UserLab(context);
        }
        return sUserLab;
    }

    private UserLab(Context context){
        mUsers = new ArrayList<>();
        for (int i = 0; i < 100; i++){
            User user = new User();
            user.setName("Driver #" + i);
            user.setPosition("Location" + i);
            user.setPhone("555-555-5555");
            user.setEmail("driveremail@trackatruck.com");
            user.setAddress(i + "Main St.");
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
