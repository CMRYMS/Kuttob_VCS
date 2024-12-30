package com.example.kuttob;
public class kuttob_cart_display {
    private String Book_Name;
    private String Price;


    public kuttob_cart_display() {}
    public kuttob_cart_display(String book_Name, String price) {
        Book_Name = book_Name;
        Price = price;
    }

    public String getBook_Name() {
        return Book_Name;
    }

    public void setBook_Name(String book_Name) {
        Book_Name = book_Name;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }
}
