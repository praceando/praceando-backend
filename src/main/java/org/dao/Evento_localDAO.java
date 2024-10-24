package org.dao;

import org.common.SqlExitDML;
import org.model.Evento_local;
import org.model.Produto;

import java.util.ArrayList;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class Evento_localDAO extends DAOGeneric<Evento_local> {

    @Override
    protected Evento_local extrairEntidade(ResultSet rs) throws SQLException {
        return new Evento_local(
                rs.getString("nome"),
                rs.getDouble("lat"),
                rs.getDouble("long")
        );
    }

    @Override
    protected PreparedStatement getInserirQuery(Evento_local local) throws SQLException {
        PreparedStatement ps = Conexao.conn.prepareStatement("INSERT INTO evento_local (nome, lat, long) values (?,?,?)");
        ps.setString(1, local.getNome());
        ps.setDouble(2, local.getLatitud());
        ps.setDouble(3, local.getLongitud());
        return ps;
    }

    @Override
    protected PreparedStatement getAlterarQuery(Evento_local local) throws SQLException {
        PreparedStatement ps = Conexao.conn.prepareStatement("UPDATE evento_local SET nome = ?, lat = ?, long = ? WHERE id = ?");
        ps.setString(1, local.getNome());
        ps.setDouble(2, local.getLatitud());
        ps.setDouble(3, local.getLongitud());
        ps.setInt(4, local.getId());
        return ps;
    }

    @Override
    protected String getNome() {
        return "evento_local";
    }
}
