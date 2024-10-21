package org.model;
import java.util.Date;
public class Admin {
    private final int id_admin;
    private final String email;
    private final String senha;
    private Date dt_atualizacao;

    public Admin(int id_admin, String email, String senha) {
        this.id_admin = id_admin;
        this.email = email;
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public int getId_admin() {
        return id_admin;
    }

    public boolean matches(Admin adm) {
        return adm.senha.equals(this.senha) && adm.email.equals(this.email);
    }

//    public Date getDt_atualizacao() {
//        return dt_atualizacao;
//    }
//
//    public void setDt_atualizacao(Date dt_atualizacao) {
//        this.dt_atualizacao = dt_atualizacao;
//    }
}

