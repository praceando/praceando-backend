package org.model;
import java.util.Date;

public class Evento_local {
    private String nome;
    private double latitud;
    private double longitud;

    public Evento_local(String nome, double latitud, double longitud) {
        this.nome = nome;
        this.latitud = latitud;
        this.longitud = longitud;
    }
    public Evento_local() {}

    public String getNome() {
        return nome;
    }

    public double getLatitud() {
        return latitud;
    }

    public double getLongitud() {
        return longitud;
    }
}

