package com.example.bibliotecawebflux.router;

import com.example.bibliotecawebflux.dto.RecursoDTO;
import com.example.bibliotecawebflux.dto.RespuestaRecursoDTO;
import com.example.bibliotecawebflux.usecase.CasoUsoConsultarDisponibilidad;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;


@WebFluxTest
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {ConsultarDisponibilidad.class})
class ConsultarDisponibilidadTest {

    @MockBean
    private CasoUsoConsultarDisponibilidad casoUsoConsultarDisponibilidad;
    @Autowired
    private WebTestClient webTestClient;

    @Test
    private void consultar(){
        var rescursoDTO = new RecursoDTO("1","18/10/2021", true, "GOT", "1A","1L");
       var repuestaRecursoDTO = new RespuestaRecursoDTO();
       repuestaRecursoDTO.setFecha("08/07/2021");
       repuestaRecursoDTO.setDisponible(true);
       repuestaRecursoDTO.setDescripcion("El recurso esta disponible");

        Mockito.when(casoUsoConsultarDisponibilidad.apply(rescursoDTO.getId()).thenReturn(Mono.just(repuestaRecursoDTO)));

        webTestClient.get().uri("/disponibilidad/{id}","1")
                .exchange()
                .expectStatus().isOk()
                .expectBody(RecursoDTO.class)
                .value(userResponse -> {
                    Assertions.assertThat(userResponse.getId().compareTo(rescursoDTO.getId()));
                });
    }
}