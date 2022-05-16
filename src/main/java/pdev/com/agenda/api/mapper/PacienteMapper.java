package pdev.com.agenda.api.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pdev.com.agenda.api.request.PacienteRequest;
import pdev.com.agenda.api.response.PacienteResponse;
import pdev.com.agenda.domain.entity.Paciente;

@Mapper(componentModel = "spring")
public abstract class PacienteMapper {

    @Mapping(target = "id", ignore = true)
    public abstract Paciente toEntity(PacienteRequest request);

    public abstract PacienteResponse toResponse(Paciente entity);

    public abstract List<PacienteResponse> toListResponse(List<Paciente> pacienteList);


}
