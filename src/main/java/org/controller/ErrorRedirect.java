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
        request.setAttribute("mensagem", mensagem);
        request.setAttribute("tipoErro", tipoErro);
        request.getRequestDispatcher("erroBanco.jsp").forward(request, response);
    }

    public static void handleErroBanco(HttpServletRequest request,
                                       HttpServletResponse response) throws IOException, ServletException {
        redirect(request, response, "Erro de conexão com o Banco de Dados", "Não foi possível se conectar com o banco");
    }
}
