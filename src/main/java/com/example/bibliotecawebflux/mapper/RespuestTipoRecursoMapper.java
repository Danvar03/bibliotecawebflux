package com.example.bibliotecawebflux.mapper;

import com.example.bibliotecawebflux.dto.RecursoDTO;
import com.example.bibliotecawebflux.dto.RespuestaTipoRecursoDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.function.Function;

public class RespuestTipoRecursoMapper {

    public Function<Flux<RecursoDTO>, RespuestaTipoRecursoDTO> recursoToRespuestaTipo(Mono<String> nombre) {
        return recursoTipoFlux -> {
          RespuestaTipoRecursoDTO respuestaTipoRecursoDTO = new RespuestaTipoRecursoDTO();
          respuestaTipoRecursoDTO.setNombreTipoRecurso(nombre);
          respuestaTipoRecursoDTO.setListTipoRecurso(recursoTipoFlux);
          return respuestaTipoRecursoDTO;
        };
    }
}
