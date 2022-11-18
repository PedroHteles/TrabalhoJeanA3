package repository;

import java.util.List;
import java.util.Optional;

public interface DaoGarcon {

    interface Dao<T>  {

        void create();

        List<T> getAll();

        void delete();

        Optional<T> get();
    }
}
