package org.praceando.projetopraceando;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name="Insert", value="/informacoesInsert")
public class Insert extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String valoresInsert = request.getParameter("idInsert");
        request.setAttribute("ValoresInsert", valoresInsert);
        request.getSession().setAttribute("valoresInsert", valoresInsert);

        response.sendRedirect("mensagemFinal.jsp");
    }
}