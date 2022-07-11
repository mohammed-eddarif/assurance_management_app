package com.example.login_app.loginRegister.activities;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import androidx.core.widget.NestedScrollView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.login_app.R;


public class Identifier extends AppCompatActivity {

    Button btnContactUs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_identifier);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        String phone = "+212 06244 14225";
        String message = "Hi sir , how can we help you ?";
        btnContactUs = (Button) findViewById(R.id.appCompatTextViewContactUs);

        btnContactUs.setOnClickListener(v -> {

            boolean installed = isAppInstalled("com.whatsapp");

            if (installed) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://api.whatsapp.com/send?phone=" + phone + "&text=" + message));
                startActivity(intent);
            } else {
                Toast.makeText(Identifier.this, "Whatsapp is not installed!", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private boolean isAppInstalled(String s) {
        PackageManager packageManager = getPackageManager();
        boolean is_installed;

        try {
            packageManager.getPackageInfo(s, PackageManager.GET_ACTIVITIES);
            is_installed = true;
        } catch (PackageManager.NameNotFoundException e) {
            is_installed = false;
            e.printStackTrace();
        }
        return is_installed;
    }

    public void ToUserLogin(View v){
        Intent i = new Intent(this, LoginActivity.class);
        startActivity(i);
    }

}