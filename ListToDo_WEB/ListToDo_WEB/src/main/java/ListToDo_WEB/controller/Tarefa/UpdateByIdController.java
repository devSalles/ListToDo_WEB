package ListToDo_WEB.controller.Tarefa;

import ListToDo_WEB.Enum.TarefaEnum;
import ListToDo_WEB.dto.TarefaDTO;
import ListToDo_WEB.model.TarefaModel;
import ListToDo_WEB.repository.TarefasRepository;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/tarefa")
public class UpdateByIdController {
    private final TarefasRepository tarefasRepository;

    public UpdateByIdController(TarefasRepository tarefasRepository) {
        this.tarefasRepository = tarefasRepository;
    }

    @GetMapping("/update/{id}")
    public ModelAndView updateTemplate(@PathVariable Long id, TarefaDTO tarefaDTO) {
        Optional<TarefaModel>tarefaID=this.tarefasRepository.findById(id);
        if(tarefaID.isEmpty())
        {
            return new ModelAndView("redirect:/error404");
        }
        else
        {
            TarefaModel tarefaModel=tarefaID.get();
            tarefaDTO.fromTarefa(tarefaModel);

            ModelAndView mv = new ModelAndView("tarefa/updateById");
            mv.addObject("id", id);
            mv.addObject("tarefaDTO", tarefaDTO);
            mv.addObject("statusTarefa", TarefaEnum.values());
            return mv;
        }
    }

    @PostMapping("/update/{id}")
    public ModelAndView updateReq(@PathVariable Long id, TarefaDTO tarefaDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            ModelAndView mv = new ModelAndView("redirect:/tarefa/update");

            mv.addObject("id", id);
            mv.addObject("tarefaDTO", tarefaDTO);
            mv.addObject("statusTarefa", TarefaEnum.values());

            return mv;
        } else {
            Optional<TarefaModel> tarefaID = this.tarefasRepository.findById(id);
            if (tarefaID.isEmpty())
            {
                return new ModelAndView("redirect:/error404");
            }
            else
            {
                TarefaModel tarefaUpdate = tarefaID.get();
                tarefaDTO.updateTarefa(tarefaUpdate);
                this.tarefasRepository.save(tarefaUpdate);

                return new ModelAndView("redirect:/tarefa/getAll");
            }
        }
    }
}
