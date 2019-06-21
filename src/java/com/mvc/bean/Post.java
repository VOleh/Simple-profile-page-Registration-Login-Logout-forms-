
package com.mvc.bean;


public class Post {
    
    private int authorId;
    private String authorName;
    private String authorSurname;
    private String message;
    private String date;
    
    
    public Post(){}
    
    public Post(int authorId, String authorName, String authorSurname, String message){
        this.authorId = authorId;
        this.authorName  = authorName;
        this.authorSurname = authorSurname;        
        this.message = message;}
        
    
    
    
   
    public int getAuthor() {
        return authorId;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorSurname() {
        return authorSurname;
    }

    public void setAuthorSurname(String authorSurname) {
        this.authorSurname = authorSurname;
    }

    public void setAuthor(int authorId) {
        this.authorId = authorId;
    }
    
    
    public void setMessage(String message){
        this.message = message;
    }
     public void setDate(String date){
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return   authorName  + authorSurname  + message  ;
    }

    
}

