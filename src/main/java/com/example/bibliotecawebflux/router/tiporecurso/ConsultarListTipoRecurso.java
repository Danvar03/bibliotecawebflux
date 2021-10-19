package com.example.bibliotecawebflux.router.tiporecurso;

import com.example.bibliotecawebflux.dto.TipoRecursoDTO;
import com.example.bibliotecawebflux.usecase.tiporecurso.CasoUsoConsultarListTipoRecurso;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class ConsultarListTipoRecurso {

    @Bean
    public RouterFunction<ServerResponse> consultarListTipoRecursos(CasoUsoConsultarListTipoRecurso casoUsoConsultarListTipoRecurso) {
        return route(GET("/consultartipo").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(casoUsoConsultarListTipoRecurso.get(), TipoRecursoDTO.class))
        );
    }
}
