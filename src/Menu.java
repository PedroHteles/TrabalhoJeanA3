import model.Garcom;
import model.Mesa;
import repository.imp.GarcomImplDaoImpl;
import repository.imp.MesaImplDaoImpl;
import utils.CustomScanner;


public class Menu {
    public static void main(String[] args) {
        String menu =
                "\n\n1. Cadastro de mesa:\n"
                        + "2. Busca mesa pelo numero:\n"
                        + "3. Remocao de mesa:\n"
                        + "4. Cadastro de garcom:\n"
                        + "5. Busca garcom pelo email:\n"
                        + "6. Remocao de garcom:\n"
                        + "7. Registra garcom mesa:\n"
                        + "8. Relatório com todas as mesas que um garçom atende e que estão ocupadas :\n"
                        + "9.Busca nome do garçom responsável por uma dada mesa :\n"
                        + "10.Relatório com todas as mesas que um garçom atende:\n"
                        + "11.Relatório com todas as mesas livres e o nome do garçom responsável pela mesa :\n"
                        + "12.Relatório da quantidade de mesas que cada garçom está atendendo:\n"
                        + "0. Sair:\n\n";

        System.out.println(menu);
        MesaImplDaoImpl mesaImpl = new MesaImplDaoImpl();
        GarcomImplDaoImpl garcomImpl = new GarcomImplDaoImpl();
        CustomScanner sc = new CustomScanner();
        int opcao = sc.scInt("Digite uma opcao:");

        while (opcao != 0) {
            switch (opcao) {
                case 1 -> {
                    mesaImpl.getAll().forEach(Menu::soutMesa);
                    mesaImpl.create();
                }
                case 2 -> {
                    mesaImpl.getAll().forEach(Menu::soutMesa);
                    mesaImpl.delete();
                }
                case 3 -> mesaImpl.get().ifPresent(Menu::soutMesa);

                case 4 -> garcomImpl.create();

                case 5 -> garcomImpl.delete();

                case 6 -> garcomImpl.buscarPeloEmail().ifPresent(Menu::soutGarcom);

                case 7 -> {
                    garcomImpl.buscarPeloEmail().ifPresent(garcomImpl::registraGarcomMesa);
                    mesaImpl.getAll().forEach(Menu::soutMesa);
                }
                case 8 -> mesaImpl.update();

                case 9 -> mesaImpl.getAll().forEach(Menu::soutMesa);

                case 10 -> garcomImpl.getAll().forEach(Menu::soutGarcom);

                case 11 -> mesaImpl.getMesasCapacidade().forEach(Menu::soutMesa);

                case 12 -> mesaImpl.getMesasSituacao().forEach(Menu::soutMesa);

                case 13 -> mesaImpl.getAll().forEach(Menu::soutMesa);
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
                        " garcom: " + ((mesa.getGarcom() != null) ? mesa.getGarcom().getNome() : "Mesa sem nenhum garcom no momento") + " \n"
        );
    }

    public static void soutGarcom(Garcom garcom) {
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
}