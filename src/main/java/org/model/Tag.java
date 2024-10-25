package org.model;

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
        this.id = Integer.parseInt(params.get("id"));
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

    /**Setter para o ID da tag
     */
    public void setId(int id) {
        this.id = id;
    }

    /**Método utilizado para gerar uma linha HTML com os dados da tag
     * @return Uma linha HTML com os dados da tag
     */
    public String getRawHTMLRow() {
        return String.format(
                "<td>%d</td>" +
                "<td>%s</td>",
                "<td>%s</td>",
                id,
                nome,
                categoria
        );
    }
}