package com.dao;

import com.valsoft.Book;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Rekdon on 11.05.2017.
 */
public class Main {
    public static void main(String[] args) throws SQLException {
        //  StorageDAO databaseDao = DatabaseDAO.getInstance();
        DatabaseDAO databaseDAO = DatabaseDAO.getInstance();
       //     databaseDAO.saveBook(new Book("book2",25.5,399,2000,4));
        List<Book> bookList = databaseDAO.allBooks();
        for (int i = 0; i < bookList.size(); i++) {
            System.out.println(bookList.get(i).getTitle() + " "
                    + bookList.get(i).getPrice() + " " +
                    bookList.get(i).getPages() + " " +
                    bookList.get(i).getYear() + " " +
                    bookList.get(i).getId());
        }
        System.out.println(databaseDAO.deleteBook(new Book("Титульна1", 400, 500, 1997, 1)));
        databaseDAO.updateBook(new Book("book4", 26.5, 3929, 22006, 3));
      //  System.out.println(databaseDAO.getBook(2));

    }
}
