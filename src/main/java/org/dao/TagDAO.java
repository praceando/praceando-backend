package org.dao;
import org.model.Tag;
import java.sql.*;


public class TagDAO extends DAOGeneric<Tag> {
    public boolean isReadOnly() {
        return false;
    }

    @Override
    protected Tag extrairEntidade(ResultSet rs) throws SQLException {
        return new Tag(
                rs.getInt("id_tag"),
                rs.getString("nome"),
                rs.getString("categoria")
        );
    }

    @Override
    protected PreparedStatement getInserirQuery(Tag tag) throws SQLException {
        PreparedStatement ps = Conexao.conn.prepareStatement("INSERT INTO tag (nome, categoria) VALUES (?, ?)");
        ps.setString(1, tag.getNome());
        ps.setString(2, tag.getCategoria());
        return ps;
    }

    @Override
    protected PreparedStatement getAlterarQuery(Tag tag) throws SQLException {
        PreparedStatement ps = Conexao.conn.prepareStatement("UPDATE tag SET nome = ?, categoria = ? WHERE id_tag = ?");
        // SETANDO O VALOR DOS PARÂMETROS
        ps.setString(1, tag.getNome());
        ps.setString(2, tag.getCategoria());
        ps.setInt(3, tag.getId());
        return ps;
    }

    @Override
    public String getNome() {
        return "tag";
    }
}
