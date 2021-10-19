package com.example.bibliotecawebflux.repositories;

import com.example.bibliotecawebflux.model.Recurso;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface RepositorioRecurso extends ReactiveMongoRepository<Recurso,String> {

    Flux<Recurso> findRecursoBycategoriaId(String id);
    Flux<Recurso> findRecursoBytipoRecursoId(String id);
}
