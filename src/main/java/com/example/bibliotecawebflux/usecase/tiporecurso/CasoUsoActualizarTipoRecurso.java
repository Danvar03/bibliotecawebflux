package com.example.bibliotecawebflux.usecase.tiporecurso;

import com.example.bibliotecawebflux.dto.TipoRecursoDTO;
import com.example.bibliotecawebflux.mapper.TipoRecursoMapper;
import com.example.bibliotecawebflux.repositories.RepositorioTipoRecurso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class CasoUsoActualizarTipoRecurso {

    private final RepositorioTipoRecurso repositorioTipoRecurso;
    private final TipoRecursoMapper tipoRecursoMapper;

    @Autowired
    public CasoUsoActualizarTipoRecurso(RepositorioTipoRecurso repositorioTipoRecurso, TipoRecursoMapper tipoRecursoMapper) {
        this.repositorioTipoRecurso = repositorioTipoRecurso;
        this.tipoRecursoMapper = tipoRecursoMapper;
    }


    public Mono<TipoRecursoDTO> apply(TipoRecursoDTO tipoRecursoDTO){
        return repositorioTipoRecurso.save(tipoRecursoMapper.dtoToTipoRecurso(tipoRecursoDTO.getTipoRecursoId()).apply(tipoRecursoDTO))
                .map(tipoRecursoMapper.TipoRecursoToDTO());
    }


}
