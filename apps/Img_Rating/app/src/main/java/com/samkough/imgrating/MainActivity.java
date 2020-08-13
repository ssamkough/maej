package com.samkough.imgrating;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    private Button aboutB, resultsB;
    private RatingBar manRB, penguinRB, bananaRB;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultsB = (Button) findViewById(R.id.resultsButton);
        resultsB.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                manRB = (RatingBar) findViewById(R.id.manRatingBar);
                penguinRB = (RatingBar) findViewById(R.id.penguinRatingBar);
                bananaRB = (RatingBar) findViewById(R.id.bananaRatingBar);

                Toast.makeText(getApplicationContext(), "Man = " + manRB.getRating() + " stars\n" +
                                                        "Penguin = " + penguinRB.getRating() + " stars\n" +
                                                        "Banana = " + bananaRB.getRating() + " stars\n", Toast.LENGTH_SHORT).show();
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
