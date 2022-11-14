import java.util.List;

public interface Dao<T> {

    List<T> getAll();

    void create();

    void delete();
}
