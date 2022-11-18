import java.util.List;
import java.util.Optional;

public interface DaoMesa extends Dao<Mesa>{

    List<Mesa> getMesasCapacidade();
    Optional<Mesa> getMesaCapacidade();
    Optional<Mesa> verificaStatusMesaNumero(short TipoSituacao);
    void registraGarcomMesa(Garcon garcon);
    List<Mesa> getMesasSituacao();
    void liberarMesa();

}
