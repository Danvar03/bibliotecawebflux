package com.example.bibliotecawebflux.router;


import com.example.bibliotecawebflux.dto.TipoRecursoDTO;
import com.example.bibliotecawebflux.mapper.TipoRecursoMapper;
import com.example.bibliotecawebflux.model.TipoRecurso;
import com.example.bibliotecawebflux.repositories.RepositorioTipoRecurso;
import com.example.bibliotecawebflux.usecase.tiporecurso.CasoUsoCrearTipoRecurso;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@WebFluxTest
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {CrearTipoRecursoTest.class, CasoUsoCrearTipoRecurso.class, TipoRecursoMapper.class})
class CrearTipoRecursoTest {

    @MockBean
    private RepositorioTipoRecurso repositorioTipoRecurso;

    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void crearTipo() {

        TipoRecurso tipoRecurso = new TipoRecurso();
        tipoRecurso.setTipoRecursoId("20");
        tipoRecurso.setNombreTipoRecurso("Novela");


        TipoRecursoDTO tipoRecursoDTO = new TipoRecursoDTO(tipoRecurso.getTipoRecursoId(), tipoRecurso.getNombreTipoRecurso());
        Mono<TipoRecurso> mono = Mono.just(tipoRecurso);
        when(repositorioTipoRecurso.save(any())).thenReturn(mono);
        webTestClient.post()
                .uri("/creartiporecurso")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(tipoRecursoDTO), TipoRecursoDTO.class)
                .exchange();
    }
}

