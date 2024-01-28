
package com.sistema.projetoTgid.models.enums;


public enum TipoTransacao {

    DEPÓSITO(1),
    SAQUE(2);
    
    private final int codigo;

    private TipoTransacao(int codigo){
        this.codigo = codigo;
    }  
    
    public int getCodigo() {
        return codigo;
    }
    
     public static TipoTransacao valueOf(int codigo) {
        for (TipoTransacao value : TipoTransacao.values()) {
            if(value.getCodigo() == codigo) {
                return value;
            }
        }
        throw new IllegalArgumentException("Código TipoTransacao inválido.");
    }
}
