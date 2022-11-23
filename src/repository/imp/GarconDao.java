package repository.imp;

import constate.TipoSexo;
import model.Garcon;

import repository.Dao;
import repository.DaoGarcon;
import utils.CustomScanner;

import java.util.*;

public class GarconDao extends CustomScanner implements Dao<Garcon>, DaoGarcon {

    private ArrayList<Garcon> garcons = new ArrayList<>();

    @Override
    public List<Garcon> getAll() {
        return garcons;
    }


    public Optional<Garcon> get(int value) {

        String email = scString("Digite o email do garcom ou digite SAIR");
        if(email.toUpperCase().equals("sair")) Optional.empty();
        Optional<Garcon> garcon = garcons.stream().filter(e -> Objects.equals(e.getEmail(), email)).findAny();
        if (garcon.isEmpty()) System.out.println("garcom nao encontrado");
        return garcon;
    }

    @Override
    public void update(int value) {
        this.get(0).ifPresent(e -> {
            switch (value) {
                case 1: {
                    e.setEmail(scString("Digite um novo email: "));
                }
                case 2: {
                    e.setSalarioFixo(scDouble("Digite o novo salario: "));
                }
            }
            garcons.add(e);
        });
    }

    @Override
    public void delete() {
        this.get(0).ifPresent(e -> {
            System.out.println("Garcom " + e.getNome() + " foi removido do sistema");
            garcons.remove(e);
        });
    }

    @Override
    public void create() {
        String nome = scString("Digite o nome do garcom:");
        String email = scString("Digite o email do garcom:");
        String cpf = scString("Digite o cpf garcom:");
        List<Garcon> all = this.getAll();
        if (all.size() > 0 && all.stream().filter(e -> e.getCpf().equals(cpf)).toList().size() > 0) {
            System.out.println("cpf ja foi registrado");
        } else {
            garcons.add(new Garcon(nome,
                    cpf,
                    scString("Digite a data de nascimento do garcom:"),
                    email,
                    scLong("Digite o telefone do garcom:"),
                    TipoSexo.getInstance(scShort("digite 1 para masculino e 2 para feminino")),
                    scDouble("Digite o salario do garcom:")
            ));
        }
    }

}
