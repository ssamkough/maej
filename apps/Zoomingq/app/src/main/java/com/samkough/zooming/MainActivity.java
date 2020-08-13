package com.samkough.zooming;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ZoomButton;

public class MainActivity extends Activity
{
    private Button aboutB;
    private ZoomButton zoomIn, zoomOut;
    private ImageView img;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        zoomIn = (ZoomButton) findViewById(R.id.zoomButton1);
        zoomOut = (ZoomButton) findViewById(R.id.zoomButton);
        img = (ImageView) findViewById(R.id.imageView1);

        zoomIn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                float x = img.getScaleX();
                float y = img.getScaleY();

                img.setScaleX(x + 1);
                img.setScaleY(y + 1);
            }
        });

        zoomOut.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                float x = img.getScaleX();
                float y = img.getScaleY();

                img.setScaleX(x - 1);
                img.setScaleY(y - 1);
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
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}