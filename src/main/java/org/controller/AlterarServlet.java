package org.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.common.ModelCreator;
import org.common.SqlExitDML;
import org.common.html.HTMLInput;
import org.controller.util.ErrorRedirect;
import org.dao.ConnectionIsNullException;
import org.dao.DAOGeneric;
import org.dao.DAOManager;
import org.model.Model;

import java.io.IOException;
import java.text.ParseException;
import java.util.LinkedHashMap;
import java.util.Map;

@WebServlet(name="AlterarServlet", value="/alterar-done")
public class AlterarServlet extends HttpServlet {

    /**
     * Método que processa a requisição HTTP do tipo POST para alterar um registro em uma tabela do banco de dados.
     * @param request Objeto que contém as informações da requisição HTTP
     * @param response Objeto que fornece a resposta ao cliente
     * @throws ServletException Erro no Servlet
     * @throws IOException Erro de Entrada/Saída
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tabelaNome = request.getParameter("tabelaNome");
        System.out.println(tabelaNome);
        HTMLInput[] inputs = HTMLInput.getInputs(tabelaNome);
        System.out.println(inputs.length);

        Map<String, String> params = new LinkedHashMap<>(); // Dicionário que mantém ordem de inserção

        request.setAttribute("params", params);

        // Adiciona os parâmetros da requisição ao mapa
        for (HTMLInput input : inputs) {
            System.out.printf("%s : %s", input.getName(), request.getParameter(input.getName()));
            params.put(input.getName(), request.getParameter(input.getName()));
        }
        params.put("id", request.getParameter("id"));

        System.out.println(params.size());

        // Cria o objeto Model a partir dos parâmetros da requisição
        try {
            Model criado = ModelCreator.createModel(tabelaNome, params);
            DAOGeneric<Model> dao = DAOManager.getDAO(tabelaNome);

            // Verifica se a tabela é somente leitura
            assert dao != null;
            if (!dao.isReadOnly()) { // se a tabela não é somente leitura
                SqlExitDML saida = dao.alterar(criado);

                // Exibe saída da alteração
                request.setAttribute("tabela", dao.getTabela());
                request.setAttribute("saida", saida);
                RequestDispatcher rd = request.getRequestDispatcher("inserirSaida.jsp");
                rd.forward(request, response);
            } else { // se a tabela é somente leitura
                ErrorRedirect.redirect(request, response,"Operação inválida", "Tabela '%s' não aceita alterações por administradores");
            }

        } catch (NullPointerException e) { // se o getDao() retornar null
            ErrorRedirect.handleTabelaIndisponivel(request, response, tabelaNome);
        } catch (ParseException e) { // se o parse do data retornar erro
            e.printStackTrace();
        } catch (ConnectionIsNullException cne) { // se a conexão com o banco de dados estiver indisponível
            ErrorRedirect.handleErroBanco(request, response);
        }
    }
}