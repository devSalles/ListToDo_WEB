package ListToDo_WEB.controller.layout;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/error404")
public class LayoutController {

    @GetMapping
    public ModelAndView error404()
    {
        return new ModelAndView("layout/tarefa404");
    }
}
