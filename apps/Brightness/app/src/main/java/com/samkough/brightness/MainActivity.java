package com.samkough.brightness;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends Activity
{
    private Button aboutB;
    private TextView BackLightSetting;
    private SeekBar BackLightControl;
    private float BackLightValue = 0.5f;


    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BackLightControl  = (SeekBar) findViewById(R.id.backlightcontrol);
        BackLightSetting = (TextView) findViewById(R.id.backlightsetting);

        BackLightControl.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2)
            {
                BackLightValue = (float) arg1 / 100;
                BackLightSetting.setText(String.valueOf(BackLightValue));
                WindowManager.LayoutParams layoutParams = getWindow().getAttributes();
                layoutParams.screenBrightness = BackLightValue;
                getWindow().setAttributes(layoutParams);
            }

            public void onStopTrackingTouch(SeekBar seekBar)
            {}
            public void  onStartTrackingTouch(SeekBar seekBar)
            {}
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
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}