package service;

import model.Garcom;
import model.Mesa;
import java.util.List;
import java.util.Optional;

public interface Service {

    Optional<Mesa> getMesa(Long id);
    List<Mesa> getMesas();
    Optional<Garcom> getGarcom();
    List<Garcom> getGarcoms();
}
