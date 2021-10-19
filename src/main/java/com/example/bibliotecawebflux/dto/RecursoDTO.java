package com.example.bibliotecawebflux.dto;

import javax.validation.constraints.NotBlank;
import java.util.Objects;

public class RecursoDTO {

    private String id;
    @NotBlank
    private boolean disponible;
    @NotBlank
    private String nombreRecurso;
    private String categoriaId;
    private String tipoRecursoId;
    private String fecha;

    public RecursoDTO() {
    }

    public RecursoDTO(String id, String fecha, boolean disponible, String nombreRecurso, String categoriaId, String tipoRecursoId) {
        this.id = id;
        this.fecha = fecha;
        this.disponible = disponible;
        this.nombreRecurso = nombreRecurso;
        this.categoriaId = categoriaId;
        this.tipoRecursoId = tipoRecursoId;
    }

    public RecursoDTO(boolean disponible, String nombreRecurso, String categoriaId, String tipoRecursoId, String fecha) {
        this.disponible = disponible;
        this.nombreRecurso = nombreRecurso;
        this.categoriaId = categoriaId;
        this.tipoRecursoId = tipoRecursoId;
        this.fecha = fecha;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNombreRecurso() {
        return nombreRecurso;
    }

    public void setNombreRecurso(String nombreRecurso) {
        this.nombreRecurso = nombreRecurso;
    }

    public String getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(String categoriaId) {
        this.categoriaId = categoriaId;
    }

    public String getTipoRecursoId() {
        return tipoRecursoId;
    }

    public void setTipoRecursoId(String tipoRecursoId) {
        this.tipoRecursoId = tipoRecursoId;
    }

    @Override
    public String toString() {
        return "RecursoDTO{" +
                "id='" + id + '\'' +
                ", fecha='" + fecha + '\'' +
                ", disponible=" + disponible +
                ", nombreRecurso='" + nombreRecurso + '\'' +
                ", categoriaId='" + categoriaId + '\'' +
                ", tipoRecursoId='" + tipoRecursoId + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecursoDTO that = (RecursoDTO) o;
        return disponible == that.disponible && Objects.equals(id, that.id) && Objects.equals(fecha, that.fecha) && Objects.equals(nombreRecurso, that.nombreRecurso) && Objects.equals(categoriaId, that.categoriaId) && Objects.equals(tipoRecursoId, that.tipoRecursoId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fecha, disponible, nombreRecurso, categoriaId, tipoRecursoId);
    }
}
