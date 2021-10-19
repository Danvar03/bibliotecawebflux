package com.example.bibliotecawebflux.router.tiporecurso;

import com.example.bibliotecawebflux.dto.TipoRecursoDTO;
import com.example.bibliotecawebflux.usecase.tiporecurso.CasoUsoEliminarTipoRecurso;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.DELETE;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration
public class EliminarTipoRecurso {

    @Bean
    public RouterFunction<ServerResponse> eliminarTipoRecursos(CasoUsoEliminarTipoRecurso casoUsoEliminarTipoRecurso) {
        return RouterFunctions.route(DELETE("/eliminartiporecurso/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(casoUsoEliminarTipoRecurso.deleteByIdTipoRecurso(request.pathVariable("id")), TipoRecursoDTO.class));
    }
}
