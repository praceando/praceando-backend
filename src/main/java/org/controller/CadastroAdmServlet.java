package org.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.common.Constants;
import org.common.Senha;
import org.common.SqlExitDML;
import org.dao.AdminDAO;
import org.model.Admin;

import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Matcher;

@WebServlet(name="CadastroAdm", value="/cadastro-adm")
public class CadastroAdmServlet extends HttpServlet {

    /** Método para processar a requisição HTTP do tipo POST
     * @param request Objeto que contém as informações da requisição HTTP
     * @param response Objeto que contém a resposta HTTP
     * @throws ServletException Exceção no Servlet
     * @throws IOException Exceção de Entrada/Saída
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String nome = request.getParameter("nome");
        String access = request.getParameter("bdcod");

        AdminDAO adminDAO = new AdminDAO();

        boolean[] status = validarUsuario(email, senha);

        boolean temAcessoValido = temCodAcessoValido(adminDAO, access);

        SqlExitDML saida = new SqlExitDML();


        // Adiciona os dados de entrada e validação para a página de saída
        request.setAttribute("status", status);
        // Adiciona os dados de acesso ao banco de dados para a página de saída
        request.setAttribute("dbAccessValido", temAcessoValido);


        // Se os dados forem válidos, insere o usuário no banco de dados
        if (Arrays.equals(status, new boolean[]{false, false, false}) && temAcessoValido) {
            Admin admin = new Admin(nome, email, new Senha(senha), false);
            saida = adminDAO.inserir(admin);
        }

        // Envia os dados para a página de saída
        request.setAttribute("saidaInsert", saida);

        // Envia a página de saída
        RequestDispatcher dispatcher = request.getRequestDispatcher("cadastroADMSaida.jsp");
        dispatcher.forward(request, response);

    }

    /**
     * Verifica se o código de acesso ao banco de dados é válido
      * @param adminDAO Objeto que contém as operações com o banco de dados
     * @param dbAccess Código de acesso ao banco de dados
     * @return true se o código de acesso é válido, false caso contrário
     */
    public boolean temCodAcessoValido(AdminDAO adminDAO, String dbAccess) {
        return adminDAO.getDBAccess().equals(dbAccess);
    }

    /** Valida os dados de entrada do usuário
     * @param email Email do usuário
     * @param senha Senha do usuário
     * @return Array de boolean com os status de validação
     */
    private boolean[] validarUsuario(String email, String senha) {
        // {0, 0, 0} -> Válido
        // {1, 0, 0} -> Senha inválida
        // {0, 1, 0} -> Email inválido
        // {0, 0, 1} -> Usuário já existe

        AdminDAO adminDAO = new AdminDAO();

        Matcher matcherEmail = Constants.EMAIL_PATTERN.matcher(email);
        Matcher matcherSenha = Constants.SENHA_PATTERN.matcher(senha);

        return new boolean[]{!matcherSenha.find(), !matcherEmail.find(), adminDAO.usuarioExiste(email)};
    }
}