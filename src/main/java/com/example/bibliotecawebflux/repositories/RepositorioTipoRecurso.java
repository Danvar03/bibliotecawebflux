package com.example.bibliotecawebflux.repositories;

import com.example.bibliotecawebflux.model.TipoRecurso;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface RepositorioTipoRecurso extends ReactiveMongoRepository<TipoRecurso, String> {
}
