package mobappdev.demo.finalexam.problem2;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import mobappdev.demo.finalexam.R;

public class ProblemTwoActivity extends AppCompatActivity {

    ProblemTwoBottomFragment mBottomFragment;
    FragmentManager mFragManager;
    String mBottomString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_problem_two);
    }

    public void sendBelow(View view) {
        mBottomFragment = new ProblemTwoBottomFragment();
        mFragManager = getSupportFragmentManager();
        mFragManager.beginTransaction().add(R.id.fl_bottom, mBottomFragment).commit();
        EditText mTopEditText = (EditText) findViewById(R.id.et_input);
        mBottomString = mTopEditText.getText().toString();
        mBottomFragment.setTextView(mBottomString);

    }

    public void convertUpper(View view) {
        TextView mTopTextView = (TextView) findViewById(R.id.tv_response);
        mBottomString = mBottomString.toUpperCase();
        mTopTextView.setText(mBottomString);
    }

    public void convertLower(View view) {
        TextView mTopTextView = (TextView) findViewById(R.id.tv_response);
        mBottomString = mBottomString.toLowerCase();
        mTopTextView.setText(mBottomString);
    }
}
