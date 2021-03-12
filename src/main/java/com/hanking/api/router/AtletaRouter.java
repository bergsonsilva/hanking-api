package com.hanking.api.router;

import com.hanking.api.handler.AtletaHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Component
public class AtletaRouter {

    @Bean
    public RouterFunction<ServerResponse> routeAtleta(AtletaHandler handler) {
        return RouterFunctions
                .route(POST("/atleta").and(accept(MediaType.APPLICATION_JSON)), handler::save)
                .andRoute(GET("/atleta").and(accept(MediaType.APPLICATION_JSON)),handler::findAll)
                .andRoute(GET("/atleta/{id}").and(accept(MediaType.APPLICATION_JSON)),handler::findById)
                .andRoute(GET("/atleta/{nome}").and(accept(MediaType.APPLICATION_JSON)),handler::findByNome);


    }
}
