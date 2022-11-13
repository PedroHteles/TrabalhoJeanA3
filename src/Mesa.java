public class Mesa {
    private Long numeroMesa;
    private Integer capacidadeMesa;
    private TipoSituacaoMesa situacao;

    public Mesa(final Long numeroMesa,
                final Integer capacidadeMesa
                ) {
        this.numeroMesa = numeroMesa;
        this.capacidadeMesa = capacidadeMesa;
    }

    public Long getNumeroMesa() {
        return numeroMesa;
    }

    public void setNumeroMesa(Long numeroMesa) {
        this.numeroMesa = numeroMesa;
    }

    public Integer getCapacidadeMesa() {
        return capacidadeMesa;
    }

    public void setCapacidadeMesa(Integer capacidadeMesa) {
        this.capacidadeMesa = capacidadeMesa;
    }

    public TipoSituacaoMesa getSituacao() {
        return situacao;
    }

    public void setSituacao(TipoSituacaoMesa situacao) {
        this.situacao = situacao;
    }
}
