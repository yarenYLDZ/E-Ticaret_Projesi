package E_TicaretProjesi.dao;

import E_TicaretProjesi.model.Customer;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {

    private final String saveScript = """
            
            INSERT INTO customer (name,email,password) VALUES(?,?,?)
            """;

    private final String findByIdScript = """
            SELECT * FROM customer WHERE id =?
            """;

    private final String findAllScript = """
            SELECT * FROM customer
            """;

    private final String existByEmailScrit = """
            SELECT * FROM customer WHERE email = ? 
            """;

    public void save(Customer customer) {
        String url = "jdbc:postgresql://localhost:5432/patika_store";
        String user = "postgres";            // ← Veritabanı kullanıcı adın
        String password = "1234";    // ← Veritabanı şifren

        try {
            Connection connection = DriverManager.getConnection(url, user, password);

            PreparedStatement ps = connection.prepareStatement(saveScript);
            ps.setString(1, customer.getName());
            ps.setString(2, customer.getEmail());
            ps.setString(3, customer.getPassword());

            ps.executeUpdate(); // ← Veritabanına ekleme işlemini tamamla

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public Customer findById(long id){

        String url = "jdbc:postgresql://localhost:5432/patika_store";
        String user = "postgres";            // ← Veritabanı kullanıcı adın
        String password = "1234";    // ← Veritabanı şifren
        Customer customer = null;
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            PreparedStatement ps = connection.prepareStatement(findByIdScript);
            ps.setLong(1,id);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){

                customer = new Customer();
                customer.setId(rs.getLong("id"));
                customer.setName(rs.getString("name"));
                customer.setEmail(rs.getString("email"));
                customer.setCreateDate(new Timestamp(rs.getDate("createddate").getTime()).toLocalDateTime());
                customer.setUpdatedDate(new Timestamp(rs.getDate("updateddate").getTime()).toLocalDateTime());

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return customer;
    }
    public List<Customer> findAll(){

        String url = "jdbc:postgresql://localhost:5432/patika_store";
        String user = "postgres";            // ← Veritabanı kullanıcı adın
        String password = "1234";    // ← Veritabanı şifren

        List<Customer> customers = new ArrayList<>();

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement stmt= connection.createStatement();

            ResultSet rs = stmt.executeQuery(findAllScript);

            while(rs.next()){

                Customer customer = new Customer();
                customer.setId(rs.getLong("id"));
                customer.setName(rs.getString("name"));
                customer.setEmail(rs.getString("email"));
                customer.setCreateDate(new Timestamp(rs.getDate("createddate").getTime()).toLocalDateTime());
                customer.setUpdatedDate(new Timestamp(rs.getDate("updateddate").getTime()).toLocalDateTime());
                customers.add(customer);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return customers;
    }

    public boolean existByEmail(String email) {

        String url = "jdbc:postgresql://localhost:5432/patika_store";
        String user = "postgres";            // ← Veritabanı kullanıcı adın
        String password = "1234";    // ← Veritabanı şifren

        try {
            Connection connection = DriverManager.getConnection(url, user, password);

            PreparedStatement ps= connection.prepareStatement(existByEmailScrit);
            ps.setString(1,email);
            ResultSet rs = ps.executeQuery();
            return rs.next();

    } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    public Customer findByEmail(String email) {
        String url = "jdbc:postgresql://localhost:5432/patika_store";
        String user = "postgres";            // ← Veritabanı kullanıcı adın
        String password = "1234";    // ← Veritabanı şifren
        Customer customer = null;
        try {
            Connection connection = DriverManager.getConnection(url, user, password);

            PreparedStatement ps= connection.prepareStatement(existByEmailScrit);
            ps.setString(1,email);
            ResultSet rs = ps.executeQuery();


            while(rs.next()){
                customer = new Customer();
                customer.setId(rs.getLong("id"));
                customer.setName(rs.getString("name"));
                customer.setEmail(rs.getString("email"));
                customer.setPassword(rs.getString("password"));
                customer.setCreateDate(new Timestamp(rs.getDate("createddate").getTime()).toLocalDateTime());
                customer.setUpdatedDate(new Timestamp(rs.getDate("updateddate").getTime()).toLocalDateTime());

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }
}
