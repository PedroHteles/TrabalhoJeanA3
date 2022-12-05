import model.Garcom;
import model.Mesa;
import repository.imp.GarcomImplDaoImpl;
import repository.imp.MesaImplDaoImpl;
import service.ServiceImpl;
import utils.CustomScanner;

import java.util.Optional;


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
                        + "8. Remove garcom mesa:\n"
                        + "9. Relatório com todas as mesas que um garçom atende e que estão ocupadas :\n"
                        + "10.Busca nome do garçom responsável por uma dada mesa :\n"
                        + "11.Relatório com todas as mesas que um garçom atende:\n"
                        + "12.Relatório com todas as mesas livres e o nome do garçom responsável pela mesa :\n"
                        + "13.Relatório da quantidade de mesas que cada garçom está atendendo:\n"
                        + "0. Sair:\n\n";

        System.out.println(menu);
        ServiceImpl service = new ServiceImpl();
        CustomScanner sc = new CustomScanner();
        int opcao = sc.scInt("Digite uma opcao:");

        while (opcao != 0) {
            switch (opcao) {
                case 1 -> {
                    service.getMesas().forEach(Menu::soutMesa);
                    service.serviceMesa().create();
                }
                case 2 ->service.serviceMesa().get().ifPresent(e -> {
                    service.getMesa(e.getId()).ifPresent(Menu::soutMesa);
                });

                case 3 -> service.serviceMesa().delete();
//
//                case 4 -> garcomImplDaoImpl.getMesasOcupadas().forEach(e -> {
//                    service.getMesa(e).ifPresent(Menu::soutMesa);
//                });
//
                case 5 -> service.getGarcom().ifPresent(Menu::soutGarcom);
//
                case 6 -> service.serviceGarcom().delete();
//
//                case 7 -> {
//                    garcomImplDao.buscarPeloEmail().ifPresent(garcomImplDao::registraGarcomMesa);
//                    mesaImplDao.getAll().forEach(Menu::soutMesa);
//                }
                case 8 -> service.serviceMesa().removerGarcom();
//
                case 9 -> service.serviceGarcom().getMesasOcupadas().forEach(e -> {
                    service.getMesa(e).ifPresent(Menu::soutMesa);
                });
//
                case 10 -> service.serviceMesa().get().ifPresent(e -> service.getMesa(e.getId()).ifPresent(mesa -> {
                    if(mesa.getGarcom() != null){
                        System.out.println("Garcom responsavel pela mesa " + mesa.getNumeroMesa() + ": " + mesa.getGarcom().getNome());
                    }else{
                        System.out.println("Nenhum garcom cadastrado nesta mesa");
                    }
                }));
//
//                case 11 -> mesaImplDao.getMesasCapacidade().forEach(Menu::soutMesa);
//
                case 12 -> service.serviceMesa().getMesasLivres().forEach(e -> {
                    service.getMesa(e).ifPresent(Menu::soutMesa);
                });
//
//                case 13 -> mesaImplDao.getAll().forEach(Menu::soutMesa);
            }
            System.out.println(menu);
            opcao = sc.scInt("Digite uma opcao: ");
        }
    }

    private static void soutMesa(Mesa mesa) {
        System.out.println("Mesas cadastradas:" + " \n");
        System.out.println(
                "Numero da mesa: " + mesa.getNumeroMesa() + "\n" +
                        " capacidade: " + mesa.getCapacidadeMesa() + "\n" +
                        " situacao: " + mesa.getSituacao().getDescricao() + "\n" +
                        " garcom: " + ((mesa.getGarcom() != null) ? mesa.getGarcom().getNome() : "Mesa sem nenhum garcom no momento") + " \n"
        );
    }

    private static void soutGarcom(Garcom garcom) {
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

//}



