package com.samkough.likeornot;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    private Button aboutB, resetB, resultsB;
    private TextView dogsT, catsT, pencilsT, pensT;
    private int d, c, p1, p2;
    private String sd, sc, sp1, sp2;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(getApplicationContext(), "ANSWERS START AUTOMATICALLY WITH YES!", Toast.LENGTH_SHORT).show();

        /*
        * COLOR CODES
        * RED  =  #FF0000 - NO
        * BLUE =  #03A9F4 - YES
        */

        dogsT = (TextView) findViewById(R.id.dogText);
        dogsT.setTextColor(Color.BLUE);
        dogsT.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                dogsT.setTextColor(Color.RED);
            }
        });

        catsT = (TextView) findViewById(R.id.catText);
        catsT.setTextColor(Color.BLUE);
        catsT.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                catsT.setTextColor(Color.RED);
            }
        });

        pencilsT = (TextView) findViewById(R.id.pencilText);
        pencilsT.setTextColor(Color.BLUE);
        pencilsT.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                pencilsT.setTextColor(Color.RED);
            }
        });

        pensT = (TextView) findViewById(R.id.penText);
        pensT.setTextColor(Color.BLUE);
        pensT.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                pensT.setTextColor(Color.RED);
            }
        });

        resetB = (Button) findViewById(R.id.resetButton);
        resetB.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                dogsT.setTextColor(Color.BLUE);
                catsT.setTextColor(Color.BLUE);
                pencilsT.setTextColor(Color.BLUE);
                pensT.setTextColor(Color.BLUE);
            }
        });

        resultsB = (Button) findViewById(R.id.resultButton);
        resultsB.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                d = dogsT.getCurrentTextColor();
                c = catsT.getCurrentTextColor();
                p1 = pencilsT.getCurrentTextColor();
                p2 = pensT.getCurrentTextColor();

                /*
                * BLUE = -16776961
                * RED = -65536
                * */

                // DOGS
                if(d == -16776961)
                {
                    sd = "LIKE";
                }
                else
                {
                    sd = "DISLIKE";
                }

                // CATS
                if(c == -16776961)
                {
                    sc = "LIKE";
                }
                else
                {
                    sc = "DISLIKE";
                }

                // PENCILS
                if(p1 == -16776961)
                {
                    sp1 = "LIKE";
                }
                else
                {
                    sp1 = "DISLIKE";
                }

                // PENS
                if(p2 == -16776961)
                {
                    sp2 = "LIKE";
                }
                else
                {
                    sp2 = "DISLIKE";
                }

                Toast.makeText(getApplicationContext(),
                        "RESULTS...\n" +
                        "DOGS = " + sd + "\n" +
                        "CATS = " + sc + "\n" +
                        "PENCILS = " + sp1 + "\n" +
                        "PENS = " + sp2 + "\n", Toast.LENGTH_LONG).show();
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
