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

/**
 * A simple {@link Fragment} subclass.
 */
public class TravelRecyclerFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private ArrayList<InfoItem> mItemList;

    public TravelRecyclerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View mView = inflater.inflate(R.layout.fragment_travel_recycler, container, false);

        mItemList = new ArrayList<>();
        try {
            mItemList.add(new InfoItem("Rochester International Airport", "1200 Brooks Ave, Rochester, NY 14624", "(585) 753-7000", new URL("http://http://www2.monroecounty.gov/airport-information.php"), "", "For flights domestically and to Canada. Serves the Greater Rochester area."));
            mItemList.add(new InfoItem("Amtrak Station", "320 Central Ave, Rochester, NY 14605", "320 Central Ave, Rochester, NY 14605", new URL("https://amtrak.com"), "", "Amtrak service on the Empire Line and Great Lakes Line. Service to NYC, Toronto, and Chicago."));
            mItemList.add(new InfoItem("Greyhound Bus Terminal", "186 Cumberland St, Rochester, NY 14609", "(585) 232-5121", new URL("http://http://locations.greyhound.com/bus-stations/us/new-york/rochester/bus-station-151580"), "", "Greyhound and New York Trailways bus service. Next to Amtrak Station"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        mRecyclerView = (RecyclerView) mView.findViewById(R.id.travel_recycler_view_frag);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        ItemRecyclerAdapter mAdapter = new ItemRecyclerAdapter(mItemList);
        mRecyclerView.setAdapter(mAdapter);
        return mView;
    }

}
