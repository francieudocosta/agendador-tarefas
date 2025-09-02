package br.git.francieudocosta.dev.agendadortarefas.controller;

import br.git.francieudocosta.dev.agendadortarefas.business.TarefaService;
import br.git.francieudocosta.dev.agendadortarefas.business.dto.TarefasDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("tarefas")
@RequiredArgsConstructor
public class TarefasController {

    private final TarefaService tarefaService;

    @PostMapping
    public ResponseEntity<TarefasDTO> gravarTarefas(@RequestBody TarefasDTO tarefaDTO,
                                                    @RequestHeader("Authorization") String token) {

        return ResponseEntity.ok(tarefaService.gravarTarefa(token, tarefaDTO));
    }
}
