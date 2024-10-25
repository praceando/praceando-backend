package org.model;

public class Evento_local implements Model {
    private String nome;
    private double latitude;
    private double longitude;
    private int id;

    /**
     * Construtor que inicia os atributos da classe
     * @param nome Nome do evento
     * @param latitude Latitude do local do evento
     * @param longitude Longitude do local do evento
     */

    public Evento_local(String nome, double latitude, double longitude) {
        this.nome = nome;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Evento_local(int id, String nome, double latitude, double longitude) {
        this(nome, latitude, longitude);
        this.id = id;
    }

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

    public double getLatitude() {
        return latitude;
    }

    /**
     * Getter da longitude do local do evento
     * @return Longitude do local do evento
     */

    public double getLongitude() {
        return longitude;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return
     */
    @Override
    public String getRawHTMLRow() {
        return String.format(
                "<td>%d</td>" +
                "<td>%s</td>" +
                "<td>%f</td>" +
                "<td>%f</td>",
                id,
                nome,
                latitude,
                longitude
        );
    }
}