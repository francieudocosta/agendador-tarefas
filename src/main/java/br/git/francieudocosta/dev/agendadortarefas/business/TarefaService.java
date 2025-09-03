package br.git.francieudocosta.dev.agendadortarefas.business;

import br.git.francieudocosta.dev.agendadortarefas.business.dto.TarefasDTO;
import br.git.francieudocosta.dev.agendadortarefas.business.mapper.TarefaConverter;
import br.git.francieudocosta.dev.agendadortarefas.infrastructure.enums.StatusNotificacaoEnum;
import br.git.francieudocosta.dev.agendadortarefas.infrastructure.repository.TarefasRepository;
import br.git.francieudocosta.dev.agendadortarefas.infrastructure.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TarefaService {

    private final TarefasRepository tarefaRepository;
    private final TarefaConverter tarefaConverter;
    private final JwtUtil jwtUtil;

    public TarefasDTO gravarTarefa(String token, TarefasDTO dto) {

        String email = jwtUtil.extractUsername(token.substring(7));

        dto.setEmailUsuario(email);
        dto.setDataCriacao(LocalDateTime.now());
        dto.setStatusNoficacao(StatusNotificacaoEnum.PENDENTE);

        return tarefaConverter.paraTarefaDTO(tarefaRepository.save(
                tarefaConverter.paraTarefaEntity(dto)
        ));
    }

    public List<TarefasDTO> buscaTarefasAgendadasPorPeriodo(LocalDateTime dataInicial,
                                                            LocalDateTime dataFinal) {
        return tarefaConverter.paraListaTarefasDTO(
                tarefaRepository.findByDataEventoBetween(dataInicial, dataFinal)
        );
    }

    public List<TarefasDTO> buscaTarefasPorEmail(String token) {

        String email = jwtUtil.extractUsername(token.substring(7));

        return tarefaConverter.paraListaTarefasDTO(tarefaRepository.findByEmailUsuario(email));
    }
}
