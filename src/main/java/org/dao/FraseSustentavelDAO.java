package org.dao;
import org.model.FraseSustentavel;
import java.sql.*;


public class FraseSustentavelDAO extends DAOGeneric<FraseSustentavel> {
    public boolean isReadOnly() {
        return false;
    }

    @Override
    protected FraseSustentavel extrairEntidade(ResultSet rs) throws SQLException {
        return new FraseSustentavel(
                rs.getInt("id_frase_sustentavel"), rs.getString("ds_frase")
        );
    }

    @Override
    protected PreparedStatement getInserirQuery(FraseSustentavel fraseSustentavel) throws SQLException {
        PreparedStatement ps = Conexao.conn.prepareStatement("INSERT INTO frase_sustentavel (ds_frase) VALUES (?)");

        //Setando valor
        ps.setString(1, fraseSustentavel.getDescricao() );
        return ps;
    }

    @Override
    protected PreparedStatement getAlterarQuery(FraseSustentavel fraseSustentavel) throws SQLException {
        PreparedStatement ps = Conexao.conn.prepareStatement("UPDATE frase_sustentavel SET ds_frase = ? WHERE id_frase_sustentavel = ?");
        ps.setString(1, fraseSustentavel.getDescricao());
        ps.setInt(2, fraseSustentavel.getId());
        return ps;
    }

    @Override
    public String getNome() {
        return "frase_sustentavel";
    }
}