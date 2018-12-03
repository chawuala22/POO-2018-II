package com.example.parkingapp.unimagadalena.parkingapp;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.Image;
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
    int id;
    ImageView imageView;


    String name;
    String dire;
    String propie;
    String costor;
    String hori;
    String cupito;
    String imaggen;


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
        imageView=findViewById(R.id.imageView);

        name = getIntent().getStringExtra("name");
        dire=getIntent().getStringExtra("dire");
        propie=getIntent().getStringExtra("propi");
        costor=getIntent().getStringExtra("costo");
        hori=getIntent().getStringExtra("horar");
        cupito=getIntent().getStringExtra("cup");
        imaggen=getIntent().getStringExtra("img");

        id=getResources().getIdentifier(imaggen,"drawable",getPackageName());

        imageView.setImageResource(id);
        nombre.setText(name);
        direccion.setText(dire);
        propietario.setText(propie);
        costo.setText(costor);
        horario.setText(hori);
        cupo.setText(cupito);


        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }
}

