package org.praceando.projetopraceando;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.dao.AdminDAO;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet(name="LoginDev", value="/processa-login")
public class LoginDev extends HttpServlet {

    private final Pattern emailPattern = Pattern.compile("^[^._\\s\\W]{2,}\\.[^._\\s\\W]{2,}@germinare\\.org\\.br$");

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

//        AdminDAO adminDAO = new AdminDAO();

        if (validarUsuario(email, senha)) {
            response.sendRedirect("escolherTabela.jsp");
        } else {
            response.getWriter().println("Usuário inválido");
        }
    }

    private boolean validarUsuario(String email, String senha) {
        Matcher matcher = emailPattern.matcher(email);
        return matcher.find();
    }
}
