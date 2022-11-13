import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {
        String menu =
                "\n\n1. Cadastro de Mesa\n"
                        + "2. Remoção de Mesa\n"
                        + "3. Busca Mesa pelo número\n"
                        + "4. Busca Mesa pela capacidade de clientes\n"
                        + "5. Relatório de mesas (com todos os dados de todas as mesas)\n"
                        + "6. Relatório de mesas (capacidade)\n"
                        + "7. Cadastro de Garçom\n"
                        + "8. Remoção de Garçom\n"
                        + "9. Busca Garçom pelo Email\n"
                        + "10. Relatório de mesas (com todos os dados de todas as mesas)\n\n"
                        + "0. Sair\n\n";

        System.out.println(menu);

        Scanner leOpcao = new Scanner(System.in);

        Scanner sc = new Scanner(System.in);

        MesaDao mesaDao = new MesaDao();

        GarconDao garconDao = new GarconDao();

        int opcao = leOpcao.nextInt();

        while (opcao != 0) {

            switch (opcao) {

                case 1: {

                    System.out.println("digite o numero da mesa: ");

                    Long numeroMesa = sc.nextLong();

                    System.out.println("digite a capacidade da mesa: ");

                    int capacidadeMesa = sc.nextInt();

                    mesaDao.create(new Mesa(numeroMesa, capacidadeMesa));

                    break;
                }
                case 2: {

                    System.out.println("digite o numero da mesa: ");

                    Long i = sc.nextLong();

                    Optional<Mesa> mesa = mesaDao.getMesa(i);

                    if (!mesa.isPresent()) {

                        System.out.println("mesa nao encontrada");

                    } else {

                        System.out.println("numero da mesa: " + mesa.get().getNumeroMesa() + " deletada");

                        mesaDao.delete(mesa.get());

                        System.out.println("quantidade de mesas cadastradas: " + mesaDao.getAll().size());

                        System.out.println(2);
                    }
                    break;
                }
                case 3: {
                    System.out.println("digite o numero da mesa: ");

                    Long i = sc.nextLong();

                    Optional<Mesa> mesa = mesaDao.getMesa(i);

                    if (!mesa.isPresent()) {

                        System.out.println("mesa nao encontrada");

                    } else {
                        Mesa mesaEncontrada = mesa.get();
                        System.out.println(
                                "quantidade de mesa: " + mesaEncontrada.getNumeroMesa() +
                                        " capacidade: " + mesaEncontrada.getCapacidadeMesa() +
                                        " situacao: " + mesaEncontrada.getSituacao()
                        );
                    }
                    System.out.println(3);

                    break;
                }
                case 4: {
                    System.out.println("digite a capacidade da mesa: ");

                    int i = sc.nextInt();

                    Optional<Mesa> mesa = mesaDao.getMesaCapacidade(i);

                    if (!mesa.isPresent()) {

                        System.out.println("mesa nao encontrada");

                    } else {
                        Mesa mesaEncontrada = mesa.get();
                        System.out.println(
                                "quantidade de mesa: " + mesaEncontrada.getNumeroMesa() +
                                        " capacidade: " + mesaEncontrada.getCapacidadeMesa() +
                                        " situacao: " + mesaEncontrada.getSituacao()
                        );
                    }
                    System.out.println(4);

                    break;
                }
                case 5: {
                    List<Mesa> relotorio = mesaDao.getAll();
                    for(Mesa a : relotorio){
                        System.out.println(
                                "quantidade de mesa: " + a.getNumeroMesa() +
                                        " capacidade: " + a.getCapacidadeMesa() +
                                        " situacao: " + a.getSituacao()
                        );
                    }
                    System.out.println(5);

                    break;
                }
                case 6: {
                    System.out.println("digite a capacidade da mesa: ");
                    int capacidade = sc.nextInt();
                    List<Mesa> relotorio = mesaDao.getMesasCapacidade(capacidade);
                    for(Mesa a : relotorio){
                        System.out.println(
                                "quantidade de mesa: " + a.getNumeroMesa() +
                                        " capacidade: " + a.getCapacidadeMesa() +
                                        " situacao: " + a.getSituacao()
                        );
                    }
                    System.out.println(5);
                    break;
                }
                case 7: {
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

                    Double salarioFixo  = sc.nextDouble();

                    garconDao.create(new Garcon(nome, cpf, dataNascimento, email, telefone, sexo, salarioFixo));

                    System.out.println(garconDao.getAll());

                    break;
                }
                case 8: {
                    System.out.println("digite o numero email do garcom: ");

                    String emailGarcom = sc.next();

                    Optional<Garcon> garcom = garconDao.getGarcom(emailGarcom);

                    if (!garcom.isPresent()) {

                        System.out.println("garcom nao encontrado(a)");

                    }else {

                        garconDao.delete(garcom.get());

                    }
                    System.out.println(5);

                    break;
                }
                case 9: {
                    System.out.println("digite o numero email do garcom: ");

                    String emailGarcom = sc.next();

                    Optional<Garcon> garcom = garconDao.getGarcom(emailGarcom);

                    if (!garcom.isPresent()) {

                        System.out.println("garcom nao encontrado(a)");

                    }else {

                        Garcon garcon = garcom.get();

                        System.out.println(
                                    "nome do garcom: " + garcon.getNome() +
                                            " email do garcom: " + garcon.getEmail() +
                                            " salario do garcom: " + garcon.getSalarioFixo()
                        );

                    }
                    System.out.println(5);

                    break;
                }
                case 10: {

                    System.out.println(5);

                    break;
                }
                default: {

                    break;
                }
            }
            System.out.println(menu);

            opcao = leOpcao.nextInt();
        }
    }
}