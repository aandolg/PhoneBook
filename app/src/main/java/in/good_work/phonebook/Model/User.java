package in.good_work.phonebook.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AELEX on 06.06.2017.
 */

public class User {
    private long userId;
    private String mName;
    private String mSurname;
    private String mPhone;
    private String mMail;
    private String urlPhoto;
    public ArrayList<User> persons;

    public User(long userId, String mName, String mSurname, String mPhone, String mMail, String urlPhoto) {
        this.userId = userId;
        this.mName = mName;
        this.mSurname = mSurname;
        this.mPhone = mPhone;
        this.mMail = mMail;
        this.urlPhoto = urlPhoto;
    }
    public User(){

    }

    public void initializeData(){
        persons = new ArrayList<>();
        persons.add(new User(1, "Emma", "Wilson", "1233", "email@ff.vs", "photo url"));
        persons.add(new User(2, "Lavery", "Maiss", "23423", "email@ff.vs", "photo url"));
        persons.add(new User(3, "Lillie", "Watts", "6546532", "email@ff.vs", "photo url"));
        persons.add(new User(1, "Emma1", "Wilson", "1233", "email@ff.vs", "photo url"));
        persons.add(new User(2, "Lavery1", "Maiss", "23423", "email@ff.vs", "photo url"));
        persons.add(new User(3, "Lillie1", "Watts", "6546532", "email@ff.vs", "photo url"));
        persons.add(new User(1, "Emma2", "Wilson", "1233", "email@ff.vs", "photo url"));
        persons.add(new User(2, "Lavery2", "Maiss", "23423", "email@ff.vs", "photo url"));
        persons.add(new User(3, "Lillie2", "Watts", "6546532", "email@ff.vs", "photo url"));
        persons.add(new User(1, "Emma3", "Wilson", "1233", "email@ff.vs", "photo url"));
        persons.add(new User(2, "Lavery3", "Maiss", "23423", "email@ff.vs", "photo url"));
        persons.add(new User(3, "Lillie3", "Watts", "6546532", "email@ff.vs", "photo url"));
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmSurname() {
        return mSurname;
    }

    public void setmSurname(String mSurname) {
        this.mSurname = mSurname;
    }

    public String getmPhone() {
        return mPhone;
    }

    public void setmPhone(String mPhone) {
        this.mPhone = mPhone;
    }

    public String getmMail() {
        return mMail;
    }

    public void setmMail(String mMail) {
        this.mMail = mMail;
    }

    public String getUrlPhoto() {
        return urlPhoto;
    }

    public void setUrlPhoto(String urlPhoto) {
        this.urlPhoto = urlPhoto;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", mName='" + mName + '\'' +
                ", mSurname='" + mSurname + '\'' +
                ", mPhone='" + mPhone + '\'' +
                ", mMail='" + mMail + '\'' +
                ", urlPhoto='" + urlPhoto + '\'' +
                '}';
    }
}
