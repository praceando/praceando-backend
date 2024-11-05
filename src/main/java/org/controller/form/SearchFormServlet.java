package org.controller.form;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.common.Constants;
import org.common.Tabela;
import org.controller.util.ErrorRedirect;

import java.io.IOException;

@WebServlet(name = "SearchFormServlet", value = "/search-form")
public class SearchFormServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tabelaNome = request.getParameter("tabela");
        Tabela tabela = Constants.getTabela(tabelaNome);
        if (tabela != null) {
            request.setAttribute("tabela", tabela);
            RequestDispatcher rd = request.getRequestDispatcher("search.jsp");
            rd.forward(request, response);
        } else {
            ErrorRedirect.handleTabelaIndisponivel(request, response, tabelaNome);
        }
    }
}
