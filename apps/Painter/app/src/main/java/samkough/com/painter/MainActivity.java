package samkough.com.painter;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.samkough.painter.R;

public class MainActivity extends Activity {

    private CanvasView canvasView;
    private int orange;
    private int purple;
    private float strokeWidth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        canvasView = (CanvasView) findViewById(R.id.canvasView);
        orange = Color.rgb(250, 128, 0);
        purple = Color.rgb(128, 0, 128);
        strokeWidth = 0;

        // REGULAR BUTTONS: about, reset
        Button aboutB = (Button) findViewById(R.id.aboutButton);
        Button resetB = (Button) findViewById(R.id.resetButton);

        // IMAGE BUTTONS: red, blue, green, yellow, black, purple, orange, erase, brush thickness plus, brush thickness minus
        ImageButton redIb = (ImageButton) findViewById(R.id.redButton);
        ImageButton blueIb = (ImageButton) findViewById(R.id.blueButton);
        ImageButton greenIb = (ImageButton) findViewById(R.id.greenButton);
        ImageButton yellowIb = (ImageButton) findViewById(R.id.yellowButton);
        ImageButton blackIb = (ImageButton) findViewById(R.id.blackButton);
        ImageButton purpleIb = (ImageButton) findViewById(R.id.purpleButton);
        ImageButton orangeIb = (ImageButton) findViewById(R.id.orangeButton);
        ImageButton eraseIb = (ImageButton) findViewById(R.id.eraseButton);
        ImageButton plusIb = (ImageButton) findViewById(R.id.plusButton);
        ImageButton minusIb = (ImageButton) findViewById(R.id.minusButton);

        minusIb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                strokeWidth -= 2;
                canvasView.setStrokeWidth(strokeWidth);
            }
        });

        plusIb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strokeWidth += 2;
                canvasView.setStrokeWidth(strokeWidth);
            }
        });

        eraseIb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                canvasView.setColor(Color.WHITE);
            }
        });

        orangeIb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                canvasView.setColor(orange);
            }
        });

        purpleIb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                canvasView.setColor(purple);
            }
        });

        blackIb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                canvasView.setColor(Color.BLACK);
            }
        });

        yellowIb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                canvasView.setColor(Color.YELLOW);
            }
        });

        greenIb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                canvasView.setColor(Color.GREEN);
            }
        });

        blueIb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                canvasView.setColor(Color.BLUE);
            }
        });

        redIb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                canvasView.setColor(Color.RED);
            }
        });

        aboutB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AboutActivity.class);

                startActivity(intent);
            }
        });

        resetB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                canvasView.clearCanvas();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}