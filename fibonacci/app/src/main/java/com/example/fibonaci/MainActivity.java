package com.example.fibonaci;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    //Definicion de variables
    Button boton1;
    Button boton2;
    Button boton3;
    Button boton4;
    Button boton5;
    EditText numero;
    int num1;
    int num2;
    TextView texto;
    LinearLayout linear;
    Spinner sele;
    int count = 0;
    int contar = 0;
    TextView FiboCont;
    TextView FiboFecha;
    TextView FactoCont;
    TextView FactoFecha;
    SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss z");

    //SimpleDateFormat df= new SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss z");
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
        boton3 = findViewById(R.id.wiki);
        sele = findViewById(R.id.spinner_fac);
        boton4 = findViewById(R.id.button_fact);
        boton5 = findViewById(R.id.paises);
        FiboCont = findViewById(R.id.Fibocont);
        FiboFecha = findViewById(R.id.FiboFecha);
        FactoCont = findViewById(R.id.FactorialCont);
        FactoFecha = findViewById(R.id.FactorialFecha);

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
                Calendar c = Calendar.getInstance();

                count++;
                String num = numero.getText().toString();
                //Creo un intent para comunicarme con otra actividad
                Intent intent = new Intent(view.getContext(), Punto5.class);
                intent.putExtra("Cuantos", num);
                //intent.putExtra("cuan", String.valueOf(count));

                // Log.i("eeeeeeee", num);
                startActivity(intent);
                FiboCont.setText("Numero de veces fibonacci: " + String.valueOf(count));
                FiboFecha.setText("Fecha: " + df.format(c.getTime()));

            }
        });
        boton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), bio.class);

                startActivity(intent);
            }
        });

        sele.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String nivel = (String) sele.getSelectedItem();
                Toast.makeText(getBaseContext(), "El item seleccionado es: " + " " + nivel,
                        Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        boton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar d = Calendar.getInstance();
                contar++;
                Intent intent = new Intent(view.getContext(), factorial.class);
                //   intent.putExtra("cuant", String.valueOf(contar));

                //int resultado = 1;

                //int i=Integer.parseInt(sele.getSelectedItem().toString());
                //  for(int i=1;i< ((int) sele.getSelectedItem());i++){

                //   resultado=resultado*i;

                //}
                //String g=String.valueOf(i);
                // intent.putExtra("re",g);
                startActivity(intent);
                FactoCont.setText("Numero de veces factorial: " + String.valueOf(contar));
                FactoFecha.setText("Fecha: " + df.format(d.getTime()));
            }
        });

        boton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), paises.class);

                startActivity(intent);
            }
        });

    }
}
