package com.samkough.mathercise;

import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.PopupWindow;

public class DivisionActivity extends AppCompatActivity
{
    private Button answer4_1, answer4_2, answer4_3, answer4_4;

    int height = 160;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_division);

        answer4_1 = (Button) findViewById(R.id.answer4_1);
        answer4_1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                // Display popup attached to the button as a position anchor
                displayPopupWindowWrong(v);
            }
        });

        answer4_2 = (Button) findViewById(R.id.answer4_2);
        answer4_2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                // Display popup attached to the button as a position anchor
                displayPopupWindowWrong(v);
            }
        });

        answer4_3 = (Button) findViewById(R.id.answer4_3);
        answer4_3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                // Display popup attached to the button as a position anchor
                displayPopupWindowRight(v);
            }
        });

        answer4_4 = (Button) findViewById(R.id.answer4_4);
        answer4_4.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                // Display popup attached to the button as a position anchor
                displayPopupWindowWrong(v);
            }
        });
    }

    // Display popup attached to the button as a position anchor
    private void displayPopupWindowRight(View anchorView)
    {
        PopupWindow popup = new PopupWindow(DivisionActivity.this);
        View layout = getLayoutInflater().inflate(R.layout.popup_content, null);
        popup.setContentView(layout);
        // Set content width and height
        popup.setHeight(height);
        popup.setWidth(WindowManager.LayoutParams.WRAP_CONTENT);
        // Closes the popup window when touch outside of it - when looses focus
        popup.setOutsideTouchable(true);
        popup.setFocusable(true);
        // Show anchored to button
        popup.setBackgroundDrawable(new BitmapDrawable());
        popup.showAsDropDown(anchorView);
    }

    private void displayPopupWindowWrong(View anchorView)
    {
        PopupWindow popup = new PopupWindow(DivisionActivity.this);
        View layout = getLayoutInflater().inflate(R.layout.popup_content_2, null);
        popup.setContentView(layout);
        // Set content width and height
        popup.setHeight(height);
        popup.setWidth(WindowManager.LayoutParams.WRAP_CONTENT);
        // Closes the popup window when touch outside of it - when looses focus
        popup.setOutsideTouchable(true);
        popup.setFocusable(true);
        // Show anchored to button
        popup.setBackgroundDrawable(new BitmapDrawable());
        popup.showAsDropDown(anchorView);
    }

    public void onBackPressed()
    {
        finish();
        overridePendingTransition(R.anim.left_in, R.anim.right_out);
    }

}
