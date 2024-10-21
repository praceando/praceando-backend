package org.model;

import java.util.Date;

public class Produto {
    // Colunas da Tabela
    private int estoque;
    private String nome;
    private String descricao;
    private int preco;
    private String categoria;
    private Date dt_atualizacao;
    private Date dt_desativacao;
    private int id_produto;

    // Métodos Construtores


    public Produto(int estoque, String nome, String descricao, int preco, String categoria) {
        this.estoque = estoque;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.categoria = categoria;
        dt_atualizacao = new Date();
    }

    public Produto() {

    }


    //Métodos Get


    public int getEstoque() {
        return estoque;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getPreco() {
        return preco;
    }

    public String getCategoria() {
        return categoria;
    }

    public Date getDt_atualizacao() {
        return dt_atualizacao;
    }

    public Date getDt_desativacao() {
        return dt_desativacao;
    }

    public int getId_produto() {
        return id_produto;
    }

    public void setDt_atualizacao(Date dt_atualizacao) {
        this.dt_atualizacao = dt_atualizacao;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "estoque=" + estoque +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", preco=" + preco +
                ", categoria='" + categoria + '\'' +
                ", dt_atualizacao=" + dt_atualizacao +
                ", dt_desativacao=" + dt_desativacao +
                ", id_produto=" + id_produto +
                '}';
    }
}
