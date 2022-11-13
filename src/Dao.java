import java.util.List;
import java.util.Optional;

public interface Dao<T> {

    List<T> getAll();

    void create(T t);

    void update(T t);

    void delete(T t);
}
