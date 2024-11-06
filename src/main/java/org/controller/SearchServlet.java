package org.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.common.Tabela;
import org.controller.util.ErrorRedirect;
import org.controller.util.TableOperations;
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
            TableOperations.filterByColumn(models, colunaFiltro.trim(), filtro.trim(), incluirNDef);
            TableOperations.orderBy(models, colunaOrderBy, orderType);


            boolean canAlter = !dao.isReadOnly() && !tabela_dao.matches("admin");
            request.setAttribute("tabela", dao.getTabela());
            request.setAttribute("saida", models);
            request.setAttribute("canAlter", canAlter);

            RequestDispatcher rd = request.getRequestDispatcher("visualizar.jsp");
            rd.forward(request, response);
        } catch (NullPointerException e) { // se o getDao() retornar null
            ErrorRedirect.handleTabelaIndisponivel(request, response, tabela);
        } catch (ConnectionIsNullException cne) {
            cne.printStackTrace();
            ErrorRedirect.handleErroBanco(request, response);
        }
    }
}
