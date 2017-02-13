package assignment01.csc214.hellodaniel;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class HelloDanielActivity extends AppCompatActivity {

    public static final String KEY_BOLD = "assignment1.csc214.hellodaniel.BOLD";
    public static final String KEY_ITALIC = "assignment1.csc214.hellodaniel.ITALIC";
    public static final String KEY_UNDELRINED = "assignment1.csc214.hellodaniel.UNDELRINED";
    private boolean mIsUnderlined = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello_daniel);

    }

    public void openFontChanger(View view) {
        Intent intent = new Intent(HelloDanielActivity.this, FontActivity.class);
        Typeface mNameTV = ((TextView)findViewById(R.id.hello)).getTypeface();
        intent.putExtra(KEY_BOLD, mNameTV.isBold());
        intent.putExtra(KEY_ITALIC, mNameTV.isItalic());
        intent.putExtra(KEY_UNDELRINED, mIsUnderlined);
        startActivity(intent);
    }
}
