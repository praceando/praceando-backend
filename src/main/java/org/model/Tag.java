package org.model;
import java.util.Date;

public class Tag {
    private int id;
    private String nome;

    /**
     * Construtor que inicializa os atributos da classe Tag
     * @param id ID da tag
     * @param nome Nome da tag
     */

    public Tag(int id,String nome) {
        this.id = id;
        this.nome = nome;
    }

    /**
     * Getter para o nome da tag
     * @return Nome da tag
     */

    public String getNome() {
        return nome;
    }

    /**
     * Getter para o ID da tag
     * @return ID da tag
     */

    public int getId_tag() {
        return id;
    }

}
