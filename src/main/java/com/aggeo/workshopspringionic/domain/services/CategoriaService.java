package com.aggeo.workshopspringionic.domain.services;

import com.aggeo.workshopspringionic.domain.Categoria;
import com.aggeo.workshopspringionic.domain.services.exceptions.ObjectNotFoundException;
import com.aggeo.workshopspringionic.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repo;


    public Categoria find(Integer id) {
        Optional<Categoria> obj = repo.findById(id);
            return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
        }

    public Categoria insert(Categoria obj) {
        return repo.save(obj);
    }

    public Categoria update(Categoria obj) {
        find(obj.getId());
        return repo.save(obj);
    }
}



