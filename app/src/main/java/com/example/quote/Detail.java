package com.example.quote;

public class Detail {
    private String quote;
    private int image;

    public Detail(String quote, int image) {
        this.quote = quote;
        this.image = image;
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
}
