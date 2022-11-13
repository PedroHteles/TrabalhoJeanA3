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
                        + "5. Relatório de mesas (com todos os dados de todas as mesas)\n\n"
                        + "0. Sair\n\n";

        System.out.println(menu);

        Scanner leOpcao = new Scanner(System.in);

        Scanner sc = new Scanner(System.in);

        MesaDao mesaDao = new MesaDao();

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
                default: {

                    break;
                }
            }
            System.out.println(menu);

            opcao = leOpcao.nextInt();
        }
    }
}