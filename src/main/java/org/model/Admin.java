package org.model;

import org.common.Constants;
import org.common.Senha;
import org.common.Tabela;
import java.sql.Date;
import java.util.Map;

public class Admin implements Model {
    private int id;
    private final String usuario;
    private final String email;
    private final boolean is_ativo;
    private final Senha senha;
    private Date dt_atualizacao;

    /** Construtor que inicializa todos os atributos da classe Admin
     * @param id ID do administrador
     * @param email E-mail do administrador
     * @param senha Senha do administrador
     */
    public Admin(int id, String usuario, String email, Senha senha, boolean is_ativo, Date dt_atualizacao) {
        this(usuario, email, senha, is_ativo);
        this.dt_atualizacao = dt_atualizacao;
        this.id = id;
    }

    /** Construtor que inicializa somente os atributos email e senha do administrador
     * @param email E-mail do administrador
     * @param senha Senha do administrador
     */
    public Admin(String usuario, String email, Senha senha, boolean is_ativo) {
        this.usuario = usuario;
        this.email = email;
        this.senha = senha;
        this.is_ativo = is_ativo;
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
    public String getUsuario() {
        return this.usuario;
    }

    /** Getter para o status do administrador
     * @return True se o administrador estiver ativo, False caso contrário
     */
    public boolean isIs_ativo() {
        return this.is_ativo;
    }

    public Tabela getTabela() {
        return Constants.TABELA_ADMIN;
    }


    /** Método para alterar o ID do objeto do administrador
     * @param id ID do administrador
     */
    @Override
    public void setId(int id) {
        throw new UnsupportedOperationException("Admin não suporta alterar o ID");
    }

    /**
     * Método para retornar os parâmetros do administrador em um Map
     * @return Map com os parâmetros do administrador
     */
    @Override
    public Map<String, String> getParams() {
        throw new UnsupportedOperationException("Admin não suporta parametrização");
    }

    /** Verifica se o email e senha são iguais aos dados passados anteriormente
     * @param email E-mail do administrador
     * @param senha Senha do administrador
     * @return True se os dados forem iguais, False caso contrário
     */
    @Deprecated
    public boolean matches(String email, String senha) {
        return this.senha.equals(senha) && this.email.equals(email);
    }
}