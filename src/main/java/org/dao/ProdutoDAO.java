package org.dao;

import org.model.Produto;
import java.sql.*;

public class ProdutoDAO extends DAOGeneric<Produto> {
    public boolean isReadOnly() {
        return false;
    }

    @Override
    protected Produto extrairEntidade(ResultSet rs) throws SQLException {
        return new Produto(
                rs.getInt("id_produto"),
                rs.getInt("estoque"),
                rs.getString("nome"),
                rs.getString("ds_produto"),
                rs.getDouble("preco"),
                rs.getString("categoria"),
                rs.getDate("dt_desativacao")
        );
    }

    @Override
    protected PreparedStatement getInserirQuery(Produto produto) throws SQLException {
        PreparedStatement ps = Conexao.conn.prepareStatement("INSERT INTO produto (estoque, nome, ds_produto, preco, categoria) values (?,?,?,?,?)");

        ps.setInt(1, produto.getEstoque());
        ps.setString(2, produto.getNome() );
        ps.setString(3, produto.getDescricao());
        ps.setDouble(4, produto.getPreco());
        ps.setString(5, produto.getCategoria());

        return ps;
    }

    @Override
    protected PreparedStatement getAlterarQuery(Produto produto) throws SQLException {
        PreparedStatement ps = Conexao.conn.prepareStatement("update produto set nome = ?, ds_produto = ?, preco = ?, categoria = ? where id_produto = ?");
        // SETANDO O VALOR DOS PARÂMETROS
        ps.setString(1, produto.getNome());
        ps.setString(2, produto.getDescricao());
        ps.setDouble(3, produto.getPreco());
        ps.setString(4, produto.getCategoria());
        ps.setInt(5, produto.getId());

        return ps;
    }

    @Override
    public String getNome() {
        return "produto";
    }
}


