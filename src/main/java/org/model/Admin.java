package org.model;
public class Admin implements Model {
    private int id;
    private final String email;
    private final String senha;

    /**
     * Construtor que inicializa todos os atributos da classe Admin
     * @param id ID do administrador
     * @param email E-mail do administrador
     * @param senha Senha do administrador
     */
    public Admin(int id, String email, String senha) {
        this.id = id;
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

    public int getId() {
        return id;
    }

    /**
     * @param id
     */
    @Override
    public void setId(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * @return
     */
    @Override
    public String getRawHTMLRow() {
        return String.format(
                "<td>%d/td>" +
                "<td>%s</td>" +
                "<td>%s</td>",
                id,
                email,
                senha
        );
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

