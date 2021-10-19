package com.example.mapper;

import com.example.bibliotecawebflux.dto.RecursoDTO;
import com.example.bibliotecawebflux.dto.RespuestaCategoriaDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.function.Function;

public class RespuestaCategoriaMapper {

    public Function<Flux<RecursoDTO>, RespuestaCategoriaDTO> recursoToRespuesta(Mono<String> nombre) {
        return recursoDTOFlux -> {
            RespuestaCategoriaDTO respuestaCategoriaDTO = new RespuestaCategoriaDTO();
            respuestaCategoriaDTO.setNombreCategoria(nombre);
            respuestaCategoriaDTO.setListRecursos(recursoDTOFlux);
            return respuestaCategoriaDTO;
        };
    }
}
