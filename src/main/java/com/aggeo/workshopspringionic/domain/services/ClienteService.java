package com.aggeo.workshopspringionic.domain.services;

import com.aggeo.workshopspringionic.domain.Cliente;
import com.aggeo.workshopspringionic.domain.services.exceptions.DataIntegrityException;
import com.aggeo.workshopspringionic.domain.services.exceptions.ObjectNotFoundException;
import com.aggeo.workshopspringionic.dto.ClienteDTO;
import com.aggeo.workshopspringionic.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repo;


    public Cliente find(Integer id) {
        Optional<Cliente> obj = repo.findById(id);
            return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
        }

    public Cliente update(Cliente obj) {
        Cliente newObj = find(obj.getId());
        updateDate(newObj, obj);
        return repo.save(newObj);
    }

    private void updateDate(Cliente newObj, Cliente obj) {
        newObj.setNome((obj.getNome()));
        newObj.setEmail(obj.getEmail());
    }

    public void delete(Integer id) {
        find(id);
        try {
            repo.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir porque há entidades relacionadas");
        }
    }

    public List<Cliente> findAll() {
        return repo.findAll();
    }

    public Page<Cliente> findPage(Integer page, Integer linesPerPage, String direction, String orderBy ){
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return repo.findAll(pageRequest);
    }

    public Cliente fromDTO(ClienteDTO objDto){
        return new Cliente(objDto.getId(), objDto.getNome(), objDto.getEmail(), null, null);
    }
}




