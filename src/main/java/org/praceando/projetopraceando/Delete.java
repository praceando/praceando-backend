package org.praceando.projetopraceando;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name="Delete", value="/informacoesDelete")
public class Delete extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idDelete =  request.getParameter("idDelete");
        request.setAttribute("idDelete", idDelete);
        request.getSession().setAttribute("idDelete", idDelete);

        response.sendRedirect("mensagemFinal.jsp");
    }
}