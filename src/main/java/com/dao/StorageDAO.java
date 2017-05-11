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
}
