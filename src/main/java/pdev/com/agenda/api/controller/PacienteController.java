package pdev.com.agenda.api.controller;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import pdev.com.agenda.api.request.PacienteRequest;
import pdev.com.agenda.api.response.PacienteResponse;
import pdev.com.agenda.domain.entity.Paciente;
import pdev.com.agenda.domain.service.PacienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
@RequestMapping("/paciente")
public class PacienteController {

    private final PacienteService service;

    @PostMapping
    public ResponseEntity<PacienteResponse> salvar(@RequestBody PacienteRequest pacienteRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(pacienteRequest));
    }

    @GetMapping
    public ResponseEntity<List<PacienteResponse>> listarTodos() {
        return ResponseEntity.status(HttpStatus.OK).body(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PacienteResponse> buscarPorId(@PathVariable Long id) {
        PacienteResponse paciente = service.buscarPorId(id);
        if(paciente == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(paciente);
    }

    @PutMapping
    public ResponseEntity<PacienteResponse> alterar(@RequestBody PacienteRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}