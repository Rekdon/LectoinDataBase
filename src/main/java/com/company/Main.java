package com.company;

import java.sql.*;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException {
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = null;
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "Vlad1998");
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM goods ";
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                int price = rs.getInt("price");
                String shop = rs.getString("shop");
                System.out.println(id + "." + name + " - " + description + " - " + price + " - " + shop);
            }
            rs.close();
            statement.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            Connection con = null;
            try {
                con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "Vlad1998");
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            Statement stmt = null;
            try {
                stmt = con.createStatement();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            String query = "INSERT INTO goods(id, name, description,price,shop) \n" + " VALUES (7, 'Ring', 'Golden Ring',15000,'Golden Age')";
            stmt.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = null;
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "Vlad1998");
            Statement statement = connection.createStatement();
            String query = "DELETE FROM goods where id = 3";
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                int price = rs.getInt("price");
                String shop = rs.getString("shop");
                System.out.println(id + "." + name + " - " + description + " - " + price + " - " + shop);
            }
            rs.close();
            statement.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}