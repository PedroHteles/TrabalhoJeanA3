import constate.TipoSituacao;
import model.Garcon;
import model.Mesa;
import repository.imp.GarconDao;
import repository.imp.MesaDao;
import utils.CustomScanner;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        String menu =
                      "\n\n1. Cadastro de mesa:\n"
                        + "2. Remocao de mesa:\n"
                        + "3. Busca mesa pelo numero:\n"
                        + "4. Cadastro de garcom:\n"
                        + "5. Remocao de garcom:\n"
                        + "6. Busca garcom pelo email:\n"
                        + "7. Garcom seleciona mesa livre:\n"
                        + "8. Garcom  libera mesa selecionada:\n"
                        + "9. Relatorio de mesas:\n"
                        + "10.Relatorio dos garcons:\n"
                        + "11.Relatorio de mesas (capacidade de clientes):\n"
                        + "12.Relatorio de mesas(situacao):\n"
                        + "13.Relatorio de mesas atendidas:\n"
                        + "0. Sair:\n\n";

        System.out.println(menu);
        MesaDao mesaDao = new MesaDao();
        GarconDao garconDao = new GarconDao();
        CustomScanner sc = new CustomScanner();

        int opcao = sc.scInt("Digite uma opcao: ");
        while (opcao != 0) {
            switch (opcao) {
                case 1: {
                    mesaDao.getAll().forEach(Menu::soutMesa);
                    mesaDao.create();
                    break;
                }
                case 2: {
                    mesaDao.getAll().forEach(Menu::soutMesa);
                    mesaDao.delete();
                    break;
                }
                case 3:{
                    mesaDao.get(0).ifPresent(Menu::soutMesa);
                    break;
                }
                case 4: {
                    garconDao.create();
                    break;
                }
                case 5: {
                    garconDao.delete();
                    break;
                }
                case 6: {
                    garconDao.get(0).ifPresent(Menu::soutGarcom);
                    break;
                }
                case 7: {
                    garconDao.get(0).ifPresent(mesaDao::registraGarcomMesa);
                    mesaDao.getAll().forEach(Menu::soutMesa);
                    break;
                }
                case 8: {
                    mesaDao.update((short) 4);
                    break;
                }
                case 9: {
                    mesaDao.getAll().forEach(Menu::soutMesa);
                    break;
                }
                case 10: {
                    garconDao.getAll().forEach(Menu::soutGarcom);
                    break;
                }
                case 11: {
                    mesaDao.getMesasCapacidade().forEach(Menu::soutMesa);
                    break;
                }
                case 12: {
                    mesaDao.getMesasSituacao().forEach(Menu::soutMesa);
                    break;
                }
                case 13: {
                    mesaDao.getMesasGarcom().forEach(Menu::soutMesa);
                    break;
                }
                default: {
                    break;
                }
            }
            System.out.println(menu);
            opcao = sc.scInt("Digite uma opcao: ");
        }

    }

    public static void soutMesa(Mesa mesa) {
        System.out.println("Mesas cadastradas:" + " \n");
        System.out.println(
                "Numero da mesa: " + mesa.getNumeroMesa() + "\n" +
                        " capacidade: " + mesa.getCapacidadeMesa() + "\n" +
                        " situacao: " + mesa.getSituacao().getDescricao() + "\n" +
                        " garcom: " + ((mesa.getGarcon() != null) ? mesa.getGarcon().getNome() : "Mesa sem nenhum garcon no momento") + " \n"
        );
    }

    public static void soutGarcom(Garcon garcon) {
        System.out.println(
                "nome do garcom: " + garcon.getNome() + "\n" +
                        " email do garcom: " + garcon.getEmail() + "\n" +
                        " salario do garcom: " + garcon.getSalarioFixo() + "\n" +
                        " sexo do garcom: " + garcon.getSexo().getValorString() + " \n\n"
        );
    }
}