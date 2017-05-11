package com.valsoft;

/**
 * Created by Rekdon on 11.05.2017.
 */
public class Book {
    private String title;
    private double price;
    private int pages;
    private int year;
    private int id;

    public Book() {
    }

    public Book(String title, double price, int pages, int year, int id) {
        this.title = title;
        this.price = price;
        this.pages = pages;
        this.year = year;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
