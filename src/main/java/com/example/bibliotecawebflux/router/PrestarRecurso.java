package com.example.bibliotecawebflux.router;

import com.example.bibliotecawebflux.dto.RecursoDTO;
import com.example.bibliotecawebflux.dto.RespuestaRecursoDTO;
import com.example.bibliotecawebflux.usecase.CasoUsoPrestarRecurso;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.PUT;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class PrestarRecurso {

    @Bean
    public RouterFunction<ServerResponse> prestarRecursos(CasoUsoPrestarRecurso casoUsoPrestarRecurso){
        return route(PUT("/prestar/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                    .body(casoUsoPrestarRecurso.prestarRecurso(request.pathVariable("id")), RespuestaRecursoDTO.class)
                );
    }
}
