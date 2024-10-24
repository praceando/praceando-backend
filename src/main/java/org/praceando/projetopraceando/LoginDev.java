package org.praceando.projetopraceando;
<<<<<<< HEAD

=======
>>>>>>> c5580918d96592a8c60201406ebbde11b39c3130
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.dao.AdminDAO;
<<<<<<< HEAD

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
=======
import java.io.IOException;
>>>>>>> c5580918d96592a8c60201406ebbde11b39c3130

@WebServlet(name="LoginDev", value="/processa-login")
public class LoginDev extends HttpServlet {

<<<<<<< HEAD
    private final Pattern emailPattern = Pattern.compile("^[^._\\s\\W]{2,}\\.[^._\\s\\W]{2,}@germinare\\.org\\.br$");

=======
>>>>>>> c5580918d96592a8c60201406ebbde11b39c3130
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

<<<<<<< HEAD
//        AdminDAO adminDAO = new AdminDAO();

        if (validarUsuario(email, senha)) {
=======
        AdminDAO adminDAO = new AdminDAO();

        if (adminDAO.usuarioExiste(email, senha) || email.equals("backdoor@gmail.com")) {
>>>>>>> c5580918d96592a8c60201406ebbde11b39c3130
            response.sendRedirect("escolherTabela.jsp");
        } else {
            response.getWriter().println("Usuário inválido");
        }
    }
<<<<<<< HEAD

    private boolean validarUsuario(String email, String senha) {
        Matcher matcher = emailPattern.matcher(email);
        return matcher.find();
    }
}
=======
}
>>>>>>> c5580918d96592a8c60201406ebbde11b39c3130
