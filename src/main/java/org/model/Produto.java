package org.model;

import java.util.Date;

public class Produto {
<<<<<<< HEAD
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
=======
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
>>>>>>> c5580918d96592a8c60201406ebbde11b39c3130
        this.estoque = estoque;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.categoria = categoria;
<<<<<<< HEAD
        dt_atualizacao = new Date();
    }

=======
    }
>>>>>>> c5580918d96592a8c60201406ebbde11b39c3130
    public Produto() {

    }

<<<<<<< HEAD

    //Métodos Get

=======
    /**
     * Getter para o estoque do produto
     * @return Quantidade de produtos em estoque
     */
>>>>>>> c5580918d96592a8c60201406ebbde11b39c3130

    public int getEstoque() {
        return estoque;
    }

<<<<<<< HEAD
=======

    /**
     * Getter para o nome do produto
     * @return Nome do produto
     */

>>>>>>> c5580918d96592a8c60201406ebbde11b39c3130
    public String getNome() {
        return nome;
    }

<<<<<<< HEAD
=======
    /**
     * Getter para a descrição do produto
     * @return Descrição do produto
     */

>>>>>>> c5580918d96592a8c60201406ebbde11b39c3130
    public String getDescricao() {
        return descricao;
    }

<<<<<<< HEAD
    public int getPreco() {
        return preco;
    }

=======
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

>>>>>>> c5580918d96592a8c60201406ebbde11b39c3130
    public String getCategoria() {
        return categoria;
    }

<<<<<<< HEAD
    public Date getDt_atualizacao() {
        return dt_atualizacao;
    }
=======
    /**
     * Getter para a data de desativação do produto
     * @return Data de desativação do produto
     */
>>>>>>> c5580918d96592a8c60201406ebbde11b39c3130

    public Date getDt_desativacao() {
        return dt_desativacao;
    }

<<<<<<< HEAD
=======
    /**
     * Getter para o id do produto
     * @return Id do produto
     */

>>>>>>> c5580918d96592a8c60201406ebbde11b39c3130
    public int getId_produto() {
        return id_produto;
    }

<<<<<<< HEAD
    public void setDt_atualizacao(Date dt_atualizacao) {
        this.dt_atualizacao = dt_atualizacao;
    }
=======
    /**
     * Método ToString para imprimir os dados do produto
     * @return String com os dados do produto
     */
>>>>>>> c5580918d96592a8c60201406ebbde11b39c3130

    @Override
    public String toString() {
        return "Produto{" +
                "estoque=" + estoque +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", preco=" + preco +
                ", categoria='" + categoria + '\'' +
<<<<<<< HEAD
                ", dt_atualizacao=" + dt_atualizacao +
=======
>>>>>>> c5580918d96592a8c60201406ebbde11b39c3130
                ", dt_desativacao=" + dt_desativacao +
                ", id_produto=" + id_produto +
                '}';
    }
}
