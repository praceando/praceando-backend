package org.praceando.projetopraceando;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.dao.TagDAO;

import java.io.IOException;

@WebServlet(name="Redirect", value="/redirect")
public class Redirect extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = getDispatcher(request);
        rd.forward(request, response);
    }

    private RequestDispatcher getDispatcher(HttpServletRequest request) {
        String tabela = request.getParameter("tabela");
        String opcao = request.getParameter("opcao");

        return request.getRequestDispatcher(String.format("%s-%s.jsp", opcao, tabela));
    }
}
