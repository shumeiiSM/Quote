package com.example.quote;

public class Quote {
    private String author;
    private int image;

    public Quote(String author, int image) {
        this.author = author;
        this.image = image;
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
