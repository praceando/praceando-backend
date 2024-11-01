package org.model;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class EventoLocal implements Model {
    private int id;
    private String nome;
    private BigDecimal lat;
    private BigDecimal lon;

    /** Construtor que inicia os atributos da classe
     * @param nome Nome do evento
     * @param lat Latitude do local do evento
     * @param lon Longitude do local do evento
     */
    public EventoLocal(String nome, BigDecimal lat, BigDecimal lon) {
        this.nome = nome;
        this.lat = lat;
        this.lon = lon;
    }

    /** Construtor que inicia os atributos da classe e o id do evento
     * @param id
     * @param nome
     * @param lat
     * @param lon
     */
    public EventoLocal(int id, String nome, BigDecimal lat, BigDecimal lon) {
        this(nome, lat, lon);
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
        this.lat = new BigDecimal(params.get("latitude"));
        this.lon = new BigDecimal(params.get("longitude"));
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
    public BigDecimal getLat() {
        return this.lat;
    }

    /** Getter da longitude do local do evento
     * @return Longitude do local do evento
     */
    public BigDecimal getLon() {
        return this.lon;
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
        params.put("latitude", this.lat.toString());
        params.put("longitude", this.lon.toString());
        return params;
    }
}