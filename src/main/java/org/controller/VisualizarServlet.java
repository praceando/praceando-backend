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
import java.util.List;

@WebServlet(name="Visualizar", value="/visualizar")
public class VisualizarServlet extends HttpServlet {

    /**Processa uma requisição GET.
     * @param request Solicitação HTTP
     * @param response Resposta HTTP
     * @throws ServletException Possível erro no servlet
     * @throws IOException Possível erro de IO
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tabela = request.getParameter("tabela");

        try { // verifica se a tabela está disponível
            DAOGeneric<Model> dao = DAOManager.getDAO(tabela);

            assert dao != null;

            Tabela tabela_dao = dao.getTabela();
            boolean canAlter = !dao.isReadOnly() && !tabela_dao.getNomeBanco().equals("admin");

            List<Model> saida = dao.visualizar();
            if (saida != null) { // se a saída não for null
                request.setAttribute("tabela", tabela_dao);
                request.setAttribute("saida", saida);
                request.setAttribute("canAlter", canAlter);


                RequestDispatcher rd = request.getRequestDispatcher("visualizar.jsp");
                rd.forward(request, response);
            } else { // se a saída for null
                ErrorRedirect.redirect(request, response, "Saída nula.", "Saída retornou null, verifique a conexão com a internet.");
            }
        } catch (NullPointerException e) { // se o getDao() retornar null
            ErrorRedirect.handleTabelaIndisponivel(request, response, tabela);
        } catch (ConnectionIsNullException cne) { // se a conexão com o banco for null
            ErrorRedirect.handleErroBanco(request, response);
        }
    }
}