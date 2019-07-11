package com.example.quote;

public class Detail {
    private String quote;
    private int image;
    private String cname;
    private String author;

    public Detail(String quote, int image, String cname, String author) {
        this.quote = quote;
        this.image = image;
        this.cname = cname;
        this.author = author;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
