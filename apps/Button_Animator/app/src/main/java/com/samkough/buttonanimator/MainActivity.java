package com.samkough.buttonanimator;

import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.BounceInterpolator;
import android.widget.Button;

import com.plattysoft.leonids.ParticleSystem;
import com.plattysoft.leonids.modifiers.AlphaModifier;
import com.plattysoft.leonids.modifiers.ScaleModifier;

import static com.nineoldandroids.view.ViewPropertyAnimator.animate;

public class MainActivity extends AppCompatActivity {

    private Button b1, b2, b3, b4, aboutB;
    ObjectAnimator fadeAnim;
    ObjectAnimator moveAnim;
    AnimatorSet set = new AnimatorSet();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        b1 = (Button) findViewById(R.id.button1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fadeAnim = ObjectAnimator.ofFloat(b1, "alpha", 0.4f);
                fadeAnim.start();
            }
        });

        b2 = (Button) findViewById(R.id.button2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                set.playTogether(ObjectAnimator.ofFloat(b2, "scaleX", 1.0f, 2.0f).setDuration(2000),
                        ObjectAnimator.ofFloat(b2, "scaleY", 1.0f, 2.0f).setDuration(2000),
                        ObjectAnimator.ofObject(b2, "backgroundColor", new ArgbEvaluator(),
                        /*Red*/0xFFFF8080, /*Blue*/0xFF8080FF).setDuration(2000));
                set.start();
            }
        });

        b3 = (Button) findViewById(R.id.button3);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animate(b3).alpha(0);
            }
        });

        b4 = (Button) findViewById(R.id.button4);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveAnim = ObjectAnimator.ofFloat(b4, "Y", 1500);
                moveAnim.setDuration(2000);
                moveAnim.setInterpolator(new BounceInterpolator());
                moveAnim.start();
            }
        });

        aboutB = (Button) findViewById(R.id.aboutButton);
        aboutB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AboutActivity.class);
                startActivity(intent);

                overridePendingTransition(R.anim.right_in, R.anim.left_out);
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
