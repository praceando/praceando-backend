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

    /**Processa uma requisição GET.
     * @param request Solicitação HTTP
     * @param response Resposta HTTP
     * @throws ServletException Possivel erro no servlet
     * @throws IOException Possivel erro de IO
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = getDispatcher(request);
        rd.forward(request, response);
    }

    /**Obtém um objeto RequestDispatcher, que é usado para redirecionar a requisição para uma página JSP.
     * @param request Solicitação HTTP
     */
    private RequestDispatcher getDispatcher(HttpServletRequest request) {
        // Obtém os parâmetros da URL
        String tabela = request.getParameter("tabela");
        String opcao = request.getParameter("opcao");

        System.out.println(tabela);
        System.out.println(opcao);

        // Obtém as colunas da tabela
        String[] colunas = getColunas(tabela);
        DAOGeneric<Model> dao = DAOManager.getDAO(tabela);

        // Adiciona os atributos na requisição
        request.setAttribute("colunas", colunas);
        request.setAttribute("dao", dao);

        // Obtém o RequestDispatcher para a página JSP
        return request.getRequestDispatcher(String.format("%s.jsp", opcao));
    }

    /**Obtém as colunas de uma tabela.
     * @param tabelaNome Nome da tabela
     * @return Array com as colunas da tabela
     */
    public String[] getColunas(String tabelaNome) {

        String[] colunas = new String[]{};

        // Adiciona as colunas de cada tabela
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
        // Retorna o array com as colunas
        return colunas;
    }
}
