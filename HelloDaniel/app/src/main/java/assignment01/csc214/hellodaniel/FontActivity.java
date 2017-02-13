package assignment01.csc214.hellodaniel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class FontActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_font);
    }

    public void cancel(View view) {
        finish();
    }

    public void nfoReturn(View view) {
        Intent intent = new Intent();
        intent.putExtra();
        intent.putExtra();
        intent.putExtra();
        setResult(RESULT_OK, intent);
        finish();
    }
}
