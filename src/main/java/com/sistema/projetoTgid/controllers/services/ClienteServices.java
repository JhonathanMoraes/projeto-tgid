
package com.sistema.projetoTgid.controllers.services;

import com.sistema.projetoTgid.controllers.services.exceptions.DatabaseException;
import com.sistema.projetoTgid.controllers.services.exceptions.ResourceNotFoundException;
import com.sistema.projetoTgid.models.Cliente;
import com.sistema.projetoTgid.repositories.ClienteRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class ClienteServices {
    
    @Autowired
    private ClienteRepository repository;
    
    public List<Cliente> buscarTodos() {
        return repository.findAll();
    }
    
    public  Cliente buscarPorId(Long id) {
        Optional<Cliente> cliente = repository.findById(id);
        return cliente.get();
    }
    
    public Cliente cadastrar(Cliente cliente) {
        return repository.save(cliente);
    }
    
    public Cliente atualizar(Cliente cliente, Long id) {
        try {
            Cliente entity = repository.getReferenceById(id);
            atualizarDados(entity, cliente);
            return repository.save(entity);
        } catch (EntityNotFoundException ex) {
            throw new ResourceNotFoundException(id);
        }
    }
    public void atualizarDados(Cliente entity, Cliente cliente) {
        entity.setCpf(cliente.getCpf());
        entity.setEmail(cliente.getEmail());
    }
    
    public void deletar(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException ex) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException ex) {
            throw new DatabaseException(ex.getMessage());
        }
    }
}
