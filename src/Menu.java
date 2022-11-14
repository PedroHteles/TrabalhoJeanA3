import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {
        String menu =
                "\n\n1. Cadastro de Mesa\n"
                        + "2. Remocao de Mesa\n"
                        + "3. Busca Mesa pelo numero\n"
                        + "4. Busca Mesa pela capacidade de clientes\n"
                        + "5. Busca Mesa pela situacao\n"
                        + "5. Relatorio de mesas (com todos os dados de todas as mesas)\n"
                        + "6. Relatorio de mesas (capacidade)\n"
                        + "7. Cadastro de Garcom\n"
                        + "8. Remocao de Garçom\n"
                        + "9. Busca Garcom pelo Email\n"
                        + "10. Garcom Registra Mesa \n"
                        + "11. Relatorio de mesas (com todos os dados de todas as mesas)\n\n"
                        + "0. Sair\n\n";

        System.out.println(menu);
        Scanner leOpcao = new Scanner(System.in);
        MesaDao mesaDao = new MesaDao();
        GarconDao garconDao = new GarconDao();

        int opcao = leOpcao.nextInt();
        while (opcao != 0) {

            switch (opcao) {
                case 1: {
                    mesaDao.create();
                    break;
                }
                case 2: {
                    mesaDao.delete();
                    break;
                }
                case 3: {
                    mesaDao.getMesaNumero().ifPresent(Menu::soutMesa);
                    break;
                }
                case 4: {
                    mesaDao.getMesaCapacidade().ifPresent(Menu::soutMesa);
                    break;
                }
                case 5: {
                    mesaDao.getAll().forEach(Menu::soutMesa);
                    break;
                }
                case 6: {
                    mesaDao.getMesasSituacao((short) 1).forEach(Menu::soutMesa);
                    break;
                }
                case 7: {
                    mesaDao.getMesasCapacidade().forEach(Menu::soutMesa);
                    break;
                }
                case 8: {
                    garconDao.create();
                    break;
                }
                case 9: {
                    garconDao.delete();
                    break;
                }
                case 10: {
                    garconDao.getGarcom().ifPresent(Menu::soutGarcom);
                    break;
                }
                case 11: {
                    garconDao.getGarcom().ifPresent(mesaDao::registraGarcomMesa);
                    mesaDao.getAll().forEach(Menu::soutMesa);
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

    public static void soutMesa(Mesa mesa) {
        System.out.println(
                "quantidade de mesa: " + mesa.getNumeroMesa() +
                        " capacidade: " + mesa.getCapacidadeMesa() +
                        " situacao: " + mesa.getSituacao() +
                        " garcom: " + mesa.getGarcon()
        );
    }

    public static void soutGarcom(Garcon garcon) {
        System.out.println(
                "nome do garcom: " + garcon.getNome() +
                        " email do garcom: " + garcon.getEmail() +
                        " salario do garcom: " + garcon.getSalarioFixo()
        );
    }
}