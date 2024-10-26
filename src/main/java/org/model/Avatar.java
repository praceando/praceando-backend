package org.model;

import java.util.HashMap;
import java.util.Map;

public class Avatar implements Model {
    private int id;
    private String b64_avatar;

    /** Construtor que inicializa o ID do avatar podendo ser null b64_avatar
     * @param id_avatar ID do avatar
     * @param b64_avatar Converte a imagem do avatar para base64
     */
    public Avatar(Integer id_avatar, String b64_avatar) {
        this.b64_avatar = b64_avatar;
        this.id = id_avatar;
    }

    public Avatar(String b64_avatar) {
        this.b64_avatar = b64_avatar;
    }

    public Avatar(Map<String, String> params) {
        if (params.containsKey("id")) {
            this.id = Integer.parseInt(params.get("id"));
        }
        this.b64_avatar = params.get("b64_avatar");
    }

    /** Getter do b64_avatar
     * @return b64_avatar
     */
    public String getB64_avatar() {
        return b64_avatar;
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

    public Map<String, String> getParams() {
        Map<String, String> params = new HashMap<>();
        params.put("b64_avatar", b64_avatar);
        return params;
    }
}