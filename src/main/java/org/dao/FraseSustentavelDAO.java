package org.dao;
import org.common.Constants;
import org.common.Tabela;
import org.model.FraseSustentavel;
import java.sql.*;


public class FraseSustentavelDAO extends DAOGeneric<FraseSustentavel> {

    @Override
    public Tabela getTabela() {return Constants.TABELA_FRASE_SUSTENTAVEL;}

    @Override
    public boolean isReadOnly() {
        return false;
    }

    /** Método responsável por extrair os dados de um ResultSet e criar uma entidade do tipo FraseSustentavel
     * @param rs ResultSet com os dados a serem extraídos
     * @return Entidade do tipo FraseSustentavel
     * @throws SQLException Caso ocorra algum erro com o banco de dados
     */
    @Override
    protected FraseSustentavel extrairEntidade(ResultSet rs) throws SQLException {
        return new FraseSustentavel(
                rs.getInt("id_frase_sustentavel"),
                rs.getString("ds_frase"),
                rs.getDate("dt_atualizacao")
        );
    }

    /** Método responsável por criar uma query para inserir uma nova frase sustentável no banco de dados
     * @param fraseSustentavel Objeto do tipo FraseSustentavel com os dados a serem inseridos no banco de dados
     * @return Query com a instrução SQL para inserir uma nova frase sustentável no banco de dados
     * @throws SQLException Caso ocorra algum erro com o banco de dados
     */
    @Override
    protected PreparedStatement getInserirQuery(FraseSustentavel fraseSustentavel) throws SQLException {
        PreparedStatement ps = Conexao.conn.prepareStatement("INSERT INTO frase_sustentavel (ds_frase, dt_atualizacao) VALUES (?, current_timestamp)");

        //Setando valor
        ps.setString(1, fraseSustentavel.getDescricao() );
        return ps;
    }

    /** Método responsável por criar uma query para alterar uma frase sustentável no banco de dados
     * @param fraseSustentavel  Objeto do tipo FraseSustentavel com os dados a serem alterados no banco de dados
     * @return Query com a instrução SQL para alterar uma frase sustentável no banco de dados
     * @throws SQLException Caso ocorra algum erro com o banco de dados
     */
    @Override
    protected PreparedStatement getAlterarQuery(FraseSustentavel fraseSustentavel) throws SQLException {
        PreparedStatement ps = Conexao.conn.prepareStatement("UPDATE frase_sustentavel SET ds_frase = ?, dt_atualizacao = current_timestamp WHERE id_frase_sustentavel = ?");
        ps.setString(1, fraseSustentavel.getDescricao());
        ps.setInt(2, fraseSustentavel.getId());
        return ps;
    }
}