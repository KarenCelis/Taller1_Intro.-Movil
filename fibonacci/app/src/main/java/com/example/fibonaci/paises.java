package com.example.fibonaci;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public class paises extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paises);

        // loadJSONFromAsset();
        listView = findViewById(R.id.listPa);
        JSONObject json = null;
        try {
            json = new JSONObject(loadJSONFromAsset());
        } catch (JSONException e) {
            e.printStackTrace();

        }
        try {
            final JSONArray paisesJasonArray = json.getJSONArray("paises");
            final String[] array_spinner = new String[paisesJasonArray.length()];
            for (int i = 0; i < paisesJasonArray.length(); i++) {
                JSONObject json_data = paisesJasonArray.getJSONObject(i);
                String jj = json_data.getString("nombre_pais");
                array_spinner[i] = jj;
            }
            ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, array_spinner);
            adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);
            listView.setAdapter(adapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Intent intent = new Intent(getBaseContext(), DetallePais.class);
                    try {
                        JSONObject elemento = paisesJasonArray.getJSONObject(i);
                        String capital = elemento.getString("capital");
                        String nombre_rea = elemento.getString("nombre_pais_int");
                        String sigla = elemento.getString("sigla");
                        intent.putExtra("Capital", capital);
                        intent.putExtra("nombre_rea", nombre_rea);
                        intent.putExtra("sigla", sigla);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    startActivity(intent);

                }
            });
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    public String loadJSONFromAsset() {


        String json = null;
        try {

            InputStream is = this.getAssets().open("paises.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");

        } catch (IOException ex) {

            ex.printStackTrace();
            return null;

        }
        return json;

    }
}
