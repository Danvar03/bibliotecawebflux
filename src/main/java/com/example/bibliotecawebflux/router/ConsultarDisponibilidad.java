package com.example.bibliotecawebflux.router;

import com.example.bibliotecawebflux.dto.RespuestaRecursoDTO;
import com.example.bibliotecawebflux.usecase.CasoUsoConsultarDisponibilidad;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class ConsultarDisponibilidad{

    @Bean
    public RouterFunction<ServerResponse> disponibilidadRecursos(CasoUsoConsultarDisponibilidad casoUsoConsultarDisponibilidad) {
        return route(GET("/disponibilidad/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse.ok()
                        .body(casoUsoConsultarDisponibilidad.apply(request.pathVariable("id")), RespuestaRecursoDTO.class));
    }
}
