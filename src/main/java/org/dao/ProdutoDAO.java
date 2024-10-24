package org.dao;

<<<<<<< HEAD
import org.model.Produto;

import java.sql.*;

public class ProdutoDAO{
=======
import org.common.SqlExitDML;
import org.model.Produto;
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ProdutoDAO {
>>>>>>> c5580918d96592a8c60201406ebbde11b39c3130
    private PreparedStatement pstmt;
    private ResultSet rs;


    // Método para Insert

<<<<<<< HEAD
    public int inserir(Produto produto) {
=======
    public SqlExitDML inserir(Produto produto) {
>>>>>>> c5580918d96592a8c60201406ebbde11b39c3130
        Conexao.conectar();
        try {
            pstmt = Conexao.conn.prepareStatement("INSERT INTO produto (estoque, nome, ds_produto, preco, categoria) values (?,?,?,?,?)");

            // Setando valor

            pstmt.setInt(1, produto.getEstoque());
            pstmt.setString(2, produto.getNome() );
            pstmt.setString(3, produto.getDescricao());
            pstmt.setDouble(4, produto.getPreco());
            pstmt.setString(5, produto.getCategoria());
<<<<<<< HEAD
//            produto.setDt_atualizacao(conexao.dt_atualizacao());
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
    public int alterar(Produto produto) {
        Conexao.conectar();
        Statement statement = null;

=======

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
    public SqlExitDML alterar(Produto produto) {
        Conexao.conectar();
>>>>>>> c5580918d96592a8c60201406ebbde11b39c3130
        try{
            pstmt = Conexao.conn.prepareStatement("update produto set nome = ?, ds_produto = ?, preco = ?, categoria = ? where id_produto = ?");
            // SETANDO O VALOR DOS PARÂMETROS
            pstmt.setString(1, produto.getNome());
            pstmt.setString(2, produto.getDescricao());
            pstmt.setDouble(3, produto.getPreco());
            pstmt.setString(4, produto.getCategoria());
            pstmt.setInt(5, produto.getId_produto());
//            produto.setDt_atualizacao(conexao.dt_atualizacao());
<<<<<<< HEAD
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
    public ResultSet visualizar(){
        Conexao.conectar();
        try {
            pstmt = Conexao.conn.prepareStatement("SELECT * FROM Produto");
            ResultSet rs = pstmt.executeQuery();
            return rs;

        }catch (SQLException sqe){
            sqe.printStackTrace();
            return null;
        } finally {
            Conexao.desconectar();
        }
=======
    private List<Produto> visualizar() {
        Conexao.conectar();
        try {
            pstmt = Conexao.conn.prepareStatement("SELECT * FROM produto");
            return getLinhas(pstmt.executeQuery());
        } catch (SQLException sqe){
            sqe.printStackTrace();
        } finally {
            Conexao.desconectar();
        }
        return new LinkedList<>();

    }


    private List<Produto> getLinhas(ResultSet rs) throws SQLException {
        if (rs == null) {
            return null;
        }
        List<Produto> produtos = new ArrayList<>();

        while (rs.next()) {
            produtos.add(new Produto(
                    rs.getInt("estoque"),
                    rs.getString("nome"),
                    rs.getString("descricao"),
                    rs.getDouble("preco"),
                    rs.getString("categoria")

            ));
        }
        return produtos;
>>>>>>> c5580918d96592a8c60201406ebbde11b39c3130
    }


}

<<<<<<< HEAD
// No geral o comando seguem essa mesma estrutura, menos o select
=======
>>>>>>> c5580918d96592a8c60201406ebbde11b39c3130

