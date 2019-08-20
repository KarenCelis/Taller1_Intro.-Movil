package com.example.ejercicio_semana5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button web;
    Button frame;
    Spinner sele;
    EditText nombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        web=findViewById(R.id.button2);
        frame=findViewById(R.id.sesion5);
        sele=findViewById(R.id.nivelEducativo);
     nombre=findViewById(R.id.textView);
       // String nivel=(String)sele.getSelectedItem();
      //  String nom= String.valueOf(nombre.getText());
        web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(view.getContext(), web.class);
               // intent.putExtra("WEB",);
                startActivity(intent);
            }
        });
        frame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent =new Intent(view.getContext(), frame.class);
               intent.putExtra("nombre",nombre.getText().toString()+" es "+sele.getSelectedItem().toString());
          //  intent.putExtra("clic",sele.getSelectedItem().toString());
                startActivity(intent);
            }
        });
        sele.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String nivel=(String)sele.getSelectedItem();
                Toast.makeText(getBaseContext(), "El item seleccionado es: "+
                        sele.getSelectedItemId()+" "+nivel,
                        Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}
