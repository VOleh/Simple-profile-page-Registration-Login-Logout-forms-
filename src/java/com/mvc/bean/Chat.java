
package com.mvc.bean;
    

public class Chat {
    private int authorId;
    private String authorName;
    private String authorSurname;
    
    public Chat(){}
    public Chat(String authorName, String authorSurname){
        
        this.authorName =  authorName;
        this.authorSurname = authorSurname;
    }

    public String getAuthorName() {
        return authorName;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
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

    @Override
    public String toString() {
        return  authorName + " " + authorSurname ;
    }
    
    
    
}
