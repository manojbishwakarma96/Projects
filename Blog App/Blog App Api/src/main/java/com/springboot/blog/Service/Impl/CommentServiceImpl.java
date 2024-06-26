package com.springboot.blog.Service.Impl;

import org.springframework.stereotype.Service;

import com.springboot.blog.Entity.Comment;
import com.springboot.blog.Entity.Post;
import com.springboot.blog.Exception.ResourceNotFoundException;
import com.springboot.blog.Payload.CommentDto;
import com.springboot.blog.Repository.CommentRepository;
import com.springboot.blog.Repository.PostRepository;
import com.springboot.blog.Service.CommentService;

@Service
public class CommentServiceImpl implements CommentService{
	private CommentRepository commentRepository;
	private PostRepository postRepository;

	public CommentServiceImpl(CommentRepository commentRepository,PostRepository postRepository) {
		super();
		this.commentRepository = commentRepository;
		this.postRepository=postRepository;
	}

	//comment entity to comments dto
	private CommentDto mapToDtoComments(Comment comment) {
		CommentDto commentDto=new CommentDto();
		commentDto.setId(comment.getId());
		commentDto.setName(comment.getName());
		commentDto.setBody(comment.getBody());
		commentDto.setEmail(comment.getEmail());
		return commentDto;
	}
	//comment dto to comments entity
		private Comment mapToCommentEntity(CommentDto commentDto) {
			Comment comment=new Comment();
			comment.setId(commentDto.getId());
			comment.setName(commentDto.getName());
			comment.setBody(commentDto.getBody());
			comment.setEmail(commentDto.getEmail());
			return comment;
		}

		@Override
		public CommentDto createComments(CommentDto commentDto, long postId) {
			Comment comment=mapToCommentEntity(commentDto);
			//retrive post entity by id
			Post  post=postRepository
					.findById(postId)
					.orElseThrow(
							()-> new ResourceNotFoundException
							("Post", "id", postId));
			
			//set post to comment entity
			comment.setPost(post);
			//comment entity to database
			Comment newComment=commentRepository.save(comment);
			return mapToDtoComments(newComment);
		}

	 
	
}
