package com.example.login_app.loginRegister.activities;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;

import com.example.login_app.R;
import com.example.login_app.loginRegister.modal.DemandeAss;

import java.util.List;

public class DetailDemande extends AppCompatActivity {
    AppCompatTextView first_name, type, birthday, city, tele, numPermis, immat, module, marque, carburant, puissance,
            dateMisEnCirculation, dateDemande;

    int position;
    private List<DemandeAss> demande;
    String name, bir, phone, ville, permit, imm, mod, marq, car, puiss, dateM, typeC, dateD;
    Button accept;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_demande);
        initWidgets();
//        getAndSetIntentData();


        name = "mourad";
        bir = "11-05-2000";
        ville = "Tanger";
        phone = "0624414225";
        permit = "11122";
        imm = "1-A-122555";
        mod = "2017";
        marq = "Mercedes 220";
        car = "Diesel";
        puiss = "12";
        dateM = "30-05-2018";
        typeC = "Toutes options";
        dateD = "11-06-2018";


        first_name.setText(name);
        birthday.setText(bir);
        city.setText(ville);
        tele.setText(phone);
        numPermis.setText(permit);
        immat.setText(imm);
        module.setText(mod);
        marque.setText(marq);
        carburant.setText(car);
        puissance.setText(puiss);
        dateMisEnCirculation.setText(dateM);
        type.setText(typeC);
        dateDemande.setText(dateD);

        accept = (Button) findViewById(R.id.btnAccepted);
        String message = "Hi sir , your request is accepted you can pass to pay your contract .";

        accept.setOnClickListener(v -> {

            boolean installed = isAppInstalled("com.whatsapp");

            if (installed) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://api.whatsapp.com/send?phone=" + phone + "&text=" + message));
                startActivity(intent);

            } else {
                Toast.makeText(DetailDemande.this, "Whatsapp is not installed!", Toast.LENGTH_SHORT).show();

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

    private void initWidgets() {
        first_name = findViewById(R.id.textViewListeName);
        type = findViewById(R.id.textViewType);
        birthday = findViewById(R.id.textViewBirthay);
        city = findViewById(R.id.textViewCity);
        tele = findViewById(R.id.textViewPhone);
        numPermis = findViewById(R.id.textViewPermit);
        immat = findViewById(R.id.textViewListeImmat);
        module = findViewById(R.id.textViewModule);
        marque = findViewById(R.id.textViewMark);
        carburant = findViewById(R.id.textViewFuel);
        puissance = findViewById(R.id.textViewPowerFul);
        dateMisEnCirculation = findViewById(R.id.textViewDateCirculation);
        dateDemande = findViewById(R.id.textViewDateDemande);


    }
//    void getAndSetIntentData() {
//        if (getIntent().hasExtra("immat") && getIntent().hasExtra("birthay") &&
//                getIntent().hasExtra("city") && getIntent().hasExtra("tele")&& getIntent().hasExtra("numPermit")
//                && getIntent().hasExtra("immat")&& getIntent().hasExtra("module")
//                && getIntent().hasExtra("marque")&& getIntent().hasExtra("carburant")
//                && getIntent().hasExtra("puissance")&& getIntent().hasExtra("dateMisEnCirculation")&& getIntent().hasExtra("type")
//                && getIntent().hasExtra("dateDemande")) {
//            //Getting Data from Intent
//            name = getIntent().getStringExtra("name");
//            bir = getIntent().getStringExtra("birthay");
//            ville = getIntent().getStringExtra("city");
//            phone = getIntent().getStringExtra("tele");
//            permit= getIntent().getStringExtra("numPermit");
//            imm = getIntent().getStringExtra("immat");
//            mod = getIntent().getStringExtra("module");
//            marq = getIntent().getStringExtra("marque");
//            car= getIntent().getStringExtra("carburant");
//            puiss = getIntent().getStringExtra("puissance");
//            dateM = getIntent().getStringExtra("dateMisEnCirculation");
//            typeC = getIntent().getStringExtra("type");
//            dateD = getIntent().getStringExtra("dateDemande");
//
//            //Setting Intent Data
//           first_name.setText(name);
//            birthday.setText(bir);
//            city.setText(ville);
//            //Log.d("stev", first_name+" "+birthday+" "+city);
//        } else {
//            Toast.makeText(this, "No data.", Toast.LENGTH_SHORT).show();
//
//            name = getIntent().getStringExtra("name");
//            first_name.setText(name);
//
////            name= getIntent().getStringExtra("name");
////            bir = getIntent().getStringExtra("birthay");
////            ville = getIntent().getStringExtra("city");
////
////            first_name.setText(name);
////            birthday.setText(bir);
////            city.setText(ville);
//        }
}

//}
//}