package com.example.bibliotecawebflux.dto;

public class TipoRecursoDTO {

    private String tipoRecursoId;
    private String nombreTipoRecurso;

    public TipoRecursoDTO() {
    }

    public TipoRecursoDTO(String tipoRecursoId, String nombreTipoRecurso) {
        this.tipoRecursoId = tipoRecursoId;
        this.nombreTipoRecurso = nombreTipoRecurso;
    }

    public String getTipoRecursoId() {
        return tipoRecursoId;
    }

    public void setTipoRecursoId(String tipoRecursoId) {
        this.tipoRecursoId = tipoRecursoId;
    }

    public String getNombreTipoRecurso() {
        return nombreTipoRecurso;
    }

    public void setNombreTipoRecurso(String nombreTipoRecurso) {
        this.nombreTipoRecurso = nombreTipoRecurso;
    }
}
