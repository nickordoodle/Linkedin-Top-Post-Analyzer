package com.analyzer.data;
/*
 *
 */
import java.util.List;
import java.util.Objects;

public class Post {
    // Field
    int postid;
    int views;
    int likes;
    String text;
    List<String> hashtag;

    // Constructor
    public Post() {

    }

    public Post(int postid, int views, int likes, String text, List<String> hashtag) {
        this.postid = postid;
        this.views = views;
        this.likes = likes;
        this.text = text;
        this.hashtag = hashtag;
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
                Objects.equals(text, post.text) &&
                Objects.equals(hashtag, post.hashtag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(postid, views, likes, text, hashtag);
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
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    // toString()
    @Override
    public String toString() {
        return "Post{" +
                "postid=" + postid +
                ", views=" + views +
                ", likes=" + likes +
                ", text='" + text + '\'' +
                ", hashtag=" + hashtag +
                '}';
    }
}