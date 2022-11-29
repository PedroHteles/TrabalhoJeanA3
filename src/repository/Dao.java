package repository;
import model.Garcom;
import java.util.List;
import java.util.Optional;

public interface Dao<T>  {
    List<T> getAll();
    void delete();
    void update(int value);
}