package br.git.francieudocosta.dev.agendadortarefas.business.mapper;

import br.git.francieudocosta.dev.agendadortarefas.business.dto.TarefasDTO;
import br.git.francieudocosta.dev.agendadortarefas.infrastructure.entity.TarefasEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TarefaConverter {

    TarefasEntity paraTarefaEntity(TarefasDTO tarefaDTO);

    TarefasDTO paraTarefaDTO(TarefasEntity tarefaEntity);

    List<TarefasEntity> paraListaTarefasEntity(List<TarefasDTO> tarefasDTO);

    List<TarefasDTO> paraListaTarefasDTO(List<TarefasEntity> tarefasEntity);
}
