package org.praceando.projetopraceando;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
<<<<<<< HEAD
=======
import org.common.SqlExitDML;
import org.dao.TagDAO;
>>>>>>> c5580918d96592a8c60201406ebbde11b39c3130

import java.io.IOException;

@WebServlet(name="Delete", value="/informacoesDelete")
public class Delete extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
<<<<<<< HEAD
        String idDelete =  request.getParameter("idDelete");
        request.setAttribute("idDelete", idDelete);
=======
        int idDelete = Integer.parseInt(request.getParameter("idDelete"));
        String tabelaNome = request.getParameter("tabelaNome");

        SqlExitDML saida = new SqlExitDML();
        switch (tabelaNome) {
            case "tag" -> {
                TagDAO tagDao = new TagDAO();
                saida = tagDao.remover(idDelete);
            }
        }
        request.setAttribute("idDelete", idDelete);

>>>>>>> c5580918d96592a8c60201406ebbde11b39c3130
        request.getSession().setAttribute("idDelete", idDelete);

        response.sendRedirect("mensagemFinal.jsp");
    }
}