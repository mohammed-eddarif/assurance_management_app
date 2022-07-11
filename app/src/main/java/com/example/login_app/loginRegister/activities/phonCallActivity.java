package com.example.login_app.loginRegister.activities;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.login_app.R;

public class phonCallActivity extends AppCompatActivity {

    private static final int REQUEST_CALL = 1;
    private TextView callText, callText2, callText3, callText4;
    private Button callBtn, callBtn2, callBtn3, callBtn4;
    Button btnContactUs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phon_call);
        getSupportActionBar().setTitle("Urgence Phones");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        callBtn = findViewById(R.id.callButton);
        callBtn2 = findViewById(R.id.callButton2);
        callBtn3 = findViewById(R.id.callButton3);
        callBtn4 = findViewById(R.id.callButton4);
        callBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:19")));
                CallButton();
            }


        });

        callBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:19")));
                CallButton2();
            }


        });
        callBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:19")));
                CallButton3();
            }


        });
        callBtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:19")));
                CallButton4();
            }


        });


        String phone = "+212 06244 14225";
        String message = "Bonjour, j'ai une probleme en ...!";
        btnContactUs = (Button) findViewById(R.id.appCompatTextViewContactUs);

        btnContactUs.setOnClickListener(v -> {

            boolean installed = isAppInstalled("com.whatsapp");

            if (installed) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://api.whatsapp.com/send?phone=" + phone + "&text=" + message));
                startActivity(intent);
            } else {
                Toast.makeText(phonCallActivity.this, "Whatsapp is not installed!", Toast.LENGTH_SHORT).show();
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






    private void CallButton(){
        String number="19";
        if(number.trim().length()>0){
            if(ContextCompat.checkSelfPermission( phonCallActivity.this,Manifest.permission.CALL_PHONE )!=PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(phonCallActivity.this,new String[] {Manifest.permission.CALL_PHONE},REQUEST_CALL);
            }
            else{
                String dial="tel:"+number;
                startActivity(new Intent(Intent.ACTION_CALL,(Uri.parse(dial))));
            }
        }

    }
    private void CallButton2(){
        String number="15";
        if(number.trim().length()>0){
            if(ContextCompat.checkSelfPermission( phonCallActivity.this,Manifest.permission.CALL_PHONE )!=PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(phonCallActivity.this,new String[] {Manifest.permission.CALL_PHONE},REQUEST_CALL);
            }
            else{
                String dial="tel:"+number;
                startActivity(new Intent(Intent.ACTION_CALL,(Uri.parse(dial))));
            }
        }

    }
    private void CallButton3(){
        String number="177";
        if(number.trim().length()>0){
            if(ContextCompat.checkSelfPermission( phonCallActivity.this,Manifest.permission.CALL_PHONE )!=PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(phonCallActivity.this,new String[] {Manifest.permission.CALL_PHONE},REQUEST_CALL);
            }
            else{
                String dial="tel:"+number;
                startActivity(new Intent(Intent.ACTION_CALL,(Uri.parse(dial))));
            }
        }

    }
    private void CallButton4(){
        String number="150";
        if(number.trim().length()>0){
            if(ContextCompat.checkSelfPermission( phonCallActivity.this,Manifest.permission.CALL_PHONE )!=PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(phonCallActivity.this,new String[] {Manifest.permission.CALL_PHONE},REQUEST_CALL);
            }
            else{
                String dial="tel:"+number;
                startActivity(new Intent(Intent.ACTION_CALL,(Uri.parse(dial))));
            }
        }

    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode==REQUEST_CALL){
            if(grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
               CallButton();
                CallButton2();
                CallButton3();
                CallButton4();
            }else{
                Toast.makeText(this, "permission DENIED", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
         

