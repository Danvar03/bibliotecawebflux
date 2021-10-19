package com.example.bibliotecawebflux.router.categoria;

import com.example.bibliotecawebflux.dto.CategoriaDTO;
import com.example.bibliotecawebflux.usecase.categoria.CasoUsoEliminarCategoria;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.DELETE;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration
public class EliminarCategoria {
    @Bean
    public RouterFunction<ServerResponse> eliminarCategorias(CasoUsoEliminarCategoria casoUsoEliminarCategoria) {
        return RouterFunctions.route(DELETE("/eliminarcategoria/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request ->
                        ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(casoUsoEliminarCategoria.deleteByIdCategoria(request.pathVariable("id")), CategoriaDTO.class));
    }
}
