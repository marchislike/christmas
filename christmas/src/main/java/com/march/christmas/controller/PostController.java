package com.march.christmas.controller;

import com.march.christmas.domain.Post;
import com.march.christmas.dto.PostDto;
import com.march.christmas.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/posts")
public class PostController {

    private final PostService postService;

    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody PostDto.CreateRequest postDto) {
        Post post = postService.createPost(postDto, postDto.getAuthorId());
        return ResponseEntity.ok(post);
    }

    @GetMapping
    public ResponseEntity<List<PostDto>> getPosts() {
        List<Post> posts = postService.getPosts();

        List<PostDto> postDtos = posts.stream()
                .map(post -> new PostDto(post.getTitle(), post.getContent())) // PostDto의 생성자를 사용
                .collect(Collectors.toList());

        return ResponseEntity.ok(postDtos);
    }

    //상세 조회
    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPost(@PathVariable Long id) {
        Post post = postService.getPost(id);
        return ResponseEntity.ok(new PostDto(post.getTitle(), post.getContent()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable Long id, @RequestBody PostDto.UpdateRequest postDto) {
        Post post = postService.updatePost(id, postDto);
        return ResponseEntity.ok(post);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Long id) {
        postService.deletePost(id);
        return ResponseEntity.noContent().build();
    }

}
