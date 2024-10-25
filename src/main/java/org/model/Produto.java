package org.model;
import java.util.Date;

public class Produto implements Model {
    private int estoque;
    private String nome;
    private String descricao;
    private double preco;
    private String categoria;
    private Date dt_desativacao;
    private int id;

    /**Construtor com todos os parâmetros exceto o ID
     * @param id ID do produto, pode ser null
     * @param estoque Quantidade de produtos em estoque
     * @param nome Nome do produto
     * @param descricao Descrição do produto
     * @param preco Preço do produto
     * @param categoria Categoria do produto (ecobag)
     * @param dt_desativacao Data de desativação do Produto
     */
    public Produto(Integer id, int estoque, String nome, String descricao,
                   double preco, String categoria, Date dt_desativacao) {

        this.id = id;
        this.estoque = estoque;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.categoria = categoria;
        this.dt_desativacao = dt_desativacao;

    }

    /**Getter para o estoque do produto
     * @return Quantidade de produtos em estoque
     */
    public int getEstoque() {
        return estoque;
    }


    /**Getter para o nome do produto
     * @return Nome do produto
     */
    public String getNome() {
        return nome;
    }

    /**Getter para a descrição do produto
     * @return Descrição do produto
     */
    public String getDescricao() {
        return descricao;
    }

    /**Getter para o preço do produto
     * @return Preço do produto
     */
    public double getPreco() {
        return preco;
    }

    /**Getter para a categoria do produto
     * @return Categoria do produto
     */
    public String getCategoria() {
        return categoria;
    }

    /**Getter para a data de desativação do produto
     * @return Data de desativação do produto
     */
    public Date getDt_desativacao() {
        return dt_desativacao;
    }

    /**Getter para o id do produto
     * @return Id do produto
     */
    public int getId() {
        return id;
    }

    /**Setter para o id do produto
     */
    public void setId(int id) {
        this.id = id;
    }

    /**Método utilizado para gerar uma linha HTML com os dados dos produtos do nosso marketplace
     * @return Uma linha HTML com os dados dos produtos
     */
    public String getRawHTMLRow() {
        return String.format(
                "<td>%d</td>" +
                "<td>%s</td>" +
                "<td>%s</td>" +
                "<td>R$ %.2f</td>" +
                "<td>%s</td>" +
                "<td>%d</td>" +
                "<td>%s</td>",
                id,
                nome,
                descricao,
                preco,
                categoria,
                estoque,
                dt_desativacao != null ? dt_desativacao.toString() : "NÃO"
        );
    }
}