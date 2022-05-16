package pdev.com.agenda.api.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pdev.com.agenda.api.request.AgendaRequest;
import pdev.com.agenda.api.response.AgendaResponse;
import pdev.com.agenda.domain.entity.Agenda;
import pdev.com.agenda.domain.entity.Paciente;

@Mapper(componentModel = "spring", uses = {Paciente.class})
public abstract class AgendaMapper {

    @Mapping(target = "paciente.id", source = "pacienteId")
    @Mapping(target = "dataCriacao", ignore = true)
    @Mapping(target = "id", ignore = true)
    public abstract Agenda toEntity(AgendaRequest request);

    public abstract AgendaResponse toResponse(Agenda entity);

    public abstract List<AgendaResponse> toListResponse(List<Agenda> agendaList);

}
