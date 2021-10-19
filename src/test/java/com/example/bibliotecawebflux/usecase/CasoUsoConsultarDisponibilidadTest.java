package com.example.bibliotecawebflux.usecase;

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

import static org.mockito.Mockito.when;


@SpringBootTest
class CasoUsoConsultarDisponibilidadTest {

    @MockBean
    private RepositorioRecurso repositorioRecurso;
    @SpyBean
    private CasoUsoConsultarDisponibilidad casoUsoConsultarDisponibilidad;

    @Test
    public void consultarDisponibilidad() {
        var rescursoDTO = new RecursoDTO("1","18/10/2021", true, "GOT", "1A","1L");
        var recurso = new Recurso();
        recurso.setId("1");
        recurso.setFecha("18/10/2021");
        recurso.setDisponible(true);
        recurso.setNombreRecurso("Harry Potter");
        recurso.setCategoriaId("1A");
        recurso.setTipoRecursoId("1L");

        when(repositorioRecurso.findById("1")).thenReturn(Mono.just(recurso));


        var result = casoUsoConsultarDisponibilidad.apply(rescursoDTO.getId());
        Assertions.assertEquals(result.block().isDisponible(),true);

    }


}