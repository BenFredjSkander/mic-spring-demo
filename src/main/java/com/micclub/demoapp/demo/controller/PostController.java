package com.micclub.demoapp.demo.controller;


import com.micclub.demoapp.demo.domain.Post;
import com.micclub.demoapp.demo.domain.PostDTO;
import com.micclub.demoapp.demo.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/posts", produces = MediaType.APPLICATION_JSON_VALUE)
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }


    @GetMapping
    public ResponseEntity<Object>  getAllPosts() {
        List<Post> result = postService.getAllPosts();
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<Object> createPost(@RequestBody PostDTO newPost) {
        postService.createPost(newPost);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
