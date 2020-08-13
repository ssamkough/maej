package com.samkough.rainbowedlabels;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends Activity
{
    private Button aboutB;
    private TextView cL, cL2, cL3, cL4, cL5, cL6, cL7;
    private RelativeLayout mL;
    private Random rand;
    private int c1, c2, c3, c4, c5, c6, c7, colors[], colors2[], colors3[], colors4[], colors5[], colors6[], colors7[];

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mL = (RelativeLayout) findViewById(R.id.mainLayout);
        rand = new Random();
        /* 7 colors (Red, Green, Blue, Yellow, Black, Gray, White) */
        colors = new int[] {Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW, Color.BLACK, Color.GRAY, Color.WHITE};
        colors2 = new int[] {Color.GREEN, Color.BLUE, Color.RED, Color.YELLOW, Color.BLACK, Color.GRAY, Color.WHITE};
        colors3 = new int[] {Color.YELLOW, Color.RED, Color.BLUE, Color.GREEN, Color.BLACK, Color.GRAY, Color.WHITE};
        colors4 = new int[] {Color.BLUE, Color.RED, Color.YELLOW, Color.BLACK, Color.GREEN, Color.GRAY, Color.WHITE};
        colors5 = new int[] {Color.BLACK, Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW, Color.GRAY, Color.WHITE};
        colors6 = new int[] {Color.GRAY, Color.RED, Color.GREEN, Color.BLUE, Color.BLACK, Color.WHITE, Color.YELLOW};
        colors7 = new int[] {Color.WHITE, Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW, Color.BLACK, Color.GRAY};

        cL = (TextView) findViewById(R.id.textView);
        cL2 = (TextView) findViewById(R.id.textView2);
        cL3 = (TextView) findViewById(R.id.textView3);
        cL4 = (TextView) findViewById(R.id.textView4);
        cL5 = (TextView) findViewById(R.id.textView5);
        cL6 = (TextView) findViewById(R.id.textView6);
        cL7 = (TextView) findViewById(R.id.textView7);
        mL.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                // 7 is the maximum and the 1 is our minimum
                c1 = rand.nextInt(6) + 0;
                c2 = rand.nextInt(6) + 0;
                c3 = rand.nextInt(6) + 0;
                c4 = rand.nextInt(6) + 0;
                c5 = rand.nextInt(6) + 0;
                c6 = rand.nextInt(6) + 0;
                c7 = rand.nextInt(6) + 0;

                cL.setBackgroundColor(colors[c1]);
                cL2.setBackgroundColor(colors2[c2]);
                cL3.setBackgroundColor(colors3[c3]);
                cL4.setBackgroundColor(colors4[c4]);
                cL5.setBackgroundColor(colors5[c5]);
                cL6.setBackgroundColor(colors6[c6]);
                cL7.setBackgroundColor(colors7[c7]);
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

                cL.setBackgroundColor(Color.TRANSPARENT);
                cL2.setBackgroundColor(Color.TRANSPARENT);
                cL3.setBackgroundColor(Color.TRANSPARENT);
                cL4.setBackgroundColor(Color.TRANSPARENT);
                cL5.setBackgroundColor(Color.TRANSPARENT);
                cL6.setBackgroundColor(Color.TRANSPARENT);
                cL7.setBackgroundColor(Color.TRANSPARENT);
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