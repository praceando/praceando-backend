package org.model;

import java.util.Date;

public class Produto {
    private int estoque;
    private String nome;
    private String descricao;
    private double preco;
    private String categoria;

    private Date dt_desativacao;
    private int id_produto;

    /**
     * Construtor com todos os parâmetros
     * @param estoque Quantidade de produtos em estoque
     * @param nome Nome do produto
     * @param descricao Descrição do produto
     * @param preco Preço do produto
     * @param categoria Categoria do produto (ecobag)
     */

    public Produto(int estoque, String nome, String descricao, double preco, String categoria) {
        this.estoque = estoque;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.categoria = categoria;
    }
    public Produto() {

    }

    /**
     * Getter para o estoque do produto
     * @return Quantidade de produtos em estoque
     */

    public int getEstoque() {
        return estoque;
    }


    /**
     * Getter para o nome do produto
     * @return Nome do produto
     */

    public String getNome() {
        return nome;
    }

    /**
     * Getter para a descrição do produto
     * @return Descrição do produto
     */

    public String getDescricao() {
        return descricao;
    }

    /**
     * Getter para o preço do produto
     * @return Preço do produto
     */

    public double getPreco() {
        return preco;
    }

    /**
     * Getter para a categoria do produto
     * @return Categoria do produto
     */

    public String getCategoria() {
        return categoria;
    }

    /**
     * Getter para a data de desativação do produto
     * @return Data de desativação do produto
     */

    public Date getDt_desativacao() {
        return dt_desativacao;
    }

    /**
     * Getter para o id do produto
     * @return Id do produto
     */

    public int getId_produto() {
        return id_produto;
    }

    /**
     * Método ToString para imprimir os dados do produto
     * @return String com os dados do produto
     */

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
