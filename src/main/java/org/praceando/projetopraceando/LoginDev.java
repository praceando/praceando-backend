package org.praceando.projetopraceando;
import jakarta.servlet.RequestDispatcher;
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

        int saida = adminDAO.usuarioExiste(email, senha);

        System.out.println(saida);
        String pag = "erroNoBancos.jsp";

        switch (saida) {
            case 1 -> pag = "home.html";
            case 0 -> {
                request.setAttribute("tipoErro", "Acesso negado");
                request.setAttribute("mensagemErro", "Login não encontrado ou inválido. Peça permissão para o grupo para realizar o cadastro de sua conta.");
            }
            case -1 -> {
                request.setAttribute("tipoErro", "Erro Interno");
                request.setAttribute("mensagemErro", "Ocorreu uma instabilidade no banco");
            }
        }
        RequestDispatcher rd = request.getRequestDispatcher(pag);

        rd.forward(request, response);
    }
}