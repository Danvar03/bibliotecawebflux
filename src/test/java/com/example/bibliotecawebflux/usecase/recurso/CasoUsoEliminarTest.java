package com.example.bibliotecawebflux.usecase.recurso;

import com.example.bibliotecawebflux.dto.RecursoDTO;
import com.example.bibliotecawebflux.repositories.RepositorioRecurso;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import reactor.core.publisher.Mono;

@SpringBootTest
class CasoUsoEliminarTest {

@MockBean
    private RepositorioRecurso repositorioRecurso;
@SpyBean
    private CasoUsoEliminar casoUsoEliminar;

@Test
    private void eliminarRecurso(){
    var recursoDTO = new RecursoDTO("1","18/10/2021", true, "GOT", "1A","1L");

    Mockito.when(repositorioRecurso.deleteById("1")).thenReturn(Mono.empty());

    var result = casoUsoEliminar.deleteById("1").block();
    Assertions.assertEquals(result,null);
}
}