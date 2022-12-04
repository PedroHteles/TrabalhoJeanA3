package model;

import constate.TipoSituacao;


public class Mesa {

    private Long id;
    private Long numeroMesa;
    private Integer capacidadeMesa;
    private TipoSituacao situacao;
    private Garcom garcom;

    public Mesa(){}



    public Mesa(final MesaDto mesaDto
    ) {
        this.id = mesaDto.getId();
        this.situacao = mesaDto.getSituacao();
        this.numeroMesa = mesaDto.getNumeroMesa();
        this.capacidadeMesa = mesaDto.getCapacidadeMesa();
    }



    public Long getId() {
        return id;
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
