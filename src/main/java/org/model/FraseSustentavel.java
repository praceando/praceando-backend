package org.model;
import java.util.Date;

public class FraseSustentavel {
<<<<<<< HEAD
        private Date dt_atualizacao;
        private String ds_frase;
        private int id_frase;

    public FraseSustentavel(Date dt_atualizacao, String ds_frase, int id_frase) {
        this.dt_atualizacao = dt_atualizacao;
=======
        private String ds_frase;
        private int id_frase;

    /**
     * Construtor que inicializa todos os atributos
     * @param ds_frase Descrição da frase sustentável
     * @param id_frase ID da frase sustentável
     */

    public FraseSustentavel(String ds_frase, int id_frase) {
>>>>>>> c5580918d96592a8c60201406ebbde11b39c3130
        this.ds_frase = ds_frase;
        this.id_frase = id_frase;
    }

<<<<<<< HEAD
    public Date getDt_atualizacao() {
        return dt_atualizacao;
    }
=======
    /**
     * Getter da ds_frase
     * @return Descrição da frase sustentável
     */
>>>>>>> c5580918d96592a8c60201406ebbde11b39c3130

    public String getDs_frase() {
        return ds_frase;
    }

<<<<<<< HEAD
=======
    /**
     * Getter do id_frase
     * @return ID da frase sustentável
     */

>>>>>>> c5580918d96592a8c60201406ebbde11b39c3130
    public int getId_frase() {
        return id_frase;
    }

<<<<<<< HEAD
    public void setDt_atualizacao(Date dt_atualizacao) {
        this.dt_atualizacao = dt_atualizacao;
    }
=======
>>>>>>> c5580918d96592a8c60201406ebbde11b39c3130
}
