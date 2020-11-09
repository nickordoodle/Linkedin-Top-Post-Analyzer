package com.analyzer.data;
/*
 *
 */
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Post {
    // Field
    int postId;
    String mainTextContent;
    List<String> listofHashTags;
    String hashTags;
    int numOfLikes;
    int numOfComments;
    int numOfViews;

    // Constructor
    public Post() {

    }

    public Post(int postId, String mainTextContent, List<String> listofHashTags, int numOfLikes, int numOfComments, int numOfViews) {
        this.postId = postId;
        this.listofHashTags = listofHashTags;
        this.numOfComments = numOfComments;
        this.numOfViews = numOfViews;
        this.numOfLikes = numOfLikes;
        this.mainTextContent = mainTextContent;
    }


    // Method
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return postId == post.postId &&
                numOfViews == post.numOfViews &&
                numOfLikes == post.numOfLikes &&
                Objects.equals(mainTextContent, post.mainTextContent) &&
                Objects.equals(hashTags, post.hashTags);
    }

    @Override
    public int hashCode() {
        return Objects.hash(postId, numOfViews, numOfLikes, mainTextContent);
    }

    // Accessor
    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public int getNumOfViews() {
        return numOfViews;
    }

    public void setNumOfViews(int numOfViews) {
        this.numOfViews = numOfViews;
    }

    public int getNumOfLikes() {
        return numOfLikes;
    }

    public void setNumOfLikes(int numOfLikes) {
        this.numOfLikes = numOfLikes;
    }

    public String getText() {
        return mainTextContent;
    }

    public void setText(String text) {
        this.mainTextContent = text;
    }

    // toString()
    @Override
    public String toString() {
        return "Post{" +
                "postid=" + postId +
                ", views=" + numOfViews +
                ", likes=" + numOfLikes +
                ", text='" + mainTextContent + '\'' +
                    ", hashtags='" + listofHashTags.toString() + '\'' +

                    '}';
    }
}