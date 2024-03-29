package com.springboot.blog.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.blog.Payload.CommentDto;
import com.springboot.blog.Service.CommentService;

@RestController
@RequestMapping("/api")
public class CommentController {
	
	private CommentService commentService;

	public CommentController(CommentService commentService) {
		super();
		this.commentService = commentService;
	}
	@PostMapping("/posts/{postId}/comment")
	public ResponseEntity<CommentDto> createComment(
			@RequestBody CommentDto commentDto,
			@PathVariable(value="postId") long postId
			){
		return new ResponseEntity<>
		(commentService.createComments(commentDto, postId),
				HttpStatus.CREATED);
	}
}
