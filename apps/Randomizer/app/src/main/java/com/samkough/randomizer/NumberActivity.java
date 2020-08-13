package com.samkough.randomizer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.Random;

public class NumberActivity extends AppCompatActivity {

    String letters[] = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
    int idx = new Random().nextInt(letters.length);
    String random = (letters[idx]);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number);

        final TextView rNumText = (TextView) findViewById(R.id.randomNumberText);
        final RelativeLayout numLayout = (RelativeLayout) findViewById(R.id.numLayout);

        final String TAG = LetterActivity.class.getSimpleName();
        Log.e(TAG, "IMAGE_GET" + random);
        rNumText.setText(random);

        numLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rNumText.setText(random);
            }
        });
    }

}
