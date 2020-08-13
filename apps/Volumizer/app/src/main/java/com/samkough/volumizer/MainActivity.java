package com.samkough.volumizer;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity
{
    private Button aboutB, increaseB, reduceB;
    private AudioManager am;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        am = (AudioManager) getApplicationContext().getSystemService(Context.AUDIO_SERVICE);

        /* the highest point is 7, the lowest point is -7*/
        increaseB = (Button) findViewById(R.id.increaseButton);
        increaseB.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                am.adjustVolume(AudioManager.ADJUST_RAISE, AudioManager.FLAG_PLAY_SOUND);
            }
        });

        reduceB = (Button) findViewById(R.id.reduceButton);
        reduceB.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                am.adjustVolume(AudioManager.ADJUST_LOWER, AudioManager.FLAG_PLAY_SOUND);
            }
        });

        aboutB = (Button) findViewById(R.id.aboutButton);
        aboutB.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(getApplicationContext(), AboutActivity.class);
                startActivity(intent);

                overridePendingTransition(R.anim.right_in, R.anim.left_out);
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