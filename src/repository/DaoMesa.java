package repository;

import model.Garcom;
import model.Mesa;

import java.util.List;


public interface DaoMesa extends Dao<Mesa> {

    void registraGarcomMesa(Garcom garcom);
    List<Mesa> getMesasCapacidade();
    List<Mesa> getMesasSituacao();
    List<Mesa> getMesasOcupadas();
    List<Mesa> getMesasGarcom();

}
