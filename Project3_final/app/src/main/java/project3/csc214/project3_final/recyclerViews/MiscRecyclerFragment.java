package project3.csc214.project3_final.recyclerViews;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import project3.csc214.project3_final.R;
import project3.csc214.project3_final.database.CustomEntryDb;
import project3.csc214.project3_final.model.InfoItem;

/**
 * A simple {@link Fragment} subclass.
 */
public class MiscRecyclerFragment extends Fragment {

    private static final String TAG = "Cancelmo_Debug_3";

    private CustomEntryDb mDatabase;
    private RecyclerView mRecyclerView;
    private ArrayList<InfoItem> mItemList;

    public MiscRecyclerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View mView = inflater.inflate(R.layout.fragment_misc_recycler, container, false);
        mDatabase = CustomEntryDb.get(getContext());
        mItemList = mDatabase.getInfoItemList();
        mRecyclerView = (RecyclerView) mView.findViewById(R.id.misc_recycler_view_frag);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        ItemRecyclerAdapter mAdapter = new ItemRecyclerAdapter(mItemList);
        mRecyclerView.setAdapter(mAdapter);
        return mView;
    }

}
