package repository;

import model.Garcon;
import model.Mesa;

import java.util.List;


public interface DaoMesa extends Dao<Mesa> {

    void registraGarcomMesa(Garcon garcon);
    List<Mesa> getMesasCapacidade();
    List<Mesa> getMesasSituacao();
    List<Mesa> getMesasOcupadas();
    List<Mesa> getMesasGarcom();

}
