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
public class CasoUsoActualizar {
    private final RepositorioRecurso repositorioRecurso;
    private final RecursoMapper recursoMapper;

    @Autowired
    public CasoUsoActualizar(RepositorioRecurso repositorioRecurso, RecursoMapper recursoMapper) {
        this.repositorioRecurso = repositorioRecurso;
        this.recursoMapper = recursoMapper;
    }

    public Mono<RecursoDTO> apply(RecursoDTO recursoDTO) {
        return repositorioRecurso.save(recursoMapper.dtoToRecurso(recursoDTO.getId()).apply(recursoDTO))
                .map(recursoMapper.RecursoToDTO());
    }
}
