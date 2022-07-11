package com.example.login_app.loginRegister.activities;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.login_app.R;
import com.example.login_app.loginRegister.Sql.DatabaseHelper;
import com.example.login_app.loginRegister.adapters.DemandeListAdapter;

public class ListeDemande extends AppCompatActivity {
    private ListView listViewDemande;
    private DemandeListAdapter demande;
    private View view;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_demande);
        getSupportActionBar().setTitle("List of Requests");

        initView();
        loadFromDBToMemory();
       // setNoteAdapter();
        setOnClickListener();
    }


    private void loadFromDBToMemory() {
        DatabaseHelper databaseHelper = new DatabaseHelper(getApplicationContext());
      //  databaseHelper.getAllDemande();

       // AlertDialog.Builder listViewDemande;
       if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
           listViewDemande.setAdapter( new DemandeListAdapter(getApplicationContext()
                   ,R.layout.demande_item, databaseHelper.getAllDemande()));
    }
    }


    private void setOnClickListener()
    {
        listViewDemande.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l)
            {
               Intent intent = new Intent(getApplicationContext(), DetailDemande.class);
               intent.putExtra("position",position);
               startActivity(intent);
            }
        });
    }



    private void initView() {
        listViewDemande = findViewById(R.id.listViewDemande);
    }

}