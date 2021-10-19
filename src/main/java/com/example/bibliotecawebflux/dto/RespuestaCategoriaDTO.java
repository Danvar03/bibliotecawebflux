package com.example.bibliotecawebflux.dto;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class RespuestaCategoriaDTO {

    private Mono<String> nombreCategoria;
    private Flux<RecursoDTO> listRecursos;

    public Mono<String> getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(Mono<String> nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public Flux<RecursoDTO> getListRecursos() {
        return listRecursos;
    }

    public void setListRecursos(Flux<RecursoDTO> listRecursos) {
        this.listRecursos = listRecursos;
    }
}
