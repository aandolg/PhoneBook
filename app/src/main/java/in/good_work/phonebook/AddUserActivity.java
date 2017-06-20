package in.good_work.phonebook;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.IOException;

import in.good_work.phonebook.Model.User;

public class AddUserActivity extends AppCompatActivity {
    private EditText etId;
    private EditText etName;
    private EditText etSurname;
    private EditText etPhone;
    private EditText etMail;
    private ImageView etUrlPhoto;
    private String urlImg;
    private Button btnSave;
    static final int GALLERY_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        etId = (EditText) findViewById(R.id.et_main_id);
        etName = (EditText) findViewById(R.id.et_main_name);
        etSurname = (EditText) findViewById(R.id.et_main_surname);
        etPhone = (EditText) findViewById(R.id.et_main_phone);
        etMail = (EditText) findViewById(R.id.et_main_mail);
        etUrlPhoto = (ImageView) findViewById(R.id.et_main_urlphoto);
        btnSave = (Button) findViewById(R.id.btn_main_send);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = new User(
                        Long.valueOf(getValueEt(etId)),
                        getValueEt(etName),
                        getValueEt(etSurname),
                        getValueEt(etPhone),
                        getValueEt(etMail),
                        urlImg
//                        getValueEt(etUrlPhoto)
                );
                user.add();
                Intent intent = new Intent(AddUserActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        etUrlPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
                photoPickerIntent.setType("image/*");
                startActivityForResult(photoPickerIntent, GALLERY_REQUEST);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);
        Bitmap bitmap = null;
        switch (requestCode) {
            case GALLERY_REQUEST:
                if (resultCode == RESULT_OK) {
                    Uri selectedImage = imageReturnedIntent.getData();

                    try {
                        bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), selectedImage);
                        urlImg = selectedImage.toString();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    etUrlPhoto.setImageBitmap(bitmap);
                }
        }
    }

    @NonNull
    private String getValueEt(EditText v) {
        return v.getText().toString();
    }
    private String getValueEt(ImageView v) {

        return v.getResources().toString();
    }
}
