package com.samkough.switchinviews;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ViewSwitcher;

public class MainActivity extends AppCompatActivity
{
    private Button aboutB, resetB;
    private ViewSwitcher switcher;
    private static final int REFRESH_SCREEN = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        switcher = (ViewSwitcher) findViewById(R.id.ViewSwitcher);
        startScan();

        resetB = (Button) findViewById(R.id.resetButton);
        resetB.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
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

    public void startScan()
    {
        new Thread()
        {
            public void run()
            {
                try
                {
                    // This is just a tmp sleep so that we can emulate something loading
                    Thread.sleep(5000);
                    // Use this handler so than you can update the UI from a thread
                    Refresh.sendEmptyMessage(REFRESH_SCREEN);
                } catch(Exception e){}
            }
        }.start();
    }

    // Refresh handler, necessary for updating the UI in a/the thread
    Handler Refresh = new Handler()
    {
        public void handleMessage(Message msg)
        {
            switch(msg.what)
            {
                case REFRESH_SCREEN:
                    switcher.showNext();
                    // To go back to the first view, use switcher.showPrevious()
                    break;

                default:
                    break;
            }
        }
    };


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
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
}