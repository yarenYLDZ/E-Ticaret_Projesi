package E_TicaretProjesi.model;

import java.sql.*;

public class JdbcMain {

    public static void main(String[] args) throws SQLException {

        String url = "jdbc:postgresql://localhost:5432/patika_store";
        String user = "postgres";
        String password = "1234";

        Connection connection = DriverManager.getConnection(url,user,password);

        System.out.println("DB Baglantisi Gerceklesti");

        Statement  statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("SELECT * FROM customer");


    }
}
