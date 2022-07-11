package com.example.login_app.loginRegister.activities;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.login_app.R;

public class AssuranceManagement extends AppCompatActivity {
    Button btnContactUs;
    Button btnPayment;
    Button btnContractRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assurance_management);
        getSupportActionBar().setTitle("Assurance");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String phone = "+212 6244-14225";
        String message = "Bonjour, j'ai une probleme en ...!";

        btnContactUs = (Button) findViewById(R.id.appCompatTextViewContactUs);
        btnContactUs.setOnClickListener(v -> {
            boolean installed = isAppInstalled("com.whatsapp");
            if (installed) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://api.whatsapp.com/send?phone=" + phone + "&text=" + message));
                startActivity(intent);
            } else {
                Toast.makeText(AssuranceManagement.this, "Whatsapp is not installed!", Toast.LENGTH_SHORT).show();
            }
        });


        btnPayment = (Button) findViewById(R.id.appCompatButtonPayment);
        btnPayment.setOnClickListener(v -> {
            Intent intent = getPackageManager().getLaunchIntentForPackage("com.b3g.cih.online");
            if (intent != null) {
                // We found the activity now start the activity
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            } else {
                // Bring user to the market or let them choose an app?
                intent = new Intent(Intent.ACTION_VIEW);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setData(Uri.parse("https://play.google.com/store/apps/details?id=" + "com.b3g.cih.online"));
                startActivity(intent);
            }
        });

        btnContractRequest = (Button) findViewById(R.id.appCompatButtonContractRequest);
        btnContractRequest.setOnClickListener(view -> {
            startActivity(new Intent(AssuranceManagement.this, ContactRequest.class));
        });

        btnContractRequest = (Button) findViewById(R.id.appCompatButtonMyContrats);
        btnContractRequest.setOnClickListener(view -> {
            startActivity(new Intent(AssuranceManagement.this, MyContracts.class));
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
