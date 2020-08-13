package com.samkough.tipsclicks;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends AppCompatActivity
{
    private Button aboutB, clickB;
    private TextView tipT, numOfTipsT;

    private Tips t;
    private int randomNumber;
    Random randomGenerator = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t = new Tips();

        // tips
        t.addTip("Don't stress things out, they're smaller then you think.");
        t.addTip("Don't let something small turn into something big.");
        t.addTip("Don't regret your mistakes, learn from them.");
        t.addTip("Family comes from the experiences, not the label.");
        t.addTip("Wouldn't you rather be happy then miserable?");

        tipT = (TextView) findViewById(R.id.tipText);

        numOfTipsT = (TextView) findViewById(R.id.numberOfTipsText);
        numOfTipsT.setText("# of Tips: " + t.getAmountOfTips());

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

        clickB = (Button) findViewById(R.id.clickButton);
        clickB.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                // 5 is the maximum and the 0 is our minimum
                randomNumber = randomGenerator.nextInt(5) + 0;
                tipT.setText("" + t.getTip(randomNumber));
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
