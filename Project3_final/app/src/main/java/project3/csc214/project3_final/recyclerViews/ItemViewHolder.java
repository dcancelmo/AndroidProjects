package project3.csc214.project3_final.recyclerViews;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import project3.csc214.project3_final.R;
import project3.csc214.project3_final.model.InfoItem;

/**
 * Created by Dan on 4/30/17.
 */

public class ItemViewHolder extends RecyclerView.ViewHolder {

    private static final String TAG = "Cancelmo_Debug_3";

    private static final String KEY = "project3.csc214.project3_final.";


    private TextView mItemNameView;
    private TextView mItemBasicInfoView;
    private InfoItem mItem;

    public ItemViewHolder(final View itemView) {
        super(itemView);
        mItemNameView = (TextView) itemView.findViewById(R.id.view_location_name);
        mItemBasicInfoView = (TextView) itemView.findViewById(R.id.view_basic_info);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    public void bindItem(InfoItem mPItem) {
        mItem = mPItem;
        mItemNameView.setText(mItem.getName());
        mItemBasicInfoView.setText(mPItem.toString());
    }
}
