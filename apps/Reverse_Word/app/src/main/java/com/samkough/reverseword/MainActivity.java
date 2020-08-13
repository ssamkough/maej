package com.samkough.reverseword;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{

    String parsed = "";
    String reversed = "";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final MainActivity m = new MainActivity();
        final TextView label = (TextView) findViewById(R.id.text);
        final EditText input = (EditText) findViewById(R.id.textBox);
        Button reverseB = (Button) findViewById(R.id.reverseButton);
        Button aboutB = (Button) findViewById(R.id.aboutButton);

        reverseB.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                parsed = input.getText().toString();
                reversed = m.reverseString(parsed);
                label.setText(reversed);
            }
        });

        aboutB.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(getApplicationContext(), AboutActivity.class);
                startActivity(intent);
            }
        });
    }

    public String reverseString(String str)
    {
        String reverse = "";
        int length = str.length();

        for(int i = length - 1 ; i >= 0 ; i--)
        {
            reverse = reverse + str.charAt(i);
        }
        return reverse;
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
