package repository;

import constate.TipoSituacao;
import model.Garcom;
import model.Mesa;

import java.util.List;
import java.util.Optional;


public interface DaoMesa extends Dao<Mesa> {

    Optional<String> getNomeGarcom();
    Optional<TipoSituacao> getSituacaoMesa();
    List<Mesa> getMesasCapacidade();
    List<Mesa> getMesasSituacao();
    List<Mesa> getMesasOcupadas();
    List<Mesa> getMesasLivres();


}
