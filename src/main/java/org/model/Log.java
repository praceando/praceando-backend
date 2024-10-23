package org.model;
import java.util.Date;

public class Log {
    private Date dt_log;
    private Character operacao;
    private String query;

    public Log(Date dt_log, Character operacao, String query) {
        this.dt_log = dt_log;
        this.operacao = operacao;
        this.query = query;
    }

    public Date getDt_log() {
        return dt_log;
    }

    public Character getOperacao() {
        return operacao;
    }

    public String getQuery() {
        return query;
    }
}

