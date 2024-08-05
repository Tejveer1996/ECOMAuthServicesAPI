package dev.Tejveer.EcomUserAuthService.Exception;

import javax.management.RuntimeOperationsException;

public class InvalidCredentials extends RuntimeException {
    public InvalidCredentials() {

    }

    public InvalidCredentials(String message) {
        super(message);
    }
}
