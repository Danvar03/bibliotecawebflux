package com.example.bibliotecawebflux.usecase.recurso;

import com.example.bibliotecawebflux.dto.RecursoDTO;
import com.example.bibliotecawebflux.model.Recurso;
import com.example.bibliotecawebflux.repositories.RepositorioRecurso;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class CasoUsoCrearTest {

    @SpyBean
    private CasoUsoCrear casoUsoCrear;

    @MockBean
    private RepositorioRecurso repositorioRecurso;

    @Test
    public void crearRecurso() {

        var recursoDTO = new    RecursoDTO("1","18/10/2021", true, "GOT", "1A","1L");
        var recurso = new Recurso();

        recurso.setId("1");
        recurso.setFecha("18/10/2021");
        recurso.setDisponible(true);
        recurso.setNombreRecurso("GOT");
        recurso.setCategoriaId("1A");
        recurso.setTipoRecursoId("1L");

        when(repositorioRecurso.save(Mockito.any(Recurso.class))).thenReturn(Mono.just(recurso));

        var result = casoUsoCrear.apply(recursoDTO);
        Assertions.assertEquals(result.block(), "1");
    }


}