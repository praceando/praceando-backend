package org.model;
import org.common.Constants;
import org.common.Tabela;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

public class EventoLocal implements Model {
    private int id;
    private String nome;
    private BigDecimal lat;
    private BigDecimal lon;
    private Time dt_func_ini;
    private Time dt_func_fim;
    private Date dt_atualizacao;

    /** Construtor que inicia os atributos da classe
     * @param id ID do local
     * @param nome Nome do evento
     * @param lat Latitude do local do evento
     * @param lon Longitude do local do evento
     * @param dt_atualizacao Data da última alteração do local do evento
     */
    public EventoLocal(Integer id, String nome, BigDecimal lat,
                       BigDecimal lon, Time dt_func_ini, Time dt_func_fim,
                       Date dt_atualizacao) {
        this.id = id;
        this.nome = nome;
        this.lat = lat;
        this.lon = lon;
        this.dt_func_ini = dt_func_ini;
        this.dt_func_fim = dt_func_fim;
        this.dt_atualizacao = dt_atualizacao;
    }

    /** Construtor que recebe um map de parâmetros e cria um objeto do tipo EventoLocal
     * @param params Map de parâmetros
     */
    public EventoLocal(Map<String, String > params) throws ParseException {
        if (params.containsKey("id")) {
            this.id = Integer.parseInt(params.get("id"));
        }
        this.nome = params.get("nome");
        this.lat = new BigDecimal(params.get("lat"));
        this.lon = new BigDecimal(params.get("lon"));

        this.dt_func_ini = new Time(Constants.FORMATO_TEMPO.parse(params.get("dt_func_ini")).getTime());
        this.dt_func_fim = new Time(Constants.FORMATO_TEMPO.parse(params.get("dt_func_fim")).getTime());
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

    /** Getter da data de início de funcionamento do local
     * @return data de início de funcionamento
     */
    public Time getDt_func_ini() {
        return this.dt_func_ini;
    }

    /** Getter da data de início de funcionamento do local
     * @return data de fim de funcionamento
     */
    public Time getDt_func_fim() {
        return this.dt_func_fim;
    }

    public Tabela getTabela() {
        return Constants.TABELA_EVENTO_LOCAL;
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
        params.put("lat", this.lat.toString());
        params.put("lon", this.lon.toString());
        return params;
    }
}