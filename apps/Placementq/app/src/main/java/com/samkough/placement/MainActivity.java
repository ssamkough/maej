package com.samkough.placement;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener
{
    private Button aboutB;
    private ImageView ball, hoop;
    private TextView cText, sText;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

        ball = (ImageView) findViewById(R.id.basketball);
        ball.setOnTouchListener(this);

        hoop = (ImageView) findViewById(R.id.hoop);
        hoop.setOnTouchListener(this);

        cText = (TextView) findViewById(R.id.change);
        sText = (TextView) findViewById(R.id.score);
    }

    float x, y = 0.0f;
    boolean moving = false;
    String TAG = "tag";
    int i = 0;

    @Override
    public boolean onTouch(View v, MotionEvent event)
    {
        switch(event.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                moving = true;
                break;

            case MotionEvent.ACTION_MOVE:
                if(moving)
                {
                    x = event.getRawX() - ball.getWidth() / 2;
                    y = event.getRawY() - ball.getHeight() * 3 / 2;
                    ball.setX(x);
                    ball.setY(y);
                    if(collision(ball, hoop))
                    {
                        Log.d(TAG, "INTERSECTED!");
                        // Toast can't update for some reason so I'm not using it
                        // Toast.makeText(this, "INTERSECTED!", Toast.LENGTH_SHORT).show();
                        cText.setText("INTERSECTED!");
                        sText.setText("" + i);
                    }
                    else
                    {
                        Log.d(TAG, "NOT INTERSECTED!");
                        // Toast.makeText(this, "NOT INTERSECTED!", Toast.LENGTH_SHORT).show();
                        cText.setText("NOT INTERSECTED!");
                    }
                }
                break;

            case MotionEvent.ACTION_UP:
                moving = false;
                break;
        }

        return true;
    }

    public boolean collision(ImageView a, ImageView b)
    {
        float bl = a.getY();
        float bt = a.getX();
        float br = a.getWidth() + bl;
        float bb = a.getHeight() + bt;
        float pl = b.getY();
        float pt = b.getX();
        float pr = b.getWidth() + pl;
        float pb = b.getHeight() + pt;

        if (bl <= pr && bl >= pl && bt >= pt && bt <= pb)
        {
            return true;
        }
        else if (br >= pl && br <= pr && bb >= pt && bb <= pb)
        {
            return true;
        }
        else if (bt <= pb && bt >= pt && br >= pl && br <= pr)
        {
            return true;
        }
        else if (bb >= pt && bb <= pb && bl >= pl && bl <= pr)
        {
            return true;
        }
        return false;
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
