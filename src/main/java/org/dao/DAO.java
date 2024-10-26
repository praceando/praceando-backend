package org.dao;
import org.common.SqlExitDML;
import org.model.Model;

import java.util.List;

public interface DAO<T extends Model> {
    List<T> visualizar();
    T visualizar(int id);
    SqlExitDML inserir(T entidade);
    SqlExitDML alterar(T entidade);
    SqlExitDML remover(int id);
}
