package com.example.bibliotecawebflux.usecase;

import com.example.bibliotecawebflux.dto.RespuestaRecursoDTO;
import com.example.bibliotecawebflux.mapper.RecursoMapper;
import com.example.bibliotecawebflux.mapper.RespuestaRecursoMapper;
import com.example.bibliotecawebflux.repositories.RepositorioRecurso;
//import com.mongodb.Function;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;
import java.util.function.Function;

@Service
@Validated
public class CasoUsoConsultarDisponibilidad implements Function<String,Mono<RespuestaRecursoDTO>> {

    private final RepositorioRecurso repositorioRecurso;
    private RecursoMapper recursoMapper = new RecursoMapper();
    private RespuestaRecursoMapper respuestaRecursoMapper = new RespuestaRecursoMapper();

    @Autowired
    public CasoUsoConsultarDisponibilidad(RepositorioRecurso repositorioRecurso) {
        this.repositorioRecurso = repositorioRecurso;
    }

    @Override
    public Mono<RespuestaRecursoDTO> apply(String id) {
        var recurso = repositorioRecurso.findById(id).map(recursoMapper.RecursoToDTO());
        return recurso.map(respuestaRecursoMapper.consultarRecurso());
    }

}
