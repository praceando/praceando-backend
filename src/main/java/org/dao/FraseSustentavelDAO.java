package org.dao;
import org.model.FraseSustentavel;
import java.sql.*;


public class FraseSustentavelDAO extends DAOGeneric<FraseSustentavel> {
    @Override
    protected FraseSustentavel extrairEntidade(ResultSet rs) throws SQLException {
        return new FraseSustentavel(
                rs.getInt("id_frase_sustentavel"), rs.getString("ds_frase")
        );
    }

    @Override
    protected PreparedStatement getInserirQuery(FraseSustentavel fraseSustentavel) throws SQLException {
        PreparedStatement ps = Conexao.conn.prepareStatement("INSERT INTO frase_sustentavel (ds_frase) values (?)");

        //Setando valor
        ps.setString(1, fraseSustentavel.getDs_frase() );
        return ps;
    }

    @Override
    protected PreparedStatement getAlterarQuery(FraseSustentavel fraseSustentavel) throws SQLException {
        PreparedStatement ps = Conexao.conn.prepareStatement("UPDATE frase_sustentavel SET ds_frase = ? where id_frase = ?");
        ps.setString(1, fraseSustentavel.getDs_frase());
        return ps;
    }

    @Override
    public String getNome() {
        return "frase_sustentavel";
    }
}