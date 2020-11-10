package com.analyzer.data;
/*
 *
 */

import java.util.List;
import java.util.Objects;

public class Post {
	// Field
	int postId;
	String mainTextContent;
	List<String> listOfHashTags;
	int numOfLikes;
	int numOfComments;
	int numOfViews;

	// Constructor
	public Post() {

	}

	public Post(int postId, String mainTextContent, List<String> listOfHashTags, int numOfLikes, int numOfComments, int numOfViews) {
		this.postId = postId;
		this.listOfHashTags = listOfHashTags;
		this.numOfComments = numOfComments;
		this.numOfViews = numOfViews;
		this.numOfLikes = numOfLikes;
		this.mainTextContent = mainTextContent;
	}


	// Method
	@Override
	public boolean equals(Object comparePost) {
		if (this == comparePost) return true;
		if (comparePost == null || getClass() != comparePost.getClass()) return false;
		Post post = (Post) comparePost;
		return postId == post.postId &&
				numOfViews == post.numOfViews &&
				numOfLikes == post.numOfLikes &&
				Objects.equals(mainTextContent, post.mainTextContent) &&
				Objects.equals(listOfHashTags, post.listOfHashTags);
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

	public String getMainTextContent() {
		return mainTextContent;
	}

	public void setMainTextContent(String mainTextContent) {
		this.mainTextContent = mainTextContent;
	}

	public List<String> getListOfHashTags() {
		return listOfHashTags;
	}

	public void setListOfHashTags(List<String> listOfHashTags) {
		this.listOfHashTags = listOfHashTags;
	}

	public int getNumOfLikes() {
		return numOfLikes;
	}

	public void setNumOfLikes(int numOfLikes) {
		this.numOfLikes = numOfLikes;
	}

	public int getNumOfComments() {
		return numOfComments;
	}

	public void setNumOfComments(int numOfComments) {
		this.numOfComments = numOfComments;
	}

	public int getNumOfViews() {
		return numOfViews;
	}

	public void setNumOfViews(int numOfViews) {
		this.numOfViews = numOfViews;
	}

	// toString()
	@Override
	public String toString() {
		return "Post{" +
				"postid=" + postId +
				", text='" + mainTextContent + '\'' +
				", hashtags='" + listOfHashTags.toString() + '\'' +
				", likes=" + numOfLikes +
				", likes=" + numOfComments +
				", views=" + numOfViews +
				'}';
	}

}