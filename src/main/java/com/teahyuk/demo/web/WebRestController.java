package com.teahyuk.demo.web;

import com.teahyuk.demo.domain.dto.PostsSaveRequestDto;
import com.teahyuk.demo.domain.posts.PostsRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class WebRestController {

	private PostsRepository postsRepository;

	@GetMapping("/hello")
	public String hello() {
		return "HelloWorldff";
	}

	@PostMapping("/posts")
	public void savePosts(@RequestBody PostsSaveRequestDto dto){
		postsRepository.save(dto.toEntity());
	}
}