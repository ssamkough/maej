package com.samkough.scrolling;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
{
    private Button aboutB, vScroll, hScroll;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vScroll = (Button) findViewById(R.id.vScroll);
        vScroll.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(getApplicationContext(), VerticalScroll.class);
                startActivity(intent);

                overridePendingTransition(R.anim.right_in, R.anim.left_out);
            }
        });

        hScroll = (Button) findViewById(R.id.hScroll);
        hScroll.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(getApplicationContext(), HorizontalScroll.class);
                startActivity(intent);

                overridePendingTransition(R.anim.right_in, R.anim.left_out);
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
