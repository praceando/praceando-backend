package org.controller.form;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.common.Constants;
import org.common.Tabela;
import java.io.IOException;

@WebServlet(name = "SearchFormServlet", value = "/search-form")
public class SearchFormServlet extends HttpServlet {

    /**
     * Método para tratar a requisição GET do formulário de busca.
     * @param request Requisição HTTP
     * @param response Resposta HTTP
     * @throws ServletException Caso haja algum problema ao processar a requisição
     * @throws IOException Caso haja algum problema na leitura ou escrita de dados na resposta
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Tabela tabela = Constants.getTabela(request.getParameter("tabela"));
        request.setAttribute("tabela", tabela);
        RequestDispatcher rd = request.getRequestDispatcher("search.jsp");
        rd.forward(request, response);
    }
}