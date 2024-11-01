package org.dao;

public class ConnectionIsNullException extends RuntimeException {

    /**
     * Construtor da classe ConnectionIsNullException
     * @param message Mensagem de erro
     */
    public ConnectionIsNullException(String message) {
        super(message);
    }
}