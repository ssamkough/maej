package com.samkough.bulletedtext;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    private Button aboutB;
    private RadioButton rb1, rb2, rb3, rb4, rb5;
    private TextView tb1, tb2, tb3, tb4, tb5;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tb1 = (TextView) findViewById(R.id.textBox1);
        tb2 = (TextView) findViewById(R.id.textBox2);
        tb3 = (TextView) findViewById(R.id.textBox3);
        tb4 = (TextView) findViewById(R.id.textBox4);
        tb5 = (TextView) findViewById(R.id.textBox5);

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

        rb1 = (RadioButton) findViewById(R.id.radioButton1);
        rb1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                tb1.setText("Here's the first!");
            }
        });

        rb2 = (RadioButton) findViewById(R.id.radioButton2);
        rb2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                tb2.setText("I'm the second!");
            }
        });

        rb3 = (RadioButton) findViewById(R.id.radioButton3);
        rb3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                tb3.setText("Third is here!");
            }
        });

        rb4 = (RadioButton) findViewById(R.id.radioButton4);
        rb4.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                tb4.setText("Fourth in action!");
            }
        });

        rb5 = (RadioButton) findViewById(R.id.radioButton5);
        rb5.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                tb5.setText("Wasup.");
            }
        });
    }

    public void uncheck()
    {
        if(rb1.isChecked())
        {
            rb1.setChecked(false);
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
