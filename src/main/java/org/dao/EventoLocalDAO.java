package org.dao;

import org.model.EventoLocal;

import java.sql.*;

public class EventoLocalDAO extends DAOGeneric<EventoLocal> {
    public boolean isReadOnly() {
        return false;
    }

    /** Método que retorna o nome da tabela correspondente a entidade "EventoLocal"
     * @return String com o nome da tabela
     */
    @Override
    public String getNomeBanco() {
        return "evento_local";
    }

    @Override
    public String getNomeInterface() {
        return "Locais dos eventos";
    }

    /** Método que retorna a entidade correspondente a tabela "evento_local"
     * @param rs ResultSet com os dados da tabela
     * @return EventoLocal correspondente ao ResultSet
     * @throws SQLException Caso ocorra algum erro com o ResultSet
     */
    @Override
    protected EventoLocal extrairEntidade(ResultSet rs) throws SQLException {
        return new EventoLocal(
                rs.getInt("id_evento_local"),
                rs.getString("nome"),
                rs.getBigDecimal("lat"),
                rs.getBigDecimal("long")
        );
    }

    /** Método que retorna a query para inserir um novo registro na tabela "evento_local"
     * @param local Objeto EventoLocal com os dados a serem inseridos
     * @return PreparedStatement com a query de inserção
     * @throws SQLException Caso ocorra algum erro com a query
     */
    @Override
    protected PreparedStatement getInserirQuery(EventoLocal local) throws SQLException {
        PreparedStatement ps = Conexao.conn.prepareStatement("INSERT INTO evento_local (nome, lat, long) values (?,?,?)");
        ps.setString(1, local.getNome());
        ps.setBigDecimal(2, local.getLat());
        ps.setBigDecimal(3, local.getLon());
        return ps;
    }

    /** Método que retorna a query para alterar um registro na tabela "evento_local"
     * @param local Objeto EventoLocal com os dados a serem alterados
     * @return PreparedStatement com a query de alteração
     * @throws SQLException Caso ocorra algum erro com a query
     */
    @Override
    protected PreparedStatement getAlterarQuery(EventoLocal local) throws SQLException {
        PreparedStatement ps = Conexao.conn.prepareStatement("UPDATE evento_local SET nome = ?, lat = ?, long = ? WHERE id_evento_local = ?");
        ps.setString(1, local.getNome());
        ps.setBigDecimal(2, local.getLat());
        ps.setBigDecimal(3, local.getLon());
        ps.setInt(4, local.getId());
        return ps;
    }
}