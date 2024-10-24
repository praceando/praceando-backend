package org.dao;
<<<<<<< HEAD
import org.model.Evento_local;
import java.util.Date;
import java.sql.*;
=======

import org.common.SqlExitDML;
import org.model.Evento_local;
import java.util.ArrayList;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;
>>>>>>> c5580918d96592a8c60201406ebbde11b39c3130

public class Evento_localDAO {
    Conexao conexao = new Conexao();

    private PreparedStatement pstmt;
    private ResultSet rs;


    // Método para Insert
    
<<<<<<< HEAD
    public int inserir(Evento_local evento_local) {
=======
    public SqlExitDML inserir(Evento_local evento_local) {
>>>>>>> c5580918d96592a8c60201406ebbde11b39c3130
        Conexao.conectar();
        try {
            pstmt = Conexao.conn.prepareStatement("INSERT INTO local (nome, lat, long) values (?,?,?)");

            //Setando valor

            pstmt.setString(1, evento_local.getNome() );
            pstmt.setDouble(2, evento_local.getLatitud());
            pstmt.setDouble(3, evento_local.getLongitud());
<<<<<<< HEAD
//            evento_local.setDt_atualizacao(conexao.dt_atualizacao());
            return pstmt.executeUpdate() > 0 ? 1 : 0;
        } catch (SQLException sql) {
            sql.printStackTrace();
        } catch (NullPointerException nqe){
            nqe.printStackTrace();
        } finally {
            Conexao.desconectar();
        }
        return -1;
=======
            int cod = (pstmt.executeUpdate() > 0 ? 1 : 0);  // Executa o comando sql do preparedStatement, retorna um código
            return new SqlExitDML(cod);
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return new SqlExitDML(-1, sqle);
        } finally {
            Conexao.desconectar();
        }
>>>>>>> c5580918d96592a8c60201406ebbde11b39c3130
    }

    // Método para Select

<<<<<<< HEAD
    public ResultSet buscar(){
        Conexao.conectar();
        try {
            pstmt = Conexao.conn.prepareStatement("SELECT * FROM local ORDER BY id_local");
            ResultSet rs = pstmt.executeQuery();
            return rs;
        }catch (SQLException sqe){
=======

    private List<Evento_local> visualizar() {
        Conexao.conectar();
        try {
            pstmt = Conexao.conn.prepareStatement("SELECT * FROM evento_local");
            return getLinhas(pstmt.executeQuery());
        } catch (SQLException sqe){
>>>>>>> c5580918d96592a8c60201406ebbde11b39c3130
            sqe.printStackTrace();
        } finally {
            Conexao.desconectar();
        }
<<<<<<< HEAD
        return null;
=======
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
>>>>>>> c5580918d96592a8c60201406ebbde11b39c3130
    }




// No geral o comando seguem essa mesma estrutura, menos o select


}
