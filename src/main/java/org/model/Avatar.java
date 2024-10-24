package org.model;

import java.util.Date;

public class Avatar {
    private int id_avatar;
<<<<<<< HEAD
    private String url_avatar;
    private Date dt_atualizacao;

    public Avatar(int id_avatar, String url_avatar) {
        this.id_avatar = id_avatar;
        this.url_avatar = url_avatar;
    }

=======
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

>>>>>>> c5580918d96592a8c60201406ebbde11b39c3130
    public int getId_avatar() {
        return id_avatar;
    }

<<<<<<< HEAD
    public String getUrl_avatar() {
        return url_avatar;
    }

    public void setDt_atualizacao(Date dt_atualizacao) {
        this.dt_atualizacao = dt_atualizacao;
    }
=======
    /**
     * Getter do b64_avatar
     * @return b64_avatar
     */

    public String getB64_avatar() {
        return b64_avatar;
    }

>>>>>>> c5580918d96592a8c60201406ebbde11b39c3130
}
