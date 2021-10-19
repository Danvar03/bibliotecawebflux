package com.example.bibliotecawebflux.repositories;

import com.example.bibliotecawebflux.model.Recurso;
import com.example.bibliotecawebflux.model.TipoRecurso;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface RepositorioTipoRecurso extends ReactiveMongoRepository<TipoRecurso, String> {
    Flux<Recurso> findRecursoBycategoriaId(String id);
    Flux<Recurso> findRecursoBytipoRecursoId(String id);

}
