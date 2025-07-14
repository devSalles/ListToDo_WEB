package ListToDo_WEB.controller.User;

import ListToDo_WEB.dto.UserDTO;
import ListToDo_WEB.model.UserModel;
import ListToDo_WEB.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class CadastroController {

    private final UserRepository userRepository;

    public CadastroController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/cadastro")
    public ModelAndView cadastroTemplate()
    {
        ModelAndView mv = new ModelAndView("cadastro/cadastro");
        mv.addObject("userDTO", new UserDTO());
        return mv;
    }

    @PostMapping("/cadastro")
    public ModelAndView cadastroReq(@Valid @ModelAttribute("userDTO") UserDTO userDTO, BindingResult bindingResult)
    {
        ModelAndView mv = new ModelAndView("cadastro/cadastro");

        if(bindingResult.hasErrors())
        {
            return mv;
        }

        if(userRepository.findByEmail(userDTO.getEmail()) != null)
        {
            mv.addObject("erro", "email já esta em uso");
            return mv;
        }


        if(userRepository.findBySenha(userDTO.getSenha()) != null)
        {
            mv.addObject("erro", "senha já esta em uso");
            return mv;
        }

        UserModel userSave=userDTO.toUser();
        this.userRepository.save(userSave);

        return new ModelAndView("redirect:/user/login");
    }
}
