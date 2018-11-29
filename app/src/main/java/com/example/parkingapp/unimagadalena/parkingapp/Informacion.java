package com.example.parkingapp.unimagadalena.parkingapp;

import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class Informacion extends AppCompatActivity {

   TextView nombre;
   TextView direccion;
   TextView propietario;
   TextView costo;
   TextView horario;
   TextView cupo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion);

        nombre=findViewById(R.id.nombre);
        direccion= findViewById(R.id.direccion);
        propietario=findViewById(R.id.propietario);
        costo=findViewById(R.id.costo);
        horario=findViewById(R.id.horario);
        cupo=findViewById(R.id.cupo);


        HttpClient client = new HttpClient(new OnHttpRequestComplete() {
            @Override
            public void onComplete(Response status) {
                if (status.isSuccess()){

                    Gson gson = new GsonBuilder().create();
                    try{
                        JSONObject jsono = new JSONObject(status.getResult());
                        JSONArray jsonoarray= jsono.getJSONArray("info");
                        ArrayList<Person> personas = new ArrayList<Person>();
                        for (int i=0; i<jsonoarray.length(); i++){
                            String person = jsonoarray.getString(i);
                            System.out.println(person);
                            Person p = gson.fromJson(person, Person.class);
                            personas.add(p);
                            System.err.println(p.getName());
                            TextView t = new TextView(getBaseContext());

                           nombre.setText(p.getName());
                           direccion.setText(p.getDireccion());
                           propietario.setText(p.getPropietario());
                           costo.setText(p.getCosto());
                           horario.setText(p.getHorario());
                           cupo.setText(p.getCupo());
                        }

                    }catch (Exception e){
                        System.out.println("Fallo!");
                        e.printStackTrace();
                    }
                }

            }
        });
        client.excecute("https://dl.dropbox.com/s/72edv43zg3jvql9/info.json?dl=0");


        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }
}
