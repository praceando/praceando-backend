package org.praceando.projetopraceando;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.common.SqlExitDML;
import org.dao.AdminDAO;
import org.model.Admin;

import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet(name="CadastroAdm", value="/cadastro-adm")
public class CadastroAdmServlet extends HttpServlet {
    private final Pattern emailPattern = Pattern.compile("^[^._\\s\\W]{2,}\\.[^._\\s\\W]{2,}@germinare\\.org\\.br$");
    private final Pattern senhaPattern = Pattern.compile("^(?=.*\\d)(?=.*[A-Z])(?=.*[a-z]).{8,}$");

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String access = request.getParameter("bdcod");

        AdminDAO adminDAO = new AdminDAO();

        boolean[] status = validarUsuario(email, senha);

        boolean temAcessoValido = temCodAcessoValido(adminDAO, access);

        SqlExitDML saida = new SqlExitDML();


        request.setAttribute("status", status);
        request.setAttribute("dbAccessValido", temAcessoValido);


        if (Arrays.equals(status, new boolean[]{false, false, false}) && temAcessoValido) {
            Admin admin = new Admin(email, senha);
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

        Matcher matcherEmail = emailPattern.matcher(email);
        Matcher matcherSenha = senhaPattern.matcher(senha);

        return new boolean[]{!matcherSenha.find(), !matcherEmail.find(), adminDAO.usuarioExiste(email)};


    }
}
