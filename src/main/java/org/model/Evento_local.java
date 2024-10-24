package org.model;
import java.util.Date;

public class Evento_local {
    private String nome;
    private double latitud;
    private double longitud;

    /**
     * Construtor que inicia os atributos da classe
     * @param nome Nome do evento
     * @param latitud Latitude do local do evento
     * @param longitud Longitude do local do evento
     */

    public Evento_local(String nome, double latitud, double longitud) {
        this.nome = nome;
        this.latitud = latitud;
        this.longitud = longitud;
    }
    public Evento_local() {}

    /**
     * Getter do nome do evento
     * @return Nome do evento
     */

    public String getNome() {
        return nome;
    }

    /**
     * Getter da latitude do local do evento
     * @return Latitude do local do evento
     */

    public double getLatitud() {
        return latitud;
    }

    /**
     * Getter da longitude do local do evento
     * @return Longitude do local do evento
     */

    public double getLongitud() {
        return longitud;
    }
}