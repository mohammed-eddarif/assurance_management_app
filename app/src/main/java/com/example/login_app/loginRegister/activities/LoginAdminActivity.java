package com.example.login_app.loginRegister.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.login_app.R;

public class LoginAdminActivity extends AppCompatActivity {
    EditText userName;
    EditText password;
    Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_admin);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        userName = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        btnLogin = (Button) findViewById(R.id.login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(userName.getText().toString().equals("myassurance")&&(password.getText().toString().equals("myassurance"))){
                    Intent i = new Intent(LoginAdminActivity.this, AdminChooseActivity.class);
                    startActivity(i);
                }
                else{
                    Toast.makeText(LoginAdminActivity.this,"Wrong username and password",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}