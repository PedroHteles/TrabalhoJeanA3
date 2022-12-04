package repository.imp;

import constate.TipoSexo;
import constate.TipoSituacao;
import dB.ConnectionFactory;
import model.Garcom;

import model.Mesa;
import model.MesaDto;
import repository.GarcomDao;
import utils.CustomScanner;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
        try {
            Connection connection = ConnectionFactory.createConnection();
            String query = "select * from sistema.garcoms where id = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setLong(1, id);
            ResultSet resulQuery = ps.executeQuery();
            while (resulQuery.next()) return Optional.of(resultToObject(resulQuery));
            return Optional.empty();
        } catch (SQLException se) {
            System.out.println(se);
            return Optional.empty();
        }
    }

    @Override
    public Optional<Garcom> get() {
        return Optional.empty();
    }



    @Override
    public List<MesaDto> getMesas(Garcom garcom) {
        return null;
    }

    @Override
    public void registraGarcomMesa(Garcom garcom) {

    }

    @Override
    public List<MesaDto> getMesasOcupadas(Garcom garcom) {
        return null;
    }

    @Override
    public List<MesaDto> getMesasLivres(Garcom garcom) {
        return null;
    }

    @Override
    public List<MesaDto> getMesasQuantidade(Garcom garcom) {
        return null;
    }

    private Garcom resultToObject(ResultSet resultSet) {

        try {
            Garcom garcom = new Garcom(resultSet.getLong(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getDate(4),
                    resultSet.getString(5),
                    resultSet.getLong(7),
                    TipoSexo.getInstance(resultSet.getShort(7)),
                    resultSet.getDouble(8));
            return garcom;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
