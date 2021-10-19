package com.example.bibliotecawebflux.router.categoria;

import com.example.bibliotecawebflux.dto.CategoriaDTO;
import com.example.bibliotecawebflux.usecase.categoria.CasoUsoActualizarCategoria;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.PUT;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class ActualizarCategoria{

    @Bean
    public RouterFunction<ServerResponse> actualizarCategoriaId(CasoUsoActualizarCategoria casoUsoActualizarCategoria){
        return route(PUT("/actualizar/categoria").and(accept(MediaType.APPLICATION_JSON)),
                request ->request.bodyToMono(CategoriaDTO.class)
                        .flatMap(categoriaDTO -> casoUsoActualizarCategoria.actualizarCategoria(categoriaDTO)
                                .flatMap(result->ServerResponse.ok()
                                        .contentType(MediaType.APPLICATION_JSON)
                                        .bodyValue(result)))
        );
    }
}
