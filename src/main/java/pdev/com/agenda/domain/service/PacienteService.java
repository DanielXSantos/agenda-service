package pdev.com.agenda.domain.service;

import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pdev.com.agenda.domain.entity.Paciente;
import pdev.com.agenda.exception.BusinessException;
import pdev.com.agenda.domain.repository.PacienteRepository;

@RequiredArgsConstructor
@Service
@Transactional
public class PacienteService {

    private final PacienteRepository repository;

    public Paciente salvar(Paciente pacienteRequest) {
        Optional<Paciente> pacienteByCpf = findByCpf(pacienteRequest.getCpf());
        if (pacienteByCpf.isPresent() && !pacienteByCpf.get().getId()
                .equals(pacienteRequest.getId())) {
            throw new BusinessException("Cpf ja cadastrado!");
        }

        return repository.save(pacienteRequest);
    }

    private Optional<Paciente> findByCpf(String cpf) {
        return repository.findByCpf(cpf);
    }

    public List<Paciente> listarTodos() {
        return repository.findAll();
    }

    public Optional<Paciente> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
