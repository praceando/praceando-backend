package org.praceando.projetopraceando;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.common.html.HTMLGenerator;
import org.dao.DAOGeneric;
import org.dao.DAOManager;
import org.model.Model;
import java.io.IOException;

@WebServlet(name="Redirect", value="/redirect")
public class Redirect extends HttpServlet {

    /**Processa uma requisição GET.
     * @param request Solicitação HTTP
     * @param response Resposta HTTP
     * @throws ServletException Possivel erro no servlet
     * @throws IOException Possivel erro de IO
     */
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

    /**Obtém um objeto RequestDispatcher, que é usado para redirecionar a requisição para uma página JSP.
     * @param request Solicitação HTTP
     */

    private RequestDispatcher getDispatcher(HttpServletRequest request, String tabela, String opcao) {
        // Obtém as colunas da tabela
        String[] colunas = HTMLGenerator.getColunas(tabela);
        DAOGeneric<Model> dao = DAOManager.getDAO(tabela);

        // Adiciona os atributos na requisição
        request.setAttribute("colunas", colunas);
        request.setAttribute("dao", dao);

        // Obtém o RequestDispatcher para a página JSP
        return request.getRequestDispatcher(String.format("%s.jsp", opcao));
    }
}
