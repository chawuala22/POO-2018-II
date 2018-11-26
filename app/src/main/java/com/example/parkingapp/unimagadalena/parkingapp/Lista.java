package com.example.parkingapp.unimagadalena.parkingapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;


/**
 * A simple {@link Fragment} subclass.
 */
public class Lista extends Fragment {

View v;
ImageButton imgbutton;
    public Lista() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment



        View v=inflater.inflate(R.layout.fragment_lista, container, false);

        imgbutton=v.findViewById(R.id.imgnegocio);
        imgbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent siguiente= new Intent(getActivity(),Informacion.class);
                startActivity(siguiente);
            }
        });


        return v;
    }

}
