package org.dao;

import org.model.Tag;

import java.sql.*;

public class TagDAO {
    private PreparedStatement pstmt;
    private ResultSet rs;

    // Método para Insert

    public boolean inserir(Tag tag) {
        Conexao.conectar();
        try {
            pstmt = Conexao.conn.prepareStatement("INSERT INTO tag (tnome, tcategoria) values (?,?)");

            //Setando valor

            pstmt.setString(1, tag.getNome());
            pstmt.setString(2, tag.getCategoria());
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

    public int remover(Tag tag) {
        Conexao.conectar();
        try {
            String remover = "DELETE FROM tag WHERE id_tag = ?";
            // Instanciando o objeto preparedStatement (pstmt)
            pstmt = Conexao.conn.prepareStatement(remover);
            //Setando o valor do parâmetro
            pstmt.setInt(1, tag.getId_tag());
//            tag.setDt_atualizacao(conexao.dt_atualizacao());

            return pstmt.executeUpdate() > 0 ? 1 : 0;
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return -1;
        } catch (NullPointerException npe){
            npe.printStackTrace();
            return 0;
        } finally {
            Conexao.desconectar();
        }

    }

    // Método para Alterar
    public int alterar(Tag tag) {
        Statement statement = null;

        try {
            pstmt = Conexao.conn.prepareStatement("UPDATE tag SET nome = ?, categoria = ? WHERE id_tag = ?");
            // SETANDO O VALOR DOS PARÂMETROS
            pstmt.setString(1, tag.getNome());
            pstmt.setString(2, tag.getCategoria());
            pstmt.setInt(3, tag.getId_tag());
//            tag.setDt_atualizacao(conexao.dt_atualizacao());
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
            pstmt = Conexao.conn.prepareStatement("SELECT * FROM Tag ORDER BY id_tag");
            ResultSet rs = pstmt.executeQuery();
            return rs;
        } catch (SQLException sqe){
            sqe.printStackTrace();
        } finally {
            Conexao.desconectar();
        }
        return null;
    }
}
