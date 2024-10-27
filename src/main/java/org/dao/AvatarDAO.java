package org.dao;
import org.model.Avatar;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AvatarDAO extends DAOGeneric<Avatar> {

    // Método que retorna se a entidade é somente leitura ou não
    public boolean isReadOnly() {
        return false;
    }

    /** Método que extrai uma entidade do ResultSet
     * @param rs ResultSet com os dados da entidade
     * @return Entidade extraída
     * @throws SQLException Caso ocorra algum erro com o ResultSet
     */
    @Override
    protected Avatar extrairEntidade(ResultSet rs) throws SQLException {
        return new Avatar(
                rs.getInt("id"),
                rs.getString("url_avatar")
        );
    }

    /** Método que retorna a query para inserir uma entidade
     * @param avatar Entidade a ser inserida
     * @return Query de inserção
     * @throws SQLException Caso ocorra algum erro com a query
     */
    @Override
    protected PreparedStatement getInserirQuery(Avatar avatar) throws SQLException {
        PreparedStatement ps = Conexao.conn.prepareStatement("INSERT INTO avatar (b64_avatar) VALUES (?)");

        ps.setString(1, avatar.getUrl_avatar());
        return ps;
    }

    /** Método que retorna a query para alterar uma entidade
     * @param avatar Entidade a ser alterada
     * @return Query de alteração
     * @throws SQLException Caso ocorra algum erro com a query
     */
    @Override
    protected PreparedStatement getAlterarQuery(Avatar avatar) throws SQLException {
        PreparedStatement ps = Conexao.conn.prepareStatement("UPDATE avatar SET url_avatar = ? WHERE id_avatar = ?");
        // SETANDO O VALOR DOS PARÂMETROS
        ps.setString(1, avatar.getUrl_avatar());
        ps.setInt(2, avatar.getId());
        return ps;
    }

    /** Método que retorna o nome da tabela referente a entidade
     * @return Nome da tabela referente a entidade
     */
    @Override
    public String getNome() {
        return "avatar";
    }
}