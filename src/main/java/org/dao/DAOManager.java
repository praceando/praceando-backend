package org.dao;
import java.util.ArrayList;
import java.util.List;

public class DAOManager {
    List<DAOGeneric> daos = new ArrayList<>();

    public DAOGeneric getDAO(String nome) {
        for (DAOGeneric dao : daos) {
            if (dao.getNome().equals(nome)) {
                return dao;
            }
        }
        return null;
    }
}
