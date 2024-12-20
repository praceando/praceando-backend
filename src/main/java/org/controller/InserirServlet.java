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
import org.controller.util.ErrorRedirect;
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

    /** Método para processar o formulário de inserção de dados.
     * @param request Requisição do usuário
     * @param response Resposta para o usuário
     * @throws IOException Exceção na leitura do arquivo
     * @throws ServletException Exceção na execução do servlet
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String tabelaNome = request.getParameter("tabelaNome");
        HTMLInput[] inputs = HTMLInput.getInputs(tabelaNome);

        Map<String, String> params = new LinkedHashMap<>(); // Dicionário que mantém ordem de inserção

        request.setAttribute("params", params);

        // Adiciona os parâmetros do formulário ao dicionário
        for (HTMLInput input : inputs) {
            System.out.printf("%s : %s", input.getName(), request.getParameter(input.getName()));
            params.put(input.getName(), request.getParameter(input.getName()));
        }

        // Cria o objeto Model a partir dos parâmetros do formulário
        try {
            Model criado = ModelCreator.createModel(tabelaNome, params);
            DAOGeneric<Model> dao = DAOManager.getDAO(tabelaNome);

            // Verifica se a tabela aceita alterações por administradores
            assert dao != null;
            if (!dao.isReadOnly()) {
                SqlExitDML saida = dao.inserir(criado);

                request.setAttribute("tabela", dao.getTabela());
                request.setAttribute("saida", saida);
                RequestDispatcher rd = request.getRequestDispatcher("inserirSaida.jsp");
                rd.forward(request, response);
            } else {
                ErrorRedirect.redirect(request, response,"Operação inválida", "Tabela '%s' não aceita alterações por administradores");
            }
        } catch (NullPointerException e) { // se o getDao() retornar null
            ErrorRedirect.handleTabelaIndisponivel(request, response, tabelaNome);
        } catch (ConnectionIsNullException cne) { // se a conexão com o banco estiver indisponível
            ErrorRedirect.handleErroBanco(request, response);
        } catch (ParseException e) { // se o parser não conseguir converter os parâmetros
            e.printStackTrace();
        }
    }
}