package dev.visum.smartpark.ui.login;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import dev.visum.smartpark.MainActivity;
import dev.visum.smartpark.R;
import dev.visum.smartpark.model.BaseActivity;
import dev.visum.smartpark.ui.manager.ManagerActivity;

public class LoginActivity extends BaseActivity {

    private View parent_view;
    private EditText email,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_card_overlap);

        parent_view = findViewById(android.R.id.content);

        email=findViewById(R.id.tf_email);
        password=findViewById(R.id.tf_password);



        ((View) findViewById(R.id.sign_up)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                startMyActivity(SignUpActivity.class);
                Snackbar.make(parent_view, "Registar", Snackbar.LENGTH_SHORT).show();
            }
        });
        ((View) findViewById(R.id.btn_login)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(email.getText().toString().contains("admin")){
                    startMyActivity(ManagerActivity.class);
                    finish();
                }else{
                    startMyActivity(MainActivity.class);
                    finish();
                }


            }
        });

//        Tools.setSystemBarColor(this);
    }
}
