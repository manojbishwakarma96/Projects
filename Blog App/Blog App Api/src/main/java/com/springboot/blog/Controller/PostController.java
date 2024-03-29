package com.springboot.blog.Controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.blog.Payload.PostDto;
import com.springboot.blog.Payload.PostResponse;
import com.springboot.blog.Service.PostService;
import com.springboot.blog.Utils.AppConstants;

@RestController
@RequestMapping("/api/posts")
public class PostController {
	@Autowired
	private PostService postService;

	public PostController(PostService postService) {
		super();
		this.postService = postService;
	}
	//create blogpost restapi
	@PostMapping("/create")
	public ResponseEntity<PostDto> createPost(@RequestBody PostDto  postdto){
		return new ResponseEntity<>(postService.createPost(postdto),HttpStatus.CREATED);
	}
	//get all post rest api
	@GetMapping("/getAllPost")
	public PostResponse getAllPosts(
			@RequestParam(value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
			@RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
			@RequestParam(value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
			@RequestParam(value = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir
			
			){
		
		
		return postService.getAllPost(pageNo,pageSize,sortBy,sortDir);
	}
	@GetMapping("/getAllPost/{id}")
	public PostDto getPostById(@PathVariable long id){ 		
		return postService.getPostById(id);
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<PostDto> updateData(@RequestBody PostDto postDto, @PathVariable("id") long id) {
		return new ResponseEntity<>(postService.updatePost(postDto, id), HttpStatus.OK);
		
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deletePosts(@PathVariable("id") long id){
		postService.deletePost(id);
		return new ResponseEntity<>("Post deleted sucessfully",HttpStatus.OK);
	}
}
