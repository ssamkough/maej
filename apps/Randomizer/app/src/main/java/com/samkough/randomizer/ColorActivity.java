package com.samkough.randomizer;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import java.util.Random;

public class ColorActivity extends AppCompatActivity {

    Random rgenerator = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);

        final RelativeLayout rootView = (RelativeLayout)findViewById(R.id.randomColorLayout);
        final String TAG = ColorActivity.class.getSimpleName();
        final int[] mbgIds = new int[] {
                R.drawable.green, R.drawable.blue,R.drawable.brown,R.drawable.dark_blue,R.drawable.gold_orange,
                R.drawable.light_grey,R.drawable.lime,R.drawable.orange,
                R.drawable.pink,R.drawable.purple,R.drawable.red, R.drawable.sky_blue,
                R.drawable.white, R.drawable.yellow
        };
        final Integer u = mbgIds[rgenerator.nextInt(mbgIds.length)];

        Log.e(TAG, "IMAGE_GET" + u);
        rootView.setBackgroundResource(u);

        rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rootView.setBackgroundColor(u);
            }
        });



    }

}
