package org.common;

/**
 * Para ser possível esconder o hash da senha do usuário
 * é utilizada para discernir uma String normal de uma que
 * requira proteção.
 */
public class Senha {
    private final String pwd;

    /** Cnstrutor que inicializa a senha
     * @param password Senha
     */
    public Senha(String password) {
        this.pwd = password;
    }

    /** Obtém a senha
     * @return Senha
     */
    public String get() {
        return this.pwd;
    }

    /** Compara a senha com a senha informada
     * @param senha Senha informada
     * @return true se as senhas forem iguais, false caso contrário
     */
    public boolean equals(String senha) {
        return this.pwd.equals(senha);
    }
}