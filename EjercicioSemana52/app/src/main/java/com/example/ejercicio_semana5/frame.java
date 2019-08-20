package com.example.ejercicio_semana5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class frame extends AppCompatActivity {
TextView usu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame);
        usu=findViewById(R.id.nombreUsuario);

        usu.setText(getIntent().getStringExtra("nombre"));


    }
}
