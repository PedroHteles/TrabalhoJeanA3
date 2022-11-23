package model;

import constate.TipoSituacao;

public class Mesa {
    private Long numeroMesa;
    private Integer capacidadeMesa;
    private TipoSituacao situacao;
    private Garcon garcon;

    public Mesa(final Long numeroMesa,
                final Integer capacidadeMesa,
                final TipoSituacao situacao
    ) {
        this.situacao = situacao;
        this.numeroMesa = numeroMesa;
        this.capacidadeMesa = capacidadeMesa;
    }

    public Garcon getGarcon() {
        return garcon;
    }

    public void setGarcon(Garcon garcon) {
        this.garcon = garcon;
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

    public TipoSituacao getSituacao() {return situacao;}

    public void  setSituacao(TipoSituacao situacao) {this.situacao = situacao;}
}
