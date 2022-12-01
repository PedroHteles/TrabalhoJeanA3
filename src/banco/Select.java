package banco;

import constate.TipoSituacao;
import model.Garcom;
import model.Mesa;

import java.sql.*;

public class Select {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();;
        }
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sistema","root","password");
             Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/sistema","root","password");
            Statement st = con.createStatement();
        ){
            String query = "select * from mesas";
                    st.execute(query);
            ResultSet resultSet = st.getResultSet();


            while (resultSet.next()){
                Mesa selectObj = new Mesa();
                Garcom garcomRelacionado = new Garcom();
                selectObj.setId(resultSet.getInt(1));
                selectObj.setNumeroMesa(resultSet.getLong(2));
                selectObj.setCapacidadeMesa(resultSet.getInt(3));
                selectObj.setSituacao(TipoSituacao.getInstance(resultSet.getShort(4)));
                String queryGarcom = "select * from garcoms where id = " + resultSet.getLong(5);
                System.out.println(queryGarcom);
                Statement st1 = con.createStatement();
                st1.execute(queryGarcom);
                ResultSet resultSet1 = st1.getResultSet();
                while (resultSet1.next()){
                    resultSet1.getInt(1);
                }



//                selectObj.setIdGarcom(resultSet.getLong(6));
            }
        } catch (SQLException se) {
            System.out.println(se.getMessage());
            se.printStackTrace();
        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }
}
