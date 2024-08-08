package br.com.fiap.soat4.grupo48.deletar.cliente.commons.exception;

public class ApplicationException extends Exception {
    private static final long serialVersionUID = 792810425708638161L;

    public ApplicationException(String message) { super(message);}

    public ApplicationException(String message, Throwable cause) { super(message, cause);}
}
