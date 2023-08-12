package com.self.bankapi.Exception;

public class InsufficientFundsException extends RuntimeException{
    public InsufficientFundsException() {
        super("Insufficient funds in the account.");
    }

    public InsufficientFundsException(String message) {
        super(message);
    }
}
