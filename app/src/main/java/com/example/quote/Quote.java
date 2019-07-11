package com.example.quote;

public class Quote {
    private String author;
    private String cname;
    private int image;

    public Quote(String author, String cname, int image) {
        this.author = author;
        this.cname = cname;
        this.image = image;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
