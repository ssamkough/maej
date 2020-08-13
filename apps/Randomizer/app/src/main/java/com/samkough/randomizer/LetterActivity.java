package com.samkough.randomizer;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Random;

public class LetterActivity extends AppCompatActivity {

    String letters[] = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    int idx = new Random().nextInt(letters.length);
    String random = (letters[idx]);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_letter);

        final TextView rText = (TextView) findViewById(R.id.randomText);
        final RelativeLayout layout = (RelativeLayout) findViewById(R.id.layout);

        final String TAG = LetterActivity.class.getSimpleName();
        Log.e(TAG, "IMAGE_GET" + random);
        rText.setText(random);

        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rText.setText(random);
            }
        });
    }

}
