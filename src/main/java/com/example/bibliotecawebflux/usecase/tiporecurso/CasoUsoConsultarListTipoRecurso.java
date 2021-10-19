package com.example.bibliotecawebflux.usecase.tiporecurso;

import com.example.bibliotecawebflux.dto.TipoRecursoDTO;
import com.example.bibliotecawebflux.mapper.TipoRecursoMapper;
import com.example.bibliotecawebflux.repositories.RepositorioTipoRecurso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Flux;

import java.util.function.Supplier;

@Service
@Validated
public class CasoUsoConsultarListTipoRecurso implements Supplier<Flux<TipoRecursoDTO>>{

    private final RepositorioTipoRecurso repositorioTipoRecurso;
    private final TipoRecursoMapper tipoRecursoMapper;


    public CasoUsoConsultarListTipoRecurso(RepositorioTipoRecurso repositorioTipoRecurso, TipoRecursoMapper tipoRecursoMapper) {
        this.repositorioTipoRecurso = repositorioTipoRecurso;
        this.tipoRecursoMapper = tipoRecursoMapper;
    }

    @Override
    public Flux<TipoRecursoDTO> get() {
        return repositorioTipoRecurso.findAll().map(tipoRecursoMapper.TipoRecursoToDTO());
    }

}
