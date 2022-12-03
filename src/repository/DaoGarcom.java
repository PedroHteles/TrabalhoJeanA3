package repository;

import model.Garcom;
import model.Mesa;

import java.util.List;
import java.util.Optional;

public interface DaoGarcom extends Dao<Garcom> {

    List<Mesa> getMesas(Garcom garcom);
    void registraGarcomMesa( Garcom garcom);
    List<Mesa> getMesasOcupadas(Garcom garcom);
    List<Mesa> getMesasLivres(Garcom garcom);
    List<Mesa> getMesasQuantidade(Garcom garcom);
}
