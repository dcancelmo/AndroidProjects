package lecture.csc214.downtherabbithole;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button mButtonEatMe = (Button) findViewById(R.id.button_eat_me);
        mButtonEatMe.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, R.string.bigger, Toast.LENGTH_SHORT).show();
            }
        });
        Button mButtonDrinkMe = (Button) findViewById(R.id.button_drink_me);
        mButtonDrinkMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, getString(R.string.smaller), Toast.LENGTH_SHORT).show();
            }
        });
        TextView mTextViewInstructions = (TextView) findViewById(R.id.text_view_instructions);
    }
}
