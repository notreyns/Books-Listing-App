package com.example.bookslistingapp;


public class Book {
    private String title;
    private String author;
    private String pagesCount;
    private String time;
    private String coverImage;
    private String rating;
    private String url;

    public Book(){}
    public Book(String title, String author,String pages,String time, String img, String rating, String url){
        this.title=title;
        this.author=author;
        this.pagesCount=pages;
        this.time=time;
        this.coverImage=img;
        this.rating=rating;
        this.url=url;
    }
    public Book(String title, String author){
        this.title=title;
        this.author=author;
    }



    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }



    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPagesCount() {
        return pagesCount;
    }

    public void setPagesCount(String pagesCount) {
        this.pagesCount = pagesCount;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
