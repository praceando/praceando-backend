package org.dao;
import org.model.Model;

public class DAOManager {
    private static DAOGeneric<Model>[] daos = new DAOGeneric[]{
            new LogDAO(),
            new AdminDAO(),
            new TagDAO(),
            new AvatarDAO(),
            new ProdutoDAO(),
            new FraseSustentavelDAO(),
            new EventoLocalDAO()
    };

    public static DAOGeneric<Model> getDAO(String nome) {
        for (DAOGeneric<Model> dao : daos) {
            if (dao.getNome().equals(nome)) {
                return dao;
            }
        }
        return null;
    }
}
