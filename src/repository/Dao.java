package repository;
import java.util.List;

public interface Dao<T>  {
    List<T> getAll();
    void delete();
    void update(int value);
}