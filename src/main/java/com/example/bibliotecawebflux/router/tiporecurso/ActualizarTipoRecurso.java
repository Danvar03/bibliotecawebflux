package com.example.bibliotecawebflux.router.tiporecurso;

import com.example.bibliotecawebflux.dto.TipoRecursoDTO;
import com.example.bibliotecawebflux.usecase.tiporecurso.CasoUsoActualizarTipoRecurso;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.PUT;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration
public class ActualizarTipoRecurso{

    @Bean
    public RouterFunction<ServerResponse> actualizarTipoRecursos(CasoUsoActualizarTipoRecurso casoUsoActualizarTipoRecurso) {
        return route(PUT("/actualizar/tiporecurso").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(TipoRecursoDTO.class)
                .flatMap(tipoRecursoDTO -> casoUsoActualizarTipoRecurso.apply(tipoRecursoDTO)
                .flatMap(result -> ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(result)))
                );
    }
}
