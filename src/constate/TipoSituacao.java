package constate;



public enum TipoSituacao  {

    LIVRE( "LIVRE", (short) 1 ),
    OCUPADA("OCUPADA", (short) 2),

    RESERVADA("RESERVADA",(short) 3);
    ;

    private final String descricao;
    private final Short valor;

    TipoSituacao(
            final String descricao,
            final Short valor
    ) {

        this.descricao = descricao;
        this.valor = valor;
    }


    public String getDescricao() {

        return this.descricao;
    }


    public Short getValor() {

        return this.valor;
    }

    public static TipoSituacao getInstance( Short valor ){
        for ( TipoSituacao tipoSituacao: TipoSituacao.values()){
            if ( tipoSituacao.getValor().equals( valor )){
                return tipoSituacao;
            }
        }
        return null;
    }
}

