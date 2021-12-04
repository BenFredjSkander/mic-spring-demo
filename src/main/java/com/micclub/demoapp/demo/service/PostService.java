package com.micclub.demoapp.demo.service;

import com.micclub.demoapp.demo.domain.Post;
import com.micclub.demoapp.demo.domain.PostDTO;

import java.util.List;

public interface PostService {
    List<Post> getAllPosts();

    Post getPostByid(Long id);

    void createPost(PostDTO postDTO);

    void deletePost(Long id);
}
