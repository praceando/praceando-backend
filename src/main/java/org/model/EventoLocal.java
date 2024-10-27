package org.model;
import java.util.HashMap;
import java.util.Map;

public class EventoLocal implements Model {
    private int id;
    private String nome;
    private double latitude;
    private double longitude;

    /** Construtor que inicia os atributos da classe
     * @param nome Nome do evento
     * @param latitude Latitude do local do evento
     * @param longitude Longitude do local do evento
     */
    public EventoLocal(String nome, double latitude, double longitude) {
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
    public EventoLocal(int id, String nome, double latitude, double longitude) {
        this(nome, latitude, longitude);
        this.id = id;
    }

    /** Construtor que recebe um map de parâmetros e cria um objeto do tipo EventoLocal
     * @param params Map de parâmetros
     */
    public EventoLocal(Map<String, String > params) {
        if (params.containsKey("id")) {
            this.id = Integer.parseInt(params.get("id"));
        }
        this.nome = params.get("nome");
        this.latitude = Double.parseDouble(params.get("latitude"));
        this.longitude = Double.parseDouble(params.get("longitude"));
    }

    /** Getter do nome do evento
     * @return Nome do evento
     */
    public String getNome() {
        return this.nome;
    }

    /** Getter da latitude do local do evento
     * @return Latitude do local do evento
     */
    public double getLatitude() {
        return this.latitude;
    }

    /** Getter da longitude do local do evento
     * @return Longitude do local do evento
     */
    public double getLongitude() {
        return this.longitude;
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

    /** Método que retorna um map de parâmetros do objeto
     * @return Map de parâmetros do objeto
     */
    public Map<String, String> getParams() {
        Map<String, String> params = new HashMap<>();
        params.put("nome", this.nome);
        params.put("latitude", Double.toString(this.latitude));
        params.put("longitude", Double.toString(this.longitude));
        return params;
    }
}