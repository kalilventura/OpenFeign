package br.com.github.kalilventura.openfeign.controller;

import br.com.github.kalilventura.openfeign.client.PostFeignClient;
import br.com.github.kalilventura.openfeign.dto.PostDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    private final PostFeignClient postFeignClient;

    public PostController(PostFeignClient clientFeign) {
        this.postFeignClient = clientFeign;
    }

    @GetMapping
    public ResponseEntity<List<PostDTO>> getAllPosts() {
        return ResponseEntity.ok(postFeignClient.getPosts());
    }
}
