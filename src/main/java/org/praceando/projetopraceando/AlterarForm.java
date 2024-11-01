package org.praceando.projetopraceando;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.dao.ConnectionIsNullException;
import org.dao.DAOGeneric;
import org.dao.DAOManager;
import org.model.Model;

import java.io.IOException;

@WebServlet(name="AlterarForm", value="/alterar")
public class AlterarForm extends HttpServlet {

    /**
     * Método do HttpServlet que é chamado quando o usuário envia o formulário de alteração de um registro.
     * @param request Objeto que contém as informações da requisição do usuário
     * @param response Objeto que contém as informações da resposta do servlet
     * @throws ServletException Erro no Servlet
     * @throws IOException Erro de Entrada/Saída
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String tabela = request.getParameter("tabela");

        // Recupera o DAO correspondente à tabela
        DAOGeneric<Model> dao = DAOManager.getDAO(tabela);
        assert dao != null;

        try {
            // Recupera o registro a ser alterado
            Model model = dao.visualizar(id);

            // Adiciona o registro a ser alterado ao request
            request.setAttribute("model", model);
            request.setAttribute("tabelaNome", dao.getNomeInterface());

            // Encaminha o request para o JSP
            request.getRequestDispatcher("alterar.jsp").forward(request, response);
        } catch (ConnectionIsNullException cne) {
            ErrorRedirect.handleErroBanco(request, response);
        }
    }
}