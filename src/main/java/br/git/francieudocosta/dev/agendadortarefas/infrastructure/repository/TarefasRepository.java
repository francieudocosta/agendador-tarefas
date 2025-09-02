package br.git.francieudocosta.dev.agendadortarefas.infrastructure.repository;

import br.git.francieudocosta.dev.agendadortarefas.infrastructure.entity.TarefasEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TarefasRepository extends MongoRepository<TarefasEntity, String> {
}
