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

public class GarcomImplDaoImpl extends ConnectionFactory implements GarcomDao {

    @Override
    public void create() {

    }

    @Override
    public ArrayList<Garcom> getAll() {
        final ArrayList<Garcom> garcoms = new ArrayList<>();
        try {
            Connection connection = ConnectionFactory.createConnection();
            String query = "select * from sistema.garcoms";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet resulQuery = ps.executeQuery();
            while (resulQuery.next()) garcoms.add(resultToObject(resulQuery));
            if (garcoms.size() == 0) {
                System.out.println("Nenhuma mesa nao encontrada\n");
                return new ArrayList<>();
            } else {
                System.out.println(garcoms.size());
                return garcoms;
            }
        } catch (SQLException se) {
            System.out.println(se);
            return null;

        }
    }

    @Override
    public void delete() {
        this.get().ifPresent(e -> {
            try {
                Connection connection = ConnectionFactory.createConnection();
                String query = "delete from sistema.garcoms where id = ?";
                PreparedStatement ps = connection.prepareStatement(query);
                ps.setLong(1, e.getId());
                int i = ps.executeUpdate();
                if (i == 0) {
                    System.out.println("Erro ao deletar Garcom");
                } else System.out.println("Garcom deletado com sucesso");
            } catch (SQLException se) {
                System.out.println(se);
            }
        });
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
        String emailGarcom = scString("Digite o email do garcom: ");
        try {
            Connection connection = ConnectionFactory.createConnection();
            String query = "select * from sistema.garcoms where email = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, emailGarcom);
            ResultSet resulQuery = ps.executeQuery();
            while (resulQuery.next()) return Optional.of(resultToObject(resulQuery));
            return Optional.empty();
        } catch (SQLException se) {
            System.out.println(se);
            return Optional.empty();
        }
    }


    @Override
    public List<Long> getMesas(Long id) {
            final List<Long> listaIdMesas = new ArrayList<>();
            try {
                Connection connection = ConnectionFactory.createConnection();
                String query = "select m.id from sistema.garcoms g ,sistema.mesas m where g.id = ? and g.id = m.id_garcom";
                PreparedStatement ps = connection.prepareStatement(query);
                ps.setLong(1, id);
                ResultSet resulQuery = ps.executeQuery();
                while (resulQuery.next()) {
                    listaIdMesas.add(resulQuery.getLong(1));
                }
                if (listaIdMesas.size() == 0) {
                    System.out.println("Nenhuma mesa nao encontrada\n");
                    return new ArrayList<>();
                } else return listaIdMesas;

            } catch (SQLException se) {
                System.out.println(se);
                return null;
            }
    }

    @Override
    public void registraGarcomMesa() {
    }

    @Override
    public List<Long> getMesasOcupadas() {
        Optional<Garcom> garcom = this.get();
        if (garcom.isPresent()) {
            final List<Long> listaIdMesas = new ArrayList<>();
            try {
                Connection connection = ConnectionFactory.createConnection();
                String query = "select m.id from sistema.garcoms g ,sistema.mesas m where g.id = ? and g.id = m.id_garcom and m.situacao_mesa = ?";
                PreparedStatement ps = connection.prepareStatement(query);
                ps.setLong(1, garcom.get().getId());
                ps.setLong(2, TipoSituacao.OCUPADA.getValor());
                ResultSet resulQuery = ps.executeQuery();
                while (resulQuery.next()) {
                    listaIdMesas.add(resulQuery.getLong(1));
                }
                if (listaIdMesas.size() == 0) {
                    System.out.println("Nenhuma mesa nao encontrada\n");
                    return new ArrayList<>();
                } else return listaIdMesas;

            } catch (SQLException se) {
                System.out.println(se);
                return null;
            }
        } else return new ArrayList<>();
    }

//    @Override
//    public List<Long> getMesasLivres() {
//        final List<Long> listaIdMesas = new ArrayList<>();
//        try {
//            Connection connection = ConnectionFactory.createConnection();
//            String query = "select m.id from sistema.mesas m where m.situacao_mesa = ? and m.id_garcom IS NOT NULL";
//            PreparedStatement ps = connection.prepareStatement(query);
//            ps.setLong(1, TipoSituacao.LIVRE.getValor());
//            ResultSet resulQuery = ps.executeQuery();
//            while (resulQuery.next()) {
//                listaIdMesas.add(resulQuery.getLong(1));
//            }
//            if (listaIdMesas.size() == 0) {
//                System.out.println("Nenhuma mesa nao encontrada\n");
//                return new ArrayList<>();
//            } else return listaIdMesas;
//
//        } catch (SQLException se) {
//            System.out.println(se);
//            return null;
//
//        }
//    }



    @Override
    public List<MesaDto> getMesasQuantidade() {
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
