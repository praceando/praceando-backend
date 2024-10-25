package org.model;
import java.util.Map;

public class Evento_local implements Model {
    private String nome;
    private double latitude;
    private double longitude;
    private int id;

    /** Construtor que inicia os atributos da classe
     * @param nome Nome do evento
     * @param latitude Latitude do local do evento
     * @param longitude Longitude do local do evento
     */
    public Evento_local(String nome, double latitude, double longitude) {
        this.nome = nome;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    /** Construtor que inicia os atributos da classe e o id do evento
     * @param id
     * @param nome
     * @param latitude
     * @param longitude
     */
    public Evento_local(int id, String nome, double latitude, double longitude) {
        this(nome, latitude, longitude);
        this.id = id;
    }

    public Evento_local(Map<String, String > params) {
        this.id = Integer.parseInt(params.get("id"));
        this.nome = params.get("nome");
        this.latitude = Double.parseDouble(params.get("latitude"));
        this.longitude = Double.parseDouble(params.get("longitude"));
    }

    /** Getter do nome do evento
     * @return Nome do evento
     */
    public String getNome() {
        return nome;
    }

    /** Getter da latitude do local do evento
     * @return Latitude do local do evento
     */
    public double getLatitude() {
        return latitude;
    }

    /** Getter da longitude do local do evento
     * @return Longitude do local do evento
     */
    public double getLongitude() {
        return longitude;
    }

    /** Getter do id do evento
     * @return Id do evento
     */
    public int getId() {
        return this.id;
    }

    /** Setter do id do evento
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /* Método utilizado para gerar uma linha HTML com os dados dos locais
     * @return Uma linha HTML com os dados dos locais
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