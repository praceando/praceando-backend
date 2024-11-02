package org.model;

import org.common.Constants;
import org.common.Tabela;

import java.util.HashMap;
import java.util.Map;


public class Tag implements Model {
    private int id;
    private String nome;
    private String categoria;
    private String descricao;

    /**Construtor que inicializa os atributos da classe Tag
     * @param id ID da tag
     * @param nome Nome da tag
     */
    public Tag(Integer id, String nome, String categoria, String descricao) {
        this.nome = nome;
        this.id = id;
        this.categoria = categoria;
        this.descricao = descricao;
    }

    /**
     * Construtor que inicializa os atributos da classe Tag a partir de um map de parâmetros
     * @param params Map com os parâmetros da tag
     */
    public Tag(Map<String, String> params) {
        if (params.containsKey("id")) {
            this.id = Integer.parseInt(params.get("id"));
        }
        this.nome = params.get("nome");
        this.categoria = params.get("categoria");
        this.descricao = params.get("descricao");
    }

    /**Getter para o nome da tag
     * @return Nome da tag
     */
    public String getNome() {
        return this.nome;
    }

    /**Getter para a categoria da tag
     * @return Categoria da tag
     */
    public String getCategoria() {
        return this.categoria;
    }

    /**Getter para a descrição da tag
     * @return Descrição da tag
     */
    public String getDescricao() {
        return this.descricao;
    }

    public Tabela getTabela() {
        return Constants.TABELA_TAG;
    }

    /**Getter para o ID da tag
     */
    public int getId() {
        return this.id;
    }

    /**
     * Getter para os parâmetros da tag
     * @return Map com os parâmetros da tag
     */
    public Map<String, String> getParams() {
        Map<String, String> params = new HashMap<>();
        params.put("nome", nome);
        params.put("categoria", categoria);
        params.put("descricao", descricao);
        return params;
    }

    /**Setter para o ID da tag
     */
    public void setId(int id) {
        this.id = id;
    }
}