package org.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.common.SqlExitDML;
import org.controller.util.ErrorRedirect;
import org.dao.ConnectionIsNullException;
import org.dao.DAOGeneric;
import org.dao.DAOManager;
import org.model.Model;

import java.io.IOException;

@WebServlet(name="RemoverServlet", value="/remover")
public class RemoverServlet extends HttpServlet {

    /**
     * Metodo doGet para remover um registro da tabela
     * @param request Requisição do cliente
     * @param response Resposta para o cliente
     * @throws ServletException Exceção ocorrida no Servlet
     * @throws IOException Exceção ocorrida no I/O
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String tabela = request.getParameter("tabela");

        try {
            DAOGeneric<Model> dao = DAOManager.getDAO(tabela);

            assert dao != null;

            SqlExitDML saida = dao.remover(id);

            request.setAttribute("tabela", dao.getTabela());
            request.setAttribute("saida", saida);

            RequestDispatcher rd = request.getRequestDispatcher("removerSaida.jsp");
            rd.forward(request, response);
        } catch (NullPointerException e) { // se o getDao() retornar null
            ErrorRedirect.handleTabelaIndisponivel(request, response, tabela);
        } catch (ConnectionIsNullException cne) {
            ErrorRedirect.handleErroBanco(request, response);
        } catch (UnsupportedOperationException uoe) {
            ErrorRedirect.redirect(request, response, "Operação inválida", "Não é possível remover da tabela " + tabela);
        }
    }
}