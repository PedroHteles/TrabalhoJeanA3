import java.util.*;

public class MesaDao extends CustomScanner implements Dao<Mesa>, DaoMesa {

    private ArrayList<Mesa> mesas = new ArrayList<>();

    @Override
    public void create() {
        mesas.add(new Mesa(scLong("numero","mesa"),
                scInt("capacidade","Mesa"),
                scShort("situacao","mesa")));
    }

    @Override
    public Optional<Mesa> get() {

        final Long aLong = scLong("numero","mesa");

        Optional<Mesa> any = mesas.stream().filter(e -> Objects.equals(e.getNumeroMesa(),
                aLong)).findAny();

        if (any.isEmpty()) System.out.println("mesa nao encontrada");

        return any;
    }

    @Override
    public List<Mesa> getMesasCapacidade() {
        final int valor = scInt("capacidade", "Mesa");
        return mesas.stream().filter(e ->  valor >= e.getCapacidadeMesa()).toList();
    }

    public List<Mesa> getMesasSituacao(short TipoSituacao) {
        return this.getAll().stream().filter(e -> Objects.equals(e.getSituacao(), TipoSituacao)).toList();
    }

    @Override
    public Optional<Mesa> getMesaCapacidade() {
        final int valor = scInt("capacidade", "Mesa");
        Optional<Mesa> collect = mesas.stream().filter(e -> Objects.equals(e.getCapacidadeMesa(),
                valor)).findAny();

        if (collect.isEmpty()) System.out.println("mesa nao encontrada");
        return collect;
    }

    @Override
    public Optional<Mesa> verificaStatusMesaNumero(short TipoSituacao) {
        return this.get().filter(value -> Objects.equals(value.getSituacao(), TipoSituacao));
    }

    @Override
    public void registraGarcomMesa(Garcon garcon) {
        this.verificaStatusMesaNumero((short) 1).ifPresent(e -> {
            e.setSituacao((short) 2);
            e.setGarcon(garcon);
        });
    }

    @Override
    public void liberarMesa() {
        this.get().ifPresent(e -> e.setSituacao((short) 1));
    }

    @Override
    public ArrayList<Mesa> getAll() {
        return mesas;
    }

    @Override
    public void delete() {
        this.get().ifPresent(e -> {
            mesas.remove(e);
            System.out.println("numero da mesa: " + e.getNumeroMesa() + " deletada");
        });
    }

}
