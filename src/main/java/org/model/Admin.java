package org.model;
public class Admin {
    private int id_admin;
    private final String email;
    private final String senha;

    public Admin(int id_admin, String email, String senha) {
        this.id_admin = id_admin;
        this.email = email;
        this.senha = senha;
    }

    public Admin(String email, String senha) {
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
        return this.matches(adm.email, adm.senha);
    }

    public boolean matches(String email, String senha) {
        return this.senha.equals(senha) && this.email.equals(email);
    }

}

