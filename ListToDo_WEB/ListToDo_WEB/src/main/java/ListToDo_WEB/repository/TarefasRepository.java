package ListToDo_WEB.repository;

import ListToDo_WEB.model.TarefaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarefasRepository extends JpaRepository<TarefaModel,Long> {
}
