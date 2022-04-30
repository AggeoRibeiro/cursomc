package com.aggeo.workshopspringionic.domain.services;

import java.util.Optional;

import com.aggeo.workshopspringionic.domain.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aggeo.workshopspringionic.domain.Categoria;
import com.aggeo.workshopspringionic.repositories.CategoriaRepository;

import javax.persistence.Id;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repo;


    public Categoria buscar(Integer id) {
        Optional<Categoria> obj = repo.findById(id);
            return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
        }
    }



