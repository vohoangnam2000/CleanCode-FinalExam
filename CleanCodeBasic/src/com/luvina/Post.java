package com.luvina;

import java.util.ArrayList;

public class Post {
    private long id;
    private String title;
    private String content;
    private User author;
    private ArrayList<Comment> comments;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }
    public Post(long id,String title,String content,User user){
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = user;
    }
    public boolean isAuthorPost(Post post){
        boolean isAuthor = false;
        if(isSameID(post.getId()) && isSameAuthor(post.getAuthor())){
            isAuthor = true;
        }
        return isAuthor;
    }
    public boolean isSameID(long id){
        return this.getId() == id;
    }
    public boolean isSameAuthor(User user){
        return this.getAuthor().equals(user);
    }

}
