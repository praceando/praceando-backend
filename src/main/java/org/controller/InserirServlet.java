package org.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.common.html.HTMLInput;
import org.common.ModelCreator;
import org.common.SqlExitDML;
import org.dao.ConnectionIsNullException;
import org.dao.DAOGeneric;
import org.dao.DAOManager;
import org.model.Model;

import java.io.IOException;
import java.text.ParseException;
import java.util.LinkedHashMap;
import java.util.Map;

@WebServlet(name="InserirServlet", value="/inserir-done")
public class InserirServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String tabelaNome = request.getParameter("tabelaNome");
        System.out.println(tabelaNome);
        HTMLInput[] inputs = HTMLInput.getInputs(tabelaNome);
        System.out.println(inputs.length);

        Map<String, String> params = new LinkedHashMap<>(); // Dicionário que mantém ordem de inserção

        request.setAttribute("params", params);

        for (HTMLInput input : inputs) {
            System.out.printf("%s : %s", input.getName(), request.getParameter(input.getName()));
            params.put(input.getName(), request.getParameter(input.getName()));
        }
        System.out.println(params.size());

        try {
            Model criado = ModelCreator.createModel(tabelaNome, params);
            DAOGeneric<Model> dao = DAOManager.getDAO(tabelaNome);

            assert dao != null;
            if (!dao.isReadOnly()) {
                SqlExitDML saida = dao.inserir(criado);

                request.setAttribute("saida", saida);
                RequestDispatcher rd = request.getRequestDispatcher("inserirSaida.jsp");
                rd.forward(request, response);
            } else {
                ErrorRedirect.redirect(request, response,"Operação inválida", "Tabela '%s' não aceita alterações por administradores");
            }

        } catch (ConnectionIsNullException cne) {
            ErrorRedirect.handleErroBanco(request, response);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}