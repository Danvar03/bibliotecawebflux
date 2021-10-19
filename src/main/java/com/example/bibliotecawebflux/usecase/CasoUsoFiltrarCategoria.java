package com.example.bibliotecawebflux.usecase;

import com.example.bibliotecawebflux.dto.RecursoDTO;
import com.example.bibliotecawebflux.mapper.RecursoMapper;
import com.example.bibliotecawebflux.repositories.RepositorioRecurso;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Validated
public class CasoUsoFiltrarCategoria {

    private final RepositorioRecurso repositorioRecurso;
    private final RecursoMapper recursoMapper;

    public CasoUsoFiltrarCategoria(RepositorioRecurso repositorioRecurso, RecursoMapper recursoMapper) {
        this.repositorioRecurso = repositorioRecurso;
        this.recursoMapper = recursoMapper;
    }

    public Flux<RecursoDTO> filtrarCategoria(String id) {
        return repositorioRecurso.findRecursoBycategoriaId(id).map(recursoMapper.RecursoToDTO());
    }
}
