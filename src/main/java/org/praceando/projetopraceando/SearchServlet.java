package org.praceando.projetopraceando;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.dao.DAOGeneric;
import org.dao.DAOManager;
import org.model.Model;

import java.io.IOException;

@WebServlet(name="search", value="/search")
public class SearchServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tabela = request.getParameter("tabela");
        String operacao = request.getParameter("operacao");

        DAOGeneric<Model> dao = DAOManager.getDAO(tabela);
    }
}
