package org.dao;

import org.model.Produto;

import java.sql.*;

public class ProdutoDAO{
    private PreparedStatement pstmt;
    private ResultSet rs;


    // Método para Insert

    public int inserir(Produto produto) {
        Conexao.conectar();
        try {
            pstmt = Conexao.conn.prepareStatement("INSERT INTO produto (estoque, nome, ds_produto, preco, categoria) values (?,?,?,?,?)");

            // Setando valor

            pstmt.setInt(1, produto.getEstoque());
            pstmt.setString(2, produto.getNome() );
            pstmt.setString(3, produto.getDescricao());
            pstmt.setDouble(4, produto.getPreco());
            pstmt.setString(5, produto.getCategoria());
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

        try{
            pstmt = Conexao.conn.prepareStatement("update produto set nome = ?, ds_produto = ?, preco = ?, categoria = ? where id_produto = ?");
            // SETANDO O VALOR DOS PARÂMETROS
            pstmt.setString(1, produto.getNome());
            pstmt.setString(2, produto.getDescricao());
            pstmt.setDouble(3, produto.getPreco());
            pstmt.setString(4, produto.getCategoria());
            pstmt.setInt(5, produto.getId_produto());
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

    // Método para Select

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
    }


}

// No geral o comando seguem essa mesma estrutura, menos o select

