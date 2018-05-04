package edu.wtamu.tfleeman.track_a_truck;

import java.util.UUID;

public class User {

    private UUID mId;
    private String mName;
    private String mPosition;
    private String mPhone;
    private String mEmail;
    private String mAddress;

    public User(){
        mId = UUID.randomUUID();
    }

    public UUID getId() {
        return mId;
    }

    public void setId(UUID id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getPosition() {
        return mPosition;
    }

    public void setPosition(String position) {
        mPosition = position;
    }

    //public String getPhone() { return mPhone; }

    //public void setPhone(String phone) {mPhone = phone; }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String email) {
        mEmail = email;
    }

    //public String getAddress() { return mAddress; }

    //public void setAddress(String address) { mAddress = address;}
}
