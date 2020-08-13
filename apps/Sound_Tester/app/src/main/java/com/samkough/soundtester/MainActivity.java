package com.samkough.soundtester;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    private Button aboutB, sb, dogB, cowB, lionB, deerB;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dogB = (Button) findViewById(R.id.dogButton);
        dogB.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(getApplicationContext(), "CORRECT!", Toast.LENGTH_SHORT).show();
            }
        });

        cowB = (Button) findViewById(R.id.cowButton);
        cowB.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(getApplicationContext(), "INCORRECT!", Toast.LENGTH_SHORT).show();
            }
        });

        lionB = (Button) findViewById(R.id.lionButton);
        lionB.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(getApplicationContext(), "INCORRECT!", Toast.LENGTH_SHORT).show();
            }
        });

        deerB = (Button) findViewById(R.id.deerButton);
        deerB.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(getApplicationContext(), "INCORRECT!", Toast.LENGTH_SHORT).show();
            }
        });

        sb = (Button) findViewById(R.id.soundButton);
        final MediaPlayer mp1 = MediaPlayer.create(this, R.raw.bark);
        sb.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                mp1.start();
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
