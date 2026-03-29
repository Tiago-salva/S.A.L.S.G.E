package com.salsge.demo.Categorias;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public List<Categoria> getAllCategorias() {
        return categoriaRepository.findAll();
    }

    public Optional<Categoria> getCategoria(Long id) {
        return categoriaRepository.findById(id);
    }

    public void editCategoria(Categoria categoria, String categoriaSueldo) {
        categoria.setSueldo(categoriaSueldo);

        categoriaRepository.save(categoria);
    }

}
