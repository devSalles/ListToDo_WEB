package ListToDo_WEB.dto;

import ListToDo_WEB.Enum.TarefaEnum;
import ListToDo_WEB.model.TarefaModel;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.dao.TransientDataAccessResourceException;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TarefaDTO {

    @NotNull(message = "Título otbigatório")
    private String titulo;

    @NotNull(message = "Descrição otbigatória")
    private String descricao;

    @Enumerated(EnumType.STRING)
    private TarefaEnum tarefaEnum;

    @NotNull @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate inicio;

    @NotNull @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fim;

    public TarefaModel toTarefa()
    {
        TarefaModel tarefaModel = new TarefaModel();

        tarefaModel.setTitulo(this.titulo);
        tarefaModel.setDescricao(this.descricao);
        tarefaModel.setTarefaEnum(this.tarefaEnum);
        tarefaModel.setInicio(this.inicio);
        tarefaModel.setFim(this.fim);

        return tarefaModel;
    }

    public void fromTarefa(TarefaModel tarefaModel)
    {
        this.titulo = tarefaModel.getTitulo();
        this.descricao = tarefaModel.getDescricao();
        this.tarefaEnum = tarefaModel.getTarefaEnum();
        this.inicio=tarefaModel.getInicio();
        this.fim=tarefaModel.getFim();
    }

    public TarefaModel updateTarefa(TarefaModel tarefaModel)
    {
        tarefaModel.setTitulo(this.getTitulo());
        tarefaModel.setDescricao(this.getDescricao());
        tarefaModel.setTarefaEnum(this.getTarefaEnum());
        tarefaModel.setInicio(this.getInicio());
        tarefaModel.setFim(this.getFim());

        return tarefaModel;
    }
}