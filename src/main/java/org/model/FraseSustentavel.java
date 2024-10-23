package org.model;
import java.util.Date;

public class FraseSustentavel {
        private String ds_frase;
        private int id_frase;

    public FraseSustentavel(String ds_frase, int id_frase) {
        this.ds_frase = ds_frase;
        this.id_frase = id_frase;
    }


    public String getDs_frase() {
        return ds_frase;
    }

    public int getId_frase() {
        return id_frase;
    }

}
