package com.hanking.api.atleta;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface AtletaRepository extends ReactiveMongoRepository<Atleta, String> {
     Mono<Atleta> findByNome(String nome);
}
