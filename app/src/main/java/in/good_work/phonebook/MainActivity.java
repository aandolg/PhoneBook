package in.good_work.phonebook;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import in.good_work.phonebook.Adapter.RVAdapterUser;
import in.good_work.phonebook.Model.User;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String LOG_TAG = "DEBUGINFO";
    private static Context context;
    private RecyclerView rvListUser;
    private RVAdapterUser adapterUser;
    private Button btnAddUser;
    private ImageButton btnUserCall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MainActivity.context = getApplicationContext();

        setContentView(R.layout.activity_main);
        rvListUser = (RecyclerView) findViewById(R.id.rv_main_listuser);
        LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext());
        rvListUser.setLayoutManager(llm);

        adapterUser = new RVAdapterUser();

        User u = new User();
//        u.initializeData();
        u.load();

        rvListUser.setAdapter(adapterUser);
        adapterUser.addAll(u.persons);

        btnAddUser = (Button) findViewById(R.id.btn_main_add_user);
        btnAddUser.setOnClickListener(this);
    }

    public static Context getAppContext() {
        return MainActivity.context;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_main_add_user:
                Intent intent = new Intent(MainActivity.this, AddUserActivity.class);
                startActivity(intent);
                break;
            default:
                this.showText("Action unknown");
                break;
        }
    }

    private void showText(String text) {
        Toast.makeText(this.getAppContext(), text, Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        Intent intent = item.getIntent();

        switch (item.getItemId()) {
            case R.id.menu_view:
                break;
            case R.id.menu_delete:
                if (intent != null) {
                    Long userId = intent.getLongExtra("userId", 0);
                    if (userId > 0) {
                        User user = new User();
                        if (user.deleteUser(userId) > 0) {
                            Toast.makeText(this, "DELETE " + userId, Toast.LENGTH_LONG).show();
                        }
                    }
                }
                break;
        }
        return super.onContextItemSelected(item);
    }
}
