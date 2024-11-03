package org.model;
import org.common.Constants;
import org.common.Tabela;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

public class Avatar implements Model {
    private int id;
    private String url_avatar;
    private Date dt_atualizacao;

    /** Construtor que inicializa o ID do avatar podendo ser null b64_avatar
     * @param id_avatar ID do avatar
     * @param url_avatar URL da imagem do avatar
     */
    public Avatar(Integer id_avatar, String url_avatar, Date dt_atualizacao) {
        this.url_avatar = url_avatar;
        this.id = id_avatar;
        this.dt_atualizacao = dt_atualizacao;
    }

    public Avatar(Map<String, String> params) {
        if (params.containsKey("id")) {
            this.id = Integer.parseInt(params.get("id"));
        }
        this.url_avatar = params.get("b64_avatar");
    }

    public Tabela getTabela() {
        return Constants.TABELA_AVATAR;
    }

    /** Getter do b64_avatar
     * @return b64_avatar
     */
    public String getUrl_avatar() {
        return this.url_avatar;
    }

    /** Getter do ID do avatar, pode retornar null.
     * @return ID do avatar
     */
    public int getId() {
        return this.id;
    }

    /** Setter do ID do avatar
     * @param id ID do avatar
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Método que retorna os parâmetros do avatar em um mapa.
     * @return Map<String, String> com os parâmetros do avatar
     */
    public Map<String, String> getParams() {
        Map<String, String> params = new HashMap<>();
        params.put("b64_avatar", this.url_avatar);
        return params;
    }
}