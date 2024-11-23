package com.example.trascau_teodor_bogdan_1101;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button Add;
    Button Detalii;
    ListView lvFacturi;
    List<Factura> list = new ArrayList<>();

    ActivityResultLauncher<Intent> launcher;
    private final String FACTURA_KEY = "NEW_FACTURA";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Init();

        Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),AddActivity.class);
                launcher.launch(intent);
            }
        });

        Detalii.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), DetaliiActivity2.class);
                startActivity(intent);
            }
        });
    }

    void  Init()
    {
        Add = findViewById(R.id.btnAdauga);
        Detalii = findViewById(R.id.btnDescriere);
        lvFacturi = findViewById(R.id.lvFactura);
        launcher = createLauncher();
    }

    ActivityResultCallback<ActivityResult> createCallback()
    {
        return new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult o) {
                if(o.getResultCode()==RESULT_OK && o.getData()!=null)
                {
                    Factura f = (Factura)o.getData().getSerializableExtra(FACTURA_KEY);
                    list.add(f);
                    populate();
                }
            }
        };
    }

    ActivityResultLauncher<Intent> createLauncher()
    {
        ActivityResultCallback<ActivityResult> callback = createCallback();
        return registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),callback);
    }

    void populate()
    {
        FacturaAdapter adapter = new FacturaAdapter(getApplicationContext(),R.layout.lv_row,list,getLayoutInflater());
        lvFacturi.setAdapter(adapter);
    }
}