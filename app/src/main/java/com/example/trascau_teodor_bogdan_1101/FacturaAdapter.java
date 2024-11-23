package com.example.trascau_teodor_bogdan_1101;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class FacturaAdapter extends ArrayAdapter<Factura> {

    int resource;
    List<Factura> list;
    LayoutInflater inflater;
    public FacturaAdapter(@NonNull Context context, int resource, @NonNull List<Factura> objects, LayoutInflater inflater) {
        super(context, resource, objects);
        this.resource = resource;
        this.inflater = inflater;
        this.list = objects;
    }
    void Init(View row, Factura f, int position)
    {
        TextView categorie = row.findViewById(R.id.tvCategorie);
        TextView suma = row.findViewById(R.id.tvSuma);

        if(position%2==0)
        {
            categorie.setBackgroundColor(row.getResources().getColor(R.color.green));
        }
        else
            categorie.setBackgroundColor(row.getResources().getColor(R.color.red));

        categorie.setText(f.getCategorie());
        suma.setText(String.valueOf(f.getSuma()));
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = inflater.inflate(this.resource,parent,false);
        Factura f = list.get(position);
        Init(row,f,position);
        return row;
    }
}
