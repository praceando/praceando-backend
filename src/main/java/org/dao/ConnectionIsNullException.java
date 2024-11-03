package org.dao;

/**
 * Representa a exceção que ocorre quando não é possível se conectar ao
 * banco de dados. Especificamente quando o DriverManager do JDBC retorna
 * um objeto Connection null no conectar() da classe Conexao
 */
public class ConnectionIsNullException extends RuntimeException {

    /**
     * Construtor da classe ConnectionIsNullException
     * @param message Mensagem de erro
     */
    public ConnectionIsNullException(String message) {
        super(message);
    }
}