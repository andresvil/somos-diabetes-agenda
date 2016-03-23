package com.example.andresvil.agenda;

import android.app.usage.UsageEvents;

import java.util.Date;

/**
 * Created by andresvil on 3/23/16.
 */
public class Evento {
    private String nombreEvento, fecha, lugar;

    // Constructor
    public Evento (String nombreEvento, String fecha, String lugar)
    {
        this.nombreEvento = nombreEvento;
        this.fecha = fecha;
        this.lugar = lugar;
    }

    // Setters
    public void setNombreEvento(String nombreEvento) {
        this.nombreEvento = nombreEvento;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    // Getters
    public String getNombreEvento() {
        return nombreEvento;
    }

    public String getFecha() {
        return fecha;
    }

    public String getLugar() {
        return lugar;
    }
}
