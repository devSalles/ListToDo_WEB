package ListToDo_WEB.model;

import ListToDo_WEB.Enum.TarefaEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@Entity
@Table(name = "tb__tarefa")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TarefaModel {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String descricao;

    @Enumerated(EnumType.STRING) @Column(nullable = false)
    private TarefaEnum tarefaEnum;

    @Column(nullable = false)
    private LocalDate inicio;

    @Column(nullable = false)
    private LocalDate fim;
}
