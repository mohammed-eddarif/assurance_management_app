package com.example.login_app.loginRegister.activities;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.example.login_app.R;

public class AssistanceActivity extends AppCompatActivity {
    Button btnCall;
    Button btnLocation;
    Button btnContactUs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assistance);
        getSupportActionBar().setTitle("Assistance");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btnCall = (Button) findViewById(R.id.appCompatButtonUrgencePhon);
        btnLocation = (Button) findViewById(R.id.appCompatButtonLocation);

        btnCall.setOnClickListener(view -> {
            startActivity(new Intent(AssistanceActivity.this, phonCallActivity.class));
        });

        btnLocation.setOnClickListener(view -> {
            startActivity(new Intent(AssistanceActivity.this, CurrentLocation.class));
        });

        String phone = "+212 6244-14225";
        String message = "Hi sir , how can we help you ?";
        btnContactUs = (Button) findViewById(R.id.appCompatTextViewContactUs);

        btnContactUs.setOnClickListener(v -> {

            boolean installed = isAppInstalled("com.whatsapp");

            if (installed) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://api.whatsapp.com/send?phone=" + phone + "&text=" + message));
                startActivity(intent);
            } else {
                Toast.makeText(AssistanceActivity.this, "Whatsapp is not installed!", Toast.LENGTH_SHORT).show();
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