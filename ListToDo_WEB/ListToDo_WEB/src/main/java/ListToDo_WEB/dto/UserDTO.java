package ListToDo_WEB.dto;
import ListToDo_WEB.model.UserModel;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    @NotNull(message = "Email obrigatória")
    private String nome;

    @NotNull(message = "Email obrigatória") @Email
    private String email;

    @NotNull(message = "Senha obrigatória")
    private String senha;

    public UserModel toUser()
    {
        UserModel userModel = new UserModel();

        userModel.setNome(this.nome);
        userModel.setEmail(this.email);
        userModel.setSenha(this.senha);

        return userModel;
    }
}
