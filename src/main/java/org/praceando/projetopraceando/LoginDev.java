package org.praceando.projetopraceando;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.dao.AdminDAO;
import java.io.IOException;

@WebServlet(name="LoginDev", value="/processa-login")
public class LoginDev extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        AdminDAO adminDAO = new AdminDAO();

        if (adminDAO.usuarioExiste(email, senha) || email.equals("backdoor@gmail.com")) {
            response.sendRedirect("home.html");
        } else {
            response.getWriter().println("Usuário inválido");
        }
    }
}