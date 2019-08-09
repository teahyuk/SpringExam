package com.teahyuk.demo.web;

import com.teahyuk.demo.domain.dto.PostsSaveRequestDto;
import com.teahyuk.demo.service.PostsService;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
public class WebRestController {

	private PostsService postsService;
	private Environment env;

	public WebRestController(PostsService postsService, Environment env) {
		this.postsService = postsService;
		this.env = env;
	}

	@GetMapping("/hello")
	public String hello() {
		return "HelloWorldff";
	}

	@PostMapping("/posts")
	public void savePosts(@RequestBody PostsSaveRequestDto dto){
		postsService.save(dto);
	}

	@GetMapping("/profile")
	public String getProfile(){
		return Arrays.stream(env.getActiveProfiles())
				.findFirst()
				.orElse("");
	}
}