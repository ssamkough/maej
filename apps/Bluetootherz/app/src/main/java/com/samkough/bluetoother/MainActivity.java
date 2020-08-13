package com.samkough.bluetoother;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity
{
    private Button aboutB, enableB, disableB;
    private TextView text;
    private BluetoothAdapter mBlueA;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBlueA = BluetoothAdapter.getDefaultAdapter();
        text = (TextView) findViewById(R.id.textView);

        if(mBlueA.isEnabled())
        {
            text.setText("ENABLED");
        }
        else
        {
            text.setText("DISABLED");
        }

        enableB = (Button) findViewById(R.id.enableButton);
        enableB.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(mBlueA.isEnabled())
                {
                    text.setText("ALREADY ENABLED");
                }
                else
                {
                    mBlueA.enable();
                    text.setText("ENABLED");
                }
            }
        });

        disableB = (Button) findViewById(R.id.disableButton);
        disableB.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(mBlueA.isEnabled())
                {
                    mBlueA.disable();
                    text.setText("DISABLED");
                }
                else
                {
                    text.setText("ALREADY DISABLED");
                }
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
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}