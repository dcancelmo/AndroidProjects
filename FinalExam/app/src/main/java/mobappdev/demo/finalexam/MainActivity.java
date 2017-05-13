package mobappdev.demo.finalexam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import mobappdev.demo.finalexam.problem1.ProblemOneFirstActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void problemOneClicked(View view) {
        Intent mIntent = new Intent(MainActivity.this, ProblemOneFirstActivity.class);
        startActivityForResult(mIntent, 0);
    }

    public void problemTwoClicked(View view) {
    }

    public void problemThreeAClicked(View view) {
    }

    public void problemThreeBClicked(View view) {
    }

    public void problemFourClicked(View view) {
    }
}
