package org.dao;

public class ConnectionIsNullException extends RuntimeException {
    public ConnectionIsNullException(String message) {
        super(message);
    }
}
