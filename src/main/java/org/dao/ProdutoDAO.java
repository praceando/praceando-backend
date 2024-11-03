package org.dao;

import org.common.Constants;
import org.common.Tabela;
import org.model.Produto;
import java.sql.*;

public class ProdutoDAO extends DAOGeneric<Produto> {

    @Override
    public Tabela getTabela() {return Constants.TABELA_PRODUTO;}

    @Override
    public boolean isReadOnly() {
        return false;
    }

    /**
     * Extrai uma entidade do ResultSet
     *
     * @param rs ResultSet
     * @return Entidade extraída
     * @throws SQLException Se ocorrer algum erro com o banco de dados
     */
    @Override
    protected Produto extrairEntidade(ResultSet rs) throws SQLException {
        return new Produto(
                rs.getInt("id_produto"),
                rs.getString("nome"), rs.getString("ds_produto"), rs.getDouble("preco"), rs.getString("categoria"), rs.getInt("estoque"),
                rs.getDate("dt_desativacao"),
                rs.getDate("dt_atualizacao")
        );
    }

    /**
     * Cria uma query para inserir uma entidade no banco de dados
     *
     * @param produto Entidade a ser inserida
     * @return Query de inserção
     * @throws SQLException Se ocorrer algum erro com o banco de dados
     */
    @Override
    protected PreparedStatement getInserirQuery(Produto produto) throws SQLException {
        PreparedStatement ps = Conexao.conn.prepareStatement("INSERT INTO produto (estoque, nome, ds_produto, preco, categoria, dt_desativacao, dt_atualizacao) values (?,?,?,?,?,?, current_timestamp)");

        ps.setInt(1, produto.getEstoque());
        ps.setString(2, produto.getNome());
        ps.setString(3, produto.getDescricao());
        ps.setDouble(4, produto.getPreco());
        ps.setString(5, produto.getCategoria());
        ps.setDate(6, produto.getDt_desativacao());

        return ps;
    }

    /**
     * Cria uma query para alterar uma entidade no banco de dados
     *
     * @param produto Entidade a ser alterada
     * @return Query de alteração
     * @throws SQLException Se ocorrer algum erro com o banco de dados
     */
    @Override
    protected PreparedStatement getAlterarQuery(Produto produto) throws SQLException {
        PreparedStatement ps = Conexao.conn.prepareStatement("update produto set nome = ?, ds_produto = ?, preco = ?, categoria = ?, dt_desativacao = ?, dt_atualizacao = current_timestamp where id_produto = ?");
        // SETANDO O VALOR DOS PARÂMETROS
        ps.setString(1, produto.getNome());
        ps.setString(2, produto.getDescricao());
        ps.setDouble(3, produto.getPreco());
        ps.setString(4, produto.getCategoria());
        ps.setDate(5, produto.getDt_desativacao());
        ps.setInt(6, produto.getId());

        return ps;
    }
}
