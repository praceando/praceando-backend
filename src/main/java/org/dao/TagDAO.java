package org.dao;
import org.model.Tag;
import java.sql.*;


public class TagDAO extends DAOGeneric<Tag> {

    @Override
    protected Tag extrairEntidade(ResultSet rs) throws SQLException {
        return null;
    }

    @Override
    protected PreparedStatement getInserirQuery(Tag tag) throws SQLException {
        PreparedStatement ps = Conexao.conn.prepareStatement("INSERT INTO tag (nome) values (?)");

        ps.setString(1, tag.getNome());
        return ps;
    }

    @Override
    protected PreparedStatement getAlterarQuery(Tag tag) throws SQLException {
        PreparedStatement ps = Conexao.conn.prepareStatement("UPDATE tag SET nome = ?, categoria = ? WHERE id_tag = ?");
        // SETANDO O VALOR DOS PARÂMETROS
        ps.setString(1, tag.getNome());
        ps.setInt(3, tag.getId());
        return ps;
    }

    @Override
    public String getNome() {
        return "tag";
    }
}
