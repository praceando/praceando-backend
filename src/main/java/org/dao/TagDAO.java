package org.dao;

<<<<<<< HEAD
import org.model.Tag;

import java.sql.*;
=======
import org.common.SqlExitDML;
import org.model.Tag;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
>>>>>>> c5580918d96592a8c60201406ebbde11b39c3130

public class TagDAO {
    private PreparedStatement pstmt;
    private ResultSet rs;

    // Método para Insert

    public boolean inserir(Tag tag) {
        Conexao.conectar();
        try {
<<<<<<< HEAD
            pstmt = Conexao.conn.prepareStatement("INSERT INTO tag (tnome, tcategoria) values (?,?)");
=======
            pstmt = Conexao.conn.prepareStatement("INSERT INTO tag (nome) values (?)");
>>>>>>> c5580918d96592a8c60201406ebbde11b39c3130

            //Setando valor

            pstmt.setString(1, tag.getNome());
<<<<<<< HEAD
            pstmt.setString(2, tag.getCategoria());
=======
>>>>>>> c5580918d96592a8c60201406ebbde11b39c3130
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

<<<<<<< HEAD
    public int remover(Tag tag) {
=======
    public SqlExitDML remover(Tag tag) {
>>>>>>> c5580918d96592a8c60201406ebbde11b39c3130
        Conexao.conectar();
        try {
            String remover = "DELETE FROM tag WHERE id_tag = ?";
            // Instanciando o objeto preparedStatement (pstmt)
            pstmt = Conexao.conn.prepareStatement(remover);
            //Setando o valor do parâmetro
            pstmt.setInt(1, tag.getId_tag());
//            tag.setDt_atualizacao(conexao.dt_atualizacao());

<<<<<<< HEAD
            return pstmt.executeUpdate() > 0 ? 1 : 0;
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return -1;
        } catch (NullPointerException npe){
            npe.printStackTrace();
            return 0;
=======
            int cod = (pstmt.executeUpdate() > 0 ? 1 : 0);  // Executa o comando sql do preparedStatement, retorna um código
            return new SqlExitDML(cod);
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return new SqlExitDML(-1);
>>>>>>> c5580918d96592a8c60201406ebbde11b39c3130
        } finally {
            Conexao.desconectar();
        }

    }

    // Método para Alterar
<<<<<<< HEAD
    public int alterar(Tag tag) {
        Statement statement = null;
=======
    public SqlExitDML alterar(Tag tag) {
>>>>>>> c5580918d96592a8c60201406ebbde11b39c3130

        try {
            pstmt = Conexao.conn.prepareStatement("UPDATE tag SET nome = ?, categoria = ? WHERE id_tag = ?");
            // SETANDO O VALOR DOS PARÂMETROS
            pstmt.setString(1, tag.getNome());
<<<<<<< HEAD
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
=======
            pstmt.setInt(3, tag.getId_tag());

            int cod = pstmt.executeUpdate() > 0 ? 1 : 0;
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
            pstmt = Conexao.conn.prepareStatement("SELECT * FROM Tag ORDER BY id_tag");
            ResultSet rs = pstmt.executeQuery();
            return rs;
=======
    private List<Tag> visualizar() {
        Conexao.conectar();
        try {
            pstmt = Conexao.conn.prepareStatement("SELECT * FROM tag");
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
>>>>>>> c5580918d96592a8c60201406ebbde11b39c3130
    }
}
