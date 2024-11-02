package org.model;
import org.common.Constants;
import org.common.Tabela;

import java.util.Date;
import java.util.Map;

public class Log implements Model {
    private int id;
    private Date dt_log;
    private String operacao;
    private String query;

    /**Construtor que inicializa os atributos da classe Log
     * @param dt_log Data e hora da operação
     * @param operacao Operação realizada no banco de dados
     * @param query Consulta executada no banco de dados
     */
    public Log(Date dt_log, String operacao, String query) {
        this.dt_log = dt_log;
        this.operacao = operacao;
        this.query = query;
    }

    /** Construtor que inicializa os atributos da classe Log e o id da operação
     * @param id Id da operação
     */
    public Log(int id, Date dt_log, String operacao, String query) {
        this(dt_log, operacao, query);
        this.id = id;
    }

    /**Getter para o atributo dt_log
     * @return Data e hora da operação
     */
    public Date getDt_log() {
        return this.dt_log;
    }

    /**Getter para o atributo operacao
     * @return Operação realizada no banco de dados
     */
    public String getOperacao() {
        return this.operacao;
    }

    /**Getter para o atributo query
     * @return nome da tabela consultada
     */
    public String getQuery() {
        return this.query;
    }

    public Tabela getTabela() {
        return Constants.TABELA_LOG;
    }

    /**
     * Getter para o atributo id
     * @return Id da operação
     */
    public int getId() { return id; }

    /** Setter para o atributo id
     * @param id Id da operação
     */
    public void setId(int id) {
        this.id = id;
    }

    /** Metodo que retorna um mapa com os atributos e seus valores
     * @return Mapa com os atributos e seus valores
     */
    @Override
    public Map<String, String> getParams() {
        throw new UnsupportedOperationException("Log não suporta parametrização");
    }
}