package com.samkough.notificationsinthebar;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
{
    private Button aboutB, btnShow, btnClear;
    NotificationManager manager;
    Notification myNotication;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialise();

        manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        btnShow.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View arg0)
            {
                //API level 11
                Intent intent = new Intent("com.rj.notitfications.SECACTIVITY");

                PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, 1, intent, 0);

                Notification.Builder builder = new Notification.Builder(MainActivity.this);

                builder.setAutoCancel(false);
                builder.setTicker("This is the notificatino ticker text!");
                builder.setContentTitle("Notifications In The Bar Notification");
                builder.setContentText("You have a new message!");
                builder.setSmallIcon(R.drawable.ic_launcher);
                builder.setContentIntent(pendingIntent);
                builder.setOngoing(true);
                builder.setSubText("This is the notification sub text!");   //API level 16
                builder.setNumber(100);
                builder.build();

                myNotication = builder.getNotification();
                manager.notify(11, myNotication);

            /*
            //API level 8
            Notification myNotification8 = new Notification(R.drawable.ic_launcher, "this is ticker text 8", System.currentTimeMillis());

            Intent intent2 = new Intent(MainActivity.this, SecActivity.class);
            PendingIntent pendingIntent2 = PendingIntent.getActivity(getApplicationContext(), 2, intent2, 0);
            myNotification8.setLatestEventInfo(getApplicationContext(), "API level 8", "this is api 8 msg", pendingIntent2);
            manager.notify(11, myNotification8);
            */

            }
        });

        btnClear.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View arg0) {
                manager.cancel(11);
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

    private void initialise()
    {
        btnShow = (Button) findViewById(R.id.buttonShow);
        btnClear = (Button) findViewById(R.id.buttonClear);
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
