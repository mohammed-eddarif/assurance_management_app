package com.example.login_app.loginRegister.activities;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.login_app.R;

public class ChooseActivity extends AppCompatActivity {
    Button btnAssistance;
    Button btnAssurance;
    Button btnContactUs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        btnAssistance = (Button) findViewById(R.id.appCompatButtonAssistence);
        btnAssurance = (Button) findViewById(R.id.appCompatButtonAssurence);

        btnAssistance.setOnClickListener(view -> {
            startActivity(new Intent(ChooseActivity.this, AssistanceActivity.class));
        });

        btnAssurance.setOnClickListener(view -> {
            startActivity(new Intent(ChooseActivity.this, AssuranceManagement.class));
        });

        String phone = "+212 624-414225";
        String message = "Hi sir , how can we help you ?";
        btnContactUs = (Button) findViewById(R.id.appCompatButtonContactUs);
        Context context = this;

        btnContactUs.setOnClickListener(v -> {

            boolean installed = isAppInstalled("com.whatsapp");

            if (installed) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://api.whatsapp.com/send?phone=" + phone + "&text=" + message));
                startActivity(intent);

            } else {
                Toast.makeText(ChooseActivity.this, "Whatsapp is not installed!", Toast.LENGTH_SHORT).show();

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


}











