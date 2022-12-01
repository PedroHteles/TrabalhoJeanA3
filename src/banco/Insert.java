package banco;

import java.sql.*;

public class Insert {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();;
        }
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sistema","root","password");
            Statement st = con.createStatement();
        ){
            String query = "select * from mesas";
                    st.execute(query);
            ResultSet resultSet = st.getResultSet();
            while (resultSet.next()){
                System.out.println(resultSet.getInt(1));
                System.out.println(resultSet.getLong(2));
                System.out.println(resultSet.getInt(3));
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
