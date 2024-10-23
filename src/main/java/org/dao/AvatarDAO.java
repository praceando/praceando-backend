package org.dao;

import org.common.SqlExitDML;
import org.model.Avatar;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AvatarDAO {
    private PreparedStatement pstmt;
    private ResultSet rs;

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
        } catch (SQLException sqe){
            sqe.printStackTrace();
        } finally {
            Conexao.desconectar();
        }
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
    }
}
