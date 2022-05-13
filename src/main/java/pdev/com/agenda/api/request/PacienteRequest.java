package pdev.com.agenda.api.request;

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
    private String nome;
    private String sobrenome;
    private String email;
    private String cpf;


}
