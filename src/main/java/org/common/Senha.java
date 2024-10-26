package org.common;

public class Senha {
    private final String pwd;
    public Senha(String password) {
        this.pwd = password;
    }
    public String get() {
        return pwd;
    }

    public boolean equals(String senha) {
        return pwd.equals(senha);
    }
}
