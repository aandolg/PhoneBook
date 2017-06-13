package in.good_work.phonebook.Adapter;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import in.good_work.phonebook.MainActivity;
import in.good_work.phonebook.Model.User;
import in.good_work.phonebook.R;


/**
 * Created by AELEX on 09.06.2017.
 */

class RecyclerViewHolderUser extends RecyclerView.ViewHolder implements View.OnClickListener {
    private TextView tvUserName;
    private TextView tvUserSurname;
    private TextView tvUserPhone;
    private TextView tvUserEmail;
    private ImageButton imbntCall;
    private User user;

    public RecyclerViewHolderUser(View itemView) {
        super(itemView);
        tvUserName = (TextView) itemView.findViewById(R.id.user_name);
        tvUserSurname = (TextView) itemView.findViewById(R.id.user_surname);
        tvUserPhone = (TextView) itemView.findViewById(R.id.user_phone);
        tvUserEmail = (TextView) itemView.findViewById(R.id.user_email);
        imbntCall = (ImageButton) itemView.findViewById(R.id.btn_user_list_call);
        imbntCall.setOnClickListener(this);
    }

    public void bind(User u) {
        if (u != null) {
            this.user = u;
            tvUserName.setText(u.getmName());
            tvUserSurname.setText(u.getmSurname());
            tvUserPhone.setText(u.getmPhone());
            tvUserEmail.setText(u.getmMail());
        }
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
                Toast.makeText(MainActivity.getAppContext(), v.toString(), Toast.LENGTH_LONG);
                break;

        }
    }
}
