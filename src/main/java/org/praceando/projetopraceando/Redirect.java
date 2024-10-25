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

@WebServlet(name="Redirect", value="/redirect")
public class Redirect extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tabela = request.getParameter("tabela");
        String opcao = request.getParameter("opcao");

        RequestDispatcher rd = getDispatcher(request, tabela, opcao);

        try {
            rd.forward(request, response);
        } catch (UnsupportedOperationException uoe) {
            RequestDispatcher rd2 = request.getRequestDispatcher("erroNoBancos.jsp");
            request.setAttribute("tipoErro", "Acesso negado");
            request.setAttribute("mensagemErro", String.format("Operação '%s' para a tabela '%s'", opcao, tabela));

            rd2.forward(request, response);
        }
    }

    private RequestDispatcher getDispatcher(HttpServletRequest request, String tabela, String opcao) {
        String[] colunas = getColunas(tabela);
        DAOGeneric<Model> dao = DAOManager.getDAO(tabela);

        request.setAttribute("colunas", colunas);
        request.setAttribute("dao", dao);

        return request.getRequestDispatcher(String.format("%s.jsp", opcao));
    }

    public String[] getColunas(String tabelaNome) {

        String[] colunas = new String[]{};

        switch (tabelaNome) {
            case "admin" -> colunas = new String[]{
                    "ID", "Nome", "E-mail", "Senha", "Status"
            };
            case "avatar" -> colunas = new String[]{
                    "ID", "URL"
            };
            case "evento_local" -> colunas = new String[]{
                    "ID", "Nome", "Latitude", "Longitude"
            };
            case "frase_sustentavel" -> colunas = new String[] {
                    "ID", "Descrição"
            };
            case "produto" -> colunas = new String[]{
                    "ID", "Nome", "Descrição", "Preço", "Categoria",
                    "Estoque", "Desativação"
            };
            case "tag" -> colunas = new String[]{
                    "ID", "Nome", "Categoria"
            };
        }
        return colunas;
    }
}
