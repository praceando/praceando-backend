package org.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * Classe utilizada para o tratamento de exceções nos servlets
 */
public class ErrorRedirect {
    public static void redirect(HttpServletRequest request,
                                HttpServletResponse response,
                                String tipoErro, String mensagem) throws IOException, ServletException {
        request.setAttribute("mensagemErro", mensagem);
        request.setAttribute("tipoErro", tipoErro);
        request.getRequestDispatcher("erroBanco.jsp").forward(request, response);
    }

    public static void handleErroBanco(HttpServletRequest request,
                                       HttpServletResponse response) throws IOException, ServletException {
        redirect(request, response, "Erro de conexão", "Não foi possível estabelecer conexão com o banco de dados. Você pode tentar:\n" + "-Verificar a URL e certificar-se de que está correta\n" + "-Limpar o cache e os cookies do navegador\n" + "-Reiniciar o navegador ou tentar em um navegador diferente");
    }
}
