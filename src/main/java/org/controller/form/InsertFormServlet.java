package org.controller.form;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.common.Constants;
import org.common.Tabela;

import java.io.IOException;

@WebServlet(name="InsertFormServlet", value="/inserir")
public class InsertFormServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Tabela tabela = Constants.getTabela(request.getParameter("tabela"));
        request.setAttribute("tabela", tabela);
        RequestDispatcher rd = request.getRequestDispatcher("inserir.jsp");
        rd.forward(request, response);
    }
}
