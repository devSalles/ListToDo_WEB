package ListToDo_WEB.controller.User;

import ListToDo_WEB.model.UserModel;
import ListToDo_WEB.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class LoginController {

    private final UserRepository userRepository;

    public LoginController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/login")
    public ModelAndView loginTemplate()
    {
        return new ModelAndView("login/login");
    }

    @PostMapping("/login")
    public ModelAndView loginReq(@RequestParam String email, @RequestParam String senha)
    {
        UserModel userModel = this.userRepository.findByEmail(email);
        if(userModel != null && userModel.getEmail().equals(email) && userModel.getSenha().equals(senha))
        {
            return new ModelAndView("redirect:/tarefa/getAll");
        }
        else
        {
            ModelAndView mv = new ModelAndView("login/login");
            mv.addObject("erro", "email ou senha incorreto");
            return mv;
        }
    }
}
