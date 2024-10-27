package org.dao;
import org.model.Avatar;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AvatarDAO extends DAOGeneric<Avatar> {

    public boolean isReadOnly() {
        return false;
    }

    @Override
    protected Avatar extrairEntidade(ResultSet rs) throws SQLException {
        return new Avatar(
                rs.getInt("id"),
                rs.getString("url_avatar")
        );
    }

    @Override
    protected PreparedStatement getInserirQuery(Avatar avatar) throws SQLException {
        PreparedStatement ps = Conexao.conn.prepareStatement("INSERT INTO avatar (b64_avatar) VALUES (?)");

        ps.setString(1, avatar.getUrl_avatar());
        return ps;
    }

    @Override
    protected PreparedStatement getAlterarQuery(Avatar avatar) throws SQLException {
        PreparedStatement ps = Conexao.conn.prepareStatement("UPDATE avatar SET url_avatar = ? WHERE id_avatar = ?");
        // SETANDO O VALOR DOS PARÂMETROS
        ps.setString(1, avatar.getUrl_avatar());
        ps.setInt(2, avatar.getId());
        return ps;
    }

    @Override
    public String getNome() {
        return "avatar";
    }
}
