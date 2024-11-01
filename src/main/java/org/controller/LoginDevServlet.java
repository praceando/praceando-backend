package org.controller;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.dao.AdminDAO;
import java.io.IOException;

@WebServlet(name="LoginDevServlet", value="/processa-login")
public class LoginDevServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        // Verifica se o usuário existe no banco de dados
        AdminDAO adminDAO = new AdminDAO();

        // Verifica se o usuário existe no banco de dados
        int saida = adminDAO.usuarioExiste(email, senha);

        // Verifica o tipo de retorno do método
        System.out.println(saida);
        // Define a página a ser redirecionada dependendo do retorno do método
        String pag = "erroBanco.jsp";

        // Verifica o tipo de retorno do método
        switch (saida) {
            // Se o usuário existe, redireciona para a página de home
            case 1 -> pag = "home.html";
            // Se o usuário não existe, redireciona para a página de erro
            case 0 -> {
                ErrorRedirect.redirect(request, response, "Acesso Negado", "Login não encontrado ou inválido");
            }
            // Se houve algum erro interno, redireciona para a página de erro
            case -1 -> {
                ErrorRedirect.handleErroBanco(request, response);
            }
        }
        RequestDispatcher rd = request.getRequestDispatcher(pag);

        rd.forward(request, response);
    }
}