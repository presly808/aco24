package week3.mvc.db;

import java.sql.*;

public class DataBaseMysql {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306?useUnicode=true" +
            "&useJDBCCompliantTimezoneShift=true" +
            "&useLegacyDatetimeCode=false&serverTimezone=UTC";

    //  Database credentials
    static final String USER = "admin";
    static final String PASS = "password";

    Statement stament = null;

    public DataBaseMysql() {

        initDb();

    }


    private void initDb() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS); Statement stmt = conn.createStatement();) {

            System.out.println("Connecting to database...");
            System.out.println("Creating databases:");

            stmt.executeUpdate("CREATE DATABASE IF NOT EXISTS ServiceCenter;");
            stmt.executeUpdate("USE ServiceCenter;");
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS workers (Name VARCHAR(50), PhoneNumber VARCHAR(15),  Salary DOUBLE(10,2), StartWorkDate DATE);");
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS users (Name varchar(50), PhoneNumber varchar(15));");
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS tickets (ItemId int(4), Id int(4), Status varchar(15), FixHours int(2), User varchar(15));");
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS items (Model varchar(50), Type varchar(15), State varchar(10));");

            System.out.println("Database created successfully...");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void execureQurey(String query) {
        try {
            stament.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}