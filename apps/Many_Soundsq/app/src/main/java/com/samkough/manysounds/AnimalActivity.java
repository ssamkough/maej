package com.samkough.manysounds;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class AnimalActivity extends AppCompatActivity
{
    private Button s1, s2, s3, s4;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal);

        final MediaPlayer mp1 = MediaPlayer.create(this, R.raw.bird);
        s1 = (Button) findViewById(R.id.soundOne);
        s1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                mp1.start();
            }
        });

        final MediaPlayer mp2 = MediaPlayer.create(this, R.raw.dog);
        s2 = (Button) findViewById(R.id.soundTwo);
        s2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                mp2.start();
            }
        });

        final MediaPlayer mp3 = MediaPlayer.create(this, R.raw.horse);
        s3 = (Button) findViewById(R.id.soundThree);
        s3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                mp3.start();
            }
        });

        final MediaPlayer mp4 = MediaPlayer.create(this, R.raw.lamb);
        s4 = (Button) findViewById(R.id.soundFour);
        s4.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                mp4.start();
            }
        });
    }

    public void onBackPressed()
    {
        finish();
        overridePendingTransition(R.anim.left_in, R.anim.right_out);
    }
}
