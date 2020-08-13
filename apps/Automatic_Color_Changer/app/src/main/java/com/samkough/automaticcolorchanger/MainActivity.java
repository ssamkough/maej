package com.samkough.automaticcolorchanger;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends Activity
{
    private Button aboutB;
    private Timer timer;
    private TimerTask timerTask;
    private RelativeLayout mL;
    private Random rand;
    private int c1, colors[];

    //we are going to use a handler to be able to run in our TimerTask
    final Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mL = (RelativeLayout) findViewById(R.id.mainLayout);
        rand = new Random();
        /* 7 colors (Red, Green, Blue, Yellow, Black, Gray, White) */
        colors = new int[] {Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW, Color.BLACK, Color.GRAY, Color.WHITE};

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

    @Override
    protected void onResume()
    {
        super.onResume();

        //onResume we start our timer so it can start when the app comes from the background
        startTimer();
    }

    public void startTimer()
    {
        //set a new Timer
        timer = new Timer();

        //initialize the TimerTask's job
        initializeTimerTask();

        // schedule the timer, after the first 5000ms the TimerTask will run every 10000ms
        timer.schedule(timerTask, 2000, 2000); //
    }

    public void stoptimertask(View v)
    {
        // stop the timer, if it's not already null
        if (timer != null)
        {
            timer.cancel();
            timer = null;
        }
    }

    public void initializeTimerTask()
    {

        timerTask = new TimerTask()
        {
            public void run()
            {

                //use a handler to run a toast that shows the current timestamp
                handler.post(new Runnable()
                {
                    public void run()
                    {
                        c1 = rand.nextInt(6) + 0;
                        mL.setBackgroundColor(colors[c1]);
                    }
                });
            }
        };
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}