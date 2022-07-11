package com.example.login_app.loginRegister.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.login_app.R;
import com.example.login_app.loginRegister.modal.DemandeAss;

import java.util.List;

public class DemandeListAdapter extends ArrayAdapter<DemandeAss> {

    private Context context;
    private int layout;
    private List<DemandeAss> demande;
    LinearLayout mainLayout;
    public DemandeListAdapter(@NonNull Context context, int resource, @NonNull List<DemandeAss> objects) {
        super(context, resource, objects);
        this.context = context;
        this.layout = resource;
        this.demande = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        DemandeAss demandeAss = demande.get(position);
        if (convertView == null)
            convertView = LayoutInflater.from(context).inflate(R.layout.demande_item, parent, false);
        TextView textViewDemande = convertView.findViewById(R.id.textViewDemande);
        TextView textViewDate = convertView.findViewById(R.id.textViewDate);

        textViewDemande.setText(demandeAss.getImmat());
        textViewDate.setText(demandeAss.getDateDem());


        return convertView;
    }

}
