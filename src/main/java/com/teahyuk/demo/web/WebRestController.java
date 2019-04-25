package com.teahyuk.demo.web;

import com.teahyuk.demo.domain.dto.PostsSaveRequestDto;
import com.teahyuk.demo.service.PostsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class WebRestController {

	private PostsService postsService;

	@GetMapping("/hello")
	public String hello() {
		return "HelloWorldff";
	}

	@PostMapping("/posts")
	public void savePosts(@RequestBody PostsSaveRequestDto dto){
		postsService.save(dto);
	}
}