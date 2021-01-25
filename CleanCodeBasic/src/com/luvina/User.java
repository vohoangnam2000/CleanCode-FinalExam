package com.luvina;

import java.util.ArrayList;

public class User {
    private long id;
    private String fullName;
    private ArrayList<Post> posts = new ArrayList<>();
    private ArrayList<Comment> comments = new ArrayList<>();

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

    public ArrayList<Post> getPosts() {
        return posts;
    }

    public void setPosts(ArrayList<Post> posts) {
        this.posts = posts;
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }
    public User(long id, String fullName){
        this.id = id;
        this.fullName = fullName;
    }
    public void submit(Post post) {
        this.posts.add(post);
    }
    public void deleteSubmit(Post post){
        for(int i = 0; i < this.posts.size(); i++) {
            if(post != null && this.posts.get(i).isAuthorPost(post)){
                this.posts.remove(i);
                System.out.println("Remove Post title :" + post.getTitle());
                return;
            }
        }
        System.out.println("Donot Have Post title :" + post.getTitle());
    }
}
