package com.example.bibliotecawebflux.usecase.categoria;

import com.example.bibliotecawebflux.dto.CategoriaDTO;
import com.example.bibliotecawebflux.mapper.CategoriaMapper;
import com.example.bibliotecawebflux.repositories.RepositorioCategoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Flux;

import java.util.function.Supplier;

@Service
@Validated
public class CasoUsoConsultarListCategoria implements Supplier<Flux<CategoriaDTO>> {

    private final RepositorioCategoria repositorioCategoria;
    private final CategoriaMapper categoriaMapper;

    @Autowired
    public CasoUsoConsultarListCategoria(RepositorioCategoria repositorioCategoria, CategoriaMapper categoriaMapper) {
        this.repositorioCategoria = repositorioCategoria;
        this.categoriaMapper = categoriaMapper;
    }

    @Override
    public Flux<CategoriaDTO> get() {return repositorioCategoria.findAll().map(categoriaMapper.CategoriaToDTO());}

}
