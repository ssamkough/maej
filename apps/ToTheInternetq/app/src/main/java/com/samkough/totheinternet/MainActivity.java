package com.samkough.totheinternet;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    private Button aboutB;
    private TextView t1, t2, t3, t4;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t1 = (TextView) findViewById(R.id.text1);
        t1.setClickable(true);
        t1.setMovementMethod(LinkMovementMethod.getInstance());
        String text1 = "<a href='http://www.google.com'> Google </a>";
        t1.setText(Html.fromHtml(text1));

        t2 = (TextView) findViewById(R.id.text2);
        t2.setClickable(true);
        t2.setMovementMethod(LinkMovementMethod.getInstance());
        String text2 = "<a href='https://stackoverflow.com/'> Stackoverflow </a>";
        t2.setText(Html.fromHtml(text2));

        t3 = (TextView) findViewById(R.id.text3);
        t3.setClickable(true);
        t3.setMovementMethod(LinkMovementMethod.getInstance());
        String text3 = "<a href='http://www.youtube.com/'> YouTube </a>";
        t3.setText(Html.fromHtml(text3));

        t4 = (TextView) findViewById(R.id.text4);
        t4.setClickable(true);
        t4.setMovementMethod(LinkMovementMethod.getInstance());
        String text4 = "<a href='http://www.amazon.com/'> Amazon </a>";
        t4.setText(Html.fromHtml(text4));

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
