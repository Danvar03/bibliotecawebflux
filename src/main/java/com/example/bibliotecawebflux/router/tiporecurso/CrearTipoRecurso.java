package com.example.bibliotecawebflux.router.tiporecurso;

import com.example.bibliotecawebflux.dto.TipoRecursoDTO;
import com.example.bibliotecawebflux.usecase.categoria.CasoUsoCrearCategoria;
import com.example.bibliotecawebflux.usecase.tiporecurso.CasoUsoCrearTipoRecurso;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class CrearTipoRecurso {

    @Bean
    public RouterFunction<ServerResponse> crearTipoRecursos(CasoUsoCrearTipoRecurso casoUsoCrearTipoRecurso) {
        return route(POST("/creartiporecurso").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(TipoRecursoDTO.class)
                .flatMap(questionDTO -> casoUsoCrearTipoRecurso.apply(questionDTO)
                .flatMap(result -> ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(result)))
                );
    }
}
