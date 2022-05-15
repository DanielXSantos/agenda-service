package pdev.com.agenda.api.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import pdev.com.agenda.api.request.AgendaRequest;
import pdev.com.agenda.api.response.AgendaResponse;
import pdev.com.agenda.domain.entity.Agenda;

@Mapper(componentModel = "spring")
public abstract class AgendaMapper {

    public abstract Agenda toEntity(AgendaRequest request);

    public abstract AgendaResponse toResponse(Agenda entity);

    public abstract List<AgendaResponse> toListResponse(List<Agenda> agendaList);

}
