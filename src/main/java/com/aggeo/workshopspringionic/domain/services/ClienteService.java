package com.aggeo.workshopspringionic.domain.services;

import com.aggeo.workshopspringionic.domain.Cliente;
import com.aggeo.workshopspringionic.domain.services.exceptions.ObjectNotFoundException;
import com.aggeo.workshopspringionic.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repo;


    public Cliente buscar(Integer id) {
        Optional<Cliente> obj = repo.findById(id);
            return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
        }
    }



