package com.example.bibliotecawebflux.usecase.recurso;

import com.example.bibliotecawebflux.dto.RecursoDTO;
import com.example.bibliotecawebflux.mapper.RecursoMapper;
import com.example.bibliotecawebflux.repositories.RepositorioRecurso;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class CasoUsoEliminar {
    private final RepositorioRecurso repositorioRecurso;
    private final RecursoMapper recursoMapper;

    public CasoUsoEliminar(RecursoMapper recursoMapper, RepositorioRecurso repositorioRecurso) {
        this.repositorioRecurso = repositorioRecurso;
        this.recursoMapper = recursoMapper;
    }

    public Mono<Void> deleteById(String id) {
        return repositorioRecurso.deleteById(id);
    }
}

