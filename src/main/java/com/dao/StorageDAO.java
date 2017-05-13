package com.dao;

import com.valsoft.Book;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Rekdon on 11.05.2017.
 */
public interface StorageDAO {

    void saveBook(Book book) throws SQLException;
    List<Book> allBooks() throws SQLException;
    boolean deleteBook(Book book) throws SQLException;
    public void updateBook(Book book,int id) throws SQLException;
    public Book getBook(int id) throws SQLException;
}
