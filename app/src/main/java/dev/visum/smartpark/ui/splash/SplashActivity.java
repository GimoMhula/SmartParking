package dev.visum.smartpark.ui.splash;

import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.Nullable;
import dev.visum.smartpark.MainActivity;
import dev.visum.smartpark.R;
import dev.visum.smartpark.model.BaseActivity;
import dev.visum.smartpark.ui.login.LoginActivity;

public class SplashActivity extends BaseActivity {
    private final int SPLASH_TIME_OUT= 2000; // 1 sec
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startMyActivity(LoginActivity.class);
                finish();
            }
        },SPLASH_TIME_OUT);
    }
}
