package repository.imp;

import constate.TipoSituacao;
import dB.ConnectionFactory;
import model.MesaDto;
import repository.MesaDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class MesaImplDaoImpl extends ConnectionFactory implements MesaDao {
    @Override
    public void create() {
        Long numeroMesa = scLong("Digite o numero da mesa ou digite 0 para voltar ao menu:");
        if (numeroMesa == 0) return;
        Optional<MesaDto> byId = this.findByNumero(numeroMesa);
        try {
            if (byId.isEmpty()) {
                int capacidade = scInt("Digite a capacidade de mesa:");
                Short situacao = scShort("Digite 1 para LIVRE, Digite 2 para OCUPADA, digite 3 para RESERVADA: ");
                if (situacao >= 1 && situacao <= 3) {
                    Connection connection = ConnectionFactory.createConnection();
                    String query = "INSERT INTO `sistema`.`mesas` (`numero`, `capacidade`,`situacao`) VALUES (?, ?,?);";
                    PreparedStatement ps = connection.prepareStatement(query);
                    ps.setLong(1, numeroMesa);
                    ps.setLong(2, capacidade);
                    ps.setShort(3, situacao);

                    int i = ps.executeUpdate();
                    if (i == 0) {
                        System.out.println("mesa nao cadastrada verifique!");
                    } else {
                        System.out.println("mesa cadastrada !");
                    }
                } else {
                    System.out.println("Valor invalido!! ");
                }
            } else System.out.println("mesa ja cadastrada");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ArrayList<MesaDto> getAll() {
        final ArrayList<MesaDto> mesas = new ArrayList<>();
        try {
            Connection connection = ConnectionFactory.createConnection();
            String query = "select * from sistema.mesas";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet resulQuery = ps.executeQuery();
            while (resulQuery.next()) mesas.add(resultToObject(resulQuery));
            if (mesas.size() == 0) {
                System.out.println("Nenhuma mesa nao encontrada\n");
                return new ArrayList<>();
            } else {
                System.out.println(mesas.size());
                return mesas;
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
                String query = "delete from sistema.mesas where id = ?";
                PreparedStatement ps = connection.prepareStatement(query);
                ps.setLong(1, e.getId());
                int i = ps.executeUpdate();
                if (i == 0) {
                    System.out.println("Erro ao deletar Mesa");
                } else System.out.println("Mesa deletado com sucesso");
            } catch (SQLException se) {
                System.out.println(se);
            }
        });
    }

    @Override
    public void update() {

    }

    @Override
    public Optional<MesaDto> findById(Long id) {
        try {
            Connection connection = ConnectionFactory.createConnection();
            String query = "select * from sistema.mesas where id = ?";
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
    public Optional<MesaDto> get() {

        try {
            Connection connection = ConnectionFactory.createConnection();
            Long numeroMesa = scLong("Digite o numero da mesa ou digite 0 para voltar ao menu:");
            if (numeroMesa == 0) return Optional.empty();
            String query = "select * from sistema.mesas where numero = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setLong(1, numeroMesa);
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
    public Optional<TipoSituacao> getSituacaoMesa() {
        Optional<MesaDto> mesa = this.get();
        if (mesa.isPresent()) {
            try {
                Connection connection = ConnectionFactory.createConnection();
                String query = "select * from sistema.mesas where id = ?";
                PreparedStatement ps = connection.prepareStatement(query);
                ps.setLong(1, mesa.get().getId());
                ResultSet resulQuery = ps.executeQuery();
                while (resulQuery.next()) return Optional.of(resultToObject(resulQuery).getSituacao());
                System.out.println("mesa nao encontrada");
                return Optional.empty();
            } catch (SQLException se) {
                System.out.println(se);
                return Optional.empty();

            }
        } else return Optional.empty();
    }

    @Override
    public List<MesaDto> getMesasCapacidade() {
        Long capacidadeMinima = scLong("Digite a capicidade minima das mesas");
        final ArrayList<MesaDto> Mesas = new ArrayList<>();
        try {
            Connection connection = ConnectionFactory.createConnection();
            String query = "select * from sistema.mesas where capacidade = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setLong(1, capacidadeMinima);
            ResultSet resulQuery = ps.executeQuery();
            while (resulQuery.next()) Mesas.add(resultToObject(resulQuery));
            if (Mesas.size() == 0) {
                System.out.println("Nenhuma mesa nao encontrada");
                return new ArrayList<>();
            } else {
                return Mesas;
            }
        } catch (SQLException se) {
            System.out.println(se);
            return new ArrayList<>();
        }
    }

    @Override
    public List<MesaDto> getMesasSituacao() {
        final ArrayList<MesaDto> Mesas = new ArrayList<>();
        try {
            Short situacao = scShort("Digite 1 para LIVRE, Digite 2 para OCUPADA, digite 3 para RESERVADA: ");
            if (!(situacao >= 1 && situacao <= 3)) {
                System.out.println("Valor invalido!! ");
                return new ArrayList<>();
            }
            Connection connection = ConnectionFactory.createConnection();
            String query = "select * from sistema.mesas where situacao = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setShort(1, situacao);
            ResultSet resulQuery = ps.executeQuery();
            while (resulQuery.next()) Mesas.add(resultToObject(resulQuery));
            if (Mesas.size() == 0) {
                System.out.println("Nenhuma mesa nao encontrada");
                return new ArrayList<>();
            } else {
                return Mesas;
            }
        } catch (SQLException se) {
            System.out.println(se);
            return new ArrayList<>();

        }
    }

    @Override
    public List<MesaDto> getMesasOcupadas() {
        final ArrayList<MesaDto> Mesas = new ArrayList<>();
        try {
            Connection connection = ConnectionFactory.createConnection();
            String query = "select * from sistema.mesas where situacao = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setShort(1, TipoSituacao.OCUPADA.getValor());
            ResultSet resulQuery = ps.executeQuery();
            while (resulQuery.next()) Mesas.add(resultToObject(resulQuery));
            if (Mesas.size() == 0) {
                System.out.println("Nenhuma mesa nao encontrada");
                return new ArrayList<>();
            } else {
                return Mesas;
            }
        } catch (SQLException se) {
            System.out.println(se);
            return new ArrayList<>();

        }
    }

    @Override
    public List<Long> getMesasLivres() {
        final List<Long> listaIdMesas = new ArrayList<>();
        try {
            Connection connection = ConnectionFactory.createConnection();
            String query = "select m.id from sistema.mesas m where m.situacao = ? and m.id_garcom IS NOT NULL";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setLong(1, TipoSituacao.LIVRE.getValor());
            ResultSet resulQuery = ps.executeQuery();
            while (resulQuery.next()) listaIdMesas.add(resulQuery.getLong(1));
            if (listaIdMesas.size() == 0) {
                System.out.println("Nenhuma mesa nao encontrada");
                return new ArrayList<>();
            } else {
                return listaIdMesas;
            }
        } catch (SQLException se) {
            System.out.println(se);
            return new ArrayList<>();
        }
    }

    @Override
    public void removerGarcom() {
        this.get().ifPresent(e -> {
            try {
                Connection connection = ConnectionFactory.createConnection();
                String query = "UPDATE `sistema`.`mesas` SET `id_garcom` = NULL WHERE `id` = ?";
                PreparedStatement ps = connection.prepareStatement(query);
                ps.setLong(1, e.getId());
                int i = ps.executeUpdate();
                if (i == 0) {
                    System.out.println("Erro ao remover garcom da mesa");
                } else System.out.println("Garcom removido com sucesso");
            } catch (SQLException se) {
                System.out.println(se);
            }
        });
    }

    @Override
    public void registraGarcomMesa(Long idGarcom) {
        this.get().ifPresent(e -> {
            try {
                Connection connection = ConnectionFactory.createConnection();
                String query = "UPDATE `sistema`.`mesas` SET `id_garcom` = ? WHERE `id` = ?";
                PreparedStatement ps = connection.prepareStatement(query);
                ps.setLong(1, idGarcom);
                ps.setLong(2, e.getId());
                int i = ps.executeUpdate();
                if (i == 0) {
                    System.out.println("Erro ao registrar garcom na mesa");
                } else System.out.println("Garcom registrado na mesa");
            } catch (SQLException se) {
                System.out.println(se);
            }
        });
    }

    @Override
    public void atualizaStatusMesa() {
        this.get().ifPresent(e ->{
            Short situacao = scShort("Digite 1 para LIVRE, Digite 2 para OCUPADA, digite 3 para RESERVADA: ");
            if (!(situacao >= 1 && situacao <= 3)) {
                System.out.println("Valor invalido!! ");
            }else{
                try {
                    Connection connection = ConnectionFactory.createConnection();
                    String query = "UPDATE `sistema`.`mesas` SET `situacao` = ? WHERE `id` = ?";
                    PreparedStatement ps = connection.prepareStatement(query);
                    ps.setLong(1, situacao);
                    ps.setLong(2, e.getId());
                    int i = ps.executeUpdate();
                    if (i == 0) {
                        System.out.println("Erro atualizar status mesa");
                    } else System.out.println("Status mesa atualizado");
                } catch (SQLException se) {
                    System.out.println(se);
                }
            }
        });
    }

    public Optional<MesaDto> findByNumero(Long numeroMesa) {
        try {
            Connection connection = ConnectionFactory.createConnection();
            if (numeroMesa == 0) return Optional.empty();
            String query = "select * from sistema.mesas where numero = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setLong(1, numeroMesa);
            ResultSet resulQuery = ps.executeQuery();
            while (resulQuery.next()) return Optional.of(resultToObject(resulQuery));
            return Optional.empty();
        } catch (SQLException se) {
            System.out.println(se);
            return Optional.empty();

        }
    }

    private MesaDto resultToObject(ResultSet resultSet) {
        try {
            MesaDto mesaTransfer = new MesaDto(resultSet.getLong(1),
                    resultSet.getLong(2),
                    resultSet.getInt(3),
                    TipoSituacao.getInstance(resultSet.getShort(4)),
                    resultSet.getLong(5));
            return mesaTransfer;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
