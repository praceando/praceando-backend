package org.model;

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

    /** Método para retornar o HTML da linha do objeto
     * @return HTML da linha do objeto
     */
    String getRawHTMLRow();
}