package com.samkough.calculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Integer n1 = null;
    Integer n2 = null;
    int outputNumber = 0;
    boolean clicked1 = false, clicked2 = false, clicked3 = false, clicked4 = false, clicked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // LABELS
        final TextView output = (TextView) findViewById(R.id.outputText);

        // BUTTONS
        /* OPERATOR BUTTONS */
        final Button plusB = (Button) findViewById(R.id.plusButton);
        final Button minusB = (Button) findViewById(R.id.minusButton);
        final Button timesB = (Button) findViewById(R.id.timesButton);
        final Button divisionB = (Button) findViewById(R.id.divisionButton);
        final Button equalsB = (Button) findViewById(R.id.equalsButton);

        /* APP BUTTONS */
        final Button resetB = (Button) findViewById(R.id.resetButton);
        final Button aboutB = (Button) findViewById(R.id.aboutButton);

        /* NUMBER BUTTONS */
        final Button oneB = (Button) findViewById(R.id.oneButton);
        final Button twoB = (Button) findViewById(R.id.twoButton);
        final Button threeB = (Button) findViewById(R.id.threeButton);
        final Button fourB = (Button) findViewById(R.id.fourButton);
        final Button fiveB = (Button) findViewById(R.id.fiveButton);
        final Button sixB = (Button) findViewById(R.id.sixButton);
        final Button sevenB = (Button) findViewById(R.id.sevenButton);
        final Button eightB = (Button) findViewById(R.id.eightButton);
        final Button nineB = (Button) findViewById(R.id.nineButton);
        final Button zeroB = (Button) findViewById(R.id.zeroButton);

        oneB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(clicked == false)
                {
                    n1 = 1;
                }
                else
                {
                    n2 = 1;
                }
                output.setText("1");
            }
        });

        twoB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(clicked == false)
                {
                    n1 = 2;
                }
                else
                {
                    n2 = 2;
                }
                output.setText("2");
            }
        });

        threeB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(clicked == false)
                {
                    n1 = 3;
                }
                else
                {
                    n2 = 3;
                }
                output.setText("3");
            }
        });

        fourB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(clicked == false)
                {
                    n1 = 4;
                }
                else
                {
                    n2 = 4;
                }
                output.setText("4");
            }
        });

        fiveB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(clicked == false)
                {
                    n1 = 5;
                }
                else
                {
                    n2 = 5;
                }
                output.setText("5");
            }
        });

        sixB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(clicked == false)
                {
                    n1 = 6;
                }
                else
                {
                    n2 = 6;
                }
                output.setText("6");
            }
        });

        sevenB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(clicked == false)
                {
                    n1 = 7;
                }
                else
                {
                    n2 = 7;
                }
                output.setText("7");
            }
        });

        eightB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(clicked == false)
                {
                    n1 = 8;
                }
                else
                {
                    n2 = 8;
                }
                output.setText("8");
            }
        });

        nineB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(clicked == false)
                {
                    n1 = 9;
                }
                else
                {
                    n2 = 9;
                }
                output.setText("9");
            }
        });

        zeroB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(clicked == false)
                {
                    n1 = 0;
                }
                else
                {
                    n2 = 0;
                }
                output.setText("0");
            }
        });

        plusB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicked1 = true;
                clicked = true;
                output.setText("+");
            }
        });

        minusB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicked2 = true;
                clicked = true;
                output.setText("-");
            }
        });

        timesB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicked3 = true;
                clicked = true;
                output.setText("*");
            }
        });

        divisionB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicked4 = true;
                clicked = true;
                output.setText("/");
            }
        });

        resetB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                output.setText("");
                n1 = null;
                n2 = null;
                clicked1 = false;
                clicked2 = false;
                clicked3 = false;
                clicked4 = false;
                clicked = false;
                outputNumber = 0;
            }
        });

        equalsB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(clicked1 == true)
                {
                    outputNumber = n1 + n2;
                    output.setText("" + outputNumber);
                }
                else if(clicked2 == true)
                {
                    outputNumber = n1 - n2;
                    output.setText("" + outputNumber);
                }
                else if(clicked3 == true)
                {
                    outputNumber = n1 * n2;
                    output.setText("" + outputNumber);
                }
                else if(clicked4 == true)
                {
                    outputNumber = n1 / n2;
                    output.setText("" + outputNumber);
                }

                n1 = null;
                n2 = null;
                clicked1 = false;
                clicked2 = false;
                clicked3 = false;
                clicked4 = false;
                clicked = false;
                outputNumber = 0;
            }
        });

        aboutB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AboutActivity.class);

                startActivity(intent);
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
