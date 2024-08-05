package dev.Tejveer.EcomUserAuthService.Service;

import dev.Tejveer.EcomUserAuthService.DTO.LoginRequestDTO;
import dev.Tejveer.EcomUserAuthService.DTO.SignupRequestDTO;
import dev.Tejveer.EcomUserAuthService.DTO.UserResponseDTO;

public interface UserService {
    UserResponseDTO signUp(SignupRequestDTO signupRequestDTO);
    UserResponseDTO logIn(LoginRequestDTO loginRequestDTO);
    Boolean validateToken(String authToken);
    Boolean logout(String authToken);
}
