package in.good_work.phonebook.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import in.good_work.phonebook.Model.User;
import in.good_work.phonebook.R;

public class RVAdapterUser extends RecyclerView.Adapter<RecyclerViewHendlerUser> {
    private ArrayList<User> items = new ArrayList<>();

    public void addAll(List<User> user){
        int pos = getItemCount();
        this.items.addAll(user);
        notifyItemRangeChanged(pos, this.items.size());
    }


    @Override
    public RecyclerViewHendlerUser onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new RecyclerViewHendlerUser(view);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHendlerUser holder, int position) {
        holder.bind(items.get(position));
    }

    @Override
    public int getItemCount() {
       return this.items.size();
    }
}
