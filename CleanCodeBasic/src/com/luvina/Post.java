package com.luvina;

import java.util.ArrayList;

public class Post {
    private long id;
    private String title;
    private String content;
    private User author;
    private ArrayList<Comment> comments;

    public static ArrayList<Post> posts = new ArrayList<>();

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

    public Post(long id, String title, String content, User user) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = user;
        this.comments = Comment.getCommentsByPost(this);
    }

    public static void post(Post post) {
        posts.add(post);
    }

    public static ArrayList<Post> getPostsByUser(User user) {
        ArrayList<Post> postByUser = new ArrayList<>();
        for (Post p: posts) {
            if (p.getAuthor().equals(user)){
                postByUser.add(p);
            }
        }
        return postByUser;
    }

    public static void delete(Post post) {
        posts.remove(post);
    }
}
