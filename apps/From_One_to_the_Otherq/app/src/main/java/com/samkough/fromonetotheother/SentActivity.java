package com.samkough.fromonetotheother;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class SentActivity extends AppCompatActivity {

    private TextView text;
    private String stuff, st;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sent);

        //Get the bundle
        Bundle bundle = getIntent().getExtras();
        stuff = bundle.getString("arg");

        text = (TextView) findViewById(R.id.text);
        st = "Sent Text:";

        text.setText(st + " " + stuff);
    }

}
