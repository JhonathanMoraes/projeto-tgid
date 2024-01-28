
package com.sistema.projetoTgid.models.decorator;


public abstract class TaxaDecorator implements Taxa{

    private final Taxa valorDecorator;
    private final double taxa;
    
    public TaxaDecorator(Taxa valorDecorator, double taxa){
        this.valorDecorator = valorDecorator;
        this.taxa = taxa;
    }
    
    @Override
    public double taxaSistema(){
        return valorDecorator.taxaSistema();
    }
    
    public Taxa getValor(){
        return valorDecorator;
    }
    
    public double getTaxa() {
        return taxa;
    }
}
