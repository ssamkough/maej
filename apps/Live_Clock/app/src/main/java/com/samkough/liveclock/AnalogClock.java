package com.samkough.liveclock;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class AnalogClock extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analog_clock);
    }

    public void onBackPressed()
    {
        finish();
        overridePendingTransition(R.anim.left_in, R.anim.right_out);
    }
}
