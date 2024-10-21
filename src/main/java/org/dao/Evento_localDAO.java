package org.dao;
import org.model.Evento_local;
import java.util.Date;
import java.sql.*;

public class Evento_localDAO {
    Conexao conexao = new Conexao();

    private PreparedStatement pstmt;
    private ResultSet rs;


    // Método para Insert
    
    public int inserir(Evento_local evento_local) {
        Conexao.conectar();
        try {
            pstmt = Conexao.conn.prepareStatement("INSERT INTO local (nome, lat, long) values (?,?,?)");

            //Setando valor

            pstmt.setString(1, evento_local.getNome() );
            pstmt.setDouble(2, evento_local.getLatitud());
            pstmt.setDouble(3, evento_local.getLongitud());
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
    }

    // Método para Select

    public ResultSet buscar(){
        Conexao.conectar();
        try {
            pstmt = Conexao.conn.prepareStatement("SELECT * FROM local ORDER BY id_local");
            ResultSet rs = pstmt.executeQuery();
            return rs;
        }catch (SQLException sqe){
            sqe.printStackTrace();
        } finally {
            Conexao.desconectar();
        }
        return null;
    }




// No geral o comando seguem essa mesma estrutura, menos o select


}
