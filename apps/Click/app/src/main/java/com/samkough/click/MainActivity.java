package com.samkough.click;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // LABELS
        final TextView clickL = (TextView) findViewById(R.id.clickLabel);
        clickL.setText("0");

        // BUTTONS
        final Button plusB = (Button) findViewById(R.id.plusButton);

        plusB.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                count++;
                clickL.setText("" + count);
            }
        });

        final Button minusB = (Button) findViewById(R.id.minusButton);

        minusB.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                count--;
                clickL.setText("" + count);
            }
        });

        final Button resetB = (Button) findViewById(R.id.resetButton);

        resetB.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                count = 0;
                clickL.setText("" + count);
            }
        });

        final Button aboutB = (Button) findViewById(R.id.aboutButton);

        aboutB.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AboutActivity.class);

                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
