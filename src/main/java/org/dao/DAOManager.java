package org.dao;
import org.model.Model;

public class DAOManager {
    /**
     * Atributo que guarda todos os objetos DAOs em um vetor
     */
    private static final DAOGeneric<Model>[] DAOS = new DAOGeneric[]{
            new LogDAO(),
            new AdminDAO(),
            new TagDAO(),
            new AvatarDAO(),
            new ProdutoDAO(),
            new FraseSustentavelDAO(),
            new EventoLocalDAO()
    };

    /**
     * É utilizado para pegar um DAO dado o nome da tabela
     * @param nome nome da tabela
     * @return DAO relativo, se não encontrado, retorna null
     */
    public static DAOGeneric<Model> getDAO(String nome) {
        for (DAOGeneric<Model> dao : DAOS) {
            if (dao.getNome().equals(nome)) {
                return dao;
            }
        }
        return null;
    }
}
