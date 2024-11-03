package org.dao;
import org.common.SqlExitDML;
import org.common.Tabela;
import org.model.Model;

import java.util.List;

public interface DAO<T extends Model> {
    /**
     * Pegar o objeto tabela relativa ao DAO
     */
    Tabela getTabela();

    /** Método para visualizar todos os registros de uma entidade
     * @return Lista de entidades de tipo T
     */
    List<T> visualizar();

    /** Método para visualizar um registro de uma entidade
     * @param id Id do registro a ser visualizado
     * @return Entidade de tipo T
     */
    T visualizar(int id);

    /** Método para inserir um registro de uma entidade
     * @return Entidade de tipo T
     */
    boolean isReadOnly();

    /** Método para inserir um registro de uma entidade
     * @param entidade Entidade de tipo T a ser inserida
     * @return Entidade de tipo T
     */
    SqlExitDML inserir(T entidade);

    /** Método para alterar um registro de uma entidade
     * @param entidade Entidade de tipo T a ser alterada
     * @return Entidade de tipo T
     */
    SqlExitDML alterar(T entidade);

    /** Método para remover um registro de uma entidade
     * @param id Id do registro a ser removido
     * @return Entidade de tipo T
     */
    SqlExitDML remover(int id);
}