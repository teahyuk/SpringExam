package com.teahyuk.demo.domain.dto;

import com.teahyuk.demo.domain.posts.Posts;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class PostsMainResponseDto {
	private Long id;
	private String title;
	private String author;
	private String modifiedDate;

	public PostsMainResponseDto(Posts entity) {
		id = entity.getId();
		title = entity.getTitle();
		author = entity.getAuthor();
		modifiedDate = toStringDateTime(entity.getModifiedDate());
	}

	/**
	 * Java 8 버전
	 */
	private String toStringDateTime(LocalDateTime localDateTime){
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		return Optional.ofNullable(localDateTime)
				.map(formatter::format)
				.orElse("");
	}

	/**
	 * Java 7 버전
	 */
	private String toStringDateTimeByJava7(LocalDateTime localDateTime){
		if(localDateTime == null){
			return "";
		}

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		return formatter.format(localDateTime);
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public String getModifiedDate() {
		return modifiedDate;
	}
}