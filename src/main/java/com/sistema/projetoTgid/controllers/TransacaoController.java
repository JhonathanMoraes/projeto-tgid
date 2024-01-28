
package com.sistema.projetoTgid.controllers;

import com.sistema.projetoTgid.controllers.services.EmailServices;
import com.sistema.projetoTgid.controllers.services.EmpresaServices;
import com.sistema.projetoTgid.models.Empresa;
import com.sistema.projetoTgid.models.Transacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {
    
    @Autowired
    private EmpresaServices empresaService;
    
    @Autowired
    private EmailServices emailService;
    
    @PostMapping
    public ResponseEntity<Transacao> realizarTransacao(@RequestBody Transacao transacao) {
        Empresa empresa = empresaService.buscarPorId(transacao.getEmpresa().getId());
     
        if (transacao.getTipoTransacao().equals(1)) {
            empresa.depositar(transacao.getValor());
        }
        else if (transacao.getTipoTransacao().equals(2)){
            empresa.sacar(transacao.getValor());
        }
        empresaService.atualizar(empresa, transacao.getEmpresa().getId());
        transacao.callBack(emailService);
        return ResponseEntity.ok().body(transacao);
    }
}