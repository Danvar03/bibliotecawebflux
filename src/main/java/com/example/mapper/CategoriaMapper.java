package com.example.mapper;

import com.example.bibliotecawebflux.dto.CategoriaDTO;
import com.example.bibliotecawebflux.model.Categoria;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class CategoriaMapper {
    public Function<CategoriaDTO, Categoria>    dtoToCategoria(String id) {
        return updateCategoria -> {
            var categoria = new Categoria();
            categoria.setCategoriaId(id);
            categoria.setNombreCategoria(updateCategoria.getNombreCategoria());
            return categoria;
        };
    }

    public Function<Categoria,CategoriaDTO> CategoriaToDTO() {
        return entity -> new CategoriaDTO(entity.getCategoriaId(), entity.getNombreCategoria());
    }
}
