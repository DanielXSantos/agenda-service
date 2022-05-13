package pdev.com.agenda.api.response;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class PacienteResponse {

    private Long id;
    private String nome;
    private String sobrenome;
    private String email;
    private String cpf;

}
