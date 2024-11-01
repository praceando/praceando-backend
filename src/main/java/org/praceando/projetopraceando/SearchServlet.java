package org.praceando.projetopraceando;

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
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name="search", value="/search")
public class SearchServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tabela = request.getParameter("tabela");
        String coluna = request.getParameter("coluna");
        String filter = request.getParameter("filter");
        String orderBy = request.getParameter("orderBy");

        DAOGeneric<Model> dao = DAOManager.getDAO(tabela);

        assert dao != null;
        List<Model> models = dao.visualizar(); // Lidar em caso de models ser null ou vazio

        if (coluna != null && filter != null) {
            models = filterByColumn(models, coluna, filter);
        }

        if (orderBy != null) {
            models = orderBy(models, coluna, orderBy);
        }

        boolean canAlter = !dao.isReadOnly() && !dao.getNome().equals("admin");
        request.setAttribute("saida", models);
        request.setAttribute("canAlter", canAlter);

        RequestDispatcher rd = request.getRequestDispatcher("visualizar.jsp");
        rd.forward(request, response);
    }

    private List<Model> orderBy(List<Model> models, String campo, String orderBy) {
        boolean asc = !"desc".equalsIgnoreCase(orderBy);

        models.sort((model1, model2) -> {
            try {
                Field field1 = model1.getClass().getDeclaredField(campo);
                Field field2 = model2.getClass().getDeclaredField(campo);

                field1.setAccessible(true);
                field2.setAccessible(true);

                Comparable<Object> valor1 = (Comparable<Object>) field1.get(field1);
                Comparable<Object> valor2 = (Comparable<Object>) field2.get(field2);

                if (valor1 == null && valor2 == null) return 0;
                if (valor1 == null) return asc ? -1 : 1;
                if (valor2 == null) return asc ? 1 : -1;

                return asc ? valor1.compareTo(valor2) : valor2.compareTo(valor1);

            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
            return 0;
        });
        return models;
    }

    private List<Model> filterByColumn(List<Model> models, String campo, String filterString) {
        List<Model> filtrados = new ArrayList<>();
        if (models == null) {
            return filtrados;
        }

        for (Model model : models) {
            try {
                Field attr = model.getClass().getDeclaredField(campo);
                attr.setAccessible(true);
                Object valor = attr.get(model);

                if (valor != null && valor.toString().contains(filterString)) {
                    filtrados.add(model);
                }
            } catch (IllegalAccessException | NoSuchFieldException e) {
                e.printStackTrace();
            }
        }
        return filtrados;
    }
}
