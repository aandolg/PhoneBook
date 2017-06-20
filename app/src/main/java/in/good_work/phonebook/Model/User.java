package in.good_work.phonebook.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import in.good_work.phonebook.Helper.DBHelper;
import in.good_work.phonebook.MainActivity;

import static android.content.Context.CONTEXT_IGNORE_SECURITY;
import static in.good_work.phonebook.MainActivity.LOG_TAG;

/**
 * Created by AELEX on 06.06.2017.
 */

public class User {
    DBHelper dbHelper = new DBHelper(MainActivity.getAppContext());
    private SQLiteDatabase db = dbHelper.getWritableDatabase();
    ContentValues cv = new ContentValues();
    private String table = "users";

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

    public User() {

    }

    public void initializeData() {
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

    public void load() {
        persons = new ArrayList<>();
        Log.d(LOG_TAG, "--- Rows in " + this.table + ": ---");
        Cursor c = db.query(this.table, null, null, null, null, null, null);

        if (c.moveToFirst()) {
            do {
                persons.add(
                        new User(
                                (long) c.getFloat(c.getColumnIndex("id")),
                                c.getString(c.getColumnIndex("name")),
                                c.getString(c.getColumnIndex("surname")),
                                c.getString(c.getColumnIndex("phone")),
                                c.getString(c.getColumnIndex("email")),
                                c.getString(c.getColumnIndex("url_photo"))
                        )
                );
            } while (c.moveToNext());
        } else {
            Log.d(LOG_TAG, "0 rows");
        }
        c.close();
    }

    public void add() {

        Log.d(LOG_TAG, "--- Insert in user " + this.table + ": ---");
        // подготовим данные для вставки в виде пар: наименование столбца - значение
        cv.put("name", this.getmName());
        cv.put("surname", this.getmSurname());
        cv.put("phone", this.getmPhone());
        cv.put("url_photo", this.getUrlPhoto());
        cv.put("email", this.getmMail());
        long rowID = db.insert(this.table, null, cv);
        Log.d(LOG_TAG, "row inserted, ID = " + rowID);
    }

    public User getUser(Long userId) {
        Log.d(LOG_TAG, "--- Get user " + this.table + ": ---");
        Cursor c = db.query(this.table, null, "id = " + userId, null, null, null, null);
        User user = new User();
        if (c.moveToFirst()) {
            do {
                user.setUserId((long) Float.parseFloat(this.getValueColumn(c, "id")));
                user.setmName(this.getValueColumn(c, "name"));
                user.setmSurname(this.getValueColumn(c, "surname"));
                user.setmPhone(this.getValueColumn(c, "phone"));
                user.setmMail(this.getValueColumn(c, "email"));
                user.setUrlPhoto(this.getValueColumn(c, "url_photo"));
            } while (c.moveToNext());
        } else {
            Log.d(LOG_TAG, "0 rows");
        }
        c.close();
        return user;
    }

    private String getValueColumn(Cursor c, String columnName) {
       return c.getString(c.getColumnIndex(columnName));
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

    public int deleteUser(Long userId) {
        return  db.delete(this.table, "id = " + userId, null);
    }
}
