package RRC04.AarogyaHospital;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class createCon {

    static Connection setConnection() throws SQLException, ClassNotFoundException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/PATIENT" , "root", "sespl!@3");
        return connection;
    }

}
