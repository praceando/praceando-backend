package org.model;
import org.common.Tabela;

import java.util.Map;

/**
 * Interface para os Models, ou objetos representando uma linha de uma tabela do banco de dados
 */
public interface Model {
    /**
     * Pegar o objeto Tabela relativa ao model
     */
    Tabela getTabela();

    /** Método para retornar o ID do model
     * @return ID do model
     */
    int getId();

    /** Método para setar o ID do model
     * @param id ID do model
     */
    void setId(int id);

    /**
     * Método para retornar os parâmetros / atributos do model em um dicionário
     * @return Map com os parâmetros do model
     */
    Map<String, String> getParams();
}