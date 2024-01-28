
package com.sistema.projetoTgid.models.decorator;


public class SemTaxa implements Taxa{

    private final double valor;
    
    public SemTaxa(double valor){
        this.valor = valor;
    }
    
    @Override
    public double taxaSistema(){
        return valor;
    }
}
