package org.model;
public class Admin {
    private int id_admin;
    private final String email;
    private final String senha;

    /**
     * Construtor que inicializa todos os atributos da classe Admin
     * @param id_admin ID do administrador
     * @param email E-mail do administrador
     * @param senha Senha do administrador
     */
    public Admin(int id_admin, String email, String senha) {
        this.id_admin = id_admin;
        this.email = email;
        this.senha = senha;
    }

    /**
     * Construtor que inicializa somente os atributos email e senha do administrador
     * @param email E-mail do administrador
     * @param senha Senha do administrador
     */
    public Admin(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    /**
     * Getter para o e-mail do administrador
     * @return E-mail do administrador
     */

    public String getEmail() {
        return email;
    }

    /**
     * Getter para a senha do administrador
     * @return Senha do administrador
     */

    public String getSenha() {
        return senha;
    }

    /**
     * Getter para o ID do administrador
     * @return ID do administrador
     */

    public int getId_admin() {
        return id_admin;
    }

    /**
     * Setter para o ID do administrador
     * @param id_admin ID do administrador
     */

    public boolean matches(Admin adm) {
        return this.matches(adm.email, adm.senha);
    }

    /**
     * Verifica se o email e senha são iguais aos dados passados anteriormente
     * @param email E-mail do administrador
     * @param senha Senha do administrador
     * @return True se os dados forem iguais, False caso contrário
     */

    public boolean matches(String email, String senha) {
        return this.senha.equals(senha) && this.email.equals(email);
    }

}

