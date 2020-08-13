package com.samkough.coloredlabel;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends Activity
{
    private Button aboutB;
    private TextView coloredL;
    private Random rand;
    private int color, colors[];

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rand = new Random();
        /* 7 colors (Red, Green, Blue, Yellow, Black, Gray, White) */
        colors = new int[] {Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW, Color.BLACK, Color.GRAY, Color.WHITE};

        coloredL = (TextView) findViewById(R.id.textView);
        coloredL.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                // 7 is the maximum and the 1 is our minimum
                color = rand.nextInt(6) + 0;
                coloredL.setBackgroundColor(colors[color]);
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
                coloredL.setBackgroundColor(Color.TRANSPARENT);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}