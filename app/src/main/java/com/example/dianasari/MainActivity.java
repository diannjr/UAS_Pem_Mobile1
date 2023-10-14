package com.example.dianasari;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnlogin;
    Button btnsignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnlogin = (Button) findViewById(R.id.btn_login);
        btnlogin.setOnClickListener(this);
        btnsignup = (Button) findViewById(R.id.btn_signup);
        btnsignup.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                Intent btn_login = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(btn_login);
                break;
            case R.id.btn_signup:
                Intent btn_signup = new Intent(MainActivity.this, SignupActivity.class);
                startActivity(btn_signup);
                break;
            default:
                break;
        }
    }
}