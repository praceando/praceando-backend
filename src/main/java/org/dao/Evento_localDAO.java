package org.dao;

import org.model.Evento_local;

import java.sql.*;

public class Evento_localDAO extends DAOGeneric<Evento_local> {

    @Override
    protected Evento_local extrairEntidade(ResultSet rs) throws SQLException {
        return new Evento_local(
                rs.getInt("id_evento_local"),
                rs.getString("nome"),
                rs.getDouble("lat"),
                rs.getDouble("long")
        );
    }

    @Override
    protected PreparedStatement getInserirQuery(Evento_local local) throws SQLException {
        PreparedStatement ps = Conexao.conn.prepareStatement("INSERT INTO evento_local (nome, lat, long) values (?,?,?)");
        ps.setString(1, local.getNome());
        ps.setDouble(2, local.getLatitude());
        ps.setDouble(3, local.getLongitude());
        return ps;
    }

    @Override
    protected PreparedStatement getAlterarQuery(Evento_local local) throws SQLException {
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
