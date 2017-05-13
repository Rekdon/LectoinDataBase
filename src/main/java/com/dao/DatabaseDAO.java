package com.dao;

import com.valsoft.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Rekdon on 11.05.2017.
 */
public class DatabaseDAO implements StorageDAO {

    private static String URL = "jdbc:postgresql://localhost:5433/postgres";
    private static String USER = "postgres";
    private static String PASSWORD = "Vlad1998";

    private static DatabaseDAO instance;

    public static DatabaseDAO getInstance() throws SQLException {
        if (instance == null) {
            instance = new DatabaseDAO();
        }
        return instance;
    }

    private DatabaseDAO() throws SQLException {
      connection = DriverManager.getConnection(URL,USER,PASSWORD);
    }

    private Connection connection;

    public void saveBook(Book book) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(
                "INSERT INTO book (title,price,page,year,id)" +
                        " VALUES (?,?,?,?,?)");
        ps.setString(1,book.getTitle());
        ps.setDouble(2,book.getPrice());
        ps.setInt(3,book.getPages());
        ps.setInt(4,book.getYear());
        ps.setInt(5,book.getId());
        ps.execute();
        ps.close();
    }


    public List<Book> allBooks() throws SQLException {
        List<Book> result = new ArrayList<Book>();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("SELECT title,price,page,year,id FROM book");
        while(rs.next())
        {
            result.add(new Book(rs.getString("title"),
                    rs.getDouble("price"),
                    rs.getInt("page"),
                    rs.getInt("year"),
                    rs.getInt("id")));
        }
        //join пошукати
        return result;
    }

    public boolean deleteBook(Book book) throws SQLException {
        String delete = "DELETE FROM book where id = ?";
        PreparedStatement statement = connection.prepareStatement(delete);
        statement.setInt(1, book.getId());

        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        return rowDeleted;

    }

    public void updateBook(Book book,int id1) throws SQLException {
        String sql = "UPDATE book SET title = ?, price = ?, page = ?, year = ?,id = ?";
        sql += " where id = ?";

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, book.getTitle());
        statement.setDouble(2, book.getPrice());
        statement.setInt(3, book.getPages());
        statement.setInt(4, book.getYear());
        statement.setInt(5, book.getId());
        statement.setInt(6, id1);


        statement.close();

    }

    public Book getBook(int id) throws SQLException {
        Book book = null;
        String sql = "SELECT * FROM book WHERE id = ?";

        PreparedStatement statement =connection.prepareStatement(sql);
        statement.setInt(1, id);

        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            String title = resultSet.getString("title");
            double price = resultSet.getDouble("price");
            int page = resultSet.getInt("page");
            int year = resultSet.getInt("year");
            int id1 = resultSet.getInt("id");

            book = new Book(title, price, page, year,id1);
        }

        resultSet.close();
        statement.close();

        return book;
    }
}
