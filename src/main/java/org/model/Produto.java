package org.model;
import org.common.Constants;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Produto implements Model {
    private int id;
    private String nome;
    private String descricao;
    private double preco;
    private String categoria;
    private int estoque;
    private Date dt_desativacao;

    /**
     * Construtor com todos os parâmetros exceto o ID
     *
     * @param id             ID do produto, pode ser null
     * @param nome           Nome do produto
     * @param descricao      Descrição do produto
     * @param preco          Preço do produto
     * @param categoria      Categoria do produto (ecobag)
     * @param estoque        Quantidade de produtos em estoque
     * @param dt_desativacao Data de desativação do Produto
     */
    public Produto(Integer id, String nome, String descricao, double preco, String categoria, int estoque,
                   Date dt_desativacao) {

        this.id = id;
        this.estoque = estoque;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.categoria = categoria;
        this.dt_desativacao = dt_desativacao;

    }

    public Produto(Map<String, String> params) throws ParseException {
        if (params.containsKey("id")) {
            this.id = Integer.parseInt(params.get("id"));
        }
        this.nome = params.get("nome");
        this.descricao = params.get("descricao");
        this.preco = Double.parseDouble(params.get("preco"));
        this.categoria =  params.get("categoria");
        this.dt_desativacao = Constants.formatoData.parse(params.get("dt_desativacao"));
        this.estoque = Integer.parseInt(params.get("estoque"));
    }

    /**Getter para o estoque do produto
     * @return Quantidade de produtos em estoque
     */
    public int getEstoque() {
        return this.estoque;
    }


    /**Getter para o nome do produto
     * @return Nome do produto
     */
    public String getNome() {
        return this.nome;
    }

    /**Getter para a descrição do produto
     * @return Descrição do produto
     */
    public String getDescricao() {
        return this.descricao;
    }

    /**Getter para o preço do produto
     * @return Preço do produto
     */
    public double getPreco() {
        return this.preco;
    }

    /**Getter para a categoria do produto
     * @return Categoria do produto
     */
    public String getCategoria() {
        return this.categoria;
    }

    /**Getter para a data de desativação do produto
     * @return Data de desativação do produto
     */
    public Date getDt_desativacao() {
        return this.dt_desativacao;
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

    public Map<String, String> getParams() {
        Map<String, String> params = new HashMap<>();
        params.put("nome", this.nome);
        params.put("categoria", this.categoria);
        params.put("descricao", this.descricao);
        params.put("preco", Double.toString(this.preco));
        params.put("estoque", Integer.toString(this.estoque));
        params.put("dt_desativacao", this.dt_desativacao.toString());
        return params;
    }
}