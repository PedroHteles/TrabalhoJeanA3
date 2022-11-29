package utils;

import model.Garcom;
import model.Mesa;
import repository.imp.GarcomDao;
import repository.imp.MesaDao;

import java.util.Optional;


public class MenuApp extends CustomScanner {
    public void MenuApp() {
        final String menu =
                "\n\n1. Cadastro de mesa:\n"
                        + "2. Remocao de mesa:\n"
                        + "3. Busca mesa pelo numero:\n"
                        + "4. Cadastro de garcom:\n"
                        + "5. Remocao de garcom:\n"
                        + "6. Busca garcom pelo email:\n"
                        + "7. Alterar garcom de mesa:\n"
                        + "8. Alterar status de mesa:\n"
                        + "9. Relatorio de mesas:\n"
                        + "10.Relatorio dos garcons:\n"
                        + "11.Relatorio de mesas (capacidade de clientes):\n"
                        + "12.Relatorio de mesas(situacao):\n"
                        + "13.Relatorio de mesas atendidas:\n"
                        + "0. Sair:\n\n";

        System.out.println(menu);
        MesaDao mesaDao = new MesaDao();
        GarcomDao garcomDao = new GarcomDao();
        int opcao = scInt("Digite uma opcao:");

        while (opcao != 0) {
            switch (opcao) {
                case 1 -> {
                    mesaDao.getAll().forEach(this::soutMesa);
                    Optional<Garcom> garcom = garcomDao.get();
                    if (garcom.isPresent()) {
                        mesaDao.create(garcom.get());
                    } else {
                        System.out.println("Sistema deve cadastrar ao menos um GARCOM");
                    }
                }
                case 2 -> {
                    mesaDao.getAll().forEach(this::soutMesa);
                    mesaDao.delete();
                }
                case 3 -> mesaDao.get(0).ifPresent(this::soutMesa);

                case 4 -> garcomDao.create();

                case 5 -> garcomDao.delete();

                case 6 -> garcomDao.get().ifPresent(this::soutGarcom);

                case 7 -> {
                    garcomDao.get().ifPresent(mesaDao::alteraGarcom);
                    mesaDao.getAll().forEach(this::soutMesa);
                }
                case 8 -> mesaDao.alteraStatus();

                case 9 -> mesaDao.getAll().forEach(this::soutMesa);

                case 10 -> garcomDao.getAll().forEach(this::soutGarcom);

                case 11 -> mesaDao.getMesasCapacidade().forEach(this::soutMesa);

                case 12 -> mesaDao.getMesasSituacao().forEach(this::soutMesa);

                case 13 -> mesaDao.getMesasGarcom().forEach(this::soutMesa);
            }
            System.out.println(menu);
            opcao = scInt("Digite uma opcao: ");
        }


    }

    private void soutMesa(Mesa mesa) {
        System.out.println("Mesas cadastradas:" + " \n");
        System.out.println(
                "Numero da mesa: " + mesa.getNumeroMesa() + "\n" +
                        " capacidade: " + mesa.getCapacidadeMesa() + "\n" +
                        " situacao: " + mesa.getSituacao().getDescricao() + "\n" +
                        " garcom: " + ((mesa.getGarcom() != null) ? mesa.getGarcom().getNome() : "Mesa sem nenhum garcom no momento") + " \n"
        );
    }

    private void soutGarcom(Garcom garcom) {
        System.out.println(
                "nome do garcom: " + garcom.getNome() + "\n" +
                        "email do garcom: " + garcom.getEmail() + "\n" +
                        "cpf do garcom: " + garcom.getCpf() + "\n" +
                        "data de nascimento do garcom: " + garcom.getDataNascimento() + "\n" +
                        "total de mesas atendidas no momento: " + garcom.getListaMesas().size() + "\n" +
                        "telefone do garcom: " + garcom.getTelefone() + "\n" +
                        "salario do garcom: " + garcom.getSalarioFixo() + "\n" +
                        "sexo : " + garcom.getSexo().getDescricao() + " \n\n"
        );
    }

    public static class Main {
        public static void main(String[] args) {

        }
    }
}