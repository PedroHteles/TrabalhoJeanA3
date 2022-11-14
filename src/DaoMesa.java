import java.util.List;
import java.util.Optional;

public interface DaoMesa extends Dao<Mesa>{
    Optional<Mesa> getMesaNumero();
    List<Mesa> getMesasCapacidade();
    Optional<Mesa> getMesaCapacidade();
    Optional<Mesa> verificaStatusMesaNumero(short TipoSituacao);
    void registraGarcomMesa(Garcon garcon);
    List<Mesa> getMesasSituacao(short TipoSituacao);


}
