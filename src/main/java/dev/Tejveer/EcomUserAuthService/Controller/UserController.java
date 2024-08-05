package dev.Tejveer.EcomUserAuthService.Controller;

import dev.Tejveer.EcomUserAuthService.DTO.LoginRequestDTO;
import dev.Tejveer.EcomUserAuthService.DTO.SignupRequestDTO;
import dev.Tejveer.EcomUserAuthService.DTO.UserResponseDTO;
import dev.Tejveer.EcomUserAuthService.Service.UserService;
import org.apache.tomcat.util.http.parser.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<UserResponseDTO> signUp(@RequestBody SignupRequestDTO signupRequestDTO){
        return ResponseEntity.ok(userService.signUp(signupRequestDTO));
    }

    @PostMapping("/login")
    public ResponseEntity<UserResponseDTO> login(@RequestBody LoginRequestDTO loginRequestDTO){
        return ResponseEntity.ok(userService.logIn(loginRequestDTO));
    }

    @GetMapping("/validate")
    public ResponseEntity<Boolean> validateToken(@RequestHeader("Authorization") String authToken){
        return ResponseEntity.ok(userService.validateToken(authToken));
    }

    @GetMapping("/logout")
    public ResponseEntity<Boolean> logout(@RequestHeader("Authorisation") String authToken){
        return ResponseEntity.ok(userService.logout(authToken));
    }
}
