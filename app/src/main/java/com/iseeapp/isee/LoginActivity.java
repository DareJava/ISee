package com.iseeapp.isee;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
    private LinearLayout loginLyt, recoverLyt;
    private TextView toggleRecover, signUpTextView;
    private static final String REC_PASSWORD = "Forgot Password?";
    private static final String LOGIN = "Login";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginLyt = (LinearLayout) findViewById(R.id.loginLyt);
        recoverLyt = (LinearLayout) findViewById(R.id.recoverLyt);

        toggleRecover = (TextView) findViewById(R.id.forgotPassword);
        signUpTextView = (TextView) findViewById(R.id.signUpTextView);
        signUpTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchActivity(SignUpActivity.class);
            }
        });;

        toggleRecover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (loginLyt.getVisibility() == View.VISIBLE ) {
                    toggleRecover.setText(LOGIN);
                    recoverLyt.setVisibility(View.VISIBLE);
                    loginLyt.setVisibility(View.GONE);
                    loginLyt.animate().alpha(0.0f).setDuration(300);
                    recoverLyt.animate().alpha(1.0f).setDuration(300);
                } else {
                    toggleRecover.setText(REC_PASSWORD);
                    recoverLyt.setVisibility(View.GONE);
                    loginLyt.setVisibility(View.VISIBLE);
                    loginLyt.animate().alpha(1.0f).setDuration(300);
                    recoverLyt.animate().alpha(0.0f).setDuration(300);
                }
            }
        });;
    }

    private void launchActivity(Class clazz) {
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
    }
}
