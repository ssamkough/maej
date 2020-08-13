package com.samkough.pop_up;

import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.PopupWindow;
import android.widget.Toast;

public class Pop_Ups extends AppCompatActivity
{
    private Button ppm;
    private Button btnShowPopup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop__ups);

        ppm = (Button) findViewById(R.id.popUpMenu);
        ppm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFilterPopup(v);
            }
        });

        // Locate the show popup button and attach click listener
        btnShowPopup = (Button) findViewById(R.id.ppw);
        btnShowPopup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Display popup attached to the button as a position anchor
                displayPopupWindow(v);
            }
        });
    }

    // Display anchored popup menu based on view selected
    private void showFilterPopup(View v) {
        PopupMenu popup = new PopupMenu(this, v);
        // Inflate the menu from xml
        popup.getMenuInflater().inflate(R.menu.popup_filters2, popup.getMenu());
        // Setup menu item selection
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_one:
                        Toast.makeText(Pop_Ups.this, "1", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.menu_two:
                        Toast.makeText(Pop_Ups.this, "2", Toast.LENGTH_SHORT).show();
                        return true;
                    default:
                        return false;
                }
            }
        });
        // Handle dismissal with: popup.setOnDismissListener(...);
        // Show the menu
        popup.show();
    }

    // Display popup attached to the button as a position anchor
    private void displayPopupWindow(View anchorView) {
        PopupWindow popup = new PopupWindow(Pop_Ups.this);
        View layout = getLayoutInflater().inflate(R.layout.popup_content, null);
        popup.setContentView(layout);
        // Set content width and height
        popup.setHeight(WindowManager.LayoutParams.WRAP_CONTENT);
        popup.setWidth(WindowManager.LayoutParams.WRAP_CONTENT);
        // Closes the popup window when touch outside of it - when looses focus
        popup.setOutsideTouchable(true);
        popup.setFocusable(true);
        // Show anchored to button
        popup.setBackgroundDrawable(new BitmapDrawable());
        popup.showAsDropDown(anchorView);
    }


    public void onBackPressed() {
        finish();
        overridePendingTransition(R.anim.from_middle, R.anim.to_middle);
    }

}
