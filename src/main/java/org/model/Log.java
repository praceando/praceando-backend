package org.model;
import java.util.Date;

public class Log {
    private Date dt_log;
    private Character operacao;
    private String query;

<<<<<<< HEAD
=======
    /**
     * Construtor que inicializa os atributos da classe Log
     * @param dt_log Data e hora da operação
     * @param operacao Operação realizada no banco de dados
     * @param query Consulta executada no banco de dados
     */

>>>>>>> c5580918d96592a8c60201406ebbde11b39c3130
    public Log(Date dt_log, Character operacao, String query) {
        this.dt_log = dt_log;
        this.operacao = operacao;
        this.query = query;
    }

<<<<<<< HEAD
=======
    /**
     * Getter para o atributo dt_log
     * @return Data e hora da operação
     */

>>>>>>> c5580918d96592a8c60201406ebbde11b39c3130
    public Date getDt_log() {
        return dt_log;
    }

<<<<<<< HEAD
=======
    /**
     * Getter para o atributo operacao
     * @return Operação realizada no banco de dados
     */

>>>>>>> c5580918d96592a8c60201406ebbde11b39c3130
    public Character getOperacao() {
        return operacao;
    }

<<<<<<< HEAD
=======
    /**
     * Getter para o atributo query
     * @return nome da tabela consultada
     */

>>>>>>> c5580918d96592a8c60201406ebbde11b39c3130
    public String getQuery() {
        return query;
    }
}

