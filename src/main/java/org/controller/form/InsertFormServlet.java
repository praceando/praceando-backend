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

@WebServlet(name="InsertFormServlet", value="/inserir")

public class InsertFormServlet extends HttpServlet {

    /**
     * Método para tratar a requisição HTTP GET para a URL /inserir.
     * @param request Requisição HTTP
     * @param response Resposta HTTP
     * @throws ServletException Caso haja algum problema ao processar a requisição
     * @throws IOException Caso haja algum problema na leitura ou escrita de dados de entrada/saída
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tabelaNome = request.getParameter("tabela");
        Tabela tabela = Constants.getTabela(tabelaNome);
        if (tabela != null) {
            request.setAttribute("tabela", tabela);
            RequestDispatcher rd = request.getRequestDispatcher("inserir.jsp");
            rd.forward(request, response);
        } else {
            ErrorRedirect.handleTabelaIndisponivel(request, response, tabelaNome);
        }
    }
}