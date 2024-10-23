package org.model;

import java.util.Date;

public class Avatar {
    private int id_avatar;
    private String b64_avatar;

    public Avatar(int id_avatar, String b64_avatar) {
        this(b64_avatar);
        this.id_avatar = id_avatar;
    }

    public Avatar(String b64_avatar) {
        this.b64_avatar = b64_avatar;
    }

    public int getId_avatar() {
        return id_avatar;
    }

    public String getB64_avatar() {
        return b64_avatar;
    }

}
