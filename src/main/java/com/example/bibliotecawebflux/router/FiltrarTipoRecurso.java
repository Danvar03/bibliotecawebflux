package com.example.bibliotecawebflux.router;

import com.example.bibliotecawebflux.dto.RespuestaTipoRecursoDTO;
import com.example.bibliotecawebflux.usecase.CasoUsoFiltrarTipoRecurso;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class FiltrarTipoRecurso {

    @Bean
    public RouterFunction<ServerResponse> filtrarTipos(CasoUsoFiltrarTipoRecurso casoUsoFiltrarTipoRecurso) {
        return route(GET("/filtrartipo/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request ->  ServerResponse.ok()
                        .body(casoUsoFiltrarTipoRecurso.filtrarTipo(request.pathVariable("id")), RespuestaTipoRecursoDTO.class));

    }
}
