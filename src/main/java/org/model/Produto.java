package org.model;

import java.util.Date;

public class Produto {
    // Colunas da Tabela
    private int estoque;
    private String nome;
    private String descricao;
    private double preco;
    private String categoria;

    private Date dt_desativacao;
    private int id_produto;

    // Métodos Construtores


    public Produto(int estoque, String nome, String descricao, double preco, String categoria) {
        this.estoque = estoque;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.categoria = categoria;
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

    public double getPreco() {
        return preco;
    }

    public String getCategoria() {
        return categoria;
    }

    public Date getDt_desativacao() {
        return dt_desativacao;
    }

    public int getId_produto() {
        return id_produto;
    }


    @Override
    public String toString() {
        return "Produto{" +
                "estoque=" + estoque +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", preco=" + preco +
                ", categoria='" + categoria + '\'' +
                ", dt_desativacao=" + dt_desativacao +
                ", id_produto=" + id_produto +
                '}';
    }
}
