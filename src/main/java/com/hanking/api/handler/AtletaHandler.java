package com.hanking.api.handler;

import com.hanking.api.model.dto.AtletaDto;
import com.hanking.api.service.AtletaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component
public class AtletaHandler {

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
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(atletaService.findById(id), AtletaDto.class);
    }

    public Mono<ServerResponse> findByNome(ServerRequest request){
        String nome = request.pathVariable("nome");
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(atletaService.findByNome(nome), AtletaDto.class);
    }
}
