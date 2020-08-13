package com.samkough.combinewords;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity
{
    private Button aboutB, randomizeB;
    private EditText firstW, secondW;
    private TextView resultT;

    String first, second, result, shuffled1, shuffled2, shuffled3;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        first = "";
        second = "";
        result = "";

        firstW = (EditText) findViewById(R.id.firstWord);
        secondW = (EditText) findViewById(R.id.secondWord);
        resultT = (TextView) findViewById(R.id.resultText);

        randomizeB = (Button) findViewById(R.id.randomizeButton);
        randomizeB.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (firstW.getText().equals("") && secondW.getText().equals(""))
                {

                }
                else
                {
                    first = String.valueOf(firstW.getText());
                    List<String> letters1 = Arrays.asList(first.split(""));
                    Collections.shuffle(letters1);
                    shuffled1 = "";
                    for (String letter : letters1)
                    {
                        shuffled1 += letter;
                    }

                    second = String.valueOf(secondW.getText());
                    List<String> letters2 = Arrays.asList(second.split(""));
                    Collections.shuffle(letters2);
                    shuffled2 = "";
                    for (String letter : letters2)
                    {
                        shuffled2 += letter;
                    }

                    result = shuffled1 + shuffled2;
                    List<String> letters3 = Arrays.asList(result.split(""));
                    Collections.shuffle(letters3);
                    shuffled3 = "";
                    for (String letter : letters3)
                    {
                        shuffled3 += letter;
                    }

                    resultT.setText(shuffled3);
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
