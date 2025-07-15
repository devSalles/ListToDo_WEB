package ListToDo_WEB.controller.Tarefa;

import ListToDo_WEB.model.TarefaModel;
import ListToDo_WEB.repository.TarefasRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/tarefa")
public class DeleteByIdController {

    private final TarefasRepository tarefasRepository;

    public DeleteByIdController(TarefasRepository tarefasRepository) {
        this.tarefasRepository = tarefasRepository;
    }

    @PostMapping("/delete/{id}")
    public ModelAndView deleteReq(@PathVariable Long id)
    {
        Optional<TarefaModel>tarefaID=this.tarefasRepository.findById(id);
        if(tarefaID.isEmpty())
        {
            return new ModelAndView("redirect:/error404");
        }
        TarefaModel tarefaRecId=tarefaID.get();
        this.tarefasRepository.delete(tarefaRecId);

        return new ModelAndView("redirect:/tarefa/getAll");
    }
}
