import java.util.*;

public class GarconDao implements Dao<Garcon>, DaoGarcon {

    private ArrayList<Garcon> garcons = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    @Override
    public List<Garcon> getAll() {
        return garcons;
    }

    private String getGarcomEmail() {
        System.out.println("digite o email do garcom: ");
        return sc.next();
    }

    @Override
    public Optional<Garcon> getGarcom() {

        Optional<Garcon> garcon = garcons.stream().filter(e -> Objects.equals(e.getEmail(), getGarcomEmail())).findAny();

        if (garcon.isEmpty()) System.out.println("garcom nao encontrado");

        return garcon;
    }

    @Override
    public void create() {
        System.out.println("digite o nome do Garçom: ");

        String nome = sc.next();

        System.out.println("digite o cpf do Garçom: ");

        String cpf = sc.next();

        System.out.println("digite a data de nascimento do Garçom: ");

        String dataNascimento = sc.next();

        System.out.println("digite o Email do Garçom: ");

        String email = sc.next();

        System.out.println("digite o telefone do Garçom: ");

        Long telefone = sc.nextLong();

        System.out.println("digite o sexo do Garçom: ");

        String sexo = sc.next();

        System.out.println("digite o salário fixo do Garçom: ");

        Double salarioFixo = sc.nextDouble();

        garcons.add(new Garcon(nome,
                cpf,
                dataNascimento,
                email,
                telefone,
                sexo,
                salarioFixo
        ));
    }

    @Override
    public void atualizaStatusGarcom(Garcon garcon) {

        garcon.setNome(garcon.getNome());
        garcon.setCpf(garcon.getCpf());
        garcon.setDataNascimento(garcon.getDataNascimento());
        garcon.setEmail(garcon.getEmail());
        garcon.setSexo(garcon.getSexo());
        garcon.setSalarioFixo(garcon.getSalarioFixo());
        garcon.setTelefone(garcon.getTelefone());
        garcons.add(garcon);
    }

    @Override
    public void delete() {
        this.getGarcom().ifPresent(e -> garcons.remove(e));
    }

}
