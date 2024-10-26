package org.model;

import java.util.HashMap;
import java.util.Map;

public class Tag implements Model {
    private int id;
    private String nome;
    private String categoria;

    /**Construtor que inicializa os atributos da classe Tag
     * @param id ID da tag
     * @param nome Nome da tag
     */
    public Tag(Integer id, String nome, String categoria) {
        this.nome = nome;
        this.id = id;
        this.categoria = categoria;
    }

    public Tag(Map<String, String> params) {
        if (params.containsKey("id")) {
            this.id = Integer.parseInt(params.get("id"));
        }
        this.nome = params.get("nome");
        this.categoria = params.get("categoria");
    }

    /**Getter para o nome da tag
     * @return Nome da tag
     */
    public String getNome() {
        return nome;
    }

    /**Getter para a categoria da tag
     * @return Categoria da tag
     */
    public String getCategoria() {
        return categoria;
    }

    /**Getter para o ID da tag
     */
    public int getId() {
        return id;
    }

    public Map<String, String> getParams() {
        Map<String, String> params = new HashMap<>();
        params.put("nome", nome);
        params.put("categoria", categoria);
        return params;
    }

    /**Setter para o ID da tag
     */
    public void setId(int id) {
        this.id = id;
    }
}