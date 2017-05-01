package project3.csc214.project3_final.recyclerViews;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import project3.csc214.project3_final.R;
import project3.csc214.project3_final.model.InfoItem;

/**
 * Created by Dan on 4/30/17.
 */

public class ItemRecyclerAdapter  extends RecyclerView.Adapter<ItemViewHolder> {

    private static final String TAG = "Cancelmo_Debug_3";

    private List<InfoItem> mItems;

    public ItemRecyclerAdapter(List<InfoItem> mItemList) {
        mItems = mItemList;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater mInflater = LayoutInflater.from(parent.getContext());
        View mView = mInflater.inflate(R.layout.view_info_item, parent, false);
        ItemViewHolder mHolder = new ItemViewHolder(mView);
        return mHolder;
    }


    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        holder.bindItem(mItems.get(position));
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }
}
