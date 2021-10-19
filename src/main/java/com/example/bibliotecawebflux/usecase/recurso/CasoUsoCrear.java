package com.example.bibliotecawebflux.usecase.recurso;

import com.example.bibliotecawebflux.dto.RecursoDTO;
import com.example.bibliotecawebflux.mapper.RecursoMapper;
import com.example.bibliotecawebflux.model.Recurso;
import com.example.bibliotecawebflux.repositories.RepositorioRecurso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class CasoUsoCrear implements GuardarRecurso {
    private final RepositorioRecurso repositorioRecurso;
    private final RecursoMapper mapperRecurso;

    @Autowired
    public CasoUsoCrear(RecursoMapper mapperRecurso, RepositorioRecurso repositorioRecurso) {
        this.repositorioRecurso = repositorioRecurso;
        this.mapperRecurso = mapperRecurso;
    }

    @Override
    public Mono<String> apply(RecursoDTO recursoDTO) {
        return repositorioRecurso.save(mapperRecurso.dtoToRecurso(null).apply(recursoDTO)).map(Recurso::getId);
    }

}
