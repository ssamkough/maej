package com.samkough.liveclock;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextClock;

public class DigitalClock extends AppCompatActivity
{
    private TextClock tc;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_digital_clock);

        tc = (TextClock) findViewById(R.id.textclock12);


    }

    public void onBackPressed()
    {
        finish();
        overridePendingTransition(R.anim.left_in, R.anim.right_out);
    }
}
