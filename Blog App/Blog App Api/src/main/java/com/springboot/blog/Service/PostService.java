package com.springboot.blog.Service;


import com.springboot.blog.Payload.PostDto;
import com.springboot.blog.Payload.PostResponse;

public interface PostService {
	PostDto createPost(PostDto postDto);
	PostDto updatePost(PostDto postDto, long id);
	PostResponse getAllPost(int pageNo, int pageSize, String sortBy, String sortDir);
	PostDto getPostById(long id);
	void deletePost(long id);
	

}
