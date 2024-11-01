package com.march.christmas.service;

import com.march.christmas.domain.Post;
import com.march.christmas.dto.PostDto;
import com.march.christmas.repository.PostRepository;
import com.march.christmas.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

//    @Transactional
    public Post createPost(PostDto.CreateRequest dto, Object o) {
        Post post = Post.builder()
                .title(dto.getTitle())
                .content(dto.getContent())
                .build();

        return postRepository.save(post);
    }

    public List<Post> getPosts() {
        return postRepository.findAllByOrderByCreatedAtDesc();
    }

    // 게시글 상세 조회
    public Post getPost(Long id){
        return postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("게시글을 찾을 수 없습니다."));
    }

    public Post updatePost(Long id, PostDto.UpdateRequest dto) {
        //조회 후
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("수정할 게시글을 찾을 수 없습니다."));

        // 수정
        Post updatedPost = new Post(post);
        updatedPost.setTitle(dto.getTitle());
        updatedPost.setContent(dto.getContent());

        return postRepository.save(updatedPost);
    }

    public void deletePost(Long id) {
        //조회 해 보고
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("삭제할 게시글을 찾을 수 없습니다."));

        postRepository.delete(post);
    }

}
