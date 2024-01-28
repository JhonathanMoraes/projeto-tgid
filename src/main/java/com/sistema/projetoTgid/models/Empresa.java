
package com.sistema.projetoTgid.models;

import com.sistema.projetoTgid.models.decorator.SemTaxa;
import com.sistema.projetoTgid.models.decorator.Taxa;
import com.sistema.projetoTgid.models.decorator.TaxaFixa;
import com.sistema.projetoTgid.models.decorator.TaxaPorcentagem;
import com.sistema.projetoTgid.models.enums.TipoTaxa;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Empresa {
    
    @Id
    @Column(name = "id_empresa")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cnpj;
    private String email;
    @Column(columnDefinition = "double default 0.0")
    private double saldo;
    private TipoTaxa tipoTaxa;
    private double valorTaxa;
    
    public void depositar(double valor) {
        valor = aplicarTaxa(valor);
        saldo += valor;
    }
    public void sacar(double valor) {
        valor = aplicarTaxa(valor);
        if (saldo >= valor) {
            saldo -= valor;
        } else {
            System.out.println("Não foi possível sacar, saldo insuficiente.");
        }
    }
    
    public double aplicarTaxa(double valor){
        Taxa taxa = new SemTaxa(valor);
        switch (getTipoTaxa()) {
            case SEM_TAXA -> {
                return taxa.taxaSistema();
            }
            case FIXO -> {
                taxa = new TaxaFixa(taxa, getValorTaxa());
                return taxa.taxaSistema();
            }
            case PORCENTAGEM -> {
                taxa = new TaxaPorcentagem(taxa, getValorTaxa());
                return taxa.taxaSistema();
            }
            default -> throw new AssertionError();
        }
        
    }

    // Getters e Setters
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getSaldo() {
        return saldo;
    }

    public TipoTaxa getTipoTaxa() {
        return tipoTaxa;
    }

    public void setTipoTaxa(TipoTaxa tipoTaxa) {
        this.tipoTaxa = tipoTaxa;
    }

    public double getValorTaxa() {
        return valorTaxa;
    }

    public void setValorTaxa(double valorTaxa) {
        this.valorTaxa = valorTaxa;
    }
    
}
