package com.hanking.api.atleta;

import io.swagger.v3.oas.annotations.enums.ParameterIn;
import org.springdoc.core.fn.builders.operation.Builder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import java.util.function.Consumer;

import static org.springdoc.core.fn.builders.apiresponse.Builder.responseBuilder;
import static org.springdoc.core.fn.builders.parameter.Builder.parameterBuilder;
import static org.springdoc.webflux.core.fn.SpringdocRouteBuilder.route;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;


@Configuration
public class RouterConfig {

    @Bean
    RouterFunction<ServerResponse> routerFunction(Handler handler) {
        return route().GET("/atleta", handler::findAll, findAll()).build()
                .and(route().GET("/atleta/{id}", handler::findById, findById()).build())
                .and(route().GET("/atleta/nome/{nome}", handler::findByNome, findByNome()).build())
                .and(route().POST("/atleta/save", accept(MediaType.APPLICATION_JSON),
                        handler::save, getOpenAPI("save")).build());
    }

    private Consumer<Builder> findById() {
        return ops -> ops.tag("Atleta")
                .operationId("findById").summary("Find purchase order by ID").tags(new String[]{"Atleta"})
                .parameter(parameterBuilder().in(ParameterIn.PATH).name("id").description("Atleta Id"))
                .response(responseBuilder().responseCode("200").description("successful operation").implementation(AtletaDto.class))
                .response(responseBuilder().responseCode("400").description("Invalid Employee ID supplied"))
                .response(responseBuilder().responseCode("404").description("Atleta not found"));
    }

    private Consumer<Builder> findByNome() {
        return ops -> ops.tag("Atleta")
                .operationId("findByNome").summary("Find purchase order by ID").tags(new String[]{"Atleta"})
                .parameter(parameterBuilder().in(ParameterIn.PATH).name("nome").description("Atleta Nome"))
                .response(responseBuilder().responseCode("200").description("successful operation").implementation(AtletaDto.class))
                .response(responseBuilder().responseCode("400").description("Invalid Atleta nome supplied"))
                .response(responseBuilder().responseCode("404").description("Atleta not found"));
    }

    private Consumer<Builder> findAll() {
        return ops -> ops.tag("Atleta")
                .operationId("findAll").summary("Find All").tags(new String[]{"Atleta"})
                .response(responseBuilder().responseCode("200").description("successful operation").implementation(AtletaDto.class));
    }

    private Consumer<Builder> getOpenAPI(String save) {
        return ops -> ops.tag("Atleta").summary("Cadastrar um novo atleta").tags(new String[]{"Atleta"})
                .operationId("save")
                .beanClass(AtletaRepository.class).beanMethod(save)
                .response(responseBuilder().responseCode("201").description("Atleta criado com sucesso."));
    }
}
