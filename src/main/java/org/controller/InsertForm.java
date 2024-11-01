package org.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.dao.DAOGeneric;
import org.dao.DAOManager;
import org.model.Model;

import java.io.IOException;

@WebServlet(name="InsertForm", value="/inserir")
public class InsertForm extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tabela = request.getParameter("tabela");
        DAOGeneric<Model> dao = DAOManager.getDAO(tabela);

        assert dao != null;
        request.setAttribute("tabelaInterface", dao.getNomeInterface());
        RequestDispatcher rd = request.getRequestDispatcher("inserir.jsp");
        rd.forward(request, response);
    }
}
