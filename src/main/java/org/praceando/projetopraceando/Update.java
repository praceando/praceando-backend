package org.praceando.projetopraceando;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name="Update", value="/informacoesUpdate")
public class Update extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idUpdate =  request.getParameter("idUpdate");
        request.setAttribute("idUpdate", idUpdate);
        request.getSession().setAttribute("idUpdate", idUpdate);

        String valorAtualizadoUpdate =  request.getParameter("valorAtualizadoUpdate");
        request.setAttribute("valorAtualizadoUpdate", valorAtualizadoUpdate);
        request.getSession().setAttribute("valorAtualizadoUpdate", valorAtualizadoUpdate);

        response.sendRedirect("mensagemFinal.jsp");
    }
}