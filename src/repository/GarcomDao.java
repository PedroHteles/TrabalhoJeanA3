package repository;

import model.Garcom;
import model.Mesa;
import model.MesaDto;

import java.util.List;

public interface GarcomDao extends Dao<Garcom> {

    List<MesaDto> getMesas(Garcom garcom);
    void registraGarcomMesa( Garcom garcom);
    List<MesaDto> getMesasOcupadas(Garcom garcom);
    List<MesaDto> getMesasLivres(Garcom garcom);
    List<MesaDto> getMesasQuantidade(Garcom garcom);
}
