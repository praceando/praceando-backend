package org.dao;
import org.common.Constants;
import org.common.Tabela;
import org.model.Tag;
import java.sql.*;


public class TagDAO extends DAOGeneric<Tag> {
    @Override
    public Tabela getTabela() {return Constants.TABELA_TAG;}

    @Override
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
                rs.getString("categoria"),
                rs.getString("descricao"),
                rs.getDate("dt_atualizacao")
        );
    }

    /** Método que retorna a query para inserir uma nova entidade
     * @param tag Entidade a ser inserida
     * @return Query para inserir a entidade
     * @throws SQLException Se ocorrer algum erro com o banco de dados
     */
    @Override
    protected PreparedStatement getInserirQuery(Tag tag) throws SQLException {
        PreparedStatement ps = Conexao.conn.prepareStatement("INSERT INTO tag (nome, categoria, descricao, dt_atualizacao) VALUES (?,?,?,current_date)");
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
        PreparedStatement ps = Conexao.conn.prepareStatement("UPDATE tag SET nome = ?, categoria = ?, descricao = ?, dt_atualizacao = current_date WHERE id_tag = ?");

        // SETANDO O VALOR DOS PARÂMETROS
        ps.setString(1, tag.getNome());
        ps.setString(2, tag.getCategoria());
        ps.setString(3, tag.getDescricao());
        ps.setInt(4, tag.getId());
        return ps;
    }
}