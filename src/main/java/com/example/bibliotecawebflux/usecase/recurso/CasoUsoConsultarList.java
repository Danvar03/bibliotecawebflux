package com.example.bibliotecawebflux.usecase.recurso;

import com.example.bibliotecawebflux.dto.RecursoDTO;
import com.example.bibliotecawebflux.mapper.RecursoMapper;
import com.example.bibliotecawebflux.repositories.RepositorioRecurso;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Flux;
import java.util.function.Supplier;

@Service
@Validated
public class CasoUsoConsultarList implements Supplier<Flux<RecursoDTO>> {
        private final RepositorioRecurso repositorioRecurso;
        private final RecursoMapper recursoMapper;

        public CasoUsoConsultarList(RecursoMapper recursoMapper, RepositorioRecurso repositorioRecurso) {
            this.repositorioRecurso = repositorioRecurso;
            this.recursoMapper = recursoMapper;
        }
        @Override
        public Flux<RecursoDTO> get() {
            return repositorioRecurso.findAll().map(recursoMapper.RecursoToDTO());
        }
}

