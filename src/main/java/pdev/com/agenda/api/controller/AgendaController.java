package pdev.com.agenda.api.controller;

import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pdev.com.agenda.api.mapper.AgendaMapper;
import pdev.com.agenda.api.request.AgendaRequest;
import pdev.com.agenda.api.response.AgendaResponse;
import pdev.com.agenda.domain.entity.Agenda;
import pdev.com.agenda.domain.service.AgendaService;

@RestController
@RequestMapping("/agenda")
@RequiredArgsConstructor
public class AgendaController {

    private final AgendaService service;
    private final AgendaMapper mapper;

    @PostMapping
    public ResponseEntity<AgendaResponse> salvar(@RequestBody AgendaRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toResponse(service.salvar(
                mapper.toEntity(request))));

    }

    @GetMapping
    public ResponseEntity<List<AgendaResponse>> listarTodos() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(mapper.toListResponse(service.listarTodos()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AgendaResponse> buscarPorId(@PathVariable Long id) {
        Optional<Agenda> optAgenda = service.buscarPorId(id);
        if (optAgenda.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(mapper.toResponse(optAgenda.get()));
    }
}
