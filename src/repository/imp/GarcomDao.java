package repository.imp;

import constate.TipoSexo;
import model.Garcom;

import model.Mesa;
import repository.Dao;
import repository.DaoGarcom;
import utils.CustomScanner;

import java.util.*;

public class GarcomDao extends CustomScanner implements DaoGarcom {

    @Override
    public void create() {

    }

    @Override
    public List<Garcom> getAll() {
        return null;
    }

    @Override
    public void delete() {

    }

    @Override
    public void update() {

    }

    @Override
    public Optional<Garcom> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Garcom> get() {
        return Optional.empty();
    }

    public Optional<Garcom> buscarPeloEmail(){
        return Optional.empty();
    }

    @Override
    public List<Mesa> getMesas(Garcom garcom) {
        return null;
    }

    @Override
    public void registraGarcomMesa(Garcom garcom) {

    }

    @Override
    public List<Mesa> getMesasOcupadas(Garcom garcom) {
        return null;
    }

    @Override
    public List<Mesa> getMesasLivres(Garcom garcom) {
        return null;
    }

    @Override
    public List<Mesa> getMesasQuantidade(Garcom garcom) {
        return null;
    }
}
