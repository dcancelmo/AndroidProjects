package project3.csc214.project3_final.recyclerViews;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import project3.csc214.project3_final.ItemDetailsFragment;
import project3.csc214.project3_final.ItemDialogFragment;
import project3.csc214.project3_final.R;
import project3.csc214.project3_final.model.InfoItem;
import project3.csc214.project3_final.sounds.Radio;
import project3.csc214.project3_final.sounds.Track;

/**
 * Created by Dan on 4/30/17.
 */

public class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private static final String TAG = "Cancelmo_Debug_3";

    private static final String KEY = "project3.csc214.project3_final.";

    private TextView mItemNameView;
    private TextView mItemBasicInfoView;
    private InfoItem mItem;

    public ItemViewHolder(final View itemView) {
        super(itemView);
        mItemNameView = (TextView) itemView.findViewById(R.id.view_location_name);
        mItemBasicInfoView = (TextView) itemView.findViewById(R.id.view_basic_info);
        itemView.setOnClickListener(this);
    }

    public void bindItem(InfoItem mPItem) {
        mItem = mPItem;
        mItemNameView.setText(mItem.getName());
        mItemBasicInfoView.setText(mPItem.toString());
    }

    @Override
    public void onClick(View v) {
        AppCompatActivity mContext = (AppCompatActivity) v.getContext();
        if (mContext.getResources().getConfiguration().smallestScreenWidthDp == 600) {
            Log.i(TAG, "Item selected, displaying detail fragment for:  " + mItem.getName());
            FragmentManager mManager = mContext.getSupportFragmentManager();
            ItemDetailsFragment mFragment = ItemDetailsFragment.newInstance(mItem);
            mManager.beginTransaction().add(R.id.tablet_detail_frame_layout, mFragment).commit();

        } else {
            Log.i(TAG, "Dialog fragment created for " + mItem.getName());
            FragmentManager mManager = mContext.getSupportFragmentManager();
            ItemDialogFragment mDialog = ItemDialogFragment.newInstance(mItem);
            mDialog.show(mManager, "Item Dialog");
        }
    }
}
