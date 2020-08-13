package com.samkough.whatimageisthis;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ImageTestActivity extends AppCompatActivity
{
    private Button b1, b2, b3, b4;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_test);

        final MediaPlayer mp1 = MediaPlayer.create(this, R.raw.correct);
        final MediaPlayer mp2 = MediaPlayer.create(this, R.raw.wrong);

        b1 = (Button) findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                mp2.start();

                Toast t1 = Toast.makeText(getApplicationContext(), "WRONG!", Toast.LENGTH_SHORT);
                t1.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL, 0, 35);
                t1.show();
            }
        });

        b2 = (Button) findViewById(R.id.button2);
        b2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                mp2.start();

                Toast t1 = Toast.makeText(getApplicationContext(), "WRONG!", Toast.LENGTH_SHORT);
                t1.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL, 0, 35);
                t1.show();
            }
        });

        b3 = (Button) findViewById(R.id.button3);
        b3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                mp1.start();

                Toast t1 = Toast.makeText(getApplicationContext(), "CORRECT!", Toast.LENGTH_SHORT);
                t1.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL, 0, 35);
                t1.show();
            }
        });

        b4 = (Button) findViewById(R.id.button4);
        b4.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                mp2.start();

                Toast t1 = Toast.makeText(getApplicationContext(), "WRONG!", Toast.LENGTH_SHORT);
                t1.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL, 0, 35);
                t1.show();
            }
        });
    }

}
