package org.model;
import java.util.Date;
import java.util.Map;

public class Log implements Model {
    private int id;
    private Date dtLog;
    private String operacao;
    private String query;

    /**Construtor que inicializa os atributos da classe Log
     * @param dtLog Data e hora da operação
     * @param operacao Operação realizada no banco de dados
     * @param query Consulta executada no banco de dados
     */
    public Log(Date dtLog, String operacao, String query) {
        this.dtLog = dtLog;
        this.operacao = operacao;
        this.query = query;
    }

    /** Construtor que inicializa os atributos da classe Log e o id da operação
     * @param id Id da operação
     */
    public Log(int id, Date dtLog, String operacao, String query) {
        this(dtLog, operacao, query);
        this.id = id;
    }

    /**Getter para o atributo dt_log
     * @return Data e hora da operação
     */
    public Date getDtLog() {
        return this.dtLog;
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

    @Override
    public Map<String, String> getParams() {
        throw new UnsupportedOperationException("Log não suporta parametrização");
    }
}