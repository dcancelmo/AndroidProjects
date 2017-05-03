package project3.csc214.project3_final.recyclerViews;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import project3.csc214.project3_final.R;
import project3.csc214.project3_final.model.InfoItem;
import project3.csc214.project3_final.sounds.Radio;

/**
 * A simple {@link Fragment} subclass.
 */
public class BarsRecyclerFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private ArrayList<InfoItem> mItemList;

    public BarsRecyclerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View mView = inflater.inflate(R.layout.fragment_bars_recycler, container, false);
        mItemList = new ArrayList<>();
        mItemList.add(new InfoItem("Bar 145", "71 Celebration Dr, Rochester, NY 14642", "585) 360-2458", "", "In CollegeTown. Take the bus or walk! No need for a cab!"));
        mItemList.add(new InfoItem("Pearl", "349 East Ave, Rochester, NY 14604", "(757) 752-0370", "", "Club and bar in downtown."));
        mItemList.add(new InfoItem("Tilt", "444 Central Ave, Rochester, NY 14605", "(585) 232-8440", "", "Gay club and bar in downtown"));
        mItemList.add(new InfoItem("ONE", "1 Ryan Alley, Rochester, NY 14607", "(585) 546-1010", "", "Club and bar in downtown"));

        mRecyclerView = (RecyclerView) mView.findViewById(R.id.bars_recycler_view_frag);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        ItemRecyclerAdapter mAdapter = new ItemRecyclerAdapter(mItemList);
        mRecyclerView.setAdapter(mAdapter);
        return mView;
    }

}
