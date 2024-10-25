package org.dao;
import org.model.Model;
import java.util.ArrayList;
import java.util.List;

public class DAOManager {
    private static List<DAOGeneric<Model>> daos = new ArrayList<>();

    public static DAOGeneric<Model> getDAO(String nome) {
        for (DAOGeneric<Model> dao : daos) {
            if (dao.getNome().equals(nome)) {
                return dao;
            }
        }
        return null;
    }
}
