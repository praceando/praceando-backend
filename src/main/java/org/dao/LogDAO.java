package org.dao;

import org.model.Log;

import java.sql.*;

public class LogDAO extends DAOGeneric<Log> {

    @Override
    protected Log extrairEntidade(ResultSet rs) throws SQLException {
        return new Log(
                rs.getInt("id_log"),
                rs.getDate("dt_log"),
                rs.getString("operacao"),
                rs.getString("query")
        );
    }

    @Override
    protected PreparedStatement getInserirQuery(Log entidade) throws SQLException {
        PreparedStatement ps = Conexao.conn.prepareStatement("INSERT INTO log (operacao, query) VALUES (?, ?)");
        ps.setString(1, entidade.getOperacao());
        ps.setString(2, entidade.getQuery());
        return ps;
    }

    @Override
    protected PreparedStatement getAlterarQuery(Log entidade) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String getNome() {
        return "log";
    }
}
