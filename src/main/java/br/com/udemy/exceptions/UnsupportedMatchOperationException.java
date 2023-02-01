package br.com.udemy.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus é que codigo de erro, o qual codigo irá retornar codigo do erro

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnsupportedMatchOperationException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public UnsupportedMatchOperationException(String ex) {
        super(ex);
    }
}