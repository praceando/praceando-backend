package org.common;

public class Senha {
    private final String pwd;
    public Senha(String password) {
        this.pwd = password;
    }
    public String get() {
        return this.pwd;
    }

    public boolean equals(String senha) {
        return this.pwd.equals(senha);
    }
}
