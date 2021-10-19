package com.example.bibliotecawebflux.usecase.categoria;

import com.example.bibliotecawebflux.dto.CategoriaDTO;
import com.example.bibliotecawebflux.mapper.CategoriaMapper;
import com.example.bibliotecawebflux.model.Categoria;
import com.example.bibliotecawebflux.repositories.RepositorioCategoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class CasoUsoCrearCategoria {
    private final RepositorioCategoria repositorioCategoria;
    private final CategoriaMapper categoriaMapper;

    @Autowired
    public CasoUsoCrearCategoria(RepositorioCategoria repositorioCategoria, CategoriaMapper categoriaMapper) {
        this.repositorioCategoria = repositorioCategoria;
        this.categoriaMapper = categoriaMapper;
    }

    public Mono<String> crearCategoria(CategoriaDTO categoriaDTO) {
        return repositorioCategoria.save(categoriaMapper.dtoToCategoria(null).apply(categoriaDTO)).map(Categoria::getCategoriaId);
    }
}
