package repository;

import model.Mesa;

import java.util.List;
import java.util.Optional;

public interface Dao<T>  {
    void create();
    List<T> getAll();
    void delete();
    Optional<T> get();
    void update();
    Optional<T> findById(Long id);
}