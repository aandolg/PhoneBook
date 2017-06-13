package in.good_work.phonebook;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import in.good_work.phonebook.Model.User;

public class AddUserActivity extends AppCompatActivity {
    private EditText etId;
    private EditText etName;
    private EditText etSurname;
    private EditText etPhone;
    private EditText etMail;
    private EditText etUrlPhoto;
    private Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        etId = (EditText) findViewById(R.id.et_main_id);
        etName = (EditText) findViewById(R.id.et_main_name);
        etSurname = (EditText) findViewById(R.id.et_main_surname);
        etPhone = (EditText) findViewById(R.id.et_main_phone);
        etMail = (EditText) findViewById(R.id.et_main_mail);
        etUrlPhoto = (EditText) findViewById(R.id.et_main_urlphoto);
        btnSave = (Button) findViewById(R.id.btn_main_send);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = new User(Long.valueOf(getValueEt(etId)), getValueEt(etName), getValueEt(etSurname), getValueEt(etPhone),  getValueEt(etMail), getValueEt(etUrlPhoto));
                user.add();
                Intent intent = new Intent(AddUserActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    @NonNull
    private String  getValueEt(EditText v){
        return v.getText().toString();
    }
}
