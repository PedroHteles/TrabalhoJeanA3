package service;

import model.Garcom;
import model.Mesa;
import model.MesaDto;
import repository.imp.GarcomImplDaoImpl;
import repository.imp.MesaImplDaoImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ServiceImpl implements Service {

    private final MesaImplDaoImpl  mesaImplDaoImpl = new MesaImplDaoImpl();
    private final GarcomImplDaoImpl garcomImplDaoImpl = new GarcomImplDaoImpl();
    public MesaImplDaoImpl serviceMesa(){
        return mesaImplDaoImpl;
    }

    public GarcomImplDaoImpl serviceGarcom(){
        return garcomImplDaoImpl;
    }


    @Override
    public Optional<Mesa> getMesa(Long id) {
        Optional<MesaDto> mesaDto = mesaImplDaoImpl.findById(id);

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
        ArrayList<Mesa> mesas = new ArrayList<>();
        Optional<Garcom> garcom = garcomImplDaoImpl.get();
        garcom.ifPresent(e ->{
            garcomImplDaoImpl.getMesas(e.getId()).forEach(idMesa-> {
                Optional<Mesa> mesa = this.getMesa(idMesa);
                mesa.ifPresent(m -> mesas.add(m));
            });
            garcom.get().setListaMesas(mesas);
        });
        return garcom;
    }

    @Override
    public List<Garcom> getGarcoms() {
        return null;
    }
}
