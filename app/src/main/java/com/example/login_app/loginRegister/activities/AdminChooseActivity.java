package com.example.login_app.loginRegister.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.login_app.R;

public class AdminChooseActivity extends AppCompatActivity {
    Button btnRequest;
    Button btnAssurance;
    Button btnSignOut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_choose);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        btnRequest = (Button) findViewById(R.id.appCompatButtonRequest);
        btnAssurance = (Button) findViewById(R.id.appCompatButtonAssurence);
        btnSignOut = (Button) findViewById(R.id.appCompatSignOut);
        btnRequest.setOnClickListener(view -> {
            startActivity(new Intent(AdminChooseActivity.this,ListeDemande.class));
        });
        btnSignOut.setOnClickListener(view -> {
            startActivity(new Intent(AdminChooseActivity.this,Identifier.class));
        });

    }
}