package com.samkough.drinkup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity
{
    private Button aboutB, refillB;
    private ImageView water;
    private int count;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        count = 0;

        water = (ImageView) findViewById(R.id.imageView);
        water.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                water.setImageResource(R.drawable.half);
                count++;
                if(count >= 2)
                {
                    water.setImageResource(R.drawable.empty);
                }
            }
        });

        refillB = (Button) findViewById(R.id.refillButton);
        refillB.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                count = 0;
                water.setImageResource(R.drawable.full);
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
