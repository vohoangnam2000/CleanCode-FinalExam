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
        return Post.getPostsByUser(this);
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

    public void deletePost(Post post) {
        if (isPermissionDeletePost(post)) {
            Post.delete(post);
        } else {
            System.out.println("You haven't permission");
        }
    }

    private boolean isPermissionDeletePost(Post post) {
        boolean permission = false;
        if (this.equals(post.getAuthor())) {
            permission = true;
        }
        return permission;
    }

    public void submitComment(Comment comment) {
        if (isExisPost(comment.getPost())) {
            Comment.Post(comment);
        } else {
            System.out.println("Post has been deleted");
        }
    }

    public boolean isExisPost(Post post) {
        boolean isExisPost = false;
        ArrayList<Post> postOfUser = this.getPosts();
        if (postOfUser.contains(post)) {
            isExisPost = true;
        }
        return isExisPost;
    }

    public void deleteComment(Comment comment) {
        if (isPermissionDeleteComment(comment)) {
            Comment.Delete(comment);
        } else {
            System.out.println("You haven't permission");
        }
    }

    private boolean isPermissionDeleteComment(Comment comment) {
        boolean permission = false;
        if (this.equals(comment.getUser())) {
            permission = true;
        }
        return permission;
    }
}
