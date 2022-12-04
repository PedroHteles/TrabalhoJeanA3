package model;

import constate.TipoSituacao;

public class MesaDto {
    private final Long id;
    private final Long numeroMesa;
    private final Integer capacidadeMesa;
    private final TipoSituacao situacao;
    private final Long idGarcom;

    public MesaDto(Long id, Long numeroMesa, Integer capacidadeMesa, TipoSituacao situacao, Long idGarcom) {
        this.id = id;
        this.numeroMesa = numeroMesa;
        this.capacidadeMesa = capacidadeMesa;
        this.situacao = situacao;
        this.idGarcom = idGarcom;
    }

    public Long getId() {
        return id;
    }

    public Long getNumeroMesa() {
        return numeroMesa;
    }

    public Integer getCapacidadeMesa() {
        return capacidadeMesa;
    }

    public TipoSituacao getSituacao() {
        return situacao;
    }

    public Long getIdGarcom() {
        return idGarcom;
    }
}
