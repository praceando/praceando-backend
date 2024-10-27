package org.model;
import java.util.Map;

/**
 * Modelo para Interface
 */
public interface Model {
    /** Método para retornar o ID do objeto
     * @return ID do objeto
     */
    int getId();

    /** Método para setar o ID do objeto
     * @param id ID do objeto
     */
    void setId(int id);

    /**
     * Método para retornar os parâmetros do objeto
     * @return Map com os parâmetros do objeto
     */
    Map<String, String> getParams();

}