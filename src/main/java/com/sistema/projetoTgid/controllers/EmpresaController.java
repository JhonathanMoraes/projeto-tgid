
package com.sistema.projetoTgid.controllers;

import com.sistema.projetoTgid.controllers.services.EmpresaServices;
import com.sistema.projetoTgid.models.Empresa;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {

    @Autowired
    private EmpresaServices service;
    
    @GetMapping
    public ResponseEntity<List<Empresa>> listarEmpresas(){
        return ResponseEntity.ok().body(service.buscarTodos());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Empresa> buscarEmpresa(@PathVariable Long id){
        return ResponseEntity.ok().body(service.buscarPorId(id));
    }
    
    @PostMapping
    public ResponseEntity<Empresa> cadastrarEmpresa(@RequestBody Empresa empresa){
        return ResponseEntity.ok().body(service.cadastrar(empresa));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Empresa> atualizarEmpresa(@RequestBody Empresa empresa, @PathVariable Long id){
        return ResponseEntity.ok().body(service.atualizar(empresa, id));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Empresa> deletarEmpresa(@PathVariable Long id){
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
