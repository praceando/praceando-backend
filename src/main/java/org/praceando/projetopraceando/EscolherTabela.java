package org.praceando.projetopraceando;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name="EscolherTabela", value="/escolher-tabela")
public class EscolherTabela extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tabelaNome =  request.getParameter("opcao");
        request.setAttribute("tabelaNome", tabelaNome);

        String[] colunas = null;

        request.setAttribute("colunas", colunas);


        RequestDispatcher rd = request.getRequestDispatcher("escolherAcao.jsp");
        rd.forward(request, response);
    }
}