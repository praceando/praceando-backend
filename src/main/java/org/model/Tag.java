package org.model;
import org.model.Model;

public class Tag implements Model {
    private int id;
    private String nome;
    private String categoria;

    /**
     * Construtor que inicializa os atributos da classe Tag
     * @param id ID da tag
     * @param nome Nome da tag
     */

    public Tag(Integer id, String nome, String categoria) {
        this.nome = nome;
        this.id = id;
        this.categoria = categoria;
    }

    /**
     * Getter para o nome da tag
     * @return Nome da tag
     */

    public String getNome() {
        return nome;
    }

    public String getCategoria() {
        return categoria;
    }

    /**
     * Getter para o ID da tag
     */
    public int getId() {
        return id;
    }

    /**
     * Setter para o ID da tag
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return
     */
    public String getRawHTMLRow() {
        return String.format(
                "<td>%d</td>" +
                "<td>%s</td>",
                id,
                nome);
    }
}
