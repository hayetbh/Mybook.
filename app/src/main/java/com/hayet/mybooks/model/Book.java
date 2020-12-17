package com.hayet.mybooks.model;




public class Book {

    private String Title;
    private String Author ;
    private String Description ;
    private String Nbrpages;
    private int ImgURL ;

    public Book() {
    }

    public Book(String title, String author, String description, String nbrpages , int imgUrl) {
        Title = title;
        Author = author;
        Description = description;
        Nbrpages = nbrpages;
        ImgURL=imgUrl;
    }


    public String getTitle() {
        return Title;
    }


    public String getDescription() {
        return Description;
    }


    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getNbrpages() {
        return Nbrpages;
    }

    public void setNbrpages(String nbrpages) {
        Nbrpages = nbrpages;
    }

    public int getImgURL() {
        return ImgURL;
    }

    public void setImgURL(int imgURL) {
        ImgURL = imgURL;
    }

    public void setTitle(String title) {
        Title = title;
    }


    public void setDescription(String description) {
        Description = description;
    }


}
