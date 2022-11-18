package constate;

public enum TipoSituacao {

    LIVRE( "LIVRE", (short) 1 ),
    OCUPADA("OCUPADA", (short) 2),
    RESERVADA("RESERVADA",(short) 3);

    private final String descricao;
    private final short value;
    TipoSituacao(final String descricao,
                 final short value) {
        this.value = value;
        this.descricao = descricao;
    }

    public String getValorString() {
        return descricao;
    }

}
