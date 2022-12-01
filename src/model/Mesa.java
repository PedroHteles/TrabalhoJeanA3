package model;

import constate.TipoSituacao;

public class Mesa {

    private Integer id;

    private Long numeroMesa;
    private Integer capacidadeMesa;
    private TipoSituacao situacao;
    private Garcom garcom;

    public Mesa(){}
    public Mesa(
            final Integer id,
            final Long numeroMesa,
            final Integer capacidadeMesa,
            final TipoSituacao situacao,
            final Garcom garcom
    ) {
        this.id = id;
        this.garcom = garcom;
        this.situacao = situacao;
        this.numeroMesa = numeroMesa;
        this.capacidadeMesa = capacidadeMesa;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Garcom getIdGarcom() {
        return garcom;
    }

    public void setIdGarcom(Garcom garcom) {
        this.garcom = garcom;
    }

    public Garcom getGarcom() {
        return garcom;
    }

    public void setGarcom(Garcom garcom) {
        this.garcom = garcom;
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
