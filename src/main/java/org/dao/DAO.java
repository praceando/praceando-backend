package org.dao;
import org.common.SqlExitDML;
import org.common.Tabela;
import org.model.Model;

import java.util.List;

/**
 * Interface representante de um Data Access Object (DAO)
 * que força a implementação de todos os métodos do CRUD
 * @param <T> A qual Model esse DAO se refere?
 */
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