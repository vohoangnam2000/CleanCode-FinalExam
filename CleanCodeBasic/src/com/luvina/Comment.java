package com.luvina;

import java.util.ArrayList;

public class Comment {
    private long id;
    private String title;
    private Post post;
    private User user;
    public static ArrayList<Comment> comments = new ArrayList<>();

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

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Comment(long id, String title, Post post, User user) {
        this.id = id;
        this.title = title;
        this.post = post;
        this.user = user;
    }

    public static void Post(Comment comment) {
        comments.add(comment);
    }

    public static ArrayList<Comment> getCommentsByUser(User user) {
        ArrayList<Comment> commentByUser = new ArrayList<>();
        for (Comment c : comments) {
            if (c.getUser().equals(user)) {
                commentByUser.add(c);
            }
        }
        return commentByUser;
    }

    public static ArrayList<Comment> getCommentsByPost(Post post) {
        ArrayList<Comment> commentByPost = new ArrayList<>();
        for (Comment c : comments) {
            if (c.getPost().equals(post)) {
                commentByPost.add(c);
            }
        }
        return commentByPost;
    }

    public static void Delete(Comment comment) {
        comments.remove(comment);
    }
}
