package com.example.bibliotecawebflux.usecase;

import com.example.bibliotecawebflux.dto.RecursoDTO;
import com.example.bibliotecawebflux.dto.RespuestaRecursoDTO;
import com.example.bibliotecawebflux.mapper.RecursoMapper;
import com.example.bibliotecawebflux.mapper.RespuestaRecursoMapper;
import com.example.bibliotecawebflux.model.Recurso;
import com.example.bibliotecawebflux.repositories.RepositorioRecurso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@Validated
public class CasoUsoPrestarRecurso {

    private Date objDate = new Date();
    private String strDateFormat = "hh: mm: ss a dd-MMM-aaaa";
    private SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat);

    private final RepositorioRecurso repositorioRecurso;
    private RecursoMapper recursoMapper = new RecursoMapper();
    private RespuestaRecursoMapper respuestaRecursoMapper = new RespuestaRecursoMapper();

    @Autowired
    public CasoUsoPrestarRecurso(RepositorioRecurso repositorioRecurso, RecursoMapper recursoMapper) {
        this.repositorioRecurso = repositorioRecurso;

    }

    public Mono<RespuestaRecursoDTO> prestarRecurso(String id) {
        var consulta = repositorioRecurso.findById(id);
        var prestamo = consulta.flatMap(recurso -> {
            if(recurso.getDisponible()){
                recurso.setDisponible(false);
                recurso.setFecha(objSDF.format(objDate));
                repositorioRecurso.save(recurso);

            }
            return repositorioRecurso.save(recurso);
        });

        var respuestaDTO = prestamo.map(recursoMapper.RecursoToDTO()).map(respuestaRecursoMapper.prestarRecurso());
        var respuesta = consulta.map(recursoMapper.RecursoToDTO()).map(respuestaRecursoMapper.prestarRecurso()).map(
                recurso -> {
                    if(recurso.isDisponible()){
                        recurso.setDisponible(false);
                        recurso.setDescripcion("El recurso fue prestado con exito!");
                        recurso.setFecha(objSDF.format(objDate));
                        return recurso;
                    } else {
                        recurso.setDescripcion("El recurso NO esta disponible");
                    }
                    return recurso;
                });
return respuesta;
    }

}
