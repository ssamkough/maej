package com.samkough.speak2you;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.app.Activity;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.List;
import java.util.Locale;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.widget.Toast;

public class MainActivity extends Activity implements TextToSpeech.OnInitListener
{
    private Button aboutB, speakB;
    private EditText text;
    private TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text =  (EditText) findViewById(R.id.editText);

        tts = new TextToSpeech(this, this);

        speakB = (Button) findViewById(R.id.speakButton);
        speakB.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                speakOut();
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
    public void onDestroy()
    {
        // Don't forget to shutdown tts!
        if (tts != null)
        {
            tts.stop();
            tts.shutdown();
        }

        super.onDestroy();
    }

    @Override
    public void onInit(int status)
    {

        if (status == TextToSpeech.SUCCESS)
        {
            int result = tts.setLanguage(Locale.US);

            if (result == TextToSpeech.LANG_MISSING_DATA
                    || result == TextToSpeech.LANG_NOT_SUPPORTED)
            {
                Log.e("TTS", "This Language is not supported");
            } else
            {
                speakB.setEnabled(true);
                speakOut();
            }

        }
        else
        {
            Log.e("TTS", "Initilization Failed!");
        }

    }

    private void speakOut()
    {
        String input = text.getText().toString();

        tts.speak(input, TextToSpeech.QUEUE_FLUSH, null);

        Toast.makeText(getApplicationContext(), input, Toast.LENGTH_SHORT).show();
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
