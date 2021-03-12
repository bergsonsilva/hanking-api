package com.hanking.api.repository;

import com.hanking.api.model.Atleta;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface AtletaRepository extends ReactiveMongoRepository<Atleta, String> {
  public Mono<Atleta> findByNome(String nome);
}
