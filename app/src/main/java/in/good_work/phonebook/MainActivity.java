package in.good_work.phonebook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import in.good_work.phonebook.Adapter.RVAdapterUser;
import in.good_work.phonebook.Model.User;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvListUser;
    private RVAdapterUser adapterUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvListUser = (RecyclerView)findViewById(R.id.rv_main_listuser);
        LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext());
        rvListUser.setLayoutManager(llm);

        adapterUser = new RVAdapterUser();

        User u = new User();
        u.initializeData();
        rvListUser.setAdapter(adapterUser);
        adapterUser.addAll(u.persons);
    }
}
