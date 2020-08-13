package com.samkough.textdecoration;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    private Button aboutB, iButton, bButton, nButton;
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = (TextView) findViewById(R.id.textView);

        iButton = (Button) findViewById(R.id.iButton);
        iButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                text.setTypeface(null, Typeface.ITALIC);
            }
        });

        bButton = (Button) findViewById(R.id.boldButton);
        bButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                text.setTypeface(null, Typeface.BOLD);
            }
        });

        nButton = (Button) findViewById(R.id.nButton);
        nButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                text.setInputType(InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS);
                text.setTypeface(null, Typeface.NORMAL);
            }
        });

        aboutB = (Button) findViewById(R.id.aboutButton);
        aboutB.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(getApplicationContext(), AboutActivity.class);
                startActivity(i);

                overridePendingTransition(R.anim.right_in, R.anim.left_out);
            }
        });
    }
}
