package com.iseeapp.isee;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;

import de.keyboardsurfer.android.widget.crouton.Crouton;
import de.keyboardsurfer.android.widget.crouton.Style;

public class SignUpActivity extends AppCompatActivity {

    private boolean shouldAllowregister = false;

    private static final String DISALLOW_REG = "You have not agreed to our terms and conditions, please tick the checkbox to continue!";
    private static final String YES_YOU_CAN = "Yes! Wellcome!";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }

    public void toggleAllowRegister(View v) {
        shouldAllowregister = !shouldAllowregister;
    }

    public void registerUser(View v) {
        if (shouldAllowregister) {
            Crouton.makeText(this, YES_YOU_CAN, setCroutonStyle()).show();
        } else {
            Crouton.makeText(this, DISALLOW_REG, Style.ALERT).show();

        }

    }

    private Style setCroutonStyle() {

        Style style = new Style.Builder()
                .setBackgroundColor(R.color.cardview_dark_background)
                .setTextColor(android.R.color.white)
                .build();
        return style;
    }
}
