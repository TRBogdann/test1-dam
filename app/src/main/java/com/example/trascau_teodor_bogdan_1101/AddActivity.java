package com.example.trascau_teodor_bogdan_1101;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class AddActivity extends AppCompatActivity {


    EditText cod;
    EditText categorie;
    EditText suma;
    EditText descriere;
    Button btnSave;
    private final String FACTURA_KEY = "NEW_FACTURA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Init();

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try
                {
                    long fCode  = Long.parseLong(cod.getText().toString());
                    float fSuma = Float.parseFloat(suma.getText().toString());
                    String fCategorie = categorie.getText().toString();
                    String fDescriere = categorie.getText().toString();

                    if(fCategorie.isEmpty() || fCode<0 || fSuma<0.1f)
                        throw new RuntimeException();

                    Factura f = new Factura(fCode,fCategorie,fSuma,fDescriere);

                    getIntent().putExtra(FACTURA_KEY,f);
                    setResult(RESULT_OK,getIntent());
                    finish();
                }
                catch(Exception e)
                {
                    Toast.makeText(getApplicationContext(),"Invalid Data",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    void Init()
    {
        cod = findViewById(R.id.etCod);
        categorie = findViewById(R.id.etCategorie);
        suma = findViewById(R.id.etSuma);
        btnSave = findViewById(R.id.btnSave);
    }
}