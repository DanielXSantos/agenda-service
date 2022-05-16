package pdev.com.agenda.api.request;

import java.time.LocalDateTime;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class AgendaRequest {

    @NotBlank(message = "Descrição do agendamento é obrigatorio!")
    private String descricao;

    @Future
    @NotNull(message = "Horario do agendamento é obrigatorio!")
    @DateTimeFormat(pattern = "yyyy-MM-ddTHH:mm:ss")
    private LocalDateTime horario;

    @NotNull
    private Long pacienteId;

}
