package org.dao;

import org.model.Avatar;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AvatarDAO {
    private PreparedStatement pstmt;
    private ResultSet rs;
    // Método para Insert

    public int inserir(Avatar avatar) {
        Conexao.conectar();
        try {
            pstmt = Conexao.conn.prepareStatement("INSERT INTO Avatar (url_avatar) values (?)");

            //Setando valor
            pstmt.setString(1, avatar.getUrl_avatar());
//            avatar.setDt_atualizacao(conexao.dt_atualizacao());
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

    // Método para Alterar
    public int alterar(Avatar avatar) {
        Conexao.conectar();
        Statement statement = null;

        try {
            pstmt = Conexao.conn.prepareStatement("update avatar set url_avatar = ? where id_avatar = ?");
            // SETANDO O VALOR DOS PARÂMETROS
            pstmt.setString(1, avatar.getUrl_avatar());
            pstmt.setInt(2, avatar.getId_avatar());
//            avatar.setDt_atualizacao(conexao.dt_atualizacao());
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

    public ResultSet buscar() {
        Conexao.conectar();
        try {
            pstmt = Conexao.conn.prepareStatement("SELECT * FROM avatar order by id_avatar");
            return pstmt.executeQuery();
        } catch (SQLException sqe){
            sqe.printStackTrace();
        } finally {
            Conexao.desconectar();
        }
        return null;
    }
}
