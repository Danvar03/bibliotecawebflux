package com.example.bibliotecawebflux.usecase.tiporecurso;

import com.example.bibliotecawebflux.mapper.TipoRecursoMapper;
import com.example.bibliotecawebflux.repositories.RepositorioTipoRecurso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class CasoUsoEliminarTipoRecurso {

    private final RepositorioTipoRecurso repositorioTipoRecurso;
    private final TipoRecursoMapper tipoRecursoMapper;

    @Autowired
    public CasoUsoEliminarTipoRecurso(RepositorioTipoRecurso repositorioTipoRecurso, TipoRecursoMapper tipoRecursoMapper) {
        this.repositorioTipoRecurso = repositorioTipoRecurso;
        this.tipoRecursoMapper = tipoRecursoMapper;
    }

    public Mono<Void> deleteByIdTipoRecurso(String id) {
        return repositorioTipoRecurso.deleteById(id);
    }
}
