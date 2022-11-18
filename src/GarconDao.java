import java.util.*;

public class GarconDao extends CustomScanner  implements Dao<Garcon>  {

    private ArrayList<Garcon> garcons = new ArrayList<>();

    @Override
    public List<Garcon> getAll() {
        return garcons;
    }

    @Override
    public Optional<Garcon> get() {

        String email = scString("Digite o email do garcom:");

        Optional<Garcon> garcon = garcons.stream().filter(e -> Objects.equals(e.getEmail(),email)).findAny();

        if (garcon.isEmpty()) System.out.println("garcom nao encontrado");

        return garcon;
    }

    @Override
    public void delete() {
        this.get().ifPresent(e -> garcons.remove(e));
    }

    @Override
    public void create() {
        garcons.add(new Garcon(scString("Digite o nome do garcom:"),
                scString("Digite o cpf garcom:"),
                scString("Digite a data de nascimento do garcom:"),
                scString("Digite o email do garcom:"),
                scLong("Digite o telefone do garcom:"),
                scStringMsgFull("digite 1 para masculino e 2 para feminino") == 1 ?  TipoSexo.MASCULINO : TipoSexo.FEMININO,
                scDouble("Digite o salario do garcom:")
        ));
    }
}
