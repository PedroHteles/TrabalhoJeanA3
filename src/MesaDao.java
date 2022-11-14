import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MesaDao implements Dao<Mesa>, DaoMesa {

    private ArrayList<Mesa> mesas = new ArrayList<>();

    Scanner sc = new Scanner(System.in);

    private Long ScannerGetMesasPeluNumero() {
        System.out.println("digite o numero da mesa: ");
        return sc.nextLong();
    }

    private int ScannerGetMesasPelaCapacidade() {
        System.out.println("digite a capacidade da mesa: ");
        return sc.nextInt();
    }

    private short ScannerGetSituacaoMesa() {
        System.out.println("digite a situacao da mesa: ");
        return sc.nextShort();
    }

    @Override
    public void create() {
        mesas.add(new Mesa(ScannerGetMesasPeluNumero(),
                ScannerGetMesasPelaCapacidade(),
                ScannerGetSituacaoMesa()));
    }

    @Override
    public Optional<Mesa> getMesaNumero() {

        Long aLong = ScannerGetMesasPeluNumero();

        Optional<Mesa> any = mesas.stream().filter(e -> Objects.equals(e.getNumeroMesa(),
                aLong)).findAny();

        if (any.isEmpty()) System.out.println("mesa nao encontrada");

        return any;
    }

    @Override
    public List<Mesa> getMesasCapacidade() {
        return mesas.stream().filter(e -> ScannerGetMesasPelaCapacidade() >= e.getCapacidadeMesa()).toList();
    }

    @Override
    public Optional<Mesa> getMesaCapacidade() {

        Optional<Mesa> collect = mesas.stream().filter(e -> Objects.equals(e.getCapacidadeMesa(),
                ScannerGetMesasPelaCapacidade())).findAny();

        if (collect.isEmpty()) System.out.println("mesa nao encontrada");
        return collect;
    }

    @Override
    public Optional<Mesa> verificaStatusMesaNumero(short TipoSituacao) {
        return this.getMesaNumero().filter(value -> Objects.equals(value.getSituacao(), TipoSituacao));
    }

    public List<Mesa> getMesasSituacao(short TipoSituacao) {
        return this.getAll().stream().filter(e -> Objects.equals(e.getSituacao(), TipoSituacao)).toList();
    }

    @Override
    public void registraGarcomMesa(Garcon garcon) {

        this.verificaStatusMesaNumero((short) 1).ifPresent(e -> {
            this.atualizaStatus(e, garcon, (short) 2);
        });

    }

    @Override
    public ArrayList<Mesa> getAll() {
        return mesas;
    }

    private void atualizaStatus(Mesa mesa, Garcon garcon, short status) {
        mesa.setSituacao(status);
        mesa.setGarcon(garcon);
    }

    @Override
    public void delete() {
        this.getMesaNumero().ifPresent(e -> {
            mesas.remove(e);
            System.out.println("numero da mesa: " + e.getNumeroMesa() + " deletada");
        });
    }
}
