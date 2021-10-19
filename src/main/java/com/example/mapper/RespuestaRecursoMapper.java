package com.example.mapper;

import com.example.bibliotecawebflux.dto.RecursoDTO;
import com.example.bibliotecawebflux.dto.RespuestaRecursoDTO;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.function.Function;

@Component
public class RespuestaRecursoMapper {
    private Date objDate = new Date();
    private String strDateFormat = "hh: mm: ss a dd-MMM-aaaa";
    private SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat);

    public Function<RecursoDTO, RespuestaRecursoDTO> consultarRecurso() {
     return recurso -> {
         RespuestaRecursoDTO respuestaRecursoDTO = new RespuestaRecursoDTO();
         String descripcion = recurso.getDisponible() ? "El recurso esta disponible" : "El Libro no esta disponible";
         respuestaRecursoDTO.setDescripcion(descripcion);
         respuestaRecursoDTO.setDisponible(recurso.getDisponible());
         respuestaRecursoDTO.setFecha(recurso.getFecha());
         return respuestaRecursoDTO;
     };
    }

    public Function<RecursoDTO,RespuestaRecursoDTO> prestarRecurso() {
        return recurso -> {
          RespuestaRecursoDTO respuestaRecursoDTO = new RespuestaRecursoDTO();
          String descripcion = "";
          respuestaRecursoDTO.setDescripcion(descripcion);
          respuestaRecursoDTO.setDisponible(recurso.getDisponible());
          respuestaRecursoDTO.setFecha(recurso.getFecha());
          return respuestaRecursoDTO;
        };

    }
}
