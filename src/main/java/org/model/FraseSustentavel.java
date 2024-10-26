package org.model;
import java.util.HashMap;
import java.util.Map;

public class FraseSustentavel implements Model {
    private String descricao;
    private int id;

    /**
     * Construtor que inicializa todos os atributos
     *
     * @param id ID da frase sustentável
     * @param descricao Descrição da frase sustentável
     */
    public FraseSustentavel(int id, String descricao) {
        this(descricao);
        this.id = id;
    }

    /**
     * Construtor que inicializa apenas o atributo ds_frase
     * @param descricao Descrição da frase sustentável
     */
    public FraseSustentavel(String descricao) {
        this.descricao = descricao;
    }

    public FraseSustentavel(Map<String, String> params) {
        if (params.containsKey("id")) {
            System.out.println("Construtor frasesustentavel: ID=" + params.get("id"));
            this.id = Integer.parseInt(params.get("id"));
        }
        this.descricao = params.get("descricao");
    }

    /** Getter da Descrição
     * @return Descrição da frase sustentável
     */
    public String getDescricao() {
        return descricao;
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

    public Map<String, String> getParams() {
        Map<String, String> params = new HashMap<>();
        params.put("descricao", descricao);
        return params;
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
                descricao
        );
    }
}