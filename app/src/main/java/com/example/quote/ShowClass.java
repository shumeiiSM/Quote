package com.example.quote;

public class ShowClass {
    private String quote;
    private String category;
    private String author;
    private int image;

    public ShowClass(String quote, String category, String author, int image) {
        this.quote = quote;
        this.category = category;
        this.author = author;
        this.image = image;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}


