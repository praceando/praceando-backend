package org.model;

import org.common.Senha;

import java.util.Map;

public class Admin implements Model {
    private int id;
    private final String nome;
    private final String email;
    private final boolean isAtivo;
    private final Senha senha;

    /** Construtor que inicializa todos os atributos da classe Admin
     * @param id ID do administrador
     * @param email E-mail do administrador
     * @param senha Senha do administrador
     */
    public Admin(int id, String nome, String email, Senha senha, boolean isAtivo) {
        this(nome, email, senha, isAtivo);
        this.id = id;
    }

    /** Construtor que inicializa somente os atributos email e senha do administrador
     * @param email E-mail do administrador
     * @param senha Senha do administrador
     */
    public Admin(String nome, String email, Senha senha, boolean isAtivo) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.isAtivo = isAtivo;
    }

    /** Getter para o e-mail do administrador
     * @return E-mail do administrador
     */
    public String getEmail() {
        return this.email;
    }

    /** Getter para a senha do administrador
     * @return Senha do administrador
     */
    public String getSenha() {
        return senha.get();
    }

    /** Getter para o ID do administrador
     * @return ID do administrador
     */
    public int getId() {
        return this.id;
    }

    /** Getter do nome do administrador
     * @return Nome do administrador
     */
    public String getNome() {
        return this.nome;
    }

    /** Getter para o status do administrador
     * @return True se o administrador estiver ativo, False caso contrário
     */
    public boolean isAtivo() {
        return this.isAtivo;
    }

    /** Método para alterar o ID do objeto do administrador
     * @param id ID do administrador
     */
    @Override
    public void setId(int id) {
        throw new UnsupportedOperationException("Admin não suporta alterar o ID");
    }

    @Override
    public Map<String, String> getParams() { throw new UnsupportedOperationException("Admin não suporta parametrização"); }

    /** Verifica se o email e senha são iguais aos dados passados anteriormente
     * @param email E-mail do administrador
     * @param senha Senha do administrador
     * @return True se os dados forem iguais, False caso contrário
     */
    public boolean matches(String email, String senha) {
        return this.senha.equals(senha) && this.email.equals(email);
    }
}