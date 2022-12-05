package repository;

import model.Garcom;
import model.MesaDto;
import java.util.List;

public interface GarcomDao extends Dao<Garcom> {

    List<Long> getMesas(Long id);

    List<Long> getMesasOcupadas();
//    List<Long> getMesasLivres();
    List<MesaDto> getMesasQuantidade();
}
