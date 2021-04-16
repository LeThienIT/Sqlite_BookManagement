package com.android.qlsachactivity;

public class Book {
    private int id;
    private int bookId;
    private String bookName;
    private int page;
    private float price;
    private String description;

    public Book(int id, int bookId, String bookName, int page, float price, String description) {
        this.id = id;
        this.bookId = bookId;
        this.bookName = bookName;
        this.page = page;
        this.price = price;
        this.description = description;
    }

    public Book() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", page=" + page +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }
}
