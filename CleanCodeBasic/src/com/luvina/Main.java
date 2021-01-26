package com.luvina;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        System.out.println("User1 Post bài 1");
        User user1 = new User(1, "Vo Hoang Nam");
        Post post1 = new Post(1L, "Post bài số 1", "Content 1", user1);
        user1.submitPost(post1);

        System.out.println("User1 Post bài 2");
        Post post2 = new Post(2L, "Post bài số 2", "Content 2", user1);
        user1.submitPost(post2);

        System.out.println("User2 Post bài 1");
        User user2 = new User(2, "Do Tuan Anh");

        System.out.println("User1 remove post 1");
        user1.delete(post1);

        System.out.println("User2 comment1 to  Post 1");
        Comment comment1 = new Comment(1L, "Comment post số 1", post1, user1);
        user2.submitComment(comment1);

        /*
        System.out.println("User2 delete comment on Post 1");
        user1.deleteComment(comment1);
        */
        System.out.println("==Start Print Post==");
        ArrayList<Comment> comments = Comment.getCommentsByUser(user2);
        for (int i = 0; i < comments.size(); i++) {
            System.out.println(comments.get(i).getTitle());
        }
        System.out.println("==End Print Post==");
    }
}
