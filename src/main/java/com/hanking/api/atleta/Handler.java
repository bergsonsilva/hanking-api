package com.hanking.api.atleta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component
public class Handler {

    @Autowired
    private AtletaService atletaService;


    public Mono<ServerResponse> save(ServerRequest request){
        final Mono<AtletaDto> contaMono = request.bodyToMono(AtletaDto.class);
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(fromPublisher(contaMono.flatMap(atletaService::save), AtletaDto.class));
    }

    public Mono<ServerResponse> findAll(ServerRequest request){
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(atletaService.findAll(), AtletaDto.class);
    }

    public Mono<ServerResponse> findById(ServerRequest request){
        String id = request.pathVariable("id");

        Mono<ServerResponse> notFound = ServerResponse.notFound().build();
        Mono<AtletaDto> atletaMonoDto = atletaService.findById(id);
        return atletaMonoDto.flatMap(atletaDto ->  ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(atletaMonoDto, AtletaDto.class)
        ).switchIfEmpty(notFound)
                .switchIfEmpty(Mono.error(new Exception()));
    }

    public Mono<ServerResponse> findByNome(ServerRequest request){
        String nome = request.pathVariable("nome");

        Mono<ServerResponse> notFound = ServerResponse.notFound().build();
        Mono<AtletaDto> atletaMonoDto = atletaService.findByNome(nome);
        return atletaMonoDto.flatMap( atletaDto ->
            ServerResponse.ok()
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(atletaMonoDto, AtletaDto.class)
        ).switchIfEmpty(notFound)
                .switchIfEmpty(Mono.error(new Exception()));
    }
}
