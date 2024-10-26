package org.dao;

import org.model.EventoLocal;

import java.sql.*;

public class EventoLocalDAO extends DAOGeneric<EventoLocal> {

    @Override
    protected EventoLocal extrairEntidade(ResultSet rs) throws SQLException {
        return new EventoLocal(
                rs.getInt("id_evento_local"),
                rs.getString("nome"),
                rs.getDouble("lat"),
                rs.getDouble("long")
        );
    }

    @Override
    protected PreparedStatement getInserirQuery(EventoLocal local) throws SQLException {
        PreparedStatement ps = Conexao.conn.prepareStatement("INSERT INTO evento_local (nome, lat, long) values (?,?,?)");
        ps.setString(1, local.getNome());
        ps.setDouble(2, local.getLatitude());
        ps.setDouble(3, local.getLongitude());
        return ps;
    }

    @Override
    protected PreparedStatement getAlterarQuery(EventoLocal local) throws SQLException {
        PreparedStatement ps = Conexao.conn.prepareStatement("UPDATE evento_local SET nome = ?, lat = ?, long = ? WHERE id = ?");
        ps.setString(1, local.getNome());
        ps.setDouble(2, local.getLatitude());
        ps.setDouble(3, local.getLongitude());
        ps.setInt(4, local.getId());
        return ps;
    }

    @Override
    public String getNome() {
        return "evento_local";
    }
}