package com.example.bibliotecawebflux.repositories;

import com.example.bibliotecawebflux.model.Categoria;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface RepositorioCategoria extends ReactiveMongoRepository<Categoria, String> {
}
