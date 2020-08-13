package com.samkough.average;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    private Button aboutB, averageB;

    private EditText ed1, ed2, ed3, ed4, ed5;
    private TextView tv1, tv2, tv3;

    private String str1, str2, str3, str4, str5;
    private int sum, n1, n2, n3, n4, n5;
    private int numbers[];
    private double average;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1 = (EditText) findViewById(R.id.editText);
        ed2 = (EditText) findViewById(R.id.editText2);
        ed3 = (EditText) findViewById(R.id.editText3);
        ed4 = (EditText) findViewById(R.id.editText4);
        ed5 = (EditText) findViewById(R.id.editText5);

        tv1 = (TextView) findViewById(R.id.textView);
        tv2 = (TextView) findViewById(R.id.sumText);
        tv3 = (TextView) findViewById(R.id.sizeText);

        str1 = "";
        str2 = "";
        str3 = "";
        str4 = "";
        str5 = "";
        average = 0;
        sum = 0;
        n1 = 0;
        n2 = 0;
        n3 = 0;
        n4 = 0;
        n5 = 0;

        averageB = (Button) findViewById(R.id.averageButton);
        averageB.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                str1 = String.valueOf(ed1.getText());
                str2 = String.valueOf(ed2.getText());
                str3 = String.valueOf(ed3.getText());
                str4 = String.valueOf(ed4.getText());
                str5 = String.valueOf(ed5.getText());

                n1 = Integer.parseInt(str1);
                n2 = Integer.parseInt(str2);
                n3 = Integer.parseInt(str3);
                n4 = Integer.parseInt(str4);
                n5 = Integer.parseInt(str5);

                numbers = new int[]{n1, n2, n3, n4, n5};

                for (int i = 0; i < numbers.length ; i++)
                {
                    sum = sum + numbers[i];
                }


                average = sum / numbers.length;

                tv1.setText("Average: " + average);
                tv2.setText("Sum: " + sum);
                tv3.setText("# of Inputs: " + numbers.length);

                n1 = 0;
                n2 = 0;
                n3 = 0;
                n4 = 0;
                n5 = 0;
                sum = 0;
                average = 0;
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
