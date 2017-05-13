package mobappdev.demo.finalexam.problem2;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import mobappdev.demo.finalexam.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProblemTwoBottomFragment extends Fragment {

    TextView mBottomTextView;
    String mBottomString;

    public ProblemTwoBottomFragment() {
        // Required empty public constructor
    }

    public void setTextView(String mBottomString) {
        this.mBottomString = mBottomString;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View mView = inflater.inflate(R.layout.fragment_problem_two_bottom, container, false);
        mBottomTextView = (TextView) mView.findViewById(R.id.tv_message);
        mBottomTextView.setText(mBottomString);
        return mView;
    }

}
