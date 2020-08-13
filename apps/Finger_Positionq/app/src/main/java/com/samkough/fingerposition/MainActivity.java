package com.samkough.fingerposition;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    private Button aboutB;
    private TextView text;
    private static final String DEBUG_TAG = "DEBUG";
    private String str;

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
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){

        int action = MotionEventCompat.getActionMasked(event);
        float x, y;
        text = (TextView) findViewById(R.id.textView);
        str = "";

        switch(action)
        {
            case(MotionEvent.ACTION_DOWN):
                Log.d(DEBUG_TAG, "Action was DOWN");
                return true;

            case(MotionEvent.ACTION_MOVE):
                Log.d(DEBUG_TAG,"Action was MOVE");
                x = event.getRawX();
                y = event.getRawY();
                str += "(" + x + ", " + y + ")";
                text.setText(str);
                return true;

            case(MotionEvent.ACTION_UP):
                Log.d(DEBUG_TAG,"Action was UP");
                return true;

            case(MotionEvent.ACTION_CANCEL):
                Log.d(DEBUG_TAG,"Action was CANCEL");
                return true;

            case(MotionEvent.ACTION_OUTSIDE):
                Log.d(DEBUG_TAG,"Movement occurred outside bounds " + "of current screen element");
                return true;

            default:
                return super.onTouchEvent(event);
        }
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
