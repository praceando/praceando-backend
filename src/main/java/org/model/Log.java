package org.model;
import java.util.Date;

public class Log implements Model {
    private Date dt_log;
    private String operacao;
    private String query;
    private int id;

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

    public Log(int id, Date dt_log, String operacao, String query) {
        this(dt_log, operacao, query);
        this.id = id;
    }

    /**Getter para o atributo dt_log
     * @return Data e hora da operação
     */

    public Date getDt_log() {
        return dt_log;
    }

    /**Getter para o atributo operacao
     * @return Operação realizada no banco de dados
     */

    public String getOperacao() {
        return operacao;
    }

    /**Getter para o atributo query
     * @return nome da tabela consultada
     */

    public String getQuery() {
        return query;
    }

    public int getId() { return id; }

    public void setId(int id) {
        this.id = id;
    }

    /**Método utilizado para gerar uma linha HTML com os dados das operações realizadas no banco de dados pelo CRUD
     * @return Uma linha HTML contendo os dados das operações realizadas no banco de dados
     */
    @Override
    public String getRawHTMLRow() {
        return String.format(
                "<td>%d</td>" +
                "<td>%s</td>" +
                "<td>%s</td>" +
                "<td>%s</td>",
                id,
                operacao,
                query,
                dt_log
        );
    }
}

