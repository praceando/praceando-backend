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
import java.lang.reflect.Field;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

@WebServlet(name="search", value="/search")
public class SearchServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tabela = request.getParameter("tabela");
        String coluna = request.getParameter("coluna");
        String filter = request.getParameter("filter");
        String orderBy = request.getParameter("orderBy");

        DAOGeneric<Model> dao = DAOManager.getDAO(tabela);

        assert dao != null;
        List<Model> models = dao.visualizar();

        Function<Model, Object> comparator;
    }

}
