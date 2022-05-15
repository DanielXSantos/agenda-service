package pdev.com.agenda.api.request;

import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pdev.com.agenda.domain.entity.Paciente;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class AgendaRequest {

    private Long id;

    @NotBlank(message = "Descrição do agendamento é obrigatorio!")
    private String descricao;

    @Future
    @NotBlank(message = "Horario do agendamento é obrigatorio!")
    private LocalDate horario;

    @NotBlank(message = "É obrigatorio informar o paciente que está agendando um horario!")
    private Paciente paciente;

}
