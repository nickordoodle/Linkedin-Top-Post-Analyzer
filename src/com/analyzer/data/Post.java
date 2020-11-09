package com.analyzer.data;
/*
 *
 */
import java.util.List;
import java.util.Objects;

public class Post {
    // Field
    int postid;
    String textBody;
    String hashTags;
    int likes;
    int comments;
    int views;

    //TODO for nick
    //to be implemeneted List<String> hashtag;

    // Constructor
    public Post() {

    }

    public Post(int postid, String text, String hashTags, int likes, int comments, int views) {
        this.postid = postid;
        this.hashTags = hashTags;
        this.comments = comments;
        this.views = views;
        this.likes = likes;
        this.textBody = text;
    }


    // Method
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return postid == post.postid &&
                views == post.views &&
                likes == post.likes &&
                Objects.equals(textBody, post.textBody);
    }

    @Override
    public int hashCode() {
        return Objects.hash(postid, views, likes, textBody);
    }

    // Accessor
    public int getPostid() {
        return postid;
    }

    public void setPostid(int postid) {
        this.postid = postid;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public String getText() {
        return textBody;
    }

    public void setText(String text) {
        this.textBody = text;
    }

    // toString()
    @Override
    public String toString() {
        return "Post{" +
                "postid=" + postid +
                ", views=" + views +
                ", likes=" + likes +
                ", text='" + textBody + '\'' +
                    ", hashtags='" + hashTags + '\'' +

                    '}';
    }
}