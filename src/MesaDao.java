import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MesaDao implements Dao<Mesa>, DaoMesa {

    private ArrayList<Mesa> mesas = new ArrayList<>();

    @Override
    public void create(Mesa mesa) {
        mesas.add(new Mesa(mesa.getNumeroMesa(), mesa.getCapacidadeMesa()));
    }

    @Override
    public Optional<Mesa> getMesa(Long numeroMesa) {
        List<Mesa> collect = mesas.stream().filter(e -> Objects.equals(e.getNumeroMesa(), numeroMesa)).toList();

        if (collect.size() > 0) {
            return Optional.ofNullable(collect.get(0));
        } else {
            return Optional.empty();
        }

    }

    @Override
    public List<Mesa> getMesasCapacidade(int capacidadeMesa) {
        List<Mesa> collect = mesas.stream().filter(e -> e.getCapacidadeMesa() >= capacidadeMesa).toList();
        return  collect;
    }

    @Override
    public Optional<Mesa> getMesaCapacidade(int capacidadeMesa) {

        List<Mesa> collect = mesas.stream().filter(e -> Objects.equals(e.getCapacidadeMesa(), capacidadeMesa)).toList();

        if (collect.size() > 0) {
            return Optional.ofNullable(collect.get(0));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public List<Mesa> getAll() {return mesas;}

    @Override
    public void update(Mesa mesa) {

        mesa.setSituacao(Objects.requireNonNull(
                mesa.getSituacao(), "Situacao da mesa nao pode null"));

        mesa.setCapacidadeMesa(Objects.requireNonNull(
                mesa.getCapacidadeMesa(), "Capacidade da mesa nao pode null"));

        mesas.add(mesa);
    }

    @Override
    public void delete(Mesa mesa) {mesas.remove(mesa);}

}
