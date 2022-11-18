import java.util.*;

public class MesaDao extends CustomScanner implements Dao<Mesa>, DaoMesa {

    private ArrayList<Mesa> mesas = new ArrayList<>();

    @Override
    public void create() {
        int size = mesas.size();
        Long numeroMesa = scLong("Digite o numero da mesa");

        Optional<Mesa> any = mesas.stream().filter(e -> Objects.equals(e.getNumeroMesa(),
                numeroMesa)).findAny();

        int capacidade = scInt("Digite a capacidade de mesa:");

        Short situacao = scShort("Digite 1 para LIVRE, Digite 2 para OCUPADA, digite 3 para RESERVADA: ");
        if(situacao >= 1 && situacao <= 3) {
                if (any.isEmpty()) {
                    mesas.add(new Mesa(numeroMesa,
                            capacidade,
                            situacao
                            ));
                    if (mesas.size() > size) System.out.println("Mesa Cadastrada com sucesso");
                } else {
                    System.out.println("Mesa ja cadastrada !!");
                }
        }else{System.out.println("Valor invalido!! ");}
    }

    @Override
    public Optional<Mesa> get() {

        final Long aLong = scLong("Digite o numero da mesa: ");

        Optional<Mesa> any = mesas.stream().filter(e -> Objects.equals(e.getNumeroMesa(),
                aLong)).findAny();

        if (any.isEmpty()) System.out.println("mesa nao encontrada");

        return any;
    }

    @Override
    public List<Mesa> getMesasCapacidade() {
        final int valor = scInt("Digite a capacidade de sua mesa: ");
        return mesas.stream().filter(e ->  valor >= e.getCapacidadeMesa()).toList();
    }

    public List<Mesa> getMesasSituacao() {
        final Short tipoSituacao = scShort("Digite a capacidade de sua mesa: ");
        return this.getAll().stream().filter(e -> Objects.equals(e.getSituacao(), tipoSituacao)).toList();
    }


    @Override
    public Optional<Mesa> getMesaCapacidade() {
        final int valor = scInt("Digite a capacidade de sua mesa: ");
        Optional<Mesa> collect = mesas.stream().filter(e -> Objects.equals(e.getCapacidadeMesa(),
                valor)).findAny();
        if (collect.isEmpty()) System.out.println("mesa nao encontrada: ");
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
        this.getMsg("Digite o numero da mesa a ser deletada ou digite 0 para voltar ao menu:").ifPresent(e -> {
            mesas.remove(e);
            System.out.println("numero da mesa: " + e.getNumeroMesa() + " deletada");
        });
    }

    private Optional<Mesa> getMsg(String msg) {

        final Long aLong = scLong(msg);
        if(aLong == 0) return Optional.empty();


        Optional<Mesa> any = mesas.stream().filter(e -> Objects.equals(e.getNumeroMesa(),
                aLong)).findAny();

        if (any.isEmpty()) System.out.println("mesa nao encontrada");

        return any;
    }
}
