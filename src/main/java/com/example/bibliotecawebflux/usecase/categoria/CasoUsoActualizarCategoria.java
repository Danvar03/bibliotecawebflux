package com.example.bibliotecawebflux.usecase.categoria;

import com.example.bibliotecawebflux.dto.CategoriaDTO;
import com.example.bibliotecawebflux.mapper.CategoriaMapper;
import com.example.bibliotecawebflux.repositories.RepositorioCategoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class CasoUsoActualizarCategoria {
    private final RepositorioCategoria repositorioCategoria;
    private final CategoriaMapper categoriaMapper;

    @Autowired
    public CasoUsoActualizarCategoria(RepositorioCategoria repositorioCategoria, CategoriaMapper categoriaMapper) {
        this.repositorioCategoria = repositorioCategoria;
        this.categoriaMapper = categoriaMapper;
    }

    public Mono<CategoriaDTO> actualizarCategoria(CategoriaDTO categoriaDTO) {
        return repositorioCategoria.save(categoriaMapper.dtoToCategoria(categoriaDTO.getCategoriaId()).apply(categoriaDTO))
                .map(categoriaMapper.CategoriaToDTO());
    }

}
