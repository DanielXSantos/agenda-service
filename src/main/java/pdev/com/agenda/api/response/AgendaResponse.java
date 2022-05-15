package pdev.com.agenda.api.response;

import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pdev.com.agenda.domain.entity.Paciente;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class AgendaResponse {

    private Long id;
    private String descricao;
    private LocalDate horario;
    private LocalDateTime dataCriacao;
    private Paciente paciente;

}
