package com.teahyuk.demo.domain.posts;

import com.teahyuk.demo.domain.BaseTimeEntity;

import javax.persistence.*;

@Entity
public class Posts extends BaseTimeEntity {

	@Id
	@GeneratedValue
	private Long id;

	@Column(length = 500, nullable = false)
	private String title;

	@Column(columnDefinition = "TEXT", nullable = false)
	private String content;

	private String author;

	public Posts() {
	}

	public Posts(String title, String content, String author) {
		this.title = title;
		this.content = content;
		this.author = author;
	}

	public Long getId() {
		return id;
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
}
