package com.dao;

import com.valsoft.Book;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Rekdon on 11.05.2017.
 */
public class Main {
    public static void main(String[] args) throws SQLException {
        DatabaseDAO databaseDAO = DatabaseDAO.getInstance();
        databaseDAO.saveBook(new Book("book2",25.5,399,2000,6));
        List<Book> bookList = databaseDAO.allBooks();
        for(int i = 0;i<bookList.size();i++)
        {
            System.out.println(bookList.get(i).getTitle()+" "
                    +bookList.get(i).getPrice()+" "+
                    bookList.get(i).getPages()+" "+
                    bookList.get(i).getYear()+" "+
                    bookList.get(i).getId());
        }
    }
}
