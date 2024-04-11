
package com.sistema.projetoTgid.models.enums;


public enum TipoTaxa {
    
    SEM_TAXA(0),
    FIXO(1),
    PORCENTAGEM(2);

    private final int codigo;

    private TipoTaxa(int codigo){
        this.codigo = codigo;
    }  
    
    public int getCodigo() {
        return codigo;
    }
    
     public static TipoTaxa valueOf(int codigo) {
        for (TipoTaxa value : TipoTaxa.values()) {
            if(value.getCodigo() == codigo) {
                return value;
            }
        }
        throw new IllegalArgumentException("Código TipoTaxa inválido.");
    }
}
