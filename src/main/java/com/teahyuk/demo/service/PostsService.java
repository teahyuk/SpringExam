package com.teahyuk.demo.service;

import com.teahyuk.demo.domain.dto.PostsMainResponseDto;
import com.teahyuk.demo.domain.dto.PostsSaveRequestDto;
import com.teahyuk.demo.domain.posts.PostsRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostsService {
	private PostsRepository postsRepository;

	public PostsService(PostsRepository postsRepository) {
		this.postsRepository = postsRepository;
	}

	@Transactional
	public Long save(PostsSaveRequestDto dto){
		return postsRepository.save(dto.toEntity()).getId();
	}

	@Transactional(readOnly = true)
	public List<PostsMainResponseDto> findAllDesc() {
		return postsRepository.findAllDesc()
				.map(PostsMainResponseDto::new)
				.collect(Collectors.toList());
	}

	public PostsRepository getPostsRepository() {
		return postsRepository;
	}
}
