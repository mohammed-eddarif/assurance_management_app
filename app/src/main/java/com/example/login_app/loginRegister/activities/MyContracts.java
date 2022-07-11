package com.example.login_app.loginRegister.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;

import com.example.login_app.R;

public class MyContracts extends AppCompatActivity {
    AppCompatTextView last_name, type, birthday, city, tele, numPermis, immat, module, marque, carburant, puissance,
            dateMisEnCirculation, typeContract, dateEffective, dateDeadline, prime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_contracts);

        last_name = findViewById(R.id.textViewListeNamec);
        type = findViewById(R.id.textViewTypec);
        birthday = findViewById(R.id.textViewBirthayc);
        city = findViewById(R.id.textViewCityc);
        tele = findViewById(R.id.textViewPhonec);
        numPermis = findViewById(R.id.textViewPermitc);
        immat = findViewById(R.id.textViewListeImmatc);
        module = findViewById(R.id.textViewModulec);
        marque = findViewById(R.id.textViewMarkc);
        carburant = findViewById(R.id.textViewFuelc);
        puissance = findViewById(R.id.textViewPowerFulc);
        dateMisEnCirculation = findViewById(R.id.textViewDateCirculationc);
        typeContract = findViewById(R.id.textViewTypec);
        dateEffective = findViewById(R.id.textViewDateEffectc);
        dateDeadline = findViewById(R.id.textViewDateDeadlinec);
        prime = findViewById(R.id.textViewPrimec);


        last_name.setText("mourad");
        birthday.setText("11-05-2000");
        city.setText("Tanger");
        tele.setText( "0624414225");
        numPermis.setText("11122");
        immat.setText("1-A-122555");
        module.setText("2017");
        marque.setText("Mercedes 220");
        carburant.setText("Diesel");
        puissance.setText("12");
        dateMisEnCirculation.setText("30-05-2018");
        typeContract.setText("Toutes options");
        dateEffective.setText("11-06-2018");
        dateDeadline.setText("11-05-2023");
        prime.setText("3000DH");

    }}

