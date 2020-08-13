package com.samkough.shake;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorListener
{
    private SensorManager mSensorManager;
    private float mAccel; // acceleration apart from gravity
    private float mAccelCurrent; // current acceleration including gravity
    private float mAccelLast; // last acceleration including gravity

    private TextView text, sliText, modText, harText;
    private Button aboutB;
    private int count1, count2, count3;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* do this in onCreate */
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mSensorManager.registerListener(mSensorListener, mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);
        mAccel = 0.00f;
        mAccelCurrent = SensorManager.GRAVITY_EARTH;
        mAccelLast = SensorManager.GRAVITY_EARTH;

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

    private final SensorEventListener mSensorListener = new SensorEventListener() {

        public void onSensorChanged(SensorEvent se) {
            float x = se.values[0];
            float y = se.values[1];
            float z = se.values[2];
            mAccelLast = mAccelCurrent;
            mAccelCurrent = (float) Math.sqrt((double) (x * x + y * y + z * z));
            float delta = mAccelCurrent - mAccelLast;
            mAccel = mAccel * 0.9f + delta; // perform low-cut filter

            text = (TextView) findViewById(R.id.textView);
            sliText = (TextView) findViewById(R.id.slightShake);
            count1 = 0;
            modText = (TextView) findViewById(R.id.moderateShake);
            count2 = 0;
            harText = (TextView) findViewById(R.id.hardShake);
            count3 = 0;

            // shake sensitivies
            if (mAccel > 1 && mAccel < 1.9)
            {
                text.setText("Device is slightly shaking.");
                count1++;
                sliText.setText("Slightly Shaking");
                modText.setText("nothing");
                harText.setText("nothing");

            }
            else if (mAccel > 2 && mAccel < 2.9)
            {
                text.setText("Device is moderately shaking.");
                count2++;
                modText.setText("Moderately Shaking");
                sliText.setText("nothing");
                harText.setText("nothing");
            }
            else if (mAccel > 3)
            {
                text.setText("Device is shaking hard.");
                count3++;
                harText.setText("Shaking Hardly");
                modText.setText("nothing");
                sliText.setText("nothing");
            }
            else if (mAccel > 0 && mAccel < 0.00001)
            {
                text.setText("Device isn't being shaked.");
                sliText.setText("nothing");
                harText.setText("nothing");
                modText.setText("nothing");
            }
        }

        public void onAccuracyChanged(Sensor sensor, int accuracy) {
        }
    };

    @Override
    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(mSensorListener, mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        mSensorManager.unregisterListener(mSensorListener);
        super.onPause();
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

    @Override
    public void onSensorChanged(int sensor, float[] values)
    {

    }

    @Override
    public void onAccuracyChanged(int sensor, int accuracy)
    {

    }
}
