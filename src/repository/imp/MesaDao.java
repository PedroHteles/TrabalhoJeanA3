package repository.imp;

import constate.TipoSituacao;
import dB.ConnectionFactory;
import model.Garcom;
import model.Mesa;
import repository.Dao;
import repository.DaoMesa;
import utils.CustomScanner;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class MesaDao extends CustomScanner implements Dao<Mesa>, DaoMesa {


    @Override
    public void create() {
        Long numeroMesa = scLong("Digite o numero da mesa ou digite 0 para voltar ao menu:");
        if (numeroMesa == 0) return;
        Optional<Mesa> byId = this.findById(numeroMesa);
        try {
        if(!byId.isPresent()){
            int capacidade = scInt("Digite a capacidade de mesa:");
            Short situacao = scShort("Digite 1 para LIVRE, Digite 2 para OCUPADA, digite 3 para RESERVADA: ");
            if (situacao >= 1 && situacao <= 3) {
                Connection connection = ConnectionFactory.createConnection();
                String query = "INSERT INTO `sistema`.`mesas` (`numero_mesa`, `capacidade_mesa`,`situacao_mesa`) VALUES (?, ?,?);";
                PreparedStatement ps = connection.prepareStatement(query);
                ps.setLong(1,numeroMesa);
                ps.setLong(2,capacidade);
                ps.setShort(3,situacao);

                int i = ps.executeUpdate();
                if(i==0){
                    System.out.println("mesa nao cadastrada verifique!");
                }else{
                    System.out.println("mesa cadastrada !");
                }
            } else {
                System.out.println("Valor invalido!! ");
            }
        }else System.out.println("mesa ja cadastrada");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    @Override
    public Optional<Mesa> get() {
        return Optional.empty();
    }

    @Override
    public ArrayList<Mesa> getAll() {
        final ArrayList<Mesa> Mesas = new ArrayList<>();
        try {
            Connection connection = ConnectionFactory.createConnection();
            String query = "select * from sistema.mesas";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet resulQuery = ps.executeQuery();
            while (resulQuery.next())  Mesas.add(resultToObject(resulQuery));
            if(Mesas.size() == 0) {
                System.out.println("Nenhuma mesa nao encontrada");
                return new ArrayList<>();
            }else{
                return Mesas;
            }
        } catch (SQLException se) {
            System.out.println(se);
            return null;

        }
    }

    @Override
    public void update() {
    }

    @Override
    public Optional<Mesa> findById(Long id) {
        try {
            Connection connection = ConnectionFactory.createConnection();
            String query = "select * from sistema.mesas where id = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setLong(1,id);
            ResultSet resulQuery = ps.executeQuery();
            while (resulQuery.next()) return Optional.of(resultToObject(resulQuery));
            System.out.println("mesa nao encontrada");
            return Optional.empty();
        } catch (SQLException se) {
            System.out.println(se);
            return Optional.empty();

        }
    }

    @Override
    public void delete() {

    }


    // motodos Mesa adicionais
    @Override
    public List<Mesa> getMesasCapacidade() {

        return null;
    }

    public List<Mesa> getMesasSituacao() {

        return null;
    }


    public List<Mesa> getMesasGarcom() {

        return null;
    }

    public List<Mesa> getMesasOcupadas() {

        return null;
    }

    @Override
    public void registraGarcomMesa(Garcom garcom) {
    }


    private Mesa resultToObject(ResultSet resultSet){
        Mesa selectObj = new Mesa();
        try {
            selectObj.setId(resultSet.getLong(1));
            selectObj.setNumeroMesa(resultSet.getLong(2));
            selectObj.setCapacidadeMesa(resultSet.getInt(3));
            selectObj.setSituacao(TipoSituacao.getInstance(resultSet.getShort(4)));
            return selectObj;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
