package com.example.login_app.loginRegister.activities;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.login_app.R;
import com.example.login_app.loginRegister.Sql.DatabaseHelper;
import com.example.login_app.loginRegister.helpers.InputValidationDem;
import com.example.login_app.loginRegister.modal.DemandeAss;
import com.google.android.material.snackbar.Snackbar;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ContactRequest extends AppCompatActivity implements View.OnClickListener {
    private final AppCompatActivity activity = ContactRequest.this;
    private Dialog dialog;
    private ScrollView ScrollView;
    private Button ShowDialog;


    EditText last_name, first_name, type, birthday, city, tele, numPermis;
    EditText immat, module, marque, carburant, puissance, dateMisEnCirculation, dateDemande;
    private int mYear, mMonth, mDay, permis1;
  //  private double puissance1;
    private InputValidationDem inputValidationDem;
    private DatabaseHelper databaseHelper;
    private DemandeAss demandeAss;
    //private ScrollView scrollView;

    private Button btnNext;
    private SimpleDateFormat simpleDateFormat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_request);
        getSupportActionBar().setTitle("Contrat Request");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initView();
        initListeners();
        initObjects();
    }

    public void initView() {
        ScrollView = (ScrollView) findViewById(R.id.ScrollView);
        last_name = (EditText) findViewById(R.id.last_name);
        first_name = (EditText) findViewById(R.id.first_name);
        birthday = (EditText) findViewById(R.id.Birthday);
        city = (EditText) findViewById(R.id.city);
        tele = (EditText) findViewById(R.id.tele);
        numPermis = (EditText) findViewById(R.id.numPermis);
        immat = (EditText) findViewById(R.id.immat);
        module = (EditText) findViewById(R.id.module);
        marque = (EditText) findViewById(R.id.marque);
        carburant = (EditText) findViewById(R.id.carburant);
        puissance = (EditText) findViewById(R.id.puissance);
        dateMisEnCirculation = (EditText) findViewById(R.id.dateMisEnCirculation);
        type = (EditText) findViewById(R.id.type);
        dateDemande = (EditText) findViewById(R.id.dateDemande);
        btnNext = (Button) findViewById(R.id.btnNext);
        birthday.setOnClickListener(this);
        dateMisEnCirculation.setOnClickListener(this);
        dateDemande.setOnClickListener(this);

    }

    private void initListeners() {
        btnNext.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {

        if (view != birthday) {
        } else {
          final   Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);


            DatePickerDialog datePickerDialog = new DatePickerDialog(ContactRequest.this,
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {

                            birthday.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                        }
                    }, mYear, mMonth, mDay);
            datePickerDialog.show();
        }
        if (view == dateMisEnCirculation) {
            final Calendar c2 = Calendar.getInstance();
            mYear = c2.get(Calendar.YEAR);
            mMonth = c2.get(Calendar.MONTH);
            mDay = c2.get(Calendar.DAY_OF_MONTH);


            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {

                            dateMisEnCirculation.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                        }
                    }, mYear, mMonth, mDay);
            datePickerDialog.show();
        }
        if (view == dateDemande) {
            final Calendar c3 = Calendar.getInstance();
            mYear = c3.get(Calendar.YEAR);
            mMonth = c3.get(Calendar.MONTH);
            mDay = c3.get(Calendar.DAY_OF_MONTH);


            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {

                            dateDemande.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                        }
                    }, mYear, mMonth, mDay);
            datePickerDialog.show();
        }
        if (view == btnNext) {
            if (!inputValidationDem.isInputEditTextFilledDem(last_name, "enter valid Last Name")) {
                return;
            }
            if (!inputValidationDem.isInputEditTextFilledDem(first_name, "enter valid First Name")) {
                return;
            }

            if (!inputValidationDem.isInputEditTextFilledDem(birthday, "enter your Birdthay")) {
                return;
            }
            if (!inputValidationDem.isInputEditTextFilledDem(city, "enter your City")) {
                return;
            }
            if (!inputValidationDem.isInputEditTextFilledDem(tele, "enter valid ")) {
                return;
            }
            if (!inputValidationDem.isValidMobile(tele, "enter valid Phone")) {

                return;
            }
            if (!inputValidationDem.isInputEditTextFilledDem(numPermis, "enter num Permis")) {
                return;
            }
            if (!inputValidationDem.isInputEditTextFilledDem(immat, "enter car registration ")) {
                return;
            }
            if (!inputValidationDem.isInputEditTextFilledDem(module, "enter car mod")) {
                return;
            }
            if (!inputValidationDem.isInputEditTextFilledDem(marque, "enter car brand")) {
                return;
            }
            if (!inputValidationDem.isInputEditTextFilledDem(carburant, "enter car fuel")) {
                return;
            }
            if (!inputValidationDem.isInputEditTextFilledDem(puissance, "enter car power")) {
                return;
            }
            if (!inputValidationDem.isInputEditTextFilledDem(dateMisEnCirculation, "enter date put into circulation car")) {
                return;
            }
            if (!inputValidationDem.isInputEditTextFilledDem(type, "enter valid First Name")) {
                return;
            }
            if (!inputValidationDem.isInputEditTextFilledDem(first_name, "enter Type of contract")) {
                return;
            }
            if (!inputValidationDem.isInputEditTextFilledDem(dateDemande, "enter request date")) {
                return;

            }
            if (!databaseHelper.checkDemande(immat.getText().toString().trim())) {

                demandeAss.setFirst_name(first_name.getText().toString().trim());
                demandeAss.setTele(tele.getText().toString().trim());
                demandeAss.setBirdthay(birthday.getText().toString().trim());
                demandeAss.setCity(city.getText().toString().trim());
                demandeAss.setPermis(Integer.parseInt(numPermis.getText().toString().trim()));
                demandeAss.setImmat(immat.getText().toString().trim());
                demandeAss.setModule(module.getText().toString().trim());
                demandeAss.setMarque(marque.getText().toString().trim());
                demandeAss.setCarburant(carburant.getText().toString().trim());
                demandeAss.setPuissance(puissance.getText().toString().trim());
                demandeAss.setDateMisEnCirculation(dateMisEnCirculation.getText().toString().trim());
                demandeAss.setType(type.getText().toString().trim());
                demandeAss.setDateDem(dateDemande.getText().toString().trim());
                if (databaseHelper.addDemande(demandeAss))
                    next();
                // Snack Bar to show success message that record saved successfully
                // Snackbar.make(ScrollView, getString(R.string.success_message), Snackbar.LENGTH_LONG).show();
                // emptyInputEditText();

            } else {
                // Snack Bar to show error message that record already exists
                Snackbar.make(ScrollView, getString(R.string.error_email_exists), Snackbar.LENGTH_LONG).show();
            }
        }
    }

    public void next() {
        //Create the Dialog here
        dialog = new Dialog(this);
        dialog.setContentView(R.layout.activity_congratulation);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            dialog.getWindow().setBackgroundDrawable(getDrawable(R.drawable.cong_background));
        }
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(false); //Optional
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation; //Setting the animations to dialog

        Button Okay = dialog.findViewById(R.id.btn_okay);
        Button Cancel = dialog.findViewById(R.id.btn_cancel);

        Okay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(ContactRequest.this, "Okay", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
                emptyInputEditText();

            }
        });


        Cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(ContactRequest.this, "Cancel", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });


        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.show(); // Showing the dialog here
            }
        });
    }


    private void initObjects() {
        inputValidationDem = new InputValidationDem(activity);
        databaseHelper = new DatabaseHelper(activity);
        demandeAss = new DemandeAss();
    }

    private void emptyInputEditText() {
        last_name.setText(null);
        first_name.setText(null);
        birthday.setText(null);
        tele.setText(null);
        city.setText(null);
        numPermis.setText(null);
        immat.setText(null);
        marque.setText(null);
        module.setText(null);
        carburant.setText(null);
        puissance.setText(null);
        dateMisEnCirculation.setText(null);
        type.setText(null);
        dateDemande.setText(null);

    }
}