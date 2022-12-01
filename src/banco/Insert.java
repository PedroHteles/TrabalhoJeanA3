package banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Insert {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();;
        }
        try (Connection con = DriverManager.getConnection("jdbc:mysql//localhost:3306/sistema","root","password");
            Statement st = con.createStatement();
        ){
            String query = "select * from mesas";
                    st.execute(query);
        } catch (SQLException se) {
            System.out.println(se.getMessage());
            se.printStackTrace();
        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
