import java.util.List;
import java.util.Optional;

public interface DaoMesa extends Dao<Mesa>{
    Optional<Mesa> getMesa(Long numeroMesa);
    List<Mesa> getMesasCapacidade(int capacidadeMesa);
    Optional<Mesa> getMesaCapacidade(int capacidadeMesa);

}
