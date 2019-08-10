package com.example.fibonaci;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button boton1;
    Button boton2;
    EditText numero;
    int num1;
    int num2;
    TextView texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        num1 = 0;
        num2 = 1;
        boton2 = findViewById(R.id.calcular1);
        texto = findViewById(R.id.textView2);
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
                texto.setText(aux);
            }
        });
    }
}
