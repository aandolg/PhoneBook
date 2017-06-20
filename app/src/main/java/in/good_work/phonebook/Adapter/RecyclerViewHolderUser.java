package in.good_work.phonebook.Adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import in.good_work.phonebook.MainActivity;
import in.good_work.phonebook.Model.User;
import in.good_work.phonebook.R;
import in.good_work.phonebook.ShowInfoUserActivity;


/**
 * Created by AELEX on 09.06.2017.
 */

public class RecyclerViewHolderUser extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnCreateContextMenuListener {
    private TextView tvUserName;
    private TextView tvUserSurname;
    private TextView tvUserPhone;
    private TextView tvUserEmail;
    private ImageView ivImage;
    private ImageButton imbntCall;
    private User user;
    Context context;

    public RecyclerViewHolderUser(View itemView, Context context) {
        super(itemView);
//        this.context = context;
        this.context = itemView.getContext();
        tvUserName = (TextView) itemView.findViewById(R.id.user_name);
        tvUserSurname = (TextView) itemView.findViewById(R.id.user_surname);
        tvUserPhone = (TextView) itemView.findViewById(R.id.user_phone);
        tvUserEmail = (TextView) itemView.findViewById(R.id.user_email);
        ivImage = (ImageView) itemView.findViewById(R.id.user_photo);
        imbntCall = (ImageButton) itemView.findViewById(R.id.btn_user_list_call);
        imbntCall.setOnClickListener(this);
        itemView.setOnClickListener(this);
    }

    public void bind(User u) {
        if (u != null) {
            this.user = u;
            tvUserName.setText(u.getmName());
            tvUserSurname.setText(u.getmSurname());
            tvUserPhone.setText(u.getmPhone());
            Picasso.with(context).load(Uri.parse(u.getUrlPhoto())).error(R.drawable.not_available).into(ivImage);
            tvUserEmail.setText(u.getmMail());
            itemView.setOnCreateContextMenuListener(this);
        }
    }

    public User getUser() {
        return this.user;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_user_list_call:
                if (user != null) {
                    if (user.getmPhone() != null) {
                        //Call with change phone
                        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", user.getmPhone(), null));
                        //Call
                       /* Intent intent = new Intent(Intent.ACTION_CALL, Uri.fromParts("tel", user.getmPhone(), null));
                        if (ActivityCompat.checkSelfPermission(MainActivity.getAppContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                            return;
                        }*/
                        v.getContext().startActivity(intent);
                    }
                }
                break;
            default:
                Toast.makeText(context, v.toString(), Toast.LENGTH_LONG).show();
                break;

        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater inflater = new MenuInflater(context);
        inflater.inflate(R.menu.user_list_context_menu, menu);

        MenuItem item = menu.getItem(0);
        Intent intentView = new Intent(context, ShowInfoUserActivity.class);
        intentView.putExtra("userId", this.user.getUserId());
        item.setIntent(intentView);

        item = menu.getItem(1);
        Intent intentDelete = new Intent(context, MainActivity.class);
        intentDelete.putExtra("userId", this.user.getUserId());
        item.setIntent(intentDelete);
    }
}
