package com.springboot.blog.Service;

import com.springboot.blog.Payload.CommentDto;

public interface CommentService {
	CommentDto createComments(CommentDto commentDto ,long postId);

}