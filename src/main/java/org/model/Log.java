package org.model;
import java.util.Date;

public class Log {
    private Date dt_log;
    private String operacao;
    private String query;

    /**
     * Construtor que inicializa os atributos da classe Log
     * @param dt_log Data e hora da operação
     * @param operacao Operação realizada no banco de dados
     * @param query Consulta executada no banco de dados
     */

    public Log(Date dt_log, String operacao, String query) {
        this.dt_log = dt_log;
        this.operacao = operacao;
        this.query = query;
    }

    /**
     * Getter para o atributo dt_log
     * @return Data e hora da operação
     */

    public Date getDt_log() {
        return dt_log;
    }

    /**
     * Getter para o atributo operacao
     * @return Operação realizada no banco de dados
     */

    public String getOperacao() {
        return operacao;
    }

    /**
     * Getter para o atributo query
     * @return nome da tabela consultada
     */

    public String getQuery() {
        return query;
    }
}

