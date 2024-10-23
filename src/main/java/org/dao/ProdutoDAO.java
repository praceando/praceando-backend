package org.dao;

import org.common.SqlExitDML;
import org.model.Produto;
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ProdutoDAO {
    private PreparedStatement pstmt;
    private ResultSet rs;


    // Método para Insert

    public SqlExitDML inserir(Produto produto) {
        Conexao.conectar();
        try {
            pstmt = Conexao.conn.prepareStatement("INSERT INTO produto (estoque, nome, ds_produto, preco, categoria) values (?,?,?,?,?)");

            // Setando valor

            pstmt.setInt(1, produto.getEstoque());
            pstmt.setString(2, produto.getNome() );
            pstmt.setString(3, produto.getDescricao());
            pstmt.setDouble(4, produto.getPreco());
            pstmt.setString(5, produto.getCategoria());

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
        try{
            pstmt = Conexao.conn.prepareStatement("update produto set nome = ?, ds_produto = ?, preco = ?, categoria = ? where id_produto = ?");
            // SETANDO O VALOR DOS PARÂMETROS
            pstmt.setString(1, produto.getNome());
            pstmt.setString(2, produto.getDescricao());
            pstmt.setDouble(3, produto.getPreco());
            pstmt.setString(4, produto.getCategoria());
            pstmt.setInt(5, produto.getId_produto());
//            produto.setDt_atualizacao(conexao.dt_atualizacao());
            int cod = (pstmt.executeUpdate() > 0 ? 1 : 0);  // Executa o comando sql do preparedStatement, retorna um código
            return new SqlExitDML(cod);
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return new SqlExitDML(-1, sqle);
        } finally {
            Conexao.desconectar();
        }
    }

    // Método para Select

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
    }


}


