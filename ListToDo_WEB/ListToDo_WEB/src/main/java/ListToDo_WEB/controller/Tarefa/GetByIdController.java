package ListToDo_WEB.controller.Tarefa;

import ListToDo_WEB.dto.TarefaDTO;
import ListToDo_WEB.model.TarefaModel;
import ListToDo_WEB.repository.TarefasRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/tarefa")
public class GetByIdController {

    private TarefasRepository tarefasRepository;

    public GetByIdController(TarefasRepository tarefasRepository) {
        this.tarefasRepository = tarefasRepository;
    }

    @GetMapping("/detalhe/{id}")
    public ModelAndView getTemplateInfo(@PathVariable Long id, TarefaDTO tarefaDTO)
    {
        Optional<TarefaModel>tarefaID=this.tarefasRepository.findById(id);
        if(tarefaID.isEmpty())
        {
            return new ModelAndView("redirect:/error404");
        }else
        {
            TarefaModel tarefaRecID=tarefaID.get();
            tarefaDTO.fromTarefa(tarefaRecID);

            ModelAndView mv = new ModelAndView("tarefa/getById");
            mv.addObject("tarefaDTO", tarefaRecID);

            return mv;
        }
    }

}