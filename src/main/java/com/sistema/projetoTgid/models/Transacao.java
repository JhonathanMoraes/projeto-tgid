
package com.sistema.projetoTgid.models;

import com.sistema.projetoTgid.controllers.services.EmailServices;
import com.sistema.projetoTgid.models.enums.TipoTransacao;

public class Transacao {
    
    private Long idEmpresa;
    private Long idCliente;
    private TipoTransacao tipoTransacao;
    private double valor;
    
    
    public void callBack(Empresa empresa, Cliente cliente) {
        String body = "Transação de " + getTipoTransacao() +" realizado por " + cliente.getEmail() + " no valor de " + getValor() + " para a empresa: " + empresa.getCnpj();
        
        EmailServices.sendEmail(empresa.getEmail(), "Transação realizada!", body);
        EmailServices.sendEmail(cliente.getEmail(), "Transação realizada!", body);
        
        System.out.println("Email enviado. Cliente ID("+ getIdCliente() +"), Empresa ID(" + getIdEmpresa() + ")");
    }
    
    // Getters e Setters

    public Long getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Long idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public TipoTransacao getTipoTransacao() {
        return tipoTransacao;
    }

    public void setTipoTransacao(TipoTransacao tipoTransacao) {
        this.tipoTransacao = tipoTransacao;
    }
    
    public Double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
