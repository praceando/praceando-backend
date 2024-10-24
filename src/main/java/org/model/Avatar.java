package org.model;

import java.util.Date;

public class Avatar {
    private int id_avatar;
    private String b64_avatar;

    /**
     * Construtor que inicializa o ID do avatar com 0 e o b64_avatar com null
     * @param id_avatar ID do avatar
     * @param b64_avatar Converte a imagem do avatar para base64
     */
    public Avatar(int id_avatar, String b64_avatar) {
        this(b64_avatar);
        this.id_avatar = id_avatar;
    }

    /**
     * Construtor que inicializa o b64_avatar com null
     * @param b64_avatar Convertendo a imagem do avatar para base64
     */

    public Avatar(String b64_avatar) {
        this.b64_avatar = b64_avatar;
    }

    /**
     * Getter do ID do avatar
     * @return ID do avatar
     */

    public int getId_avatar() {
        return id_avatar;
    }

    /**
     * Getter do b64_avatar
     * @return b64_avatar
     */

    public String getB64_avatar() {
        return b64_avatar;
    }

}
