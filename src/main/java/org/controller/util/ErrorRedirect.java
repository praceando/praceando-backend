package org.controller.util;

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

    /**
     * Método para tratar exceções de conexão com o banco de dados
     * @param request Requisição HTTP
     * @param response Resposta HTTP
     * @throws IOException Exceção de I/O
     * @throws ServletException Exceção de servlet
     */
    public static void handleErroBanco(HttpServletRequest request,
                                       HttpServletResponse response) throws IOException, ServletException {
        redirect(request, response, "Erro de conexão", "Não foi possível estabelecer conexão com o banco de dados. Você pode tentar:\n" + "-Verificar a URL e certificar-se de que está correta\n" + "-Limpar o cache e os cookies do navegador\n" + "-Reiniciar o navegador ou tentar em um navegador diferente");
    }

    /** Método para tratar exceções de tabelas indisponíveis no banco de dados
     * @param request Requisição HTTP
     * @param response Resposta HTTP
     * @param tabelaNome Nome da tabela indisponível
     * @throws IOException Exceção de I/O
     * @throws ServletException Exceção de servlet
     */
    public static void handleTabelaIndisponivel(HttpServletRequest request,
                                       HttpServletResponse response, String tabelaNome) throws IOException, ServletException {
        redirect(request, response, "404 Não encontrado: " + tabelaNome, "Não foi possível encontrar essa tabela especificada na requisição, verifique se você está digitando a URL corretamente, ou tente de novo.");
    }

    public static void handleRegistroIndisponivel(HttpServletRequest request,
                                                  HttpServletResponse response,
                                                  String tabelaNome, int id) throws IOException, ServletException {
        redirect(request, response, "404 Não encontrado em " + tabelaNome + " o registro de ID " + id, "Não foi possível encontrar esse registro especificado na requisição, tente novamente, senão, o registro possivelmente fora excluído.");
    }

}