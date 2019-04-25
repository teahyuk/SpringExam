package com.teahyuk.demo.service;

import com.teahyuk.demo.domain.dto.PostsSaveRequestDto;
import com.teahyuk.demo.domain.posts.Posts;
import com.teahyuk.demo.domain.posts.PostsRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsServiceTest {

	@Autowired
	private PostsService postsService;

	@Autowired
	private PostsRepository postsRepository;

	@After
	public void cleanup () {
		postsRepository.deleteAll();
	}

	@Test
	public void Dto데이터가_posts테이블에_저장된다 () {
		//given
		PostsSaveRequestDto dto = PostsSaveRequestDto.builder()
				.author("jojoldu@gmail.com")
				.content("테스트")
				.title("테스트 타이틀")
				.build();

		//when
		postsService.save(dto);

		//then
		Posts posts = postsRepository.findAll().get(0);
		assertEquals(posts.getAuthor(),dto.getAuthor());
		assertEquals(posts.getContent(),dto.getContent());
		assertEquals(posts.getTitle(),dto.getTitle());
	}
}