package org.praceando.projetopraceando;

<<<<<<< HEAD
=======
import jakarta.servlet.RequestDispatcher;
>>>>>>> c5580918d96592a8c60201406ebbde11b39c3130
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
<<<<<<< HEAD
        request.getSession().setAttribute("tabelaNome", tabelaNome);
=======
        request.setAttribute("tabelaNome", tabelaNome);
>>>>>>> c5580918d96592a8c60201406ebbde11b39c3130

        String[] colunas = null;

        switch (tabelaNome) {
            case "Avatar" -> colunas = new String[]{
                "id_avatar", "url_avatar"
            };
            case "Evento Local" -> colunas = new String[]{
                    "id_local", "nome", "lat", "long"
            };
            case "Frase Sustentável" -> colunas = new String[] {
                    "id_frase", "dt_atualizacao", "ds_frase"
            };
            case "Produto" -> colunas = new String[]{
                    "id_produto", "estoque", "nome", "ds_produto", "preco",
                    "categoria", "dt_atualizacao", "dt_desativacao"
            };
            case "Tag" -> colunas = new String[]{
                    "id_tag", "nome", "dt_atualizacao", "categoria"
            };
        }
<<<<<<< HEAD
        request.getSession().setAttribute("colunas", colunas);
        response.sendRedirect("escolherAcao.jsp");
=======
        request.setAttribute("colunas", colunas);

        RequestDispatcher rd = request.getRequestDispatcher("escolherAcao.jsp");
        rd.forward(request, response);
>>>>>>> c5580918d96592a8c60201406ebbde11b39c3130
    }
}