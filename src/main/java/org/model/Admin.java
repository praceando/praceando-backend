package org.model;
<<<<<<< HEAD
import java.util.Date;
public class Admin {
    private final int id_admin;
    private final String email;
    private final String senha;
    private Date dt_atualizacao;

=======
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
>>>>>>> c5580918d96592a8c60201406ebbde11b39c3130
    public Admin(int id_admin, String email, String senha) {
        this.id_admin = id_admin;
        this.email = email;
        this.senha = senha;
    }

<<<<<<< HEAD
=======
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

>>>>>>> c5580918d96592a8c60201406ebbde11b39c3130
    public String getEmail() {
        return email;
    }

<<<<<<< HEAD
=======
    /**
     * Getter para a senha do administrador
     * @return Senha do administrador
     */

>>>>>>> c5580918d96592a8c60201406ebbde11b39c3130
    public String getSenha() {
        return senha;
    }

<<<<<<< HEAD
=======
    /**
     * Getter para o ID do administrador
     * @return ID do administrador
     */

>>>>>>> c5580918d96592a8c60201406ebbde11b39c3130
    public int getId_admin() {
        return id_admin;
    }

<<<<<<< HEAD
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
=======
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

>>>>>>> c5580918d96592a8c60201406ebbde11b39c3130
}

