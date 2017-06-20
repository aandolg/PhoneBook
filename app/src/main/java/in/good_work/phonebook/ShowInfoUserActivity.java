package in.good_work.phonebook;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import in.good_work.phonebook.Model.User;

public class ShowInfoUserActivity extends AppCompatActivity {
    private TextView tvUserName;
    private TextView tvUserSurname;
    private TextView tvUserPhone;
    private TextView tvUserEmail;
    private ImageView ivImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_info_user);
        Intent intent = getIntent();
        Long userId = intent.getLongExtra("userId", 0);
        User user = new User();
        user = user.getUser(userId);

        tvUserName = (TextView) findViewById(R.id.tv_show_info_user_name);
        tvUserSurname = (TextView) findViewById(R.id.tv_show_info_user_surname);
        tvUserPhone = (TextView) findViewById(R.id.tv_show_info_user_phone);
        tvUserEmail = (TextView) findViewById(R.id.tv_show_info_user_email);
        ivImage  = (ImageView) findViewById(R.id.imgv_show_info_user_urlphoto);

        tvUserName.setText(user.getmName());
        tvUserSurname.setText(user.getmSurname());
        tvUserPhone.setText(user.getmPhone());
        tvUserEmail.setText(user.getmMail());
        try {
            Picasso.with(this).load(Uri.parse(user.getUrlPhoto())).error(R.drawable.not_available).into(ivImage);
        } catch (Exception e) {
            Toast.makeText(this,"Error image load",Toast.LENGTH_LONG).show();
        }
    }
}
