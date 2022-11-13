import java.util.Optional;

public interface DaoMesa extends Dao<Mesa>{
    Optional<Mesa> getMesa(Long numeroMesa);
    Optional<Mesa> getMesaCapacidade(int capacidadeMesa);

}
