package com.example.bibliotecawebflux.router.categoria;

import com.example.bibliotecawebflux.dto.CategoriaDTO;
import com.example.bibliotecawebflux.usecase.categoria.CasoUsoCrearCategoria;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class CrearCategoria {
    @Bean
    public RouterFunction<ServerResponse> createCategoria(CasoUsoCrearCategoria casoUsoCrearCategoria) {
        return route(POST("/crearcategoria").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(CategoriaDTO.class)
                        .flatMap(questionDTO -> casoUsoCrearCategoria.crearCategoria(questionDTO)
                                .flatMap(result -> ServerResponse.ok()
                                        .contentType(MediaType.TEXT_PLAIN)
                                        .bodyValue(result))
                        )
        );
    }
}
