package dev.Tejveer.EcomUserAuthService.Exception;

public class RoleNotFoundException extends RuntimeException{
    public RoleNotFoundException() {

    }

    public RoleNotFoundException(String message) {
        super(message);
    }
}
