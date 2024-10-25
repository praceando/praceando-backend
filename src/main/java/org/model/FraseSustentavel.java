package org.model;

public class FraseSustentavel implements Model {
    private String ds_frase;
    private int id;

    /**
     * Construtor que inicializa todos os atributos
     *
     * @param id_frase ID da frase sustentável
     * @param ds_frase Descrição da frase sustentável
     */
    public FraseSustentavel(int id_frase, String ds_frase) {
        this(ds_frase);
        this.id = id_frase;
    }

    /**
     * Construtor que inicializa apenas o atributo ds_frase
     * @param ds_frase Descrição da frase sustentável
     */
    public FraseSustentavel(String ds_frase) {
        this.ds_frase = ds_frase;
    }

    /** Getter da ds_frase
     * @return Descrição da frase sustentável
     */
    public String getDs_frase() {
        return ds_frase;
    }

    /**Getter do id_frase
     * @return ID da frase sustentável
     */
    public int getId() {
        return id;
    }

    /**Setter do id da frase sustentável
     */
    public void setId(int id) {
        this.id = id;
    }

    /** Método utilizado para gerar uma linha HTML com os dados da frase sustentável
     * @return Uma linha HTML com os dados da frase sustentável
     */
    @Override
    public String getRawHTMLRow() {
        return String.format(
                "<td>%d</td>" +
                "<td>%s</td>",
                id,
                ds_frase
        );
    }
}