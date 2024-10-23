package org.dao;

import org.common.SqlExitDML;
import org.model.Tag;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TagDAO {
    private PreparedStatement pstmt;
    private ResultSet rs;

    // Método para Insert

    public boolean inserir(Tag tag) {
        Conexao.conectar();
        try {
            pstmt = Conexao.conn.prepareStatement("INSERT INTO tag (nome) values (?)");

            //Setando valor

            pstmt.setString(1, tag.getNome());
//            tag.setDt_atualizacao(conexao.dt_atualizacao());
            pstmt.executeUpdate(); //Executa o comando sql do preparedStatement
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            Conexao.desconectar();
        }
        return false;
    }

    // Método para Remover

    public SqlExitDML remover(Tag tag) {
        Conexao.conectar();
        try {
            String remover = "DELETE FROM tag WHERE id_tag = ?";
            // Instanciando o objeto preparedStatement (pstmt)
            pstmt = Conexao.conn.prepareStatement(remover);
            //Setando o valor do parâmetro
            pstmt.setInt(1, tag.getId_tag());
//            tag.setDt_atualizacao(conexao.dt_atualizacao());

            int cod = (pstmt.executeUpdate() > 0 ? 1 : 0);  // Executa o comando sql do preparedStatement, retorna um código
            return new SqlExitDML(cod);
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return new SqlExitDML(-1);
        } finally {
            Conexao.desconectar();
        }

    }

    // Método para Alterar
    public SqlExitDML alterar(Tag tag) {

        try {
            pstmt = Conexao.conn.prepareStatement("UPDATE tag SET nome = ?, categoria = ? WHERE id_tag = ?");
            // SETANDO O VALOR DOS PARÂMETROS
            pstmt.setString(1, tag.getNome());
            pstmt.setInt(3, tag.getId_tag());

            int cod = pstmt.executeUpdate() > 0 ? 1 : 0;
            return new SqlExitDML(cod);

        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return new SqlExitDML(-1, sqle);
        } finally {
            Conexao.desconectar();
        }
    }

    // Método para Select

    private List<Tag> visualizar() {
        Conexao.conectar();
        try {
            pstmt = Conexao.conn.prepareStatement("SELECT * FROM tag");
            return getLinhas(pstmt.executeQuery());
        } catch (SQLException sqe){
            sqe.printStackTrace();
        } finally {
            Conexao.desconectar();
        }
        return new LinkedList<>();

    }


    private List<Tag> getLinhas(ResultSet rs) throws SQLException {
        if (rs == null) {
            return null;
        }
        List<Tag> tags = new ArrayList<>();

        while (rs.next()) {
            tags.add(new Tag(
                    rs.getInt("id"),
                    rs.getString("nome")
            ));
        }
        return tags;
    }
}
