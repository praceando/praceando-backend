package org.dao;
import org.model.Tag;
import java.sql.*;


public class TagDAO extends DAOGeneric<Tag> {
    public boolean isReadOnly() {
        return false;
    }

    @Override
    public String getNomeBanco() {
        return "tag";
    }

    /**
     * Método que retorna a entidade correspondente a linha do ResultSet
     * @param rs ResultSet com a linha correspondente a entidade
     * @return Entidade correspondente a linha do ResultSet
     * @throws SQLException Se ocorrer algum erro com o banco de dados
     */
    @Override
    protected Tag extrairEntidade(ResultSet rs) throws SQLException {
        return new Tag(
                rs.getInt("id_tag"),
                rs.getString("nome"),
                rs.getString("categoria"),
                rs.getString("descricao")
        );
    }

    /** Método que retorna a query para inserir uma nova entidade
     * @param tag Entidade a ser inserida
     * @return Query para inserir a entidade
     * @throws SQLException Se ocorrer algum erro com o banco de dados
     */
    @Override
    protected PreparedStatement getInserirQuery(Tag tag) throws SQLException {
        PreparedStatement ps = Conexao.conn.prepareStatement("INSERT INTO tag (nome, categoria, descricao) VALUES (?,?,?)");
        ps.setString(1, tag.getNome());
        ps.setString(2, tag.getCategoria());
        ps.setString(3, tag.getDescricao());
        return ps;
    }

    /**
     * Método que retorna a query para alterar uma entidade
     * @param tag Entidade a ser alterada
     * @return Query para alterar a entidade
     * @throws SQLException Se ocorrer algum erro com o banco de dados
     */
    @Override
    protected PreparedStatement getAlterarQuery(Tag tag) throws SQLException {
        PreparedStatement ps = Conexao.conn.prepareStatement("UPDATE tag SET nome = ?, categoria = ?, descricao = ? WHERE id_tag = ?");

        // SETANDO O VALOR DOS PARÂMETROS
        ps.setString(1, tag.getNome());
        ps.setString(2, tag.getCategoria());
        ps.setString(3, tag.getDescricao());
        ps.setInt(4, tag.getId());
        return ps;
    }
}