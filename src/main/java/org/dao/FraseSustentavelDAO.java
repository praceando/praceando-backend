package org.dao;
import java.util.Date;
import org.model.FraseSustentavel;

import java.sql.*;

public class FraseSustentavelDAO {
//    Conexao conexao = new Conexao();
    private PreparedStatement pstmt;
    private ResultSet rs;


    // Método para Insert

    public int inserir(FraseSustentavel fs) {
        Conexao.conectar();
        try {
            pstmt = Conexao.conn.prepareStatement("INSERT INTO frase_sustentavel (ds_frase) values (?)");

            //Setando valor
            pstmt.setString(1, fs.getDs_frase() );
//            fs.setDt_atualizacao(conexao.dt_atualizacao());
            return pstmt.executeUpdate() > 0 ? 1 : 0; //Executa o comando sql do preparedStatement
        } catch (SQLException sqle) {
            sqle.printStackTrace();

        } finally {
            Conexao.desconectar();
        }
        return -1;
    }

    // Método para Alterar
    public int alterar(FraseSustentavel fs) {
        Conexao.conectar();

        try{
            pstmt = Conexao.conn.prepareStatement("update frase_sustentavel set ds_frase = ? where id_frase = ?");
            // SETANDO O VALOR DOS PARÂMETROS
            pstmt.setString(1, fs.getDs_frase());
            pstmt.setInt(2, fs.getId_frase());
//            Date dt_atualizacao = new Date(System.currentTimeMillis());
//            fs.setDt_atualizacao(conexao.dt_atualizacao());
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

    // Método para Remover
    public int remover(FraseSustentavel fs) {
        Conexao.conectar();
        try {
            String remover = "DELETE FROM frase_sustentavel WHERE id_frase = ?";
            // Instanciando o objeto preparedStatement (pstmt)
            pstmt = Conexao.conn.prepareStatement(remover);
            //Setando o valor do parâmetro
            pstmt.setInt(1, fs.getId_frase());
//            fs.setDt_atualizacao(conexao.dt_atualizacao());

            pstmt.execute();
            return 1;


        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return -1;
        }catch (NullPointerException npe){
            npe.printStackTrace();
            return 0;
        }

        finally {
            Conexao.desconectar();
        }

    }

    // Método para Select

    public ResultSet visualizar(){
        Conexao.conectar();
        try {
            pstmt = Conexao.conn.prepareStatement("SELECT * FROM frase_sustentavel");
            ResultSet rs = pstmt.executeQuery();
            return rs;

        }catch (SQLException sqe){
            sqe.printStackTrace();
            return null;
        } finally {
            Conexao.desconectar();
        }
    }
}