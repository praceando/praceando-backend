package org.dao;
import org.model.Tag;
import java.sql.*;


public class TagDAO extends DAOGeneric<Tag> {
    public boolean isReadOnly() {
        return false;
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
                rs.getString("categoria")
        );
    }

    /** Método que retorna a query para inserir uma nova entidade
     * @param tag Entidade a ser inserida
     * @return Query para inserir a entidade
     * @throws SQLException Se ocorrer algum erro com o banco de dados
     */
    @Override
    protected PreparedStatement getInserirQuery(Tag tag) throws SQLException {
        PreparedStatement ps = Conexao.conn.prepareStatement("INSERT INTO tag (nome, categoria) VALUES (?, ?)");
        ps.setString(1, tag.getNome());
        ps.setString(2, tag.getCategoria());
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
        PreparedStatement ps = Conexao.conn.prepareStatement("UPDATE tag SET nome = ?, categoria = ? WHERE id_tag = ?");

        // SETANDO O VALOR DOS PARÂMETROS
        ps.setString(1, tag.getNome());
        ps.setString(2, tag.getCategoria());
        ps.setInt(3, tag.getId());
        return ps;
    }

    /** Método que retorna a query para excluir uma entidade
     * @return Query para excluir a entidade
     */
    @Override
    public String getNome() {
        return "tag";
    }
}