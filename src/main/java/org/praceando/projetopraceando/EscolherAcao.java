package org.praceando.projetopraceando;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name="escolherAcao", value="/escolher-acao")
public class EscolherAcao extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String acao =  request.getParameter("opcao");
//        request.setAttribute("acao", acao);
        request.getSession().setAttribute("acao", acao);

        switch (acao) {
            case "Delete" -> response.sendRedirect("delete.jsp");
            case "Insert" -> response.sendRedirect("insert.jsp");
            case "Update" -> response.sendRedirect("update.jsp");
            case "Select" -> response.sendRedirect("select.jsp");
        }


    }
}
