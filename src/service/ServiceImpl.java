package service;

import model.Garcom;
import model.Mesa;
import model.MesaDto;
import repository.GarcomDao;
import repository.MesaDao;
import repository.imp.GarcomImplDaoImpl;
import repository.imp.MesaImplDaoImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ServiceImpl implements Service {

    private final MesaImplDaoImpl  mesaImplDaoImpl = new MesaImplDaoImpl();
    private final GarcomImplDaoImpl garcomImplDaoImpl = new GarcomImplDaoImpl();

    @Override
    public Optional<Mesa> getMesa() {
        Optional<MesaDto> mesaDto = mesaImplDaoImpl.get();
        if(mesaDto.isPresent()){
            Mesa mesa = new Mesa(mesaDto.get());
            Optional<Garcom> byId = garcomImplDaoImpl.findById(mesaDto.get().getIdGarcom());
            byId.ifPresent(mesa::setGarcom);
            return Optional.of(mesa);
        }else return Optional.empty();
    }

    @Override
    public ArrayList<Mesa> getMesas() {
        ArrayList<Mesa> mesas = new ArrayList<>();
        mesaImplDaoImpl.getAll().forEach(e -> {
            Mesa mesa = new Mesa(e);
            Optional<Garcom> byId = garcomImplDaoImpl.findById(e.getIdGarcom());
            byId.ifPresent(mesa::setGarcom);
            mesas.add(mesa);
        });
        return  mesas;
    }

    @Override
    public Optional<Garcom> getGarcom() {
        return Optional.empty();
    }

    @Override
    public List<Garcom> getGarcoms() {
        return null;
    }
}
