package com.iseeapp.isee;

/**
 * Created by dare.fatimehin on 19/04/17.
 */

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.Toast;

import java.text.MessageFormat;

public class CustomGestureListener extends GestureDetector.SimpleOnGestureListener {
 private Context context;
    private int REL_SWIPE_MIN_DISTANCE;
    private int REL_SWIPE_MAX_OFF_PATH;
    private int REL_SWIPE_THRESHOLD_VELOCITY;

    public CustomGestureListener(Context context) {
        this.context = context;
        DisplayMetrics dm = context.getResources().getDisplayMetrics();
        REL_SWIPE_MIN_DISTANCE = (int)(120.0f * dm.densityDpi / 160.0f + 0.5);
        REL_SWIPE_MAX_OFF_PATH = (int)(250.0f * dm.densityDpi / 160.0f + 0.5);
        REL_SWIPE_THRESHOLD_VELOCITY = (int)(200.0f * dm.densityDpi / 160.0f + 0.5);
    }

    // Detect a single-click and call my own handler.
    @Override
    public boolean onSingleTapUp(MotionEvent e) {
//        ListView lv = getListView();
//        int pos = lv.pointToPosition((int)e.getX(), (int)e.getY());
        return false;
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        if (Math.abs(e1.getY() - e2.getY()) > REL_SWIPE_MAX_OFF_PATH)
            return false;
        if(e1.getX() - e2.getX() > REL_SWIPE_MIN_DISTANCE &&
                Math.abs(velocityX) > REL_SWIPE_THRESHOLD_VELOCITY) {
            onRTLFling();
        }  else if (e2.getX() - e1.getX() > REL_SWIPE_MIN_DISTANCE &&
                Math.abs(velocityX) > REL_SWIPE_THRESHOLD_VELOCITY) {
            onLTRFling();
        }
        return false;
    }

    private void myOnItemClick(int position) {
        String str = MessageFormat.format("Item clicked = {0,number}", position);
        Toast.makeText(context,"Want to add a new comment! Yipee!", Toast.LENGTH_SHORT).show();
    }

    private void onLTRFling() {
        Toast.makeText(context,"Want to add a new comment! Yipee!", Toast.LENGTH_SHORT).show();
    }

    private void onRTLFling() {
        Toast.makeText(context,"Want to add a new comment! Yipee!", Toast.LENGTH_SHORT).show();
    }

}
