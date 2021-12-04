package com.micclub.demoapp.demo.service;

import com.micclub.demoapp.demo.domain.Post;
import com.micclub.demoapp.demo.domain.PostDTO;
import com.micclub.demoapp.demo.repository.PostRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class PostServiceImpl implements PostService{
    private final PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public Post getPostByid(Long id) {
        return postRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public void createPost(PostDTO postDTO) {
        Post newpost = new Post();
        newpost.setTitle(postDTO.getTitle());
        newpost.setBody(postDTO.getBody());
        postRepository.save(newpost);
    }

    @Override
    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }
}
