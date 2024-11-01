package org.dao;
import org.model.FraseSustentavel;
import java.sql.*;


public class FraseSustentavelDAO extends DAOGeneric<FraseSustentavel> {

    @Override
    public String getNomeBanco() {
        return "frase_sustentavel";
    }

    @Override
    public String getNomeInterface() {
        return "Frases sustentáveis";
    }


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
                rs.getInt("id_frase_sustentavel"), rs.getString("ds_frase")
        );
    }

    /** Método responsável por criar uma query para inserir uma nova frase sustentável no banco de dados
     * @param fraseSustentavel Objeto do tipo FraseSustentavel com os dados a serem inseridos no banco de dados
     * @return Query com a instrução SQL para inserir uma nova frase sustentável no banco de dados
     * @throws SQLException Caso ocorra algum erro com o banco de dados
     */
    @Override
    protected PreparedStatement getInserirQuery(FraseSustentavel fraseSustentavel) throws SQLException {
        PreparedStatement ps = Conexao.conn.prepareStatement("INSERT INTO frase_sustentavel (ds_frase) VALUES (?)");

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
        PreparedStatement ps = Conexao.conn.prepareStatement("UPDATE frase_sustentavel SET ds_frase = ? WHERE id_frase_sustentavel = ?");
        ps.setString(1, fraseSustentavel.getDescricao());
        ps.setInt(2, fraseSustentavel.getId());
        return ps;
    }

    /** Método responsável por criar uma query para excluir uma frase sustentável do banco de dados
     * @return  Query com a instrução SQL para excluir uma frase sustentável do banco de dados
     */
}