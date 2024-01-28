
package com.sistema.projetoTgid.models.decorator;


public class TaxaPorcentagem extends TaxaDecorator{
    
    public TaxaPorcentagem(Taxa valorDecorator, double taxa) {
        super(valorDecorator, taxa);
    }
    
    @Override
    public double taxaSistema(){
        return super.taxaSistema() - (super.getTaxa() * (super.taxaSistema()/100));
    }
}
