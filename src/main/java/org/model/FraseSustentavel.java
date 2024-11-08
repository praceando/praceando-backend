package org.model;
import org.common.Constants;
import org.common.Tabela;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

public class FraseSustentavel implements Model {
    private int id;
    private String descricao;
    private Date dt_atualizacao;

    /**
     * Construtor que inicializa todos os atributos
     *
     * @param id ID da frase sustentável
     * @param descricao Descrição da frase sustentável
     */
    public FraseSustentavel(int id, String descricao, Date dt_atualizacao) {
        this.id = id;
        this.descricao = descricao;
        this.dt_atualizacao = dt_atualizacao;
    }

    /** Método que retorna o nome da entidade no banco de dados
     * @param params Map com os parâmetros da entidade
     */
    public FraseSustentavel(Map<String, String> params) {
        if (params.containsKey("id")) {
            System.out.println("Construtor frasesustentavel: ID=" + params.get("id"));
            this.id = Integer.parseInt(params.get("id"));
        }
        this.descricao = params.get("descricao");
    }

    /** Getter da Descrição
     * @return Descrição da frase sustentável
     */
    public String getDescricao() {
        return descricao;
    }

    public Tabela getTabela() {
        return Constants.TABELA_FRASE_SUSTENTAVEL;
    }

    /**Getter do id_frase
     * @return ID da frase sustentável
     */
    public int getId() {
        return this.id;
    }

    /**Setter do id da frase sustentável
     */
    public void setId(int id) {
        this.id = id;
    }

    /** Método que retorna os parâmetros da entidade em forma de Map
     * @return Map com os parâmetros da entidade
     */
    public Map<String, String> getParams() {
        Map<String, String> params = new HashMap<>();
        params.put("descricao", descricao);
        return params;
    }
}