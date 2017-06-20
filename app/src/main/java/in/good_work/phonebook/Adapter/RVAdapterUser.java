package in.good_work.phonebook.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import in.good_work.phonebook.Model.User;
import in.good_work.phonebook.R;

public class RVAdapterUser extends RecyclerView.Adapter<RecyclerViewHolderUser> {
    private ArrayList<User> items = new ArrayList<>();

    public void addAll(List<User> user){
        int pos = getItemCount();
        this.items.addAll(user);
        notifyItemRangeChanged(pos, this.items.size());
    }


    @Override
    public RecyclerViewHolderUser onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_list_item, parent, false);
        return new RecyclerViewHolderUser(view, parent.getContext());
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolderUser holder, int position) {
            holder.bind(items.get(position));
        }

    @Override
    public int getItemCount() {
       return this.items.size();
    }
}
