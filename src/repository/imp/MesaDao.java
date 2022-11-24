package repository.imp;

import constate.TipoSituacao;
import model.Garcom;
import model.Mesa;
import repository.Dao;
import repository.DaoMesa;
import utils.CustomScanner;

import java.util.*;

public class MesaDao extends CustomScanner implements Dao<Mesa>, DaoMesa {

    private ArrayList<Mesa> mesas = new ArrayList<>();

    @Override
    public void create() {

        int listaMesa = mesas.size();
        Long numeroMesa = scLong("Digite o numero da mesa ou digite 0 para voltar ao menu:");
        if (numeroMesa == 0) return;

        Optional<Mesa> any = mesas.stream()
                .filter(e -> Objects.equals(e.getNumeroMesa(), numeroMesa)).findAny();


        int capacidade = scInt("Digite a capacidade de mesa:");
        Short situacao = scShort("Digite 1 para LIVRE, Digite 2 para OCUPADA, digite 3 para RESERVADA: ");

        if (situacao >= 1 && situacao <= 3) {
            if (any.isEmpty()) {
                mesas.add(new Mesa(numeroMesa,
                        capacidade,
                        TipoSituacao.getInstance(situacao)
                ));
                if (mesas.size() > listaMesa) System.out.println("Mesa Cadastrada com sucesso");
            } else {
                System.out.println("Mesa ja cadastrada !!");
            }
        } else {
            System.out.println("Valor invalido!! ");
        }
    }

    @Override
    public ArrayList<Mesa> getAll() {
        return mesas;
    }

    @Override
    public Optional<Mesa> get(int value) {
        if (value == 1) {
            final Long aLong = scLong("Digite o numero da mesa a ser deletada ou digite 0 para voltar ao menu:");
            if (aLong == 0) return Optional.empty();
            Optional<Mesa> any = mesas.stream().filter(e -> Objects.equals(e.getNumeroMesa(), aLong)).findAny();
            if (any.isEmpty()) System.out.println("mesa nao encontrada");
            return any;
        }
        final Long aLong = scLong("Digite o numero da mesa: ");
        Optional<Mesa> any = mesas.stream()
                .filter(e -> Objects.equals(e.getNumeroMesa(), aLong)).findAny();
        if (any.isEmpty()) System.out.println("mesa nao encontrada");
        return any;

    }

    @Override
    public void update(int value) {
        this.get((short) 0).ifPresent(e -> {
            switch (value) {
                case 1 -> e.setCapacidadeMesa(scInt("Digite uma nova capacidade: "));
                case 2 -> e.setSituacao(TipoSituacao.getInstance(scShort("Digite 1 para LIVRE, Digite 2 para OCUPADA, digite 3 para RESERVADA: ")));
                case 3 -> e.setNumeroMesa(scLong("Digite um novo numero para a mesa: "));
                case 4 -> { e.setSituacao(TipoSituacao.LIVRE);  e.setGarcom(null); }
            }
        });
    }

    @Override
    public void delete() {
        this.get(1).ifPresent(e -> {
            mesas.remove(e);
            System.out.println("numero da mesa: " + e.getNumeroMesa() + " deletada");
        });
    }


    @Override
    public List<Mesa> getMesasCapacidade() {
        final int valor = scInt("Digite a capacidade da sua mesa: ");
        return mesas.stream().filter(e -> valor >= e.getCapacidadeMesa()).toList();
    }

    public List<Mesa> getMesasSituacao() {
        final Long tipoSituacao = scLong("Digite o numero da mesa a ser deletada: ");
        return this.getAll().stream().filter(e -> Objects.equals(e.getSituacao().getValor(), tipoSituacao)).toList();
    }


    public List<Mesa> getMesasGarcom() {
        return this.getAll().stream().filter(e -> e.getGarcom() != null).toList();
    }

    public List<Mesa> getMesasOcupadas() {
        return this.getAll().stream().filter(e -> Objects.equals(e.getSituacao().getValor(), TipoSituacao.OCUPADA.getValor())).toList();
    }

    @Override
    public void registraGarcomMesa(Garcom garcom) {
        Optional<Mesa> mesa = this.get((short) 0);
        if (mesa.isPresent()) {
            Optional<Mesa> mesaLivre = mesa.filter(value -> Objects.equals(value.getSituacao().getValor(), TipoSituacao.LIVRE));
            if (mesaLivre.isPresent()) {
                System.out.println("Mesa indisponivel no momento: ");
            } else {
                Mesa mesaSelecionada = mesa.get();
                mesaSelecionada.setSituacao(TipoSituacao.OCUPADA);
                mesaSelecionada.setGarcom(garcom);
                garcom.setMesa(mesa.get());
            }
        }
    }

}