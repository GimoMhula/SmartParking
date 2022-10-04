package dev.visum.smartpark.ui.login;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.snackbar.Snackbar;

import dev.visum.smartpark.MainActivity;
import dev.visum.smartpark.R;
import dev.visum.smartpark.model.BaseActivity;

public class SignUpActivity extends BaseActivity {

    private View parent_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_card_overlap);

        parent_view = findViewById(android.R.id.content);

        ((View) findViewById(R.id.sign_up)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startMyActivity(LoginActivity.class);
                Snackbar.make(parent_view, "Login", Snackbar.LENGTH_SHORT).show();
            }
        });
        ((View) findViewById(R.id.btn_login)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startMyActivity(LoginActivity.class);
                finish();
            }
        });

//        Tools.setSystemBarColor(this);
    }
}
