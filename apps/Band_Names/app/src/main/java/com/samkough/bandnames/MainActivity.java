package com.samkough.bandnames;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity
{
    private Button aboutB, randomB;
    private TextView firstT, secondT;
    private String[] first, second;
    private int idx, idx2;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        first = new String[]{"Arctic", "Red", "Frozen", "Hot", "Cool", "Awesome"};
        second = new String[]{"Warriors", "Peeps", "Ppl", "Children", "Adults", "Kids"};

        firstT = (TextView) findViewById(R.id.textView);
        secondT = (TextView) findViewById(R.id.textView2);
        randomB = (Button) findViewById(R.id.randomButton);
        randomB.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                idx = new Random().nextInt(first.length);
                firstT.setText(first[idx]);

                idx2 = new Random().nextInt(second.length);
                secondT.setText(second[idx2]);
            }
        });

        aboutB = (Button) findViewById(R.id.aboutButton);
        aboutB.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(getApplicationContext(), AboutActivity.class);
                startActivity(i);

                overridePendingTransition(R.anim.right_in, R.anim.left_out);
            }
        });
    }
}
