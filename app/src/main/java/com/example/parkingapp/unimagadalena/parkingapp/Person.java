package com.example.parkingapp.unimagadalena.parkingapp;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

class Person {

        private  String name;
        private  String direccion;
        private  String propietario;
        private  String costo;
        private  String horario;
        private  String cupo;



    public Person() {
        super();
    }

    public Person(String name, String direccion, String propietario, String costo, String horario, String cupo, Drawable imagen) {
        this.name = name;
        this.direccion = direccion;
        this.propietario = propietario;
        this.costo = costo;
        this.horario = horario;
        this.cupo = cupo;


    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public String getCosto() {
        return costo;
    }

    public void setCosto(String costo) {
        this.costo = costo;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getCupo() {
        return cupo;
    }

    public void setCupo(String cupo) {
        this.cupo = cupo;
    }




    }

