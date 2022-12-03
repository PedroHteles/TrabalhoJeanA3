package repository.imp;

import dB.ConnectionFactory;
import model.Garcom;

import model.Mesa;
import repository.GarcomDao;
import utils.CustomScanner;

import java.util.*;

public class GarcomImplDaoImpl extends ConnectionFactory  implements GarcomDao {

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
