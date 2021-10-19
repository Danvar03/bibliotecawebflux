package com.example.bibliotecawebflux.usecase.recurso;

import com.example.bibliotecawebflux.dto.RecursoDTO;
import com.example.bibliotecawebflux.mapper.RecursoMapper;
import com.example.bibliotecawebflux.repositories.RepositorioRecurso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class CasoUsoConsultar {

    private final RepositorioRecurso repositorioRecurso;
    private final RecursoMapper recursoMapper;

    @Autowired
    public CasoUsoConsultar(RepositorioRecurso repositorioRecurso, RecursoMapper recursoMapper) {
        this.repositorioRecurso = repositorioRecurso;
        this.recursoMapper = recursoMapper;
    }


    public Mono<RecursoDTO> findById(String id) {
        return repositorioRecurso.findById(id).map(recursoMapper.RecursoToDTO());
    }
}
