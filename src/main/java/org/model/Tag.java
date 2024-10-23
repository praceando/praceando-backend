package org.model;
import java.util.Date;

public class Tag {
    private int id;
    private String nome;

    public Tag(int id,String nome) {
        this.id = id;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public int getId_tag() {
        return id;
    }

}
