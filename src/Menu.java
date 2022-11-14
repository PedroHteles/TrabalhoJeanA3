import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        String menu =
                "\n\n1. Cadastro de Mesa\n"
                        + "2. Remocao de mesa\n"
                        + "3. Busca mesa pelo numero\n"
                        + "4. Busca mesa pela capacidade de clientes\n"
                        + "5. Busca mesa pela situacao\n"
                        + "6. Relatorio de mesas (com todos os dados de todas as mesas)\n"
                        + "7. Relatorio de mesas (capacidade)\n"
                        + "8. Cadastro de garcom\n"
                        + "9. Remocao de garcom\n"
                        + "10. Busca garcom pelo email\n"
                        + "11. Garcom registra mesa \n"
                        + "12. Garcom registra mesa livre\n"
                        + "13. Relatorio de mesas (com todos os dados de todas as mesas)\n\n"
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
                    mesaDao.get().ifPresent(Menu::soutMesa);
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
                    garconDao.get().ifPresent(Menu::soutGarcom);
                    break;
                }
                case 11: {
                    garconDao.get().ifPresent(mesaDao::registraGarcomMesa);
                    mesaDao.getAll().forEach(Menu::soutMesa);
                    break;
                }
                case 12: {
                    mesaDao.liberarMesa();
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
                        " salario do garcom: " + garcon.getSalarioFixo()+
                        " sexo do garcom: " + garcon.getSexo().getValorString()
        );
    }
}