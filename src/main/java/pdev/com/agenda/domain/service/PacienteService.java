package pdev.com.agenda.domain.service;

import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pdev.com.agenda.api.mapper.PacienteMapper;
import pdev.com.agenda.api.request.PacienteRequest;
import pdev.com.agenda.api.response.PacienteResponse;
import pdev.com.agenda.domain.entity.Paciente;
import pdev.com.agenda.domain.exception.BusinessException;
import pdev.com.agenda.domain.repository.PacienteRepository;

@RequiredArgsConstructor
@Service
@Transactional
public class PacienteService {

    private final PacienteRepository repository;
    private final PacienteMapper mapper;

    public PacienteResponse salvar(PacienteRequest pacienteRequest) {
        Optional<Paciente> pacienteByCpf = findByCpf(pacienteRequest.getCpf());
        if(pacienteByCpf.isPresent() && !pacienteByCpf.get().getId().equals(pacienteRequest.getId())) {
            throw new BusinessException("Cpf ja cadastrado!");
        }

        return mapper.toResponse(repository.save(mapper.toEntity(pacienteRequest)));
    }

    private Optional<Paciente> findByCpf(String cpf) {
        return repository.findByCpf(cpf);
    }

    public List<PacienteResponse> listarTodos() {
        return mapper.toListResponse(repository.findAll());
    }

    public PacienteResponse buscarPorId(Long id) {
        return mapper.toResponse(repository.getById(id));
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
