package com.example.bibliotecawebflux.usecase;

import com.example.bibliotecawebflux.dto.RecursoDTO;
import com.example.bibliotecawebflux.mapper.RecursoMapper;
import com.example.bibliotecawebflux.repositories.RepositorioRecurso;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Flux;

@Service
@Validated
public class CasoUsoFiltrarTipoRecurso {

    private final RepositorioRecurso repositorioRecurso;
    private final RecursoMapper recursoMapper;

    public CasoUsoFiltrarTipoRecurso(RepositorioRecurso repositorioRecurso, RecursoMapper recursoMapper) {
        this.repositorioRecurso = repositorioRecurso;
        this.recursoMapper = recursoMapper;
    }

    public Flux<RecursoDTO> filtrarTipo(String id){
        return repositorioRecurso.findRecursoBytipoRecursoId(id).map(recursoMapper.RecursoToDTO());
    }
}
