package repository;

import model.Garcom;
import model.Mesa;

import java.util.List;
import java.util.Optional;


public interface DaoMesa extends Dao<Mesa> {
    void create(Garcom garcom);
    Optional<Mesa> get(int value);
    List<Mesa> getMesasCapacidade();
    List<Mesa> getMesasSituacao();
    List<Mesa> getMesasOcupadas();
    List<Mesa> getMesasGarcom();
    void alteraGarcom(Garcom garcom);
    void alteraStatus();
}
