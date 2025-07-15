package ListToDo_WEB.controller.Tarefa;

import ListToDo_WEB.Enum.TarefaEnum;
import ListToDo_WEB.dto.TarefaDTO;
import ListToDo_WEB.model.TarefaModel;
import ListToDo_WEB.repository.TarefasRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/tarefa")
public class AddNewController {

    private final TarefasRepository tarefasRepository;

    public AddNewController(TarefasRepository tarefasRepository) {
        this.tarefasRepository = tarefasRepository;
    }

    @GetMapping("/add")
    public ModelAndView adicionarCamp()
    {
        ModelAndView mv = new ModelAndView("tarefa/new");
        mv.addObject("tarefaDTO", new TarefaDTO());
        mv.addObject("tarefaStatus", TarefaEnum.values());
        return mv;
    }

    @PostMapping("/add")
    public ModelAndView adicionarReq(@Valid TarefaDTO tarefaDTO, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
        {
            return new ModelAndView("redirect:/tarefa/add");
        }
        TarefaModel tarefaSave=tarefaDTO.toTarefa();
        this.tarefasRepository.save(tarefaSave);
        return new ModelAndView("redirect:/tarefa/getAll");
    }
}
