package org.dao;

import org.common.SqlExitDML;
import org.model.Evento_local;
import java.util.ArrayList;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class Evento_localDAO {
    Conexao conexao = new Conexao();

    private PreparedStatement pstmt;
    private ResultSet rs;


    // Método para Insert
    
    public SqlExitDML inserir(Evento_local evento_local) {
        Conexao.conectar();
        try {
            pstmt = Conexao.conn.prepareStatement("INSERT INTO local (nome, lat, long) values (?,?,?)");

            //Setando valor

            pstmt.setString(1, evento_local.getNome() );
            pstmt.setDouble(2, evento_local.getLatitud());
            pstmt.setDouble(3, evento_local.getLongitud());
            int cod = (pstmt.executeUpdate() > 0 ? 1 : 0);  // Executa o comando sql do preparedStatement, retorna um código
            return new SqlExitDML(cod);
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return new SqlExitDML(-1, sqle);
        } finally {
            Conexao.desconectar();
        }
    }

    // Método para Select


    private List<Evento_local> visualizar() {
        Conexao.conectar();
        try {
            pstmt = Conexao.conn.prepareStatement("SELECT * FROM evento_local");
            return getLinhas(pstmt.executeQuery());
        } catch (SQLException sqe){
            sqe.printStackTrace();
        } finally {
            Conexao.desconectar();
        }
        return new LinkedList<>();

    }


    private List<Evento_local> getLinhas(ResultSet rs) throws SQLException {
        if (rs == null) {
            return null;
        }
        List<Evento_local> evento = new ArrayList<>();

        while (rs.next()) {
            evento.add(new Evento_local(
                    rs.getString("nome"),
                    rs.getDouble("lat"),
                    rs.getDouble("long")
            ));
        }
        return evento;
    }




// No geral o comando seguem essa mesma estrutura, menos o select


}
