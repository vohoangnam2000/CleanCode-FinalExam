package com.luvina;

import java.util.ArrayList;

public class User {
    private long id;
    private String fullName;
    private ArrayList<Post> posts;
    private ArrayList<Comment> comments;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }


    public void setPosts(ArrayList<Post> posts) {
        this.posts = posts;
    }

    public ArrayList<Post> getPosts() {
        return posts;
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }

    public User(long id, String fullName) {
        this.id = id;
        this.fullName = fullName;
        this.posts = Post.getPostsByUser(this);
        this.comments = Comment.getCommentsByUser(this);
    }

    public void submitPost(Post post) {
        Post.post(post);
    }

    public void submitComment(Comment comment){
        Comment.Post(comment);
    }

    public void delete(Post post) {
        Post.delete(post);
    }
}
