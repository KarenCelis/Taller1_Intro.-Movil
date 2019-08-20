package com.example.fibonaci;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DetallePais extends AppCompatActivity {
    TextView capital;
    TextView nombreR;
    TextView sigla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_pais);

        capital = findViewById(R.id.capital);
        nombreR = findViewById(R.id.nombreR);
        sigla = findViewById(R.id.sigla);
        capital.setText("Capital: " + getIntent().getStringExtra("Capital"));
        nombreR.setText("Nombre Real: " + getIntent().getStringExtra("nombre_rea"));
        sigla.setText("Sigla: " + getIntent().getStringExtra("sigla"));

    }
}
