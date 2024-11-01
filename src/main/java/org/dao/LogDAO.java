package org.dao;
import org.model.Log;

import java.sql.*;

public class LogDAO extends DAOGeneric<Log> {
    public boolean isReadOnly() {
        return true;
    }

    /** Método que retorna o nome da tabela correspondente a entidade.
     * @return Nome da tabela correspondente a entidade
     */
    @Override
    public String getNomeBanco() {
        return "log";
    }

    @Override
    public String getNomeInterface() { return "Logs"; }

    /** Método que extrai uma entidade do ResultSet.
     * @param rs ResultSet com a entidade
     * @return Entidade extraída
     * @throws SQLException Se o ResultSet não contiver os dados esperados
     */
    @Override
    protected Log extrairEntidade(ResultSet rs) throws SQLException {
        return new Log(
                rs.getInt("id_log"),
                rs.getDate("dt_log"),
                rs.getString("operacao"),
                rs.getString("query")
        );
    }

    /** Método que retorna a query para inserir uma entidade.
     * @param entidade Entidade a ser inserida
     * @return Query de inserção
     * @throws SQLException Se a entidade não contiver os dados esperados
     */
    @Override
    protected PreparedStatement getInserirQuery(Log entidade) throws SQLException {
        PreparedStatement ps = Conexao.conn.prepareStatement("INSERT INTO log (operacao, query, dt_log) VALUES (?, ?, ?)");
        ps.setString(1, entidade.getOperacao());
        ps.setString(2, entidade.getQuery());
        ps.setDate(3, new Date(System.currentTimeMillis()));
        return ps;
    }

    /** Método que retorna a query para alterar uma entidade.
     * @param entidade Entidade a ser alterada
     * @return Query de alteração
     * @throws SQLException Se a entidade não contiver os dados esperados
     */
    @Override
    protected PreparedStatement getAlterarQuery(Log entidade) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}