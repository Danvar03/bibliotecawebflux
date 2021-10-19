package com.example.bibliotecawebflux.dto;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class RespuestaTipoRecursoDTO {

    private Mono<String> nombreTipoRecurso;
    private Flux<RecursoDTO> listTipoRecurso;

    public Mono<String> getNombreTipoRecurso() {
        return nombreTipoRecurso;
    }

    public void setNombreTipoRecurso(Mono<String> nombreTipoRecurso) {
        this.nombreTipoRecurso = nombreTipoRecurso;
    }

    public Flux<RecursoDTO> getListTipoRecurso() {
        return listTipoRecurso;
    }

    public void setListTipoRecurso(Flux<RecursoDTO> listTipoRecurso) {
        this.listTipoRecurso = listTipoRecurso;
    }
}
