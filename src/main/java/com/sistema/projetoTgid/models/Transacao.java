
package com.sistema.projetoTgid.models;

import com.sistema.projetoTgid.controllers.services.EmailServices;
import com.sistema.projetoTgid.models.enums.TipoTransacao;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class Transacao {
    
    @ManyToOne
    @JoinColumn(name = "id_empresa")
    private Empresa empresa;
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;
    private TipoTransacao tipoTransacao;
    private double valor;
    
    public void callBack(EmailServices service) {
        String body = "Tipo de transação: " + getTipoTransacao().toString() + " Com valor: " + getValor();
        Email email = new Email(getEmpresa().getEmail(), "Transação realizada", body);
        service.sendEmail(email);
        email = new Email(getCliente().getEmail(), "Transação realizada", body);
        service.sendEmail(email);
        System.out.println("Email enviado");
    }
    
    // Getters e Setters

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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
