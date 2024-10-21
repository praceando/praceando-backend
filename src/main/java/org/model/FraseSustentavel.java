package org.model;
import java.util.Date;

public class FraseSustentavel {
        private Date dt_atualizacao;
        private String ds_frase;
        private int id_frase;

    public FraseSustentavel(Date dt_atualizacao, String ds_frase, int id_frase) {
        this.dt_atualizacao = dt_atualizacao;
        this.ds_frase = ds_frase;
        this.id_frase = id_frase;
    }

    public Date getDt_atualizacao() {
        return dt_atualizacao;
    }

    public String getDs_frase() {
        return ds_frase;
    }

    public int getId_frase() {
        return id_frase;
    }

    public void setDt_atualizacao(Date dt_atualizacao) {
        this.dt_atualizacao = dt_atualizacao;
    }
}
