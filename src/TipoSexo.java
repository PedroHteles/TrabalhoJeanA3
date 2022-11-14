public enum TipoSexo {

    MASCULINO("MASCULINO",(short) 1),
    FEMININO( "FEMININO",(short) 2);

    private final Short i;
    private final String desc;
    TipoSexo(String descricao , short i) {
        this.i = i;
        this.desc = descricao;
    }

    public short getValor() {
        return i;
    }
    public String getValorString() {
        return desc;
    }
}
