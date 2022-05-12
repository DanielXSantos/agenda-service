package pdev.com.agenda.domain.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pdev.com.agenda.domain.entity.Paciente;
import pdev.com.agenda.domain.exception.BusinessException;
import pdev.com.agenda.domain.repository.PacienteRepository;

@Service
@Transactional
public class PacienteService {

    @Autowired
    private PacienteRepository repository;

    public Paciente salvar(Paciente paciente) {
        Optional<Paciente> pacienteByCpf = findByCpf(paciente);
        if(pacienteByCpf.isPresent() && !pacienteByCpf.get().getId().equals(paciente.getId())) {
            throw new BusinessException("Cpf ja cadastrado!");
        }

        return repository.save(paciente);
    }

    private Optional<Paciente> findByCpf(Paciente paciente) {
        return repository.findByCpf(paciente.getCpf());
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
