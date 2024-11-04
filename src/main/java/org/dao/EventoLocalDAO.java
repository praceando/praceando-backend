package org.dao;

import org.common.Constants;
import org.common.Tabela;
import org.model.EventoLocal;

import java.sql.*;

public class EventoLocalDAO extends DAOGeneric<EventoLocal> {

    @Override
    public Tabela getTabela() {return Constants.TABELA_EVENTO_LOCAL;}

    @Override
    public boolean isReadOnly() {
        return false;
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
                rs.getBigDecimal("lon"),
                rs.getTime("dt_func_ini"),
                rs.getTime("dt_func_fim"),
                rs.getDate("dt_atualizacao")
                );
    }

    /** Método que retorna a query para inserir um novo registro na tabela "evento_local"
     * @param local Objeto EventoLocal com os dados a serem inseridos
     * @return PreparedStatement com a query de inserção
     * @throws SQLException Caso ocorra algum erro com a query
     */
    @Override
    protected PreparedStatement getInserirQuery(EventoLocal local) throws SQLException {
        PreparedStatement ps = Conexao.conn.prepareStatement("INSERT INTO evento_local (nome, lat, lon, dt_func_ini, dt_func_fim, dt_atualizacao) values (?,?,?,?,?,current_timestamp)");
        ps.setString(1, local.getNome());
        ps.setBigDecimal(2, local.getLat());
        ps.setBigDecimal(3, local.getLon());
        ps.setTime(4, local.getDt_func_ini());
        ps.setTime(5, local.getDt_func_fim());
        return ps;
    }

    /** Método que retorna a query para alterar um registro na tabela "evento_local"
     * @param local Objeto EventoLocal com os dados a serem alterados
     * @return PreparedStatement com a query de alteração
     * @throws SQLException Caso ocorra algum erro com a query
     */
    @Override
    protected PreparedStatement getAlterarQuery(EventoLocal local) throws SQLException {
        PreparedStatement ps = Conexao.conn.prepareStatement("UPDATE evento_local SET nome = ?, lat = ?, lon = ?, dt_func_ini = ?, dt_func_fim = ?, dt_atualizacao = current_timestamp WHERE id_evento_local = ?");
        ps.setString(1, local.getNome());
        ps.setBigDecimal(2, local.getLat());
        ps.setBigDecimal(3, local.getLon());
        ps.setTime(4, local.getDt_func_ini());
        ps.setTime(5, local.getDt_func_fim());
        ps.setInt(6, local.getId());
        return ps;
    }
}