package com.samkough.changeshapecolor;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity
{
    private Button aboutB;
    private ImageView redIV, greenIV, blueIV, yellowIV, blackIV, whiteIV;
    private CanvasView cv;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cv = (CanvasView) findViewById(R.id.canvasView);

        redIV = (ImageView) findViewById(R.id.imageViewRed);
        redIV .setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                cv.setColor(Color.RED);
            }
        });

        greenIV = (ImageView) findViewById(R.id.imageViewGreen);
        greenIV.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                cv.setColor(Color.GREEN);
            }
        });

        blueIV = (ImageView) findViewById(R.id.imageViewBlue);
        blueIV.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                cv.setColor(Color.BLUE);
            }
        });

        yellowIV = (ImageView) findViewById(R.id.imageViewYellow);
        yellowIV.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                cv.setColor(Color.YELLOW);
            }
        });

        whiteIV = (ImageView) findViewById(R.id.imageViewWhite);
        whiteIV.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                cv.setColor(Color.WHITE);
            }
        });

        blackIV = (ImageView) findViewById(R.id.imageViewBlack);
        blackIV.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                cv.setColor(Color.BLACK);
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
