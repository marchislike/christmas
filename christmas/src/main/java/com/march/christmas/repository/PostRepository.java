package com.march.christmas.repository;

import com.march.christmas.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    
    //작성일 기준 내림차순으로 모든 게시글 조회
    List<Post> findAllByOrderByCreatedAtDesc();
}
