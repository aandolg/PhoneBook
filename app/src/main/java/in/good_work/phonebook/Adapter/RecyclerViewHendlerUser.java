package in.good_work.phonebook.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import in.good_work.phonebook.Model.User;
import in.good_work.phonebook.R;

/**
 * Created by AELEX on 09.06.2017.
 */

class RecyclerViewHendlerUser extends RecyclerView.ViewHolder {
    private TextView tvPersonName;

    public RecyclerViewHendlerUser(View itemView) {
        super(itemView);
        tvPersonName = (TextView) itemView.findViewById(R.id.person_name);
    }

    public void bind(User u) {
        tvPersonName.setText(u.getmName());
    }
}
