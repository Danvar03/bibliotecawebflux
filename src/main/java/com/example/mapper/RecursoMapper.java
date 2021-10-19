package com.example.mapper;

import com.example.bibliotecawebflux.dto.RecursoDTO;
import com.example.bibliotecawebflux.model.Recurso;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class RecursoMapper {

    public Function<RecursoDTO, Recurso> dtoToRecurso(String id) {
        return updateDato -> {
            var recurso = new Recurso();
            recurso.setId(id);
            recurso.setNombreRecurso(updateDato.getNombreRecurso());
            recurso.setDisponible(updateDato.getDisponible());
            recurso.setTipoRecursoId(updateDato.getTipoRecursoId());
            recurso.setCategoriaId(updateDato.getCategoriaId());
            recurso.setFecha(updateDato.getFecha());
            return recurso;
        };
    }

    public Function<Recurso, RecursoDTO> RecursoToDTO() {
        return recurso -> {
            var recursoDTO = new RecursoDTO();
            recursoDTO.setId(recurso.getId());
            recursoDTO.setFecha(recurso.getFecha());
            recursoDTO.setDisponible(recurso.getDisponible());
            recursoDTO.setNombreRecurso(recurso.getNombreRecurso());
            recursoDTO.setTipoRecursoId(recurso.getTipoRecursoId());
            recursoDTO.setCategoriaId(recurso.getCategoriaId());
            return recursoDTO;
        };
    }
}
