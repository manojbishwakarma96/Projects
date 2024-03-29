package com.springboot.blog.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.blog.Entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long>{

}
