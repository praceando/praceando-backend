package org.model;
import java.util.Date;

public class Tag {
    private int id;
    private String nome;
<<<<<<< HEAD
    private String categoria;
    private Date dt_atualizacao;

    public Tag(String nome, String categoria) {
        this.nome = nome;
        this.categoria = categoria;
    }

=======

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

>>>>>>> c5580918d96592a8c60201406ebbde11b39c3130
    public String getNome() {
        return nome;
    }

<<<<<<< HEAD
    public String getCategoria() {
        return categoria;
    }

    public Date getDt_atualizacao() {
        return dt_atualizacao;
    }
=======
    /**
     * Getter para o ID da tag
     * @return ID da tag
     */
>>>>>>> c5580918d96592a8c60201406ebbde11b39c3130

    public int getId_tag() {
        return id;
    }

<<<<<<< HEAD
    public void setDt_atualizacao(Date dt_atualizacao) {
        this.dt_atualizacao = dt_atualizacao;
    }
=======
>>>>>>> c5580918d96592a8c60201406ebbde11b39c3130
}
