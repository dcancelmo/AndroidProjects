package assignment06.csc214.homework6_listrecyclerviews;


import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

import assignment06.csc214.homework6_listrecyclerviews.model.Course;


/**
 * A simple {@link Fragment} subclass.
 */
public class DescriptionDialogFragment extends DialogFragment {

    private static final String DESCRIPTION = "COURSE_DESCRIPTION";


    public DescriptionDialogFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_description_dialog, container, false);
    }

    public static DescriptionDialogFragment newInstance(Course mCourse) {
        DescriptionDialogFragment mDialog = new DescriptionDialogFragment();
        Bundle mArgs = new Bundle();
        mArgs.putString(DESCRIPTION, mCourse.getDescription());
        mDialog.setArguments(mArgs);
        return mDialog;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View mView = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_description_dialog, null);
        Bundle mArgs = getArguments();
        String mDescriptionString = mArgs.getString(DESCRIPTION);
        TextView mDescriptionView = (TextView) mView.findViewById(R.id.description_dialog);
        mDescriptionView.setText(mDescriptionString);
        return new AlertDialog.Builder(getActivity()).setView(mView).setTitle(R.string.course_description)
                .setNeutralButton(getString(R.string.close), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        dismiss();
                    }
                }).create();

    }

}
