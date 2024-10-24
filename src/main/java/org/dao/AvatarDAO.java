package org.dao;

<<<<<<< HEAD
import org.model.Avatar;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
=======
import org.common.SqlExitDML;
import org.model.Avatar;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
>>>>>>> c5580918d96592a8c60201406ebbde11b39c3130

public class AvatarDAO {
    private PreparedStatement pstmt;
    private ResultSet rs;
<<<<<<< HEAD
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
=======

     // Método para Insert

    public SqlExitDML inserir(Avatar avatar) {
        Conexao.conectar();
        try {
            pstmt = Conexao.conn.prepareStatement("INSERT INTO avatar (b64_avatar) values (?)");

            //Setando valor
            pstmt.setString(1, avatar.getB64_avatar());
//            avatar.setDt_atualizacao(conexao.dt_atualizacao());
            int cod = (pstmt.executeUpdate() > 0 ? 1 : 0);  // Executa o comando sql do preparedStatement, retorna um código
            return new SqlExitDML(cod);
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return new SqlExitDML(-1, sqle);
        } finally {
            Conexao.desconectar();
        }
    }

    // Método para Alterar
    public SqlExitDML alterar(Avatar avatar) {
        Conexao.conectar();
        try {
            pstmt = Conexao.conn.prepareStatement("update avatar set b64_avatar = ? where id_avatar = ?");
            // SETANDO O VALOR DOS PARÂMETROS
            pstmt.setString(1, avatar.getB64_avatar());
            pstmt.setInt(2, avatar.getId_avatar());
//            avatar.setDt_atualizacao(conexao.dt_atualizacao());
            int cod = (pstmt.executeUpdate() > 0 ? 1 : 0);  // Executa o comando sql do preparedStatement, retorna um código
            return new SqlExitDML(cod);
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return new SqlExitDML(-1);
        } finally {
            Conexao.desconectar();
        }
    }

    // Método para select

    public List<Avatar> visualizar() {
        Conexao.conectar();
        try {
            pstmt = Conexao.conn.prepareStatement("SELECT * FROM avatar");
            return getLinhas(pstmt.executeQuery());
>>>>>>> c5580918d96592a8c60201406ebbde11b39c3130
        } catch (SQLException sqe){
            sqe.printStackTrace();
        } finally {
            Conexao.desconectar();
        }
<<<<<<< HEAD
        return null;
=======
        return new LinkedList<>();

    }

    private List<Avatar> getLinhas(ResultSet rs) throws SQLException {
        if (rs == null) {
            return null;
        }
        List<Avatar> avatares = new ArrayList<>();

        while (rs.next()) {
            avatares.add(new Avatar(
                    rs.getInt("id_avatar"),
                    rs.getString("b64_avatar")
            ));
        }
        return avatares;
>>>>>>> c5580918d96592a8c60201406ebbde11b39c3130
    }
}
