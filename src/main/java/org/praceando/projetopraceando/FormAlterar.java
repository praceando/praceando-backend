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

@WebServlet(name="FormAlterar", value="/alterar")
public class FormAlterar extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String tabela = request.getParameter("tabela");

        DAOGeneric<Model> dao = DAOManager.getDAO(tabela);
        assert dao != null;

        Model model = dao.visualizar(id);

        request.setAttribute("model", model);

        request.getRequestDispatcher("alterar.jsp").forward(request, response);
    }
}
