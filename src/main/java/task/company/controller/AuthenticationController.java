package task.company.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import task.company.bean.User;
import task.company.dto.AuthenticationRequestDto;
import task.company.dto.RegisterUserDto;
import task.company.security.JwtTokenProvider;
import task.company.service.UserService;


@RestController
@RequestMapping(value = "/api/v1/auth/")
public class AuthenticationController {
    private final AuthenticationManager authenticationManager;

    private final JwtTokenProvider jwtTokenProvider;

    private final UserService userService;

    @Autowired
    public AuthenticationController(AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider, UserService userService) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
        this.userService = userService;
    }

    @PostMapping("save")
    public String save(RegisterUserDto registerUserDto, Model model) {
        try {
            User userCheck = userService.findByUsername(registerUserDto.getUsername());
            if (userCheck == null) {
                throw new UsernameNotFoundException("User with username: " + userCheck.getUsername() + " not found");
            }
            User user1 = new User();
            user1.setUsername(registerUserDto.getUsername());
            user1.setFirstName(registerUserDto.getUsername());
            user1.setLastName(registerUserDto.getUsername());
            user1.setEmail(registerUserDto.getUsername());
            user1.setPassword(registerUserDto.getPassword());
            User user = userService.register(user1);
            String username = registerUserDto.getUsername();
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, registerUserDto.getPassword()));
            String token = jwtTokenProvider.createToken(username, user.getRoles());
            model.addAttribute("user", user);
            model.addAttribute("token", token);
            return "documentList";
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid username or password");
        }
    }

    @PostMapping("login")
    public String login(AuthenticationRequestDto requestDto, Model model) {
        try {
            String username = requestDto.getUsername();
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, requestDto.getPassword()));
            User user = userService.findByUsername(username);

            if (user == null) {
                throw new UsernameNotFoundException("User with username: " + username + " not found");
            }

            String token = jwtTokenProvider.createToken(username, user.getRoles());
            model.addAttribute("user", user);
            model.addAttribute("token", token);
            return "documentList";
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid username or password");
        }
    }
}
