package com.example.fibonaci;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //Definicion de variables
    Button boton1;
    Button boton2;
    EditText numero;
    int num1;
    int num2;
    TextView texto;
    LinearLayout linear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        num1 = 0;
        num2 = 1;
        // inflar las variables
        boton2 = findViewById(R.id.calcular1);
        texto = findViewById(R.id.textView2);
        linear = findViewById(R.id.linear2);
        boton1 = findViewById(R.id.calcular5);
        numero = findViewById(R.id.editText);
        //Crear la accion al pulsar el boton
        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int num3 = num1 + num2;
                String aux = (String) texto.getText();
                String aux2;
                aux2 = String.valueOf(num3);
                aux = aux + ", " + aux2;
                Log.i("tes", aux);
                num1 = num2;
                num2 = num3;

                //4//
                TextView textView = new TextView(view.getContext());
                textView.setText(aux2);
                textView.setId(num3);
                //al a Linear layout le  añado un tecView
                linear.addView(textView);
                //3//
                //  texto.setText(aux);
            }
        });
//Accion para que reciba la   cantidad de numeros de Fibonacci a mostrar
        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String num = numero.getText().toString();
                //Creo un intent para comunicarme con otra actividad
                Intent intent = new Intent(view.getContext(), Punto5.class);
                intent.putExtra("Cuantos", num);
               // Log.i("eeeeeeee", num);
                startActivity(intent);
            }
        });
    }
}
