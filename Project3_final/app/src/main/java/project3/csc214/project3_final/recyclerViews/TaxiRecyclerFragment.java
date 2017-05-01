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
import project3.csc214.project3_final.model.InfoItem;

/**
 * A simple {@link Fragment} subclass.
 */
public class TaxiRecyclerFragment extends Fragment {

    private static final String TAG = "Cancelmo_Debug_3";

    private RecyclerView mRecyclerView;
    private ArrayList<InfoItem> mItemList;

    public TaxiRecyclerFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View mView = inflater.inflate(R.layout.fragment_taxi_recycler, container, false);

        mItemList = new ArrayList<>();
        mItemList.add(new InfoItem("Park Avenue Taxi", "", "(585) 851-1888", "24/7", ""));
        mItemList.add(new InfoItem("Rochester Taxi", "", "(585) 694-3674", "24/7", ""));
        mItemList.add(new InfoItem("Hummingbird Taxi", "", "(866) 421-6615", "24/7", ""));
        mItemList.add(new InfoItem("Midtown Cab", "", "(585) 647-8888", "24/7", ""));
        mItemList.add(new InfoItem("Park Avenue Taxi Express", "", "(585) 442-4444", "Open until 5AM", ""));
        mItemList.add(new InfoItem("Airport Taxi Service", "", "(585) 235-3333", "Open until 12AM", ""));
        mRecyclerView = (RecyclerView) mView.findViewById(R.id.taxi_recycler_view_frag);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        ItemRecyclerAdapter mAdapter = new ItemRecyclerAdapter(mItemList);
        mRecyclerView.setAdapter(mAdapter);
        return mView;
    }

}
