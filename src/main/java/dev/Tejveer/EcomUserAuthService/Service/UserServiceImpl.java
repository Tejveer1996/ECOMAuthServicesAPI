package dev.Tejveer.EcomUserAuthService.Service;

import dev.Tejveer.EcomUserAuthService.DTO.LoginRequestDTO;
import dev.Tejveer.EcomUserAuthService.DTO.SignupRequestDTO;
import dev.Tejveer.EcomUserAuthService.DTO.UserResponseDTO;
import dev.Tejveer.EcomUserAuthService.Entity.Role;
import dev.Tejveer.EcomUserAuthService.Entity.User;
import dev.Tejveer.EcomUserAuthService.Exception.InvalidCredentials;
import dev.Tejveer.EcomUserAuthService.Exception.RoleNotFoundException;
import dev.Tejveer.EcomUserAuthService.Repository.RolesRepository;
import dev.Tejveer.EcomUserAuthService.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RolesRepository rolesRepository;
    @Override
    public UserResponseDTO signUp(SignupRequestDTO signupRequestDTO) {

        Role role = rolesRepository.findById(signupRequestDTO.getRole()).orElseThrow(
                ()-> new RoleNotFoundException("Role does not exist")
        );
        User newUser = new User();
        newUser.setUsername(signupRequestDTO.getUsername());
        newUser.setEmailId(signupRequestDTO.getEmailId());

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        newUser.setPassword(encoder.encode(signupRequestDTO.getPassword()));
        newUser.setRoles(List.of(role));

        return UserResponseDTO.from(userRepository.save(newUser));
    }

    @Override
    public UserResponseDTO logIn(LoginRequestDTO loginRequestDTO) {
        User savedUser = userRepository.findByEmailId(loginRequestDTO.getEmailId()).orElseThrow(
                ()-> new InvalidCredentials("Invalid emailId")
        );
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if (encoder.matches(loginRequestDTO.getPassword(), savedUser.getPassword())){
            String data = savedUser.getEmailId()+savedUser.getPassword()+ LocalTime.now();
            String token = encoder.encode(data);
            savedUser.setToken("Bearer "+token);
        }else {
            throw new InvalidCredentials("Invalid password");
        }
        savedUser = userRepository.save(savedUser);
        return UserResponseDTO.from(savedUser);
    }

    @Override
    public Boolean validateToken(String authToken) {
        User savedUser = userRepository.findByToken(authToken).orElseThrow(
                ()-> new InvalidCredentials("Token is not valid")
        );
        return true;
    }

    @Override
    public Boolean logout(String authToken) {
        User saveUser = userRepository.findByToken(authToken).orElseThrow(
                ()-> new InvalidCredentials("Invalid token")
        );

        saveUser.setToken(null);
        userRepository.save(saveUser);
        return true;
    }


}
