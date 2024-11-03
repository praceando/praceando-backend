package org.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.common.Tabela;
import org.controller.util.ErrorRedirect;
import org.dao.ConnectionIsNullException;
import org.dao.DAOGeneric;
import org.dao.DAOManager;
import org.model.Model;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;

@WebServlet(name="search", value="/search")
public class SearchServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tabela = request.getParameter("tabela");
        String colunaFiltro = request.getParameter("colunaFiltro");
        String filtro = request.getParameter("filtro");
        String colunaOrderBy = request.getParameter("orderBy");
        String orderType = request.getParameter("orderType");
        boolean incluirNDef = request.getParameter("incluirNDef") != null;

        DAOGeneric<Model> dao = DAOManager.getDAO(tabela);

        assert dao != null;
        try {
            Tabela tabela_dao = dao.getTabela();

            List<Model> models = dao.visualizar(); // Lidar em caso de models ser null ou vazio

            System.out.println("ha! AQUIBOM");
            filterByColumn(models, colunaFiltro, filtro, incluirNDef);
            orderBy(models, colunaOrderBy, orderType);


            boolean canAlter = !dao.isReadOnly() && !tabela_dao.matches("admin");
            request.setAttribute("tabela", dao.getTabela());
            request.setAttribute("saida", models);
            request.setAttribute("canAlter", canAlter);

            RequestDispatcher rd = request.getRequestDispatcher("visualizar.jsp");
            rd.forward(request, response);
        } catch (ConnectionIsNullException cne) {
            cne.printStackTrace();
            ErrorRedirect.handleErroBanco(request, response);
        }
    }

    private void orderBy(List<Model> models, String coluna, String orderBy) {
        if (orderBy == null) {
            return;
        }

        boolean asc = !"desc".equalsIgnoreCase(orderBy);

        models.sort((model1, model2) -> {
            try {
                Field field1 = model1.getClass().getDeclaredField(coluna);
                Field field2 = model2.getClass().getDeclaredField(coluna);

                field1.setAccessible(true);
                field2.setAccessible(true);

                Object valor1 = field1.get(model1);
                Object valor2 = field2.get(model2);

                if (valor1 == null && valor2 == null) return 0;
                if (valor1 == null) return asc ? -1 : 1;
                if (valor2 == null) return asc ? 1 : -1;

                if (valor1 instanceof String && valor2 instanceof String) {
                    return asc ? ((String) valor1).compareToIgnoreCase((String) valor2) : (((String) valor2).compareToIgnoreCase((String) valor1));
                } else {
                    Comparable<Object> valor1_ = (Comparable<Object>) valor1;
                    Comparable<Object> valor2_ = (Comparable<Object>) valor2;
                    return asc ? valor1_.compareTo(valor2_) : valor2_.compareTo(valor1_);
                }

            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
            return 0;
        });
    }

    private void filterByColumn(List<Model> models, String coluna, String filterString, boolean incluirNDef) {
        if (models == null || (filterString == null || filterString.isEmpty() || coluna == null || coluna.isEmpty())) {
            return;
        }

        System.out.println("Filtrando: " + models.size());

        models.removeIf(model -> {
            try {
                Field attr = model.getClass().getDeclaredField(coluna);
                attr.setAccessible(true);
                Object valor = attr.get(model);

                if (valor == null && !incluirNDef) {
                    return true;
                }

                String valorStr = valor != null ? valor.toString() : "Não definido";

                if (valorStr.toString().toLowerCase().contains(filterString.toLowerCase())) {
                    return false;
                }
            } catch (IllegalAccessException | NoSuchFieldException e) {
                e.printStackTrace();
            }
            return true;
        });
    }
}
