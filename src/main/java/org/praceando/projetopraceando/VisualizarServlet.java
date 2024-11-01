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

        try {
            DAOGeneric<Model> dao = DAOManager.getDAO(tabela);
            assert dao != null;
            boolean canAlter = !dao.isReadOnly() && !dao.getNomeBanco().equals("admin");

            List<Model> saida = dao.visualizar();

            request.setAttribute("tabelaNome", dao.getNomeInterface());
            request.setAttribute("saida", saida);
            request.setAttribute("canAlter", canAlter);


            RequestDispatcher rd = request.getRequestDispatcher("visualizar.jsp");
            rd.forward(request, response);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }
}
