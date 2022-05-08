package com.example.finalproject;

public class Book {
    private int cover;
    private String id;
    private String writer;
    private String date;
    private String publish;

    public Book(int cover, String id, String writer, String date, String publish) {
        this.cover = cover;
        this.id = id;
        this.writer = writer;
        this.date = date;
        this.publish = publish;
    }

    public int getCover() {
        return cover;
    }


    public String getId() {
        return id;
    }


    public String getWriter() {
        return writer;
    }


    public String getDate() {
        return date;
    }


    public String getPublish() {
        return publish;
    }
}
