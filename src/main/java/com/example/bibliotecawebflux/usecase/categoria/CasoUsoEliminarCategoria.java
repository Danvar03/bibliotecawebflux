package com.example.bibliotecawebflux.usecase.categoria;

import com.example.bibliotecawebflux.mapper.CategoriaMapper;
import com.example.bibliotecawebflux.repositories.RepositorioCategoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class CasoUsoEliminarCategoria {

    private final RepositorioCategoria repositorioCategoria;
    private final CategoriaMapper categoriaMapper;

    @Autowired
    public CasoUsoEliminarCategoria(RepositorioCategoria repositorioCategoria, CategoriaMapper categoriaMapper) {
        this.repositorioCategoria = repositorioCategoria;
        this.categoriaMapper = categoriaMapper;
    }

    public Mono<Void> deleteByIdCategoria(String id) {
        return repositorioCategoria.deleteById(id);
    }
}
