package com.example.fibonaci;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Punto5 extends AppCompatActivity {
    int num1;
    int num2;
    LinearLayout linear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_punto5);
        Log.i("eeeeeeee", "act2");
        int cantidad = Integer.parseInt(getIntent().getStringExtra("Cuantos"));
        num1 = 0;
        num2 = 1;
        linear = findViewById(R.id.linear5);
        Log.i("eeeeeeee", "act2.2");
        if (cantidad == 1) {
            Log.i("eeeeeeee", "act1.2");
            TextView textView = new TextView(this);
            Log.i("eeeeeeee", "act1..7.2");

            textView.setText("0");
           // textView.setId(0);
            linear.addView(textView);
        } else if(cantidad==2){
            TextView textView = new TextView(this);
            textView.setText("0");
           // textView.setId(0);
            linear.addView(textView);
            TextView textView2 = new TextView(this);
            textView2.setText("1");
          //  textView2.setId(1);
            linear.addView(textView2);
        } else{
            TextView textView = new TextView(this);
            textView.setText("0");
            // textView.setId(0);
            linear.addView(textView);
            TextView textView2 = new TextView(this);
            textView2.setText("1");
            //  textView2.setId(1);
            linear.addView(textView2);
            for(int i=2; i<cantidad; i++){

                int num3 = num1 + num2;

                String aux2;
                aux2 = String.valueOf(num3);
                num1 = num2;
                num2 = num3;
                TextView textView3 = new TextView(this);
                textView3.setText(aux2);
                /* textView2.setId(1); */
                linear.addView(textView3);
                Log.i("aaa", aux2);


            }

        }



        {}

    }
}
