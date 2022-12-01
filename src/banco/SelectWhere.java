package banco;

import constate.TipoSexo;
import constate.TipoSituacao;
import model.Garcom;
import model.Mesa;

import java.sql.*;

public class SelectWhere {
    public static void main(String[] args) {

        Mesa mesa = selectWhereId(1L);
        System.out.println(mesa.getGarcom().getEmail());
    }

    private static Mesa selectWhereId(Long id) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            ;
        }

        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sistema", "root", "password");
             Statement st = con.createStatement();
        ) {
            String query = "select * from mesas where id= " + id;
            st.execute(query);
            ResultSet resultSet = st.getResultSet();
            while (resultSet.next()) {
                Mesa selectObj = new Mesa();
                selectObj.setId(resultSet.getInt(1));
                selectObj.setNumeroMesa(resultSet.getLong(2));
                selectObj.setCapacidadeMesa(resultSet.getInt(3));
                selectObj.setSituacao(TipoSituacao.getInstance(resultSet.getShort(4)));
                String queryGarcom = "select * from garcoms where id = " + resultSet.getLong(5);
                Statement st1 = con.createStatement();
                st1.execute(queryGarcom);
                ResultSet resultSet1 = st1.getResultSet();
                while (resultSet1.next()) {
                    resultSet1.getInt(1);
                    Garcom garcomSistema = new Garcom(
                            resultSet1.getString(2),
                            resultSet1.getString(3),
                            resultSet1.getString(4),
                            resultSet1.getString(5),
                            resultSet1.getLong(6),
                            TipoSexo.getInstance(resultSet1.getShort(7)),
                            resultSet1.getDouble(8)
                    );
                    selectObj.setGarcom(garcomSistema);
                }
                return selectObj;
            }
        } catch (SQLException se) {
            System.out.println(se.getMessage());
            se.printStackTrace();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
}

