package com.example.quote;

public class ShowClass {
    private String category;
    private String quote;
    private String author;

    public ShowClass(String category, String quote, String author) {
        this.category = category;
        this.quote = quote;
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}


