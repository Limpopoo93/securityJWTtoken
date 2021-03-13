package task.company.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import task.company.dto.AuthenticationRequestDto;
import task.company.dto.RegisterUserDto;

@Controller
public class MainController {

    //Стартовая страница
    @GetMapping("/")
    public String main(Model model) {
        return "main";
    }

    //Переход на страницу регистрации
    @GetMapping("/registration")
    public String registration(Model model, RegisterUserDto registerUserDto) {
        return "userRegistration";
    }

    //переход на страницу входа
    @GetMapping("/comeIn")
    public String comeIn(Model model, AuthenticationRequestDto authenticationRequestDto) {
        return "userComeIn";
    }
}
