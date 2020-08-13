package com.samkough.chronometer;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    private Button aboutB, start, log, restart, set, clear, stop;
    private Chronometer focus;
    private Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start = (Button) findViewById(R.id.button1);
        log = (Button) findViewById(R.id.button2);
        restart = (Button) findViewById(R.id.button3);
        set = (Button) findViewById(R.id.button4);
        clear = (Button) findViewById(R.id.button5);
        stop = (Button) findViewById(R.id.stopButton);

        focus = (Chronometer) findViewById(R.id.chronometer1);
        focus.showContextMenu();
        
        start.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                focus.start();
            }
        });

        stop.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                focus.stop();
            }
        });

        log.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                toast = Toast.makeText(getApplicationContext(), focus.getText(), Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 0);
                toast.show();
            }
        });

        restart.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                focus.setBase(SystemClock.elapsedRealtime());
            }
        });

        set.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                focus.setFormat("Formatted Time - %s");
            }
        });

        clear.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                focus.setFormat(null);
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
