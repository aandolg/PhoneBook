package in.good_work.phonebook.Helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import static in.good_work.phonebook.MainActivity.LOG_TAG;

/**
 * Created by AELEX on 10.06.2017.
 */

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context) {
        // конструктор суперкласса
        super(context, "phoneBook1", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(LOG_TAG, "--- onCreate database ---");
        // создаем таблицу с полями
        db.execSQL("create table users ("
                + "id integer primary key autoincrement,"
                + "name text,"
                + "surname text,"
                + "phone text,"
                + "url_photo text,"
                + "email text" + ");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
