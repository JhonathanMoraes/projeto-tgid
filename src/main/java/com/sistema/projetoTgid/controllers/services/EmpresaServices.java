
package com.sistema.projetoTgid.controllers.services;

import com.sistema.projetoTgid.controllers.services.exceptions.DatabaseException;
import com.sistema.projetoTgid.controllers.services.exceptions.ResourceNotFoundException;
import com.sistema.projetoTgid.models.Empresa;
import com.sistema.projetoTgid.repositories.EmpresaRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class EmpresaServices {
	
    @Autowired
    private EmpresaRepository repository;
    
    public List<Empresa> buscarTodos() {
        return repository.findAll();
    }
    
    public  Empresa buscarPorId(Long id) {
        Optional<Empresa> empresa = repository.findById(id);
        return empresa.get();
    }
    
    public Empresa cadastrar(Empresa empresa) {
        return repository.save(empresa);
    }
    
    public Empresa atualizar(Empresa empresa, Long id) {
        try {
            Empresa entity = repository.getReferenceById(id);
            atualizarDados(entity, empresa);
            return repository.save(entity);
        } catch (EntityNotFoundException ex) {
        	System.out.println("[ ERRO ] - " + ex.getMessage());
            throw new ResourceNotFoundException(id);
        }
    }
    public void atualizarDados(Empresa entity, Empresa empresa) {
        entity.setCnpj(empresa.getCnpj());
        entity.setEmail(empresa.getEmail());
        entity.setTipoTaxa(empresa.getTipoTaxa());
        entity.setQuantiaTaxa(empresa.getQuantiaTaxa());
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
