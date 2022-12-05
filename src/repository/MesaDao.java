package repository;

import constate.TipoSituacao;
import model.MesaDto;

import java.util.List;
import java.util.Optional;


public interface MesaDao extends Dao<MesaDto> {


    Optional<TipoSituacao> getSituacaoMesa();
    List<MesaDto> getMesasCapacidade();
    List<MesaDto> getMesasSituacao();
    List<MesaDto> getMesasOcupadas();
    List<Long> getMesasLivres();
    void removerGarcom();
    void registraGarcomMesa(Long id);


}
