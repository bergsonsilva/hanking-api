package com.hanking.api.atleta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AtletaService {
    @Autowired
    private AtletaRepository repository;

    public Flux<AtletaDto> findAll() {
        return this.repository.findAll().map(Atleta::toDto).cast(AtletaDto.class);

    }

    public Mono<AtletaDto> findById(String id) {
        return repository.findById(id).map(Atleta::toDto);
    }

    public Mono<AtletaDto> findByNome(String nome) {
        return repository.findByNome(nome).map(Atleta::toDto);
    }

    public Mono<AtletaDto> save(AtletaDto dto) {
        Mono<Atleta> atletaMono = repository.save(dto.toEntity(dto));
        return atletaMono.map(Atleta::toDto);
    }

    public Mono<Void> deleteById(String id) {
        return repository.deleteById(id);
    }

}
