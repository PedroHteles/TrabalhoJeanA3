package constate;

public enum TipoSexo {

    MASCULINO("MASCULINO", (short) 1),
    FEMININO("FEMININO", (short) 2);

    private final String descricao;
    private final Short valor;

    TipoSexo(
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

    public static TipoSexo getInstance(Short valor) {
        for (TipoSexo tipoSexo : TipoSexo.values()) {
            if (tipoSexo.getValor().equals(valor)) {
                return tipoSexo;
            }
        }
        return null;
    }
}
