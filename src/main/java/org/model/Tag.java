package org.model;
import java.util.Date;

public class Tag {
    private int id;
    private String nome;
    private String categoria;
    private Date dt_atualizacao;

    public Tag(String nome, String categoria) {
        this.nome = nome;
        this.categoria = categoria;
    }

    public String getNome() {
        return nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public Date getDt_atualizacao() {
        return dt_atualizacao;
    }

    public int getId_tag() {
        return id;
    }

    public void setDt_atualizacao(Date dt_atualizacao) {
        this.dt_atualizacao = dt_atualizacao;
    }
}
