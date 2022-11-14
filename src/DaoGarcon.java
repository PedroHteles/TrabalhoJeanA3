import java.util.Optional;

public interface DaoGarcon {

    Optional<Garcon> getGarcom();
    void atualizaStatusGarcom(Garcon garcon);


}
