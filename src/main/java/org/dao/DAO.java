package org.dao;
import org.common.SqlExitDML;

import java.util.List;

public interface DAO<T> {
    List<T> visualizar();
    T visualizar(int id);
    SqlExitDML inserir(T entidade);
    SqlExitDML alterar(T entidade);
    SqlExitDML remover(int id);
}
