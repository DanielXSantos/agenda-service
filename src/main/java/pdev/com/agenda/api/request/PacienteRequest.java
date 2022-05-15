package pdev.com.agenda.api.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public class PacienteRequest {

    private Long id;

    @NotBlank(message = "Nome do paciente é obrigatorio!")
    private String nome;

    @NotBlank(message = "Sobrenome do paciente é obrigatorio!")
    private String sobrenome;

    @NotBlank(message = "Email do paciente é obrigatorio!")
    @Email
    private String email;

    @NotBlank(message = "CPF do paciente é obrigatorio!")
    private String cpf;


}
