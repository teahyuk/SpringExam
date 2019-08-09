package com.teahyuk.demo.domain.dto;

import com.teahyuk.demo.domain.posts.Posts;

public class PostsSaveRequestDto {

	private String title;
	private String content;
	private String author;

	public PostsSaveRequestDto() {
	}

	public PostsSaveRequestDto(String title, String content, String author) {
		this.title = title;
		this.content = content;
		this.author = author;
	}

	public Posts toEntity(){
		return new Posts(title, content, author);
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public String getAuthor() {
		return author;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
}