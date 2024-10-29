package org.praceando.projetopraceando;

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

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String nome = request.getParameter("nome");
        String access = request.getParameter("bdcod");

        AdminDAO adminDAO = new AdminDAO();

        boolean[] status = validarUsuario(email, senha);

        boolean temAcessoValido = temCodAcessoValido(adminDAO, access);

        SqlExitDML saida = new SqlExitDML();


        request.setAttribute("status", status);
        request.setAttribute("dbAccessValido", temAcessoValido);


        if (Arrays.equals(status, new boolean[]{false, false, false}) && temAcessoValido) {
            Admin admin = new Admin(nome, email, new Senha(senha), false);
            saida = adminDAO.inserir(admin);
        }

        request.setAttribute("saidaInsert", saida);

        RequestDispatcher dispatcher = request.getRequestDispatcher("cadastroADMSaida.jsp");
        dispatcher.forward(request, response);

    }

    public boolean temCodAcessoValido(AdminDAO adminDAO, String dbAccess) {
        return adminDAO.getDBAccess().equals(dbAccess);
    }

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
