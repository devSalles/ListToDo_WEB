package ListToDo_WEB.controller.Tarefa;

import ListToDo_WEB.Enum.TarefaEnum;
import ListToDo_WEB.model.TarefaModel;
import ListToDo_WEB.repository.TarefasRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/tarefa")
public class GetAllController {

    private final TarefasRepository tarefasRepository;

    public GetAllController(TarefasRepository tarefasRepository) {
        this.tarefasRepository = tarefasRepository;
    }

    @GetMapping("/getAll")
    public ModelAndView getAll()
    {
        ModelAndView mv = new ModelAndView("home");
        mv.addObject("tarefaAll",tarefasRepository.findAll());
        mv.addObject("tarefaNew", new TarefaModel());
        mv.addObject("statusTarefa", TarefaEnum.values());
        return mv;
    }
}
