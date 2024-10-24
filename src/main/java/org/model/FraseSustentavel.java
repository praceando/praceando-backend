package org.model;

public class FraseSustentavel {
    private String ds_frase;
    private int id_frase;

    /**
     * Construtor que inicializa todos os atributos
     * @param ds_frase Descrição da frase sustentável
     * @param id_frase ID da frase sustentável
     */

    public FraseSustentavel(String ds_frase, int id_frase) {
        this.ds_frase = ds_frase;
        this.id_frase = id_frase;
    }

    /**
     * Getter da ds_frase
     * @return Descrição da frase sustentável
     */

    public String getDs_frase() {
        return ds_frase;
    }

    /**
     * Getter do id_frase
     * @return ID da frase sustentável
     */

    public int getId_frase() {
        return id_frase;
    }

}
