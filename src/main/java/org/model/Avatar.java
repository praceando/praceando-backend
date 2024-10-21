package org.model;

import java.util.Date;

public class Avatar {
    private int id_avatar;
    private String url_avatar;
    private Date dt_atualizacao;

    public Avatar(int id_avatar, String url_avatar) {
        this.id_avatar = id_avatar;
        this.url_avatar = url_avatar;
    }

    public int getId_avatar() {
        return id_avatar;
    }

    public String getUrl_avatar() {
        return url_avatar;
    }

    public void setDt_atualizacao(Date dt_atualizacao) {
        this.dt_atualizacao = dt_atualizacao;
    }
}
