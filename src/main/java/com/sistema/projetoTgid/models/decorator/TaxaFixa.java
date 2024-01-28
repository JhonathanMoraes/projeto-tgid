
package com.sistema.projetoTgid.models.decorator;


public class TaxaFixa extends TaxaDecorator{
    
    public TaxaFixa(Taxa valorDecorator, double taxa) {
        super(valorDecorator, taxa);
    }
    
    @Override
    public double taxaSistema(){
        return super.taxaSistema() - super.getTaxa();
    }
}
