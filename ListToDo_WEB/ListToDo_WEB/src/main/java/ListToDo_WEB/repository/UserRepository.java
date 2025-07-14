package ListToDo_WEB.repository;

import ListToDo_WEB.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {

    UserModel findByEmail(String email);
    UserModel findBySenha(String senha);
}
